package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

/**
 * @author : Chavindu
 * created : 4/2/2023-3:32 PM
 **/
public class ReservationFormController {
    public TableView tblReservation;
    public JFXTextField txtResId;
    public JFXComboBox cmbStd_id;
    public JFXComboBox cmbRoomType;
    public DatePicker date;
    public JFXTextField txtStatus;
    public JFXButton btnAdd;
    public JFXButton btnClear;

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }
}
