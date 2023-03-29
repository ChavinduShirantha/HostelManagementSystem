package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.view.tdm.StudentTM;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author : Chavindu
 * created : 3/28/2023-10:45 AM
 **/
public class StudentFormController {
    public TableView tblStdDetails;
    public JFXTextField txtStdId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXComboBox cmbGender;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public DatePicker dpDate;

    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    public void initialize(){
        cmbGender.getItems().addAll("Male", "Female");
    }
    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String std_id = txtStdId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String date = String.valueOf(dpDate.getValue());
        String gender = String.valueOf(cmbGender.getValue());
        StudentDTO s1 = new StudentDTO(std_id,name,address,contact,date,gender);
//        Student student = new Student(s1.getStd_id(), s1.getName(), s1.getAddress(), s1.getContact(), s1.getDob(), s1.getGender());
        Student student=new Student(std_id,name,address,contact,date,gender);
        boolean addStudent = studentBO.saveStudent(student);
        if (addStudent){
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successfully !").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Student Added Failed !").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    public void clearFields(){
        txtStdId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        dpDate.setValue(null);
        cmbGender.setValue(null);
    }
    public void cmbGender(ActionEvent actionEvent) {
    }
}
