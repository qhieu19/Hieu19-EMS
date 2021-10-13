package Fsoft.MOOCProject.entities.entitiesDTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InternResponse extends EmployeeResponse{
    private String major;
    private int semester;
    private String education;
}
