package Fsoft.MockProject.entities.entitiesDTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private int id;
    private String username;
    private String password;
    private String role;
    private String status;
}
