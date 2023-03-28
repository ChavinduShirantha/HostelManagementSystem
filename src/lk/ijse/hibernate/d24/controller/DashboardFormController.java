package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    public Pane menubar;
    public Pane btnDashboard;
    public Pane panetxtDashboard;
    public Pane panetxtManageStudent;
    public JFXButton btnManageStudent;
    public JFXButton btnDashbord;
    public AnchorPane pane1;
    public JFXButton btnManageRoom;
    public Pane panetxtManageRoom;

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

    public void btnDashBoardOnAction1(MouseEvent mouseEvent) {
        panetxtDashboard.setVisible(true);
    }

    public void btnDashBoardOnAction2(MouseEvent mouseEvent) {
        panetxtDashboard.setVisible(false);
    }

    public void btnManageStudentOnAction1(MouseEvent mouseEvent) {
        panetxtManageStudent.setVisible(true);
    }

    public void btnManageStudentOnAction2(MouseEvent mouseEvent) {
        panetxtManageStudent.setVisible(false);
    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Dashboard, pane);
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Student, pane1);
    }

    public void btnManageRoomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Room,pane1);
    }

    public void btnManageRoomOnAction1(MouseEvent mouseEvent) {
        panetxtManageRoom.setVisible(true);
    }

    public void btnManageRoomOnAction2(MouseEvent mouseEvent) {
        panetxtManageRoom.setVisible(false);
    }
}
