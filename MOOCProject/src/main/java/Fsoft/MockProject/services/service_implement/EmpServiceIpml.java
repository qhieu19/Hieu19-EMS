package Fsoft.MockProject.services.service_implement;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.EmployeeRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.ExperienceRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.FresherRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.InternRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MockProject.entities.entitiesDTO.response.ExperienceResponse;
import Fsoft.MockProject.entities.entitiesDTO.response.FresherResponse;
import Fsoft.MockProject.entities.entitiesDTO.response.InternResponse;
import Fsoft.MockProject.entities.model.Employee;
import Fsoft.MockProject.entities.model.Experience;
import Fsoft.MockProject.entities.model.Fresher;
import Fsoft.MockProject.entities.model.Intern;
import Fsoft.MockProject.repository.EmployeeRepository;
import Fsoft.MockProject.services.service_interface.EmployeeService;
import Fsoft.MockProject.utils.Helper;
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
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        if(type == 1){
           List<Employee> list = this.employeeRepository.getEmployeeByType("experience");
           for(Employee e : list){
               employeeResponseList.add(mapper.map(e, ExperienceResponse.class));
           }
        }else if(type == 2){
            List<Employee> list = this.employeeRepository.getEmployeeByType("fresher");
            for(Employee e : list){
                employeeResponseList.add(mapper.map(e, FresherResponse.class));
            }
        }else if(type == 3){
            List<Employee> list = this.employeeRepository.getEmployeeByType("intern");
            for(Employee e : list){
                employeeResponseList.add(mapper.map(e, InternResponse.class));
            }
        }else{
            return null;
        }
        return employeeResponseList;
    }

    public List<EmployeeResponse> sort(int type){
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        if(type == 1){
            List<Employee> list = this.employeeRepository.getEmployeeOrderByFullName();
            for(Employee e : list){
                employeeResponseList.add(mapper.map(e, EmployeeResponse.class));
            }
        }else if(type == 2){
            List<Employee> list = this.employeeRepository.getEmployeeOrderByType();
            for(Employee e : list){
                employeeResponseList.add(mapper.map(e, EmployeeResponse.class));
            }
        }else{
            return null;
        }
        return employeeResponseList;
    }

    public List<EmployeeResponse> searchByName(String keyword){
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        List<Employee> list = this.employeeRepository.searchEmployeeByName(keyword);
        for(Employee e : list){
            employeeResponseList.add(mapper.map(e, EmployeeResponse.class));
        }
        return employeeResponseList;
    }

    @Override
    public EmployeeResponse getEmployee(int id){
        try {
            Optional<Employee> employee = this.employeeRepository.findById(id);
            if(employee.get() instanceof Experience)
                return employee.map(value -> mapper.map(value, ExperienceResponse.class)).orElse(null);
            if(employee.get() instanceof Fresher)
                return employee.map(value -> mapper.map(value, FresherResponse.class)).orElse(null);
            if(employee.get() instanceof Intern)
                return employee.map(value -> mapper.map(value, InternResponse.class)).orElse(null);
            return null;
        }catch (Exception e){
            return null;
        }
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
                ExperienceRequest experienceRequest1 = mapper.map(employee, ExperienceRequest.class);
                if(!(experienceRequest1.getType().equals("experience"))){
                    return new ResponseAPI(false, "Not the same type of experience");
                }else{
                    experienceRequest.setId(id);
                    Experience experience = mapper.map(experienceRequest, Experience.class);
                    this.employeeRepository.save(experience);
                    return new ResponseAPI(true, "Updated" + experience);
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
                FresherRequest fresherRequest1 = mapper.map(this.employeeRepository.findById(id), FresherRequest.class);
                if(!(fresherRequest1.getType().equals("fresher"))){
                    return new ResponseAPI(false, "Not the same type of fresher");
                }else{
                    Fresher fresher = mapper.map(fresherRequest, Fresher.class);
                    fresher.setId(id);
                    this.employeeRepository.save(fresher);
                    return new ResponseAPI(true, "Updated" + fresher);
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
                    return new ResponseAPI(true, "Updated" + intern);
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

    @Override
    public List<EmployeeResponse> test() {
        return this.employeeRepository.test();
    }
}
