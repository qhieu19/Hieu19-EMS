package Fsoft.MockProject.entities.entitiesDTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private int id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String type;
}
