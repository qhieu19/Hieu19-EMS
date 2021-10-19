package Fsoft.MockProject.entities.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "eid")
public class Fresher extends Employee{
    private String graduationDate;
    private String rank;
    private String education;

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate='" + graduationDate + '\'' +
                ", rank='" + rank + '\'' +
                ", education='" + education + '\'' +
                "} " + super.toString();
    }
}
