package Fsoft.MOOCProject.controller;

import Fsoft.MOOCProject.entities.ResponseAPI;
import Fsoft.MOOCProject.entities.entitiesDTO.request.ExperienceRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.FresherRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.InternRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MOOCProject.entities.model.Employee;
import Fsoft.MOOCProject.services.service_interface.EmployeeService;
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
        return "index";
    }

    @GetMapping(value = "/list")
    public List<EmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/filter/{type}")
    public List<EmployeeResponse> getAllByType(@PathVariable int type){
        return employeeService.getAllByType(type);
    }

    @GetMapping("/sort/{type}")
    public List<EmployeeResponse> sort(@PathVariable int type){
        return employeeService.sort(type);
    }

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
