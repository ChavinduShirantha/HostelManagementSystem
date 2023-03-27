package lk.ijse.hibernate.d24;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/27/2023-5:38 PM
 **/

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/d24/view/LoginForm.fxml"))));
        primaryStage.setResizable(false);
        primaryStage.setTitle("D24 Hostel");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
