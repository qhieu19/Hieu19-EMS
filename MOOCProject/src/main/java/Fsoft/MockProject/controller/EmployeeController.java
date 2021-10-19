package Fsoft.MockProject.controller;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.ExperienceRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.FresherRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.InternRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MockProject.entities.model.Employee;
import Fsoft.MockProject.services.service_interface.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "")
    public String index(){
        return "<h1>This is employee site</h1>";
    }

    @GetMapping(value = "/list")
    public List<EmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    //test
    @GetMapping(value = "/test-list")
    public List<EmployeeResponse> getAll1(){
        return employeeService.test();
    }

    @GetMapping("/filter/{type}")
    public List<EmployeeResponse> getAllByType(@PathVariable int type){
        return employeeService.getAllByType(type);
    }

    @GetMapping("/sort/{type}")
    public List<EmployeeResponse> sort(@PathVariable int type){
        return employeeService.sort(type);
    }

    @GetMapping("/get/{id}")
    public EmployeeResponse getEmployee(@PathVariable int id){return employeeService.getEmployee(id);}

    @GetMapping("/search/{keyword}")
    public List<EmployeeResponse> search(@PathVariable String keyword){
        return employeeService.searchByName(keyword);
    }

    @PostMapping("/add/experience")
    public ResponseAPI addExperience(@RequestBody ExperienceRequest experienceRequest){
        return employeeService.addExperience(experienceRequest);
    }

    @PostMapping("/add/fresher")
    public ResponseAPI addFresher(@RequestBody FresherRequest fresherRequest){
        return employeeService.addFresher(fresherRequest);
    }

    @PostMapping("/add/intern")
    public ResponseAPI addIntern(@RequestBody InternRequest internRequest){
        return employeeService.addIntern(internRequest);
    }

    @PutMapping("/update/experience/{id}")
    public ResponseAPI updateExperience(@RequestBody ExperienceRequest experienceRequest,@PathVariable int id){
        return employeeService.updateExperience(experienceRequest, id);
    }

    @PutMapping("/update/fresher/{id}")
    public ResponseAPI updateFresher(@RequestBody FresherRequest fresherRequest,@PathVariable int id){
        return employeeService.updateFresher(fresherRequest, id);
    }

    @PutMapping("/update/intern/{id}")
    public ResponseAPI updateIntern(@RequestBody InternRequest internRequest,@PathVariable int id){
        return employeeService.updateIntern(internRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseAPI delete(@PathVariable int id){
        return employeeService.delete(id);
    }
}
