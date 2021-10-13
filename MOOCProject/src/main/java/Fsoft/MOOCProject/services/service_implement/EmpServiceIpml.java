package Fsoft.MOOCProject.services.service_implement;

import Fsoft.MOOCProject.entities.ResponseAPI;
import Fsoft.MOOCProject.entities.entitiesDTO.request.EmployeeRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.ExperienceRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.FresherRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.InternRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MOOCProject.entities.entitiesDTO.response.ExperienceResponse;
import Fsoft.MOOCProject.entities.entitiesDTO.response.FresherResponse;
import Fsoft.MOOCProject.entities.entitiesDTO.response.InternResponse;
import Fsoft.MOOCProject.entities.model.Employee;
import Fsoft.MOOCProject.entities.model.Experience;
import Fsoft.MOOCProject.entities.model.Fresher;
import Fsoft.MOOCProject.entities.model.Intern;
import Fsoft.MOOCProject.repository.EmployeeRepository;
import Fsoft.MOOCProject.services.service_interface.EmployeeService;
import Fsoft.MOOCProject.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceIpml implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    Helper helper = new Helper();

    public EmpServiceIpml(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public List<EmployeeResponse> getAll(){
        List<Employee> employeeList = this.employeeRepository.findAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for (Employee e : employeeList){
            if(e instanceof Experience){
                employeeResponseList.add(mapper.map(e, ExperienceResponse.class));
            }else if(e instanceof Fresher){
                employeeResponseList.add(mapper.map(e, FresherResponse.class));
            }else if(e instanceof Intern){
                employeeResponseList.add(mapper.map(e, InternResponse.class));
            }
        }
        return employeeResponseList;
    }

    public List<EmployeeRequest> getRequestList(){
        List<Employee> employeeList = this.employeeRepository.findAll();
        List<EmployeeRequest> employeeRequestList = new ArrayList<>();
        for (Employee e : employeeList){
            employeeRequestList.add(mapper.map(e, EmployeeRequest.class));
        }
        return employeeRequestList;
    }

    public List<EmployeeResponse> getAllByType(int type){
        List<EmployeeResponse> employeeResponseList;
        if(type == 1){
            employeeResponseList = this.employeeRepository.getEmployeeByType("experience");
        }else if(type == 2){
            employeeResponseList = this.employeeRepository.getEmployeeByType("fresher");
        }else if(type == 3){
            employeeResponseList = this.employeeRepository.getEmployeeByType("intern");
        }else{
            return null;
        }
        return employeeResponseList;
    }

    public List<EmployeeResponse> sort(int type){
        List<EmployeeResponse> employeeResponseList;
        if(type == 1){
            employeeResponseList = this.employeeRepository.getEmployeeOrderByFullName();
        }else if(type == 2){
            employeeResponseList = this.employeeRepository.getEmployeeOrderByType();
        }else{
            return null;
        }
        return employeeResponseList;
    }

    public List<EmployeeResponse> searchByName(String keyword){
        List<EmployeeResponse> employeeResponseList = this.employeeRepository.searchEmployeeByName(keyword);
        return employeeResponseList;
    }

    public ResponseAPI addExperience(ExperienceRequest experienceRequest){
        EmployeeRequest employeeRequest = helper.getEmployee(experienceRequest, getRequestList());
        if(employeeRequest == null){
            Experience experience = mapper.map(experienceRequest, Experience.class);
            this.employeeRepository.save(experience);
            return new ResponseAPI(true, "Add successfully !");
        }else{
            return new ResponseAPI(false, "Add fail !\nError: Employee existed");
        }
    }

    public ResponseAPI addFresher(FresherRequest fresherRequest){
        EmployeeRequest employeeRequest = helper.getEmployee(fresherRequest, getRequestList());
        if(employeeRequest == null){
            Fresher fresher = mapper.map(fresherRequest, Fresher.class);
            this.employeeRepository.save(fresher);
            return new ResponseAPI(true, "Add successfully !");
        }else{
            return new ResponseAPI(false, "Add fail !\nError: Employee existed");
        }
    }

    public ResponseAPI addIntern(InternRequest internRequest){
        EmployeeRequest employeeRequest = helper.getEmployee(internRequest, getRequestList());
        if(employeeRequest == null){
            Intern intern = mapper.map(internRequest, Intern.class);
            this.employeeRepository.save(intern);
            return new ResponseAPI(true, "Add successfully !");
        }else{
            return new ResponseAPI(false, "This Employee exists");
        }
    }

    public ResponseAPI updateExperience(ExperienceRequest experienceRequest, int id){
        try {
            Optional<Employee> employee = this.employeeRepository.findById(id);
            if(!employee.isPresent()){
                return new ResponseAPI(false, "This Employee not exists");
            }else{
                ExperienceRequest experienceRequest1 = mapper.map(this.employeeRepository.findById(id).get(), ExperienceRequest.class);
                if(!(experienceRequest1.getType().equals("experience"))){
                    return new ResponseAPI(false, "Not the same type of experience");
                }else{
                    experienceRequest.setId(id);
                    Experience experience = mapper.map(experienceRequest, Experience.class);
                    this.employeeRepository.save(experience);
                    return new ResponseAPI(true, "Updated" + experience.toString());
                }
            }
        }catch (Exception e){
            return new ResponseAPI(false, "Error: " + e.getMessage());
        }
    }

    public ResponseAPI updateFresher(FresherRequest fresherRequest, int id){
        try {
            Optional<Employee> employee = this.employeeRepository.findById(id);
            if(!employee.isPresent()){
                return new ResponseAPI(false, "This Employee not exists");
            }else{
                FresherRequest fresherRequest1 = mapper.map(this.employeeRepository.findById(id).get(), FresherRequest.class);
                if(!(fresherRequest1.getType().equals("fresher"))){
                    return new ResponseAPI(false, "Not the same type of fresher");
                }else{
                    Fresher fresher = mapper.map(fresherRequest, Fresher.class);
                    fresher.setId(id);
                    this.employeeRepository.save(fresher);
                    return new ResponseAPI(true, "Updated" + fresher.toString());
                }
            }
        }catch (Exception e){
            return new ResponseAPI(false, "Error: " + e.getMessage());
        }
    }

    public ResponseAPI updateIntern(InternRequest internRequest, int id){
        try {
            Optional<Employee> employee = this.employeeRepository.findById(id);
            if(!employee.isPresent()){
                return new ResponseAPI(false, "This Employee not exists");
            }else{
                InternRequest internRequest1 = mapper.map(this.employeeRepository.findById(id), InternRequest.class);
                if(!(internRequest1.getType().equals("intern"))){
                    return new ResponseAPI(false, "Not the same type of intern");
                }else{
                    internRequest.setId(id);
                    Intern intern = mapper.map(internRequest, Intern.class);
                    this.employeeRepository.save(intern);
                    return new ResponseAPI(true, "Updated" + intern.toString());
                }
            }
        }catch (Exception e){
            return new ResponseAPI(false,"Error: " + e.getMessage());
        }
    }

    public ResponseAPI delete(int id){
        try {
            this.employeeRepository.deleteById(id);
            return new ResponseAPI(true, "Deleted!");
        }catch (Exception e){
            return new ResponseAPI(false, "Error: " + e.getMessage());
        }
    }
}
