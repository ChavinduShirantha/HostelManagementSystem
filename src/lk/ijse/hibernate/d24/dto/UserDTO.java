package lk.ijse.hibernate.d24.dto;


/**
 * @author : Chavindu
 * created : 4/1/2023-6:03 PM
 **/
public class UserDTO {
    String user_name;
    String pwd;
    String name;
    String surName;
    String city;
    String contact;
    String email;

    public UserDTO(String user_name, String pwd, String name, String surName, String city, String contact, String email) {
        this.user_name = user_name;
        this.pwd = pwd;
        this.name = name;
        this.surName = surName;
        this.city = city;
        this.contact = contact;
        this.email = email;
    }

    public UserDTO() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
