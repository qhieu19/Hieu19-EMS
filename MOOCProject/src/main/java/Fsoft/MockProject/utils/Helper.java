package Fsoft.MockProject.utils;

import Fsoft.MockProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.EmployeeRequest;
import Fsoft.MockProject.entities.entitiesDTO.request.UserRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MockProject.entities.model.Certificate;
import Fsoft.MockProject.entities.model.Employee;
import Fsoft.MockProject.entities.model.User;

import java.util.List;

public class Helper {

    public EmployeeRequest getEmployee(EmployeeRequest employee1, List<EmployeeRequest> list){
        return list.stream().filter(employeeRequest -> employeeRequest.equals(employee1)).findAny().orElse(null);
    }

    public EmployeeResponse findEmpRespById(List<EmployeeResponse> list, int eid){
        return list.stream().filter(employee -> employee.getId() == eid).findAny().orElse(null);
    }

    public CertificateRequest getCertificateRequest(CertificateRequest certificateRequest, List<CertificateRequest> list){
        return list.stream().filter(certificate ->
                certificate.getName().equals(certificateRequest.getName())
                        && certificate.getEId() == certificateRequest.getEId()).findAny().orElse(null);
    }

    public UserRequest getUserRequest(UserRequest u, List<UserRequest> list){
        return list.stream().filter(user -> user.getUsername().equals(u.getUsername())).findAny().orElse(null);
    }
}
