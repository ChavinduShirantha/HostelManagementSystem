package lk.ijse.hibernate.d24.dto;

import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.entity.Student;

import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 4/7/2023-3:35 PM
 **/
public class RegisterStudentDTO {
    private String res_id;
    private LocalDate date;
    private Student student;
    private Room room;
    private String status;

    public RegisterStudentDTO() {
    }

    public RegisterStudentDTO(String res_id, LocalDate date, Student student, Room room, String status) {
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
