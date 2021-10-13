package Fsoft.MOOCProject.entities.entitiesDTO.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class EmployeeRequest {
    private int id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String type;

    @Override
    public boolean equals(Object o) {
        EmployeeRequest that = (EmployeeRequest) o;
        return Objects.equals(fullName, that.fullName) || Objects.equals(phone, that.phone) || Objects.equals(email, that.email);
    }
}
