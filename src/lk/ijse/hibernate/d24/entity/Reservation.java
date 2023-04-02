package lk.ijse.hibernate.d24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 4/2/2023-3:12 PM
 **/
@Entity
@Table(name = "reservation")
public class Reservation implements SuperEntity{
    @Id()
    @Column(name = "res_id")
    private String res_id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "student_id")
    private String student_id;
    @Column(name = "room_type_id")
    private String room_type_id;
    @Column(name = "status")
    private String status;

    public Reservation() {
    }

    public Reservation(String res_id, LocalDate date, String student_id, String room_type_id, String status) {
        this.res_id = res_id;
        this.date = date;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", student_id='" + student_id + '\'' +
                ", room_type_id='" + room_type_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
