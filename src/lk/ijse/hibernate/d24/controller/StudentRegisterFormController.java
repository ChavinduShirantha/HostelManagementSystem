package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

/**
 * @author : Chavindu
 * created : 4/6/2023-2:58 PM
 **/
public class StudentRegisterFormController {
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

    public void cmbGender(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }
}
