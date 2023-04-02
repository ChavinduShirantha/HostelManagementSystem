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
import lk.ijse.hibernate.d24.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.view.tdm.StudentTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 3/28/2023-10:45 AM
 **/
public class StudentFormController {
    public TableView<StudentTM> tblStdDetails;
    public JFXTextField txtStdId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXComboBox cmbGender;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public DatePicker dpDate;

    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    public JFXButton btnAddId;


    public void initialize() throws IOException {
        tblStdDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("std_id"));
        tblStdDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStdDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStdDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblStdDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStdDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));

        getAllStudent();

        cmbGender.getItems().addAll("Male", "Female");

        tblStdDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnClear.setDisable(newValue == null);
            btnAdd.setText(newValue != null ? "Update Student" : "Add Student");
            btnAdd.setDisable(newValue == null);

            if (newValue != null) {
                txtStdId.setText(newValue.getStd_id());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtContact.setText(newValue.getContact());
                dpDate.setValue(LocalDate.parse(newValue.getDob()));
                cmbGender.setValue(newValue.getGender());

            }
        });
        clearFields();

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String std_id = txtStdId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String date = String.valueOf(dpDate.getValue());
        String gender = String.valueOf(cmbGender.getValue());


        if (btnAdd.getText().equalsIgnoreCase("Add Student")) {

            Student student = new Student(std_id, name, address, contact, date, gender);
            boolean addStudent = studentBO.saveStudent(student);

            if (addStudent) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Added Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student Added Failed !").show();
            }
            getAllStudent();

        } else if (btnAdd.getText().equalsIgnoreCase("Update Student")) {
            Student student = new Student(std_id, name, address, contact, date, gender);
            boolean updateStudent = studentBO.updateStudent(student);
            if (updateStudent) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student Updated Failed !").show();
            }

            btnAdd.setText("Add Student");
            txtStdId.setEditable(true);
            clearFields();
            getAllStudent();
            btnAdd.setDisable(false);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) throws IOException {
        boolean deleteStudent = studentBO.deleteStudent(txtStdId.getText());

        if (deleteStudent) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted Successfully !").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Student Deleted Failed !").show();
        }
        getAllStudent();
        clearFields();
    }

    public void clearFields() {
        txtStdId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        dpDate.setValue(null);
        cmbGender.setValue(null);
        btnAdd.setDisable(false);
    }

    public void cmbGender(ActionEvent actionEvent) {
    }

    public void getAllStudent() throws IOException {
        ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();

        tblStdDetails.getItems().clear();

        for (StudentDTO studentDTO : allStudent) {
            tblStdDetails.getItems().add(new StudentTM(
                    studentDTO.getStd_id(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getDob(),
                    studentDTO.getGender()
            ));
        }

    }

    public void btnAddIdOnAction(ActionEvent actionEvent) {
    }
}
