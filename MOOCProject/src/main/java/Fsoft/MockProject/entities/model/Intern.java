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
public class Intern extends Employee {
    private String major;
    private int semester;
    private String education;

    @Override
    public String toString() {
        return "Intern{" +
                "major='" + major + '\'' +
                ", semester=" + semester +
                ", education='" + education + '\'' +
                "} " + super.toString();
    }
}
