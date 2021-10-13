package Fsoft.MOOCProject.entities.entitiesDTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceResponse extends EmployeeResponse{
    private int expInYear;
    private String proSkill;
}
