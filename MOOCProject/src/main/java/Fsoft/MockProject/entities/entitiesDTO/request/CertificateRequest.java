package Fsoft.MockProject.entities.entitiesDTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificateRequest {
    private int id;
    private int eId;
    private String name;
    private String rank;
    private String date;
}
