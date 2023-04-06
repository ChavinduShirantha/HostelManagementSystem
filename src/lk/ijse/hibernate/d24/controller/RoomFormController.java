package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.view.tdm.RoomTM;


import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 3/28/2023-10:46 AM
 **/
public class RoomFormController {
    @FXML
    private JFXComboBox cmbRoomType;
    @FXML
    private TableView<RoomTM> tblRoomDetails;
    @FXML
    private JFXComboBox cmbRoomID;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXTextField txtKeyMoney;
    @FXML
    private JFXTextField txtRoomType;
    @FXML
    private JFXTextField txtRoomID;
    @FXML
    private JFXButton btnAddNew;



    private final RoomBOImpl roomBO = (RoomBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void initialize() throws IOException {
        tblRoomDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("r_id"));
        tblRoomDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("r_type"));
        tblRoomDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("key_money"));
        tblRoomDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));

        getAllRoom();
        setCmbRoomIds();
        setCmbRoomTypes();

        tblRoomDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnClear.setDisable(newValue == null);
            btnAdd.setText(newValue != null ? "Update Room" : "Add Room");
            btnAdd.setDisable(newValue == null);

            if (newValue != null) {
                cmbRoomID.setValue(newValue.getR_id());
                cmbRoomType.setValue(newValue.getR_type());
                txtKeyMoney.setText(newValue.getKey_money());
                txtQty.setText(String.valueOf(newValue.getQty()));
            }
        });
    }
    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String r_id = String.valueOf(cmbRoomID.getValue());
        String r_type = String.valueOf(cmbRoomType.getValue());
        String key_money = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        if (btnAdd.getText().equalsIgnoreCase("Add Room")) {

            Room room = new Room(r_id,r_type,key_money,qty);
            boolean addRoom = roomBO.saveRoom(room);

            if (addRoom) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room Added Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Room Added Failed !").show();
            }
            getAllRoom();
            clearFields();

        } else if (btnAdd.getText().equalsIgnoreCase("Update Room")) {
            Room room = new Room(r_id,r_type,key_money,qty);
            boolean updateRoom = roomBO.updateRoom(room);
            if (updateRoom) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room Updated Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Room Updated Failed !").show();
            }

            btnAdd.setText("Add Student");
            clearFields();
            getAllRoom();
            btnAdd.setDisable(false);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) throws IOException {
        boolean deleteRoom = roomBO.deleteRoom(String.valueOf(cmbRoomID.getValue()));

        if (deleteRoom) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room Deleted Successfully !").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Room Deleted Failed !").show();
        }
        getAllRoom();
        clearFields();
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        String roomId= txtRoomID.getText();
        String roomType= txtRoomType.getText();
        cmbRoomID.getItems().addAll(roomId);
        cmbRoomType.getItems().addAll(roomType);

        txtRoomType.clear();
        txtRoomID.clear();
    }
    public void clearFields() {
        txtRoomID.clear();
        txtKeyMoney.clear();
        txtQty.clear();
        txtRoomType.clear();
        cmbRoomID.setValue(null);
        cmbRoomType.setValue(null);
        btnAdd.setDisable(false);
    }

    public void getAllRoom() throws IOException {
        ArrayList<RoomDTO> allRoom = roomBO.getAllRoom();

        tblRoomDetails.getItems().clear();

        for (RoomDTO roomDTO : allRoom) {
            tblRoomDetails.getItems().add(new RoomTM(
                    roomDTO.getR_id(),
                    roomDTO.getR_type(),
                    roomDTO.getKey_money(),
                    roomDTO.getQty()
            ));
        }

    }

    private void setCmbRoomTypes() throws IOException {
        cmbRoomType.getItems().clear();
        for (RoomDTO roomDTO : roomBO.getAllRoom()) {
            cmbRoomType.getItems().add(roomDTO.getR_type());
        }

    }

    private void setCmbRoomIds() throws IOException {
        cmbRoomID.getItems().clear();
        for (RoomDTO roomDTO : roomBO.getAllRoom()) {
            cmbRoomID.getItems().add(roomDTO.getR_id());
        }

    }
}
