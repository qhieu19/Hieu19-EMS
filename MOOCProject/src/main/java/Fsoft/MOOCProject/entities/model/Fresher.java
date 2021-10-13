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
public class Fresher extends Employee{
    @Column(name = "gradDate")
    private String graduationDate;
    @Column(name = "rank")
    private String rank;
    @Column(name = "education")
    private String education;

    public Fresher(String fullName, String birthDay, String phone, String email, String type, String graduationDate, String rank, String education) {
        super(fullName, birthDay, phone, email, type);
        this.graduationDate = graduationDate;
        this.rank = rank;
        this.education = education;
    }


    @Override
    public void showInformation(){
        System.out.println("ID: " + super.getId() + " | Full name: " + super.getFullName() + " | DOB: " + super.getBirthDay() + " | Phone number: " + super.getPhone() + " | Email: " + super.getEmail() + " | Type: " + super.getType() + " | Graduation date: " + graduationDate + " | Rank: " + rank + " | Education: " + education);
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate='" + graduationDate + '\'' +
                ", rank='" + rank + '\'' +
                ", education='" + education + '\'' +
                "} " + super.toString();
    }
}
