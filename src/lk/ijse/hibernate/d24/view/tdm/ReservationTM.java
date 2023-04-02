package lk.ijse.hibernate.d24.view.tdm;

import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 4/2/2023-3:21 PM
 **/
public class ReservationTM {
    private String res_id;
    private LocalDate date;
    private String student_id;
    private String room_type_id;
    private String status;

    public ReservationTM() {
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
        return "ReservationTM{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", student_id='" + student_id + '\'' +
                ", room_type_id='" + room_type_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
