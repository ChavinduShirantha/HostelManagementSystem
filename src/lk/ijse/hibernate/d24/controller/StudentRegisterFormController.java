package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.RegisterBO;
import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dto.RegisterStudentDTO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;
import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 4/6/2023-2:58 PM
 **/
public class StudentRegisterFormController {
    @FXML
    private Label lblAllRoom;
    @FXML
    private Label lblUsedRoom;
    @FXML
    private Label lblRemainRoom;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private Label lblAvailable;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private DatePicker dpRegDate;
    @FXML
    private JFXComboBox cmbStd_id;
    @FXML
    private JFXTextField txtResId;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtKeyMoney;
    @FXML
    private JFXComboBox cmbRoom_id;
    @FXML
    private JFXTextField txtRoomType;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private DatePicker dpDate;
    @FXML
    private JFXComboBox cmbGender;
    @FXML
    private JFXTextField txtQty1;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnClear;
    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);
    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    public void initialize() throws IOException {

        cmbGender.getItems().addAll("Male","FeMale");

        for (StudentDTO dto : studentBO.getAllStudent()) {
            cmbStd_id.getItems().add(dto.getStd_id());
        }

        for (RoomDTO roomDTO : roomBO.getAllRoom()) {
            cmbRoom_id.getItems().add(roomDTO.getR_id());
        }

        cmbRoom_id.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                Room room = null;
                try {
                    room = roomBO.getRoom(String.valueOf(newValue));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                txtRoomType.setText(room.getR_type());
                txtKeyMoney.setText(String.valueOf(room.getKey_money()));
                txtQty.setText(String.valueOf(room.getQty()));
                lblAllRoom.setText(String.valueOf(room.getQty()));

               /* try {
                    List<ReserveDTO> reserveDTOS = reservationBO.searchReservedRoomById(newValue);

                    int count=0;
                    for (ReserveDTO reserveDTO : reserveDTOS) {
                        count++;
                    }

                    int remainQty=Integer.parseInt(txtQty.getText())-count;
                    lblUsedRooms.setText(String.valueOf(count));
                    lblRemainingRooms.setText(String.valueOf(remainQty));

                    if(remainQty==0){
                        lblAvailable.setText("Un-Available");
                    }else{
                        lblAvailable.setText("Available");
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }


        });

        cmbStd_id.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue!=null){
                Student student = null;
                try {
                    student = studentBO.getStudent(String.valueOf(newValue));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                txtName.setText(student.getName());
                txtAddress.setText(student.getAddress());
                txtContact.setText(student.getContact());
                cmbGender.getSelectionModel().select(student.getGender());
                dpDate.setValue(student.getDate());
            }

        });

    }
    public void cmbGender(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String regId=txtResId.getText();
        LocalDate regDate=dpRegDate.getValue();
        String std_id= String.valueOf(cmbStd_id.getValue());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate date = dpDate.getValue();
        String gender = String.valueOf(cmbGender.getValue());
        String roomId = String.valueOf(cmbRoom_id.getValue());
        String roomtype = txtRoomType.getText();
        String keyMoneyText = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());
        String status = txtQty1.getText();

        Student student = new Student(std_id, name, address, contact, date, gender);
        Room room = new Room(roomId, roomtype, keyMoneyText, qty);
        RegisterStudent registerStudent = new RegisterStudent(regId, regDate, student, room,status);


        boolean add = registerBO.saveRegister(registerStudent);

        if (add) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Registered Successfully !").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Student Registered Failed !").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        boolean deleteRegister = registerBO.deleteRegister(txtResId.getText());

        if (deleteRegister) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Successfully !").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Deleted Failed !").show();
        }
        clearFields();
    }
    public void clearFields() {
        txtResId.clear();
        txtRoomType.clear();
        txtQty.clear();
        txtQty1.clear();
        dpRegDate.setValue(null);
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        dpDate.setValue(null);
        cmbGender.setValue(null);
        cmbRoom_id.setValue(null);
        cmbStd_id.setValue(null);
        btnAdd.setDisable(false);
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String regId=txtResId.getText();
        LocalDate regDate=dpRegDate.getValue();
        String std_id= String.valueOf(cmbStd_id.getValue());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate date = dpDate.getValue();
        String gender = String.valueOf(cmbGender.getValue());
        String roomId = String.valueOf(cmbRoom_id.getValue());
        String roomtype = txtRoomType.getText();
        String keyMoneyText = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());
        String status = txtQty1.getText();

        Student student = new Student(std_id, name, address, contact, date, gender);
        Room room = new Room(roomId, roomtype, keyMoneyText, qty);
        RegisterStudent registerStudent = new RegisterStudent(regId, regDate, student, room,status);

        boolean update = registerBO.updateRegister(registerStudent);
        if (update) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated Successfully !").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Updated Failed !").show();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws IOException {
        String reg_id=txtResId.getText();

        RegisterStudent register = registerBO.getRegister(reg_id);
        cmbStd_id.setValue(register.getStudent().getStd_id());
        txtName.setText(register.getStudent().getName());
        txtAddress.setText(register.getStudent().getAddress());
        txtContact.setText(register.getStudent().getContact());
        dpDate.setValue(register.getStudent().getDate());
        cmbGender.setValue(register.getStudent().getGender());

        cmbRoom_id.setValue(register.getRoom().getR_id());
        txtRoomType.setText(register.getRoom().getR_type());
        txtKeyMoney.setText(register.getRoom().getKey_money());
        txtQty.setText(String.valueOf(register.getRoom().getQty()));

        txtQty1.setText(register.getStatus());
        dpRegDate.setValue(register.getDate());
    }
}
