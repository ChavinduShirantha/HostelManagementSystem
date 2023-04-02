package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.impl.UserBOImpl;
import lk.ijse.hibernate.d24.entity.User;
import lk.ijse.hibernate.d24.navigate.Navigation;
import lk.ijse.hibernate.d24.navigate.Routes;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/28/2023-4:19 PM
 **/
public class SignUpFormController {
    public JFXTextField txtName;
    public JFXTextField txtSurName;
    public JFXTextField txtCity;
    public JFXTextField txtContact;
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXButton btnSignUp;
    public JFXTextField txtPassword;
    public JFXPasswordField pwdPassword;
    public AnchorPane pane;
    public ImageView hidePwd;
    public ImageView showpwd;


    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize() {
        pwdPassword.setVisible(true);
        hidePwd.setVisible(false);
        showpwd.setVisible(true);
        txtPassword.setVisible(false);
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        String userName=txtUserName.getText();
        String pwd=txtPassword.getText();
        String name=txtName.getText();
        String surname = txtSurName.getText();
        String city = txtCity.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();

            User user = new User(userName, pwd, name, surname, city, contact,email);
            boolean addUser = userBO.saveUser(user);

            if (addUser) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfully !").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "User Added Failed !").show();
            }

        Navigation.navigate(Routes.Login,pane);
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
