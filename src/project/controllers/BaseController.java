package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import project.base.DBUtil;

import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import static project.LogIn.monitor;

public class BaseController {
    @FXML
    private Button datdoUongBtn;
    @FXML
    private Button nguyenlieuBtn;
    @FXML
    private Button nhansuBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Button doanhthuBtn;
    @FXML
    private Label welcomeLabel;
    @FXML
    private AnchorPane initPane;
    private AnchorPane activeScreen;
    private AnchorPane prevScreen;


    private void toggleScreen(AnchorPane screen){
        activeScreen.setVisible(false);
        prevScreen = activeScreen;
        activeScreen = screen;
        activeScreen.setVisible(true);
    }
    @FXML
    private AnchorPane datdouongScreen;
    @FXML
    private AnchorPane khoNguyenLieuScreen;
    @FXML
    private AnchorPane nhansuScreen;
    @FXML
    private AnchorPane menuScreen;
    @FXML
    private AnchorPane doanhthuScreen;
    @FXML
    private AnchorPane infoScreen;
    @FXML
    private AnchorPane hoadonScreen;
    @FXML
    private AnchorPane themNvScreen;
    @FXML
    private AnchorPane themNguyenlieuScreen;
    @FXML
    public AnchorPane themDrinkToppingScreen;
    @FXML private NhanSuController mainNhanSuController;
    @FXML private ThemNhanVienController mainAddStaffController;
    @FXML private TaiKhoanCuaBanController mainAccountController;
    @FXML private KhoNguyenLieuController mainKhoNguyenLieuController;
    @FXML private ThemNguyenLieuController mainAddIngreController;
    @FXML private ThemDoUongToppingController mainAddDrTpController;
    @FXML private MenuController mainMenuController;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        activeScreen = initPane;
        ResultSet result =
                DBUtil.dbExecuteQuery(String.format("Select tennhanvien from nhanvien where tendangnhap = '%s';",
                        monitor.getActiveUser().getUsername()));
        result.next();
        String hovaten = result.getString(1);
        welcomeLabel.setText(String.format("Chào mừng %s", hovaten));
        if (monitor.getCashier() != null) {
            datdoUongBtn.setOnAction(actionEvent -> toggleScreen(datdouongScreen));
            nguyenlieuBtn.setVisible(false);
            nhansuBtn.setVisible(false);
            menuBtn.setVisible(false);
            doanhthuBtn.setVisible(false);
        } else if (monitor.getBartender() != null) {
            datdoUongBtn.setText("Hóa đơn");
            datdoUongBtn.setOnAction(actionEvent -> toggleScreen(hoadonScreen));
            nhansuBtn.setVisible(false);
            menuBtn.setVisible(false);
            doanhthuBtn.setVisible(false);
        } else if (monitor.getAdmin() != null) {
            datdoUongBtn.setText("Hóa đơn");
            datdoUongBtn.setOnAction(actionEvent -> toggleScreen(hoadonScreen));
        }
        mainNhanSuController.themNvBtn.setOnAction(actionEvent -> toggleScreen(themNvScreen));
        mainAddStaffController.backBtn.setOnAction(actionEvent -> toggleScreen(prevScreen));
        mainAccountController.backBtn.setOnAction(actionEvent -> toggleScreen(prevScreen));
        mainKhoNguyenLieuController.taoNguyenlieuBtn.setOnAction(actionEvent -> toggleScreen(themNguyenlieuScreen));
        mainAddIngreController.backBtn.setOnAction(actionEvent -> toggleScreen(prevScreen));
        mainAddDrTpController.backBtn.setOnAction(actionEvent -> toggleScreen(prevScreen));
        mainMenuController.themDoUongToppingBtn.setOnAction(actionEvent -> toggleScreen(themDrinkToppingScreen));
    }


    @FXML
    void infBtn(ActionEvent event) {
        toggleScreen(infoScreen);
    }

    @FXML
    void nguyenlieuOnPressed(ActionEvent event) {
        toggleScreen(khoNguyenLieuScreen);
    }

    @FXML
    void nhansuOnPressed(ActionEvent event) {
        toggleScreen(nhansuScreen);
    }

    @FXML
    void menuOnPressed(ActionEvent event) {
        toggleScreen(menuScreen);
    }

    @FXML
    void doanhthuOnPressed(ActionEvent event) {
        toggleScreen(doanhthuScreen);
    }
    @FXML
    void pauseMedia(ActionEvent event) {
        String f = "src/project/resources/music/home.mp3";
        Media media = new Media(Paths.get(f).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(mediaPlayer != null) {
            System.out.println("Pause !");
            mediaPlayer.setMute(true);
        }
    }

    // Music ON !!!
    @FXML
    void playMedia(ActionEvent event) {
        String f = "Software-Engineering/src/project/resources/music/home.mp3";
        Media media = new Media(Paths.get(f).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        System.out.println("Play Music !");
        mediaPlayer.setAutoPlay(true);
    }
}

