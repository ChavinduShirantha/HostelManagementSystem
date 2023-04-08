package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.RegisterBO;
import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.d24.bo.custom.impl.UserBOImpl;
import lk.ijse.hibernate.d24.dto.RegisterStudentDTO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.dto.UserDTO;
import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.entity.User;
import lk.ijse.hibernate.d24.navigate.Navigation;
import lk.ijse.hibernate.d24.navigate.Routes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Chavindu
 * created : 3/28/2023-10:48 AM
 **/
public class DashboardFormController {
    @FXML
    private Label lblFemale;
    @FXML
    private Label lblMale;
    @FXML
    private Label lblTotRoom;
    @FXML
    private Label lblTotUsedRoom;
    @FXML
    private Label lblTotAvailable;
    @FXML
    private ImageView imgRegister;
    @FXML
    private Pane panetxtManageRegister;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblDate;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private AnchorPane pane;
    @FXML
    private Pane menubar;
    @FXML
    private Pane btnDashboard;
    @FXML
    private Pane panetxtDashboard;
    @FXML
    private Pane panetxtManageStudent;
    @FXML
    private AnchorPane pane1;
    @FXML
    private Pane panetxtManageRoom;
    @FXML
    private ImageView imgDashBoard;
    @FXML
    private ImageView imgStudent;
    @FXML
    private ImageView imgRoom;
    @FXML
    private ImageView imgReservation;
    @FXML
    private Pane panetxtManageReservation;
    @FXML
    private Label lblUserName;
    @FXML
    private ImageView imgUser;
    @FXML
    private Pane pane5;
    @FXML
    private JFXTextField txtgetUserName;
    @FXML
    private Button btnChange;
    @FXML
    private JFXPasswordField setPassword;
    @FXML
    private JFXPasswordField getPassword;
    @FXML
    private ImageView show1;
    @FXML
    private ImageView show2;
    @FXML
    private ImageView hide1;
    @FXML
    private ImageView hide2;
    @FXML
    private JFXTextField txtSetPassword;
    @FXML
    private JFXTextField txtGetPassword;
    @FXML
    private Button btnSearch;
    @FXML
    private Label lblTotStudent;
    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);

    public void initialize() {
        loadDate();
        loadTime();
        getPassword.setVisible(true);
        setPassword.setVisible(true);
        show1.setVisible(true);
        show2.setVisible(true);
        hide1.setVisible(false);
        hide2.setVisible(false);
        txtGetPassword.setVisible(false);
        txtSetPassword.setVisible(false);


            List<RoomDTO> roomDTOS = roomBO.getAllRoom();

            int count=0;
            int count2=0;
            for (RoomDTO roomDTO : roomDTOS) {
                count+=roomDTO.getQty();
                count2++;
            }
            lblTotRoom.setText(String.valueOf(count));
            int remainQty=Integer.parseInt(lblTotRoom.getText())-count2;
            lblTotUsedRoom.setText(String.valueOf(count2));
            lblTotAvailable.setText(String.valueOf(remainQty));


        List<StudentDTO> studentDTOS = studentBO.getAllStudent();

        int count1=0;
        int countAll=0;
        for (StudentDTO studentDTO : studentDTOS) {
            countAll++;
            if (studentDTO.getGender().equals("Male")){
                count1++;
            }
        }
        lblTotStudent.setText(String.valueOf(countAll));
        int female=Integer.parseInt(lblTotStudent.getText())-count1;
        lblMale.setText(String.valueOf(count1));
        lblFemale.setText(String.valueOf(female));


    }

    public void loadDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void loadTime() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss aa");
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
                case "imgReservation":
                    panetxtManageReservation.setVisible(true);
                    break;
                case "imgRegister":
                    panetxtManageRegister.setVisible(true);
                    break;
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
            panetxtManageReservation.setVisible(false);
            panetxtManageRegister.setVisible(false);
        }

    }

    public void manageStudentOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.Student, pane1);
    }

    public void manageRoomOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.Room, pane1);
    }

    public void manageReservationOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.RESERVATION, pane1);
    }

    public void userOnAction(MouseEvent mouseEvent) {
        pane5.setVisible(true);
        String name = txtgetUserName.getText();
        lblUserName.setText(name);
    }

    public void changeOnAction(ActionEvent actionEvent) {
        pane5.setVisible(false);
        String name = txtgetUserName.getText();
        String pwd = setPassword.getText();
        User user = new User(name, pwd);
        boolean updateUser = userBO.updateUser(user);
        if (updateUser) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Updated Successfully !").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "User Updated Failed !").show();
        }
        txtgetUserName.clear();
        getPassword.clear();
        setPassword.clear();
    }

    public void show1OnAction(MouseEvent mouseEvent) {
        txtGetPassword.setVisible(true);
        getPassword.setVisible(false);
        txtGetPassword.setText(getPassword.getText());
        hide1.setVisible(true);
        show1.setVisible(false);
    }

    public void show2OnAction(MouseEvent mouseEvent) {
        txtSetPassword.setVisible(true);
        setPassword.setVisible(false);
        txtSetPassword.setText(setPassword.getText());
        hide2.setVisible(true);
        show2.setVisible(false);
    }

    public void hide1OnAction(MouseEvent mouseEvent) {
        txtGetPassword.setVisible(false);
        getPassword.setVisible(true);
        show1.setVisible(true);
        hide1.setVisible(false);
    }

    public void hide2OnAction(MouseEvent mouseEvent) {
        txtSetPassword.setVisible(false);
        setPassword.setVisible(true);
        show2.setVisible(true);
        hide2.setVisible(false);
    }

    public void searchOnAction(ActionEvent actionEvent) throws IOException {
        ArrayList<UserDTO> allUser = userBO.getAllUser();

        for (UserDTO userDTO : allUser) {

            if(userDTO.getUser_name().equals(txtgetUserName.getText())){
                getPassword.setText(userDTO.getPwd());
            }
        }
    }

    public void manageRegisterOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.REGISTER, pane1);
    }
}
