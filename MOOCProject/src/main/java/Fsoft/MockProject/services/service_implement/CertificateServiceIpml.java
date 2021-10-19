package Fsoft.MockProject.services.service_implement;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.CertificateResponse;
import Fsoft.MockProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MockProject.entities.model.Certificate;
import Fsoft.MockProject.entities.model.Employee;
import Fsoft.MockProject.repository.CertificateRepository;
import Fsoft.MockProject.repository.EmployeeRepository;
import Fsoft.MockProject.services.service_interface.CertificateService;
import Fsoft.MockProject.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceIpml implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    Helper helper = new Helper();

    public CertificateServiceIpml(CertificateRepository certificateRepository, EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.certificateRepository = certificateRepository;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public List<CertificateResponse> getAll(){
        List<Certificate> certificates = this.certificateRepository.findAll();
        List<CertificateResponse> certificateResponses = new ArrayList<>();
        for (Certificate c : certificates){
            certificateResponses.add(mapper.map(c, CertificateResponse.class));
        }
        return certificateResponses;
    }

    @Override
    public List<CertificateResponse> getById(int eid) {
        try {
            List<Certificate> certificateList = this.certificateRepository.getCertificateByEId(eid);
            List<CertificateResponse> certificateResponseList = new ArrayList<>();
            for(Certificate c : certificateList){
                certificateResponseList.add(mapper.map(c, CertificateResponse.class));
            }
            return certificateResponseList;
        }catch (Exception e){
            return null;
        }
    }

    public List<CertificateRequest> getCertificateRequestList(){
        List<Certificate> certificateList = this.certificateRepository.findAll();
        List<CertificateRequest> certificateRequestList = new ArrayList<>();
        for (Certificate c : certificateList){
            certificateRequestList.add(mapper.map(c, CertificateRequest.class));
        }
        return certificateRequestList;
    }

    public CertificateResponse addComplex(CertificateRequest certificateRequest, int eid){
            //create new list from certificate -> certificateRequest type
            List<CertificateRequest> certificateRequestList = getCertificateRequestList();
            //get certificate
            certificateRequest.setEId(eid);
            CertificateRequest certificate = helper.getCertificateRequest(certificateRequest, certificateRequestList);

            //create new list from Employee -> EmployeeResponseType
            List<Employee> employeeList = this.employeeRepository.findAll();
            List<EmployeeResponse> employeeResponseList = new ArrayList<>();
            for(Employee e : employeeList){
                employeeResponseList.add(mapper.map(e, EmployeeResponse.class));
            }
            //get employee
            EmployeeResponse employee = helper.findEmpRespById(employeeResponseList, eid);
            //satisfy certificate not duplicate (name, eid) and employee has to exist.
            if(certificate == null && employee != null){
                Certificate certificate1 = mapper.map(certificateRequest, Certificate.class);
                this.certificateRepository.save(certificate1);
                CertificateResponse certificateResponse = mapper.map(certificate1, CertificateResponse.class);
                return certificateResponse;
            }else{
                return null;
            }
    }

    public ResponseAPI add(CertificateRequest certificateRequest, int eid){
        Optional<Employee> employee = this.employeeRepository.findById(eid);
        if(!employee.isPresent()){
            return new ResponseAPI(false, "Employee not exists");
        }else {
            List<CertificateRequest> certificateRequestList = getCertificateRequestList();
            certificateRequest.setEId(eid);
            CertificateRequest certificateRequest1 = helper.getCertificateRequest(certificateRequest, certificateRequestList);
            if(certificateRequest1 != null){
                return new ResponseAPI(false, "Certificate is exists");
            }else{
                Certificate certificate = mapper.map(certificateRequest, Certificate.class);
                this.certificateRepository.save(certificate);
                return new ResponseAPI(true, "Added!");
            }
        }
    }

    public ResponseAPI update(CertificateRequest certificateRequest, int id){
        try {
            Certificate certificate = this.certificateRepository.findById(id).get();
            if(certificate == null){
                return new ResponseAPI(false, "Certificate not exists");
            }else{
                List<CertificateRequest> certificateRequestList = getCertificateRequestList();
                certificateRequest.setEId(certificate.getEId());
                CertificateRequest certificateRequest1 = helper.getCertificateRequest(certificateRequest, certificateRequestList);
                if(certificateRequest1 != null){
                    return new ResponseAPI(false, "Certificate is duplicate");
                }else {
                    certificateRequest.setId(id);
                    Certificate certificate1 = mapper.map(certificateRequest, Certificate.class);
                    this.certificateRepository.save(certificate1);
                    return new ResponseAPI(true, "Updated!");
                }
            }
        }catch (Exception e){
            return new ResponseAPI(false, e.getMessage());
        }
    }

    public ResponseAPI delete(int id){
        try {
            this.certificateRepository.deleteById(id);
            return new ResponseAPI(true, "Deleted!");
        }catch (Exception e){
            return new ResponseAPI(false, e.getMessage());
        }
    }
}
