package Fsoft.MOOCProject.entities.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String fullName;
    @Column(name = "dob")
    private String birthDay;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    private String type;

    public Employee(String fullName, String birthDay, String phone, String email, String type) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public Employee() {

    }

    public void showInformation(){
        System.out.println("ID: " + id + " | Full name: " + fullName + " | DOB: " + birthDay + " | Phone number: " + phone + " | Email: " + email + " | Type: " + type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fullName, employee.fullName) && Objects.equals(birthDay, employee.birthDay) && Objects.equals(phone, employee.phone) && Objects.equals(email, employee.email) && Objects.equals(type, employee.type);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
