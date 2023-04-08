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
import lk.ijse.hibernate.d24.bo.custom.impl.RegisterBOImpl;
import lk.ijse.hibernate.d24.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.d24.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;
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
    private final RegisterBOImpl registerBO = (RegisterBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);

    public void initialize(){

        tblReservation.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("res_id"));
        tblReservation.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblReservation.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        tblReservation.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        tblReservation.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));


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


    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    private void loadCmbData(){
        for (RoomDTO roomDTO : roomBO.getAllRoom()) {
            cmbRoomType.getItems().add(roomDTO.getR_type());
        }

        for (StudentDTO dto : studentBO.getAllStudent()) {
            cmbStd_id.getItems().add(dto.getStd_id());
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
