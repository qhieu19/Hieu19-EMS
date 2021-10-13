package Fsoft.MOOCProject.utils;

import Fsoft.MOOCProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.request.EmployeeRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MOOCProject.entities.model.Certificate;
import Fsoft.MOOCProject.entities.model.Employee;
import Fsoft.MOOCProject.entities.model.User;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public EmployeeRequest getEmployee(EmployeeRequest employee1, List<EmployeeRequest> list){
        return list.stream().filter(employeeRequest -> employeeRequest.equals(employee1)).findAny().orElse(null);
    }

    public Employee findById(List<Employee> list, int eid){
        return list.stream().filter(employee -> employee.getId() == eid).findAny().orElse(null);
    }

    public EmployeeRequest findEmpRequestById(List<EmployeeRequest> list, int eid){
        return list.stream().filter(employee -> employee.getId() == eid).findAny().orElse(null);
    }

    public EmployeeResponse findEmpRespById(List<EmployeeResponse> list, int eid){
        return list.stream().filter(employee -> employee.getId() == eid).findAny().orElse(null);
    }

    public Certificate getCertificate(CertificateRequest certificateRequest, List<Certificate> list){
        return list.stream().filter(certificate ->
                certificate.getName().equals(certificateRequest.getName())
                        && certificate.getEId() == certificateRequest.getEId()).findAny().orElse(null);
    }

    public CertificateRequest getCertificateRequest(CertificateRequest certificateRequest, List<CertificateRequest> list){
        return list.stream().filter(certificate ->
                certificate.getName().equals(certificateRequest.getName())
                        && certificate.getEId() == certificateRequest.getEId()).findAny().orElse(null);
    }

    public User getUser(User u, List<User> list){
        return list.stream().filter(user -> user.getUsername().equals(u.getUsername())).findAny().orElse(null);
    }

    public User login(User u, List<User> list){
        return list.stream().filter(user -> user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())).findAny().orElse(null);
    }
}
