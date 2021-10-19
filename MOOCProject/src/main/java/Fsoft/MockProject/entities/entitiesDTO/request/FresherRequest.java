package Fsoft.MockProject.entities.entitiesDTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FresherRequest extends EmployeeRequest{
    private String graduationDate;
    private String rank;
    private String education;
}
