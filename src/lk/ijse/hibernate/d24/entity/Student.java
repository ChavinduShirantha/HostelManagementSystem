package lk.ijse.hibernate.d24.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author : Chavindu
 * created : 3/29/2023-9:24 AM
 **/
@Entity
@Table(name = "student")
public class Student implements SuperEntity {
    @Id
    @Column(name = "student_id")
    private String std_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<RegisterStudent> reservation;

    public Student() {
    }

    public Student(String std_id, String name, String address, String contact, LocalDate dob, String gender, List<RegisterStudent> reservation) {
        this.std_id = std_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
        this.reservation = reservation;
    }

    public Student(String std_id, String name, String address, String contact, LocalDate dob, String gender) {
        this.std_id = std_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }

    public Student(String stdId) {
        this.std_id = stdId;
    }


    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDate() {
        return dob;
    }

    public void setDate(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "std_id='" + std_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}
