package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.impl.UserBOImpl;
import lk.ijse.hibernate.d24.navigate.Navigation;
import lk.ijse.hibernate.d24.navigate.Routes;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/27/2023-5:41 PM
 **/
public class LoginFormController {
    public AnchorPane pane;
    public JFXButton btnLogin;
    public JFXButton btnSignUp;
    public JFXTextField txtUserName;
    public JFXTextField txtPwd;
    public ImageView hidePwd;
    public ImageView showpwd;
    public JFXPasswordField pwdPassword;
    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize() {
        pwdPassword.setVisible(true);
        hidePwd.setVisible(false);
        showpwd.setVisible(true);
        txtPwd.setVisible(false);
    }

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        /*ArrayList<UserDTO> allUser = userBO.getAllUser();

        for (UserDTO userDTO : allUser) {

            if(userDTO.getUser_name().equals(txtUserName.getText()) && userDTO.getPwd().equals(pwdPassword.getText())){*/
        Navigation.navigate(Routes.Dashboard, pane);
            /*}else{
                new Alert(Alert.AlertType.ERROR,"Login Failed..").show();
            }
        }*/

    }

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Signup, pane);
    }

    public void hidePwdOnAction(MouseEvent mouseEvent) {
        pwdPassword.setVisible(true);
        hidePwd.setVisible(false);
        showpwd.setVisible(true);
        txtPwd.setVisible(false);
    }

    public void showpwdOnAction(MouseEvent mouseEvent) {
        String pwd = pwdPassword.getText();
        pwdPassword.setVisible(false);
        txtPwd.setText(pwd);
        showpwd.setVisible(false);
        hidePwd.setVisible(true);
        txtPwd.setVisible(true);
    }
}
