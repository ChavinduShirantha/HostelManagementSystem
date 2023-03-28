package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.navigate.Navigation;
import lk.ijse.hibernate.d24.navigate.Routes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author : Chavindu
 * created : 3/28/2023-10:48 AM
 **/
public class DashboardFormController {
    public Label lblTime;
    public Label lblDate;
    public JFXButton btnLogout;
    public AnchorPane pane;

    public void initialize() {
        loadDate();
        loadTime();
    }

    public void loadDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void loadTime() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(time);
                });

            }

        });
        thread.start();
    }

    public void LogoutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Login, pane);
    }
}
