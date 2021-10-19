package Fsoft.MockProject.entities.entitiesDTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternRequest extends EmployeeRequest{
    private String major;
    private int semester;
    private String education;
}
