package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
    public AnchorPane pane1;
    public JFXButton btnManageRoom;
    public Pane panetxtManageRoom;
    public ImageView imgDashBoard;
    public ImageView imgStudent;
    public ImageView imgRoom;

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

    public void btnManageRoomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.Room, pane1);
    }

    public void dashboardOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.Dashboard, pane);
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch (icon.getId()) {
                case "imgDashBoard":
                    panetxtDashboard.setVisible(true);
                    break;
                case "imgStudent":
                    panetxtManageStudent.setVisible(true);
                    break;
                case "imgRoom":
                    panetxtManageRoom.setVisible(true);
                    break;
                /*case "imgViewOrders":

                    break;*/
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }

    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            panetxtDashboard.setVisible(false);
            panetxtManageStudent.setVisible(false);
            panetxtManageRoom.setVisible(false);
        }

    }

    public void manageStudentOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.Student, pane1);
    }

    public void manageRoomOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.Room,pane1);
    }
}
