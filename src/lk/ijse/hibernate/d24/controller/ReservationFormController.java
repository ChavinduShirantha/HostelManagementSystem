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
import lk.ijse.hibernate.d24.dto.RegisterStudentDTO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;
import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.view.tdm.ReservationTM;


import java.io.IOException;
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

    public void initialize() throws IOException {

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

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String regId = txtResId.getText();
        LocalDate regDate = dpdate.getValue();
        String std_id = String.valueOf((cmbStd_id.getValue()));
        String roomId = String.valueOf((cmbRoomType.getValue()));
        String status = txtStatus.getText();


        if (btnAdd.getText().equalsIgnoreCase("Add")) {
            Student student = new Student(std_id);
            Room room = new Room(roomId);
            RegisterStudent registerStudent = new RegisterStudent(regId, regDate, student, room, status);

            boolean add = registerBO.saveRegister(registerStudent);

            if (add) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Added Failed !").show();
            }
            getAllReservation();

        } else if (btnAdd.getText().equalsIgnoreCase("Student")) {
            Student student = new Student(std_id);
            Room room = new Room(roomId);
            RegisterStudent registerStudent = new RegisterStudent(regId, regDate, student, room, status);

            boolean update = registerBO.updateRegister(registerStudent);
            if (update) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Updated Failed !").show();
            }

            btnAdd.setText("Student");
            txtResId.setEditable(true);
            clearFields();
            getAllReservation();
            btnAdd.setDisable(false);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) throws IOException {
        boolean delete = registerBO.deleteRegister(txtResId.getText());

        if (delete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Successfully !").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Deleted Failed !").show();
        }
        getAllReservation();
        clearFields();
    }

    private void loadCmbData() {
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

    public void getAllReservation() throws IOException {
        ArrayList<RegisterStudentDTO> allReg = registerBO.getAllReg();

        tblReservation.getItems().clear();

        for (RegisterStudentDTO registerStudentDTO : allReg) {
            tblReservation.getItems().add(new ReservationTM(
                    registerStudentDTO.getRes_id(),
                    registerStudentDTO.getDate(),
                    registerStudentDTO.getStudent().getStd_id(),
                    registerStudentDTO.getRoom().getR_id(),
                    registerStudentDTO.getStatus()
            ));
        }

    }
}
