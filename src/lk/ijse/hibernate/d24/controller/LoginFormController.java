package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
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

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Dashboard, pane);
    }
}
