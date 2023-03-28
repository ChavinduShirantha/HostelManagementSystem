package lk.ijse.hibernate.d24;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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
        URL resource = getClass().getResource("/lk/ijse/hibernate/d24/view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        primaryStage.setTitle("D24 Hostel");
        primaryStage.setResizable(false);
        Image image = new Image("/lk/ijse/hibernate/d24/view/assest/images/logo.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
        /*primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/d24/view/LoginForm.fxml"))));
        primaryStage.setResizable(false);
        primaryStage.setTitle("D24 Hostel");
        primaryStage.centerOnScreen();
        primaryStage.show();*/
    }
}
