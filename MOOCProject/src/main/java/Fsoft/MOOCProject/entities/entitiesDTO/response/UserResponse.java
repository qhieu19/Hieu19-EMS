package Fsoft.MOOCProject.entities.entitiesDTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String username;
    private String password;
    private int rId;
    private String status;
}
