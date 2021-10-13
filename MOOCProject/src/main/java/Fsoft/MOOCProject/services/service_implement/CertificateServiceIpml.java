package Fsoft.MOOCProject.services.service_implement;

import Fsoft.MOOCProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.CertificateResponse;
import Fsoft.MOOCProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MOOCProject.entities.model.Certificate;
import Fsoft.MOOCProject.entities.model.Employee;
import Fsoft.MOOCProject.repository.CertificateRepository;
import Fsoft.MOOCProject.repository.EmployeeRepository;
import Fsoft.MOOCProject.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateServiceIpml {

    private final CertificateRepository certificateRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    Helper helper = new Helper();

    public CertificateServiceIpml(CertificateRepository certificateRepository, EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.certificateRepository = certificateRepository;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public List<CertificateResponse> list(){
        List<Certificate> certificates = this.certificateRepository.findAll();
        List<CertificateResponse> certificateResponses = new ArrayList<>();
        for (Certificate c : certificates){
            certificateResponses.add(mapper.map(c, CertificateResponse.class));
        }
        return certificateResponses;
    }

    public List<Certificate> getAllByEid(int eid){
//        List<Certificate> list = this.certificateRepository.getAllByEid(eid);
//        if(list.isEmpty()){
//            return null;
//        }
//        return list;
        return  null;
    }

    public CertificateResponse add(CertificateRequest certificateRequest, int eid){
            //create new list from certificate -> certificateRequest type
            List<Certificate> certificateList = this.certificateRepository.findAll();
            List<CertificateRequest> certificateRequestList = new ArrayList<>();
            for (Certificate c : certificateList){
                certificateRequestList.add(mapper.map(c, CertificateRequest.class));
            }
            //get certificate
            certificateRequest.setEId(eid);
            CertificateRequest certificate = helper.getCertificateRequest(certificateRequest, certificateRequestList);

            //create new list from Employee -> EmployeeRequestType
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

    public String update(Certificate certificate, int id){
//        try {
//            Certificate certificate1 = certificateRepository.findById(id).get();
//            if(certificate1 == null){
//                return "Certificate is not exists";
//            }else{
//                certificate1.setName(certificate.getName());
//                certificate1.setRank(certificate.getRank());
//                certificate1.setDate(certificate.getDate());
//                this.certificateRepository.save(certificate1);
//                return "updated";
//            }
//        }catch (Exception e){
//            return "ex" + e.getMessage();
//        }
        return  null;
    }

    public String delete(int id){
//        try {
//            Certificate certificate1 = certificateRepository.findById(id).get();
//            if(certificate1 == null){
//                return "Certificate is not exists";
//            }else{
//                this.certificateRepository.deleteById(id);
//                return "deleted";
//            }
//        }catch (Exception e){
//            return "ex" + e.getMessage();
//        }
        return  null;
    }
}
