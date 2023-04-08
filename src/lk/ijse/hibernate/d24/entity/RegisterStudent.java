package lk.ijse.hibernate.d24.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 4/7/2023-3:30 PM
 **/
@Entity
@Table(name = "reservation")
public class RegisterStudent implements SuperEntity{
    @Id
    @Column(name = "res_id")
    private String res_id;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",referencedColumnName = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_type_id",referencedColumnName = "room_type_id")
    private Room room;
    private String status;

    public RegisterStudent() {
    }

    public RegisterStudent(String res_id, LocalDate date, Student student, Room room, String status) {
        this.res_id = res_id;
        this.date = date;
        this.student = student;
        this.room = room;
        this.status = status;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegisterStudent{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", student=" + student +
                ", room=" + room +
                ", status='" + status + '\'' +
                '}';
    }
}
