package Fsoft.MOOCProject.entities.entitiesDTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FresherResponse extends EmployeeResponse{
    private String graduationDate;
    private String rank;
    private String education;
}
