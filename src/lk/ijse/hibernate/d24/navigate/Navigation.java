package lk.ijse.hibernate.d24.navigate;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/28/2023-10:05 AM
 **/
public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes routes,AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (routes){
            case Login:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;
            case Dashboard:
                window.setTitle("DashBoard Form");
                initUI("DashboardForm.fxml");
                break;
            case Student:
                window.setTitle("Student Form");
                initUI("StudentForm.fxml");
                break;
            case Room:
                window.setTitle("Room Form");
                initUI("RoomForm.fxml");
                break;
            case Signup:
                window.setTitle("Create New Account Form");
                initUI("SignUpForm.fxml");
                break;
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/hibernate/d24/view/" + location)));
    }
}
