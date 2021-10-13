package Fsoft.MOOCProject.services.service_interface;

import Fsoft.MOOCProject.entities.ResponseAPI;
import Fsoft.MOOCProject.entities.entitiesDTO.request.ExperienceRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.FresherRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.InternRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MOOCProject.entities.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAll();
    List<EmployeeResponse> getAllByType(int type);// 3 types of employee
    List<EmployeeResponse> sort(int type);//1 by name, 2 by type
    List<EmployeeResponse> searchByName(String keyword);
    //add
    ResponseAPI addExperience(ExperienceRequest experience);
    ResponseAPI addFresher(FresherRequest fresher);
    ResponseAPI addIntern(InternRequest intern);
    //update
    ResponseAPI updateExperience(ExperienceRequest experienceRequest, int id);
    ResponseAPI updateFresher(FresherRequest fresherRequest, int id);
    ResponseAPI updateIntern(InternRequest internRequest, int id);
    //delete
    ResponseAPI delete(int id);
}
