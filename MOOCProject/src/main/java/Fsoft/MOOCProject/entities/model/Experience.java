package Fsoft.MOOCProject.entities.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "eid")
public class Experience extends Employee{
    @Column(name = "exp")
    private int expInYear;
    @Column(name = "skills")
    private String proSkill;

    public Experience(String fullName, String birthDay, String phone, String email, String type, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInformation(){
        System.out.println("ID: " + super.getId() + " | Full name: " + super.getFullName() + " | DOB: " + super.getBirthDay() + " | Phone number: " + super.getPhone() + " | Email: " + super.getEmail() + " | Type: " + super.getType() + " | Exp: " + expInYear + " | Skills: " + proSkill);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                "} " + super.toString();
    }
}
