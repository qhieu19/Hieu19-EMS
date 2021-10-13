package Fsoft.MOOCProject.entities.entitiesDTO.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExperienceRequest extends EmployeeRequest{
    private int expInYear;
    private String proSkill;
}
