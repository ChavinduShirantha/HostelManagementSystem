package lk.ijse.hibernate.d24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String dob;
    @Column(name = "gender")
    private String gender;

    public Student() {
    }

    public Student(String std_id, String name, String address, String contact, String dob, String gender) {
        this.std_id = std_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
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

    public String getDate() {
        return dob;
    }

    public void setDate(String dob) {
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
