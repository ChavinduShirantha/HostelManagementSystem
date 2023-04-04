package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hibernate.d24.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.d24.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Reservation;
import lk.ijse.hibernate.d24.view.tdm.ReservationTM;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/2/2023-3:32 PM
 **/
public class ReservationFormController {
    public TableView<ReservationTM> tblReservation;
    public JFXTextField txtResId;
    public JFXComboBox cmbStd_id;
    public JFXComboBox cmbRoomType;
    public DatePicker dpdate;
    public JFXTextField txtStatus;
    public JFXButton btnAdd;
    public JFXButton btnClear;

    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    private final RoomBOImpl roomBO = (RoomBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    private final ReservationBOImpl reservationBO = (ReservationBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public void initialize(){

        tblReservation.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("res_id"));
        tblReservation.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblReservation.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        tblReservation.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        tblReservation.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));


        getAllReservation();


        tblReservation.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnClear.setDisable(newValue == null);
            btnAdd.setText(newValue != null ? "Update" : "Add");
            btnAdd.setDisable(newValue == null);

            if (newValue != null) {
                txtResId.setText(newValue.getRes_id());
                dpdate.setValue(newValue.getDate());
                cmbStd_id.setValue(newValue.getStudent_id());
                cmbRoomType.setValue(newValue.getRoom_type_id());
                txtStatus.setText(newValue.getStatus());
            }
        });
        clearFields();
        loadCmbData();
    }
    public void btnAddOnAction(ActionEvent actionEvent) {
        String res_id = txtResId.getText();
        LocalDate date = dpdate.getValue();
        String std_id = String.valueOf(cmbStd_id.getValue());
        String room_type = String.valueOf(cmbRoomType.getValue());
        String status = txtStatus.getText();


        if (btnAdd.getText().equalsIgnoreCase("Add")) {

            Reservation reservation = new Reservation(res_id, date, std_id, room_type, status);
            boolean addReservation = reservationBO.saveReservation(reservation);

            if (addReservation) {
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Added Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Reservation Added Failed !").show();
            }
            getAllReservation();

        } else if (btnAdd.getText().equalsIgnoreCase("Update")) {
            Reservation reservation = new Reservation(res_id, date, std_id, room_type, status);
            boolean updateReservation = reservationBO.updateReservation(reservation);
            if (updateReservation) {
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Updated Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Reservation Updated Failed !").show();
            }

            btnAdd.setText("Add");
            clearFields();
            getAllReservation();
            btnAdd.setDisable(false);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        boolean deleteReservation = reservationBO.deleteReservation(txtResId.getText());

        if (deleteReservation) {
            new Alert(Alert.AlertType.CONFIRMATION, "Reservation Deleted Successfully !").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Reservation Deleted Failed !").show();
        }
        getAllReservation();
        clearFields();
    }

    private void loadCmbData(){
        for (RoomDTO roomDTO : roomBO.getAllRoom()) {
            cmbRoomType.getItems().add(roomDTO.getR_type());
        }

        for (StudentDTO dto : studentBO.getAllStudent()) {
            cmbStd_id.getItems().add(dto.getStd_id());
        }
    }

    public void getAllReservation(){
        ArrayList<ReservationDTO> allreservation = reservationBO.getAllReservation();

        tblReservation.getItems().clear();

        for (ReservationDTO reservationDTO : allreservation) {
            tblReservation.getItems().add(new ReservationTM(
                    reservationDTO.getRes_id(),
                    reservationDTO.getDate(),
                    reservationDTO.getStudent_id(),
                    reservationDTO.getRoom_type_id(),
                    reservationDTO.getStatus()
            ));
        }

    }

    public void clearFields() {
        txtResId.clear();
        cmbStd_id.setValue(null);
        cmbRoomType.setValue(null);
        txtStatus.clear();
        dpdate.setValue(null);
    }
}
