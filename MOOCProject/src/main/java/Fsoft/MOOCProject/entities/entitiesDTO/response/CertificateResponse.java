package Fsoft.MOOCProject.entities.entitiesDTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateResponse {
    private int id;
    private int eId;
    private String name;
    private String rank;
    private String date;
}
