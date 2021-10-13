package Fsoft.MOOCProject.entities.model;

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
    @Column(name = "major")
    private String major;
    @Column(name = "semester")
    private int semester;
    @Column(name = "education")
    private String education;

    public Intern(String fullName, String birthDay, String phone, String email, String type, int count, String major, int semester, String education) {
        super(fullName, birthDay, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.education = education;
    }

    @Override
    public void showInformation(){
        System.out.println("ID: " + super.getId() + " | Full name: " + super.getFullName() + " | DOB: " + super.getBirthDay() + " | Phone number: " + super.getPhone() + " | Email: " + super.getEmail() + " | Type: " + super.getType() +   " | Major: " + major + " | Semester: " + semester + " | Education: " + education);
    }

    @Override
    public String toString() {
        return "Intern{" +
                "major='" + major + '\'' +
                ", semester=" + semester +
                ", education='" + education + '\'' +
                "} " + super.toString();
    }
}
