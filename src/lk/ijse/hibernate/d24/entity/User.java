package lk.ijse.hibernate.d24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Chavindu
 * created : 4/1/2023-5:56 PM
 **/
@Entity
@Table(name = "user")
public class User implements SuperEntity{
    @Id
    @Column(name = "user_name")
    String user_name;
    @Column(name = "password")
    String pwd;
    @Column(name = "name")
    String name;
    @Column(name = "sur_name")
    String surName;
    @Column(name = "city")
    String city;
    @Column(name = "contact")
    String contact;
    @Column(name = "email")
    String email;

    public User(String user_name, String pwd, String name, String surName, String city, String contact, String email) {
        this.user_name = user_name;
        this.pwd = pwd;
        this.name = name;
        this.surName = surName;
        this.city = city;
        this.contact = contact;
        this.email = email;
    }

    public User() {
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
