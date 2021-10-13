package Fsoft.MOOCProject.entities.entitiesDTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private int id;
    private String username;
    private String password;
    private int rId;
    private String status;
}
