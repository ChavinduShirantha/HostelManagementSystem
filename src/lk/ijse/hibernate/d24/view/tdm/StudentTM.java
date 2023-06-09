package lk.ijse.hibernate.d24.view.tdm;

import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:44 AM
 **/
public class StudentTM {
    private String std_id;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

    public StudentTM() {
    }

    public StudentTM(String std_id, String name, String address, String contact, LocalDate dob, String gender) {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
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
        return "StudentTM{" +
                "std_id='" + std_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}
