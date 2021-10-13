package Fsoft.MOOCProject.entities.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "eid")
    private int eId;
    @Column(name = "name")
    private String name;
    @Column(name = "rank")
    private String rank;
    @Column(name = "date")
    private String date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return eId == that.eId && Objects.equals(name, that.name);
    }
}
