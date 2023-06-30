package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.impl.UserBOImpl;
import lk.ijse.hibernate.d24.entity.User;
import lk.ijse.hibernate.d24.navigate.Navigation;
import lk.ijse.hibernate.d24.navigate.Routes;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author : Chavindu
 * created : 3/28/2023-4:19 PM
 **/
public class SignUpFormController {
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtSurName;
    @FXML
    private JFXTextField txtCity;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXButton btnSignUp;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXPasswordField pwdPassword;
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView hidePwd;
    @FXML
    private ImageView showpwd;
    @FXML
    private Label lblErrorName;
    @FXML
    private Label lblErrorEmail;
    @FXML
    private Label lblErrorContact;
    @FXML
    private Label lblErrorSurName;
    @FXML
    private Label lblErrorCity;
    @FXML
    private Label lblErrorPassword;
    @FXML
    private Label lblErrorUserName;

    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize() {
        pwdPassword.setVisible(true);
        hidePwd.setVisible(false);
        showpwd.setVisible(true);
        txtPassword.setVisible(false);
        lblErrorName.setVisible(false);
        lblErrorSurName.setVisible(false);
        lblErrorCity.setVisible(false);
        lblErrorContact.setVisible(false);
        lblErrorEmail.setVisible(false);
        lblErrorUserName.setVisible(false);
        lblErrorPassword.setVisible(false);
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String pwd = pwdPassword.getText();
        String name = txtName.getText();
        String surname = txtSurName.getText();
        String city = txtCity.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

        Pattern patternName = Pattern.compile("^[A-Z][a-zA-Z]+$");
        Pattern patternSurName = Pattern.compile("^[A-Z][a-zA-Z]+$");
        Pattern patternCity = Pattern.compile("^[A-Z][a-zA-Z]+$");
        Pattern patternContact = Pattern.compile("^(?:\\+94|070|071|072|074|075|076|077|078)[0-9]{7,9}$");
        Pattern patternEmail = Pattern.compile("([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})");
        Pattern patternUserName = Pattern.compile("^[A-Z][a-zA-Z]+$");
        Pattern patternPassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");

        if (patternName.matcher(name).matches() & patternSurName.matcher(surname).matches() & patternCity.matcher(city).matches() &
                patternContact.matcher(contact).matches() & patternEmail.matcher(email).matches() & patternUserName.matcher(userName).matches() &
                patternPassword.matcher(pwd).matches()) {
            User user = new User(userName, pwd, name, surname, city, contact, email);
            boolean addUser = userBO.saveUser(user);

            if (addUser) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "User Added Failed !").show();
            }

            Navigation.navigate(Routes.Login, pane);
        } else {
            if (!patternName.matcher(name).matches()) {
                lblErrorName.setVisible(true);
                txtName.requestFocus();
                txtName.setFocusColor(Paint.valueOf("Red"));
            }
            if (!patternSurName.matcher(surname).matches()) {
                lblErrorSurName.setVisible(true);
                txtSurName.requestFocus();
                txtSurName.setFocusColor(Paint.valueOf("Red"));
            }
            if (!patternCity.matcher(city).matches()) {
                lblErrorCity.setVisible(true);
                txtCity.requestFocus();
                txtCity.setFocusColor(Paint.valueOf("Red"));
            }
            if (!patternContact.matcher(contact).matches()) {
                lblErrorContact.setVisible(true);
                txtContact.requestFocus();
                txtContact.setFocusColor(Paint.valueOf("Red"));
            }
            if (!patternEmail.matcher(email).matches()) {
                lblErrorEmail.setVisible(true);
                txtEmail.requestFocus();
                txtEmail.setFocusColor(Paint.valueOf("Red"));
            }
            if (!patternUserName.matcher(userName).matches()) {
                lblErrorUserName.setVisible(true);
                txtUserName.requestFocus();
                txtUserName.setFocusColor(Paint.valueOf("Red"));
            }
            if (!patternPassword.matcher(pwd).matches()) {
                lblErrorPassword.setVisible(true);
                pwdPassword.requestFocus();
                pwdPassword.setFocusColor(Paint.valueOf("Red"));
                new Alert(Alert.AlertType.ERROR, "New User Added Failed!").show();
            }
        }

    }


    public void hidePwdOnAction(MouseEvent mouseEvent) {
        pwdPassword.setVisible(true);
        hidePwd.setVisible(false);
        showpwd.setVisible(true);
        txtPassword.setVisible(false);
    }

    public void showpwdOnAction(MouseEvent mouseEvent) {
        String pwd = pwdPassword.getText();
        pwdPassword.setVisible(false);
        txtPassword.setText(pwd);
        showpwd.setVisible(false);
        hidePwd.setVisible(true);
        txtPassword.setVisible(true);
    }
}
