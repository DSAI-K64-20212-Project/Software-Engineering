package project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import static project.LogIn.monitor;

public class BaseController {

    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Button pauseButton;

    @FXML
    private ImageView avaImg;

    @FXML
    private VBox vboxLeft;

    @FXML
    private Button playButton;
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
    private AnchorPane activeScreen = new AnchorPane();
    private void toggleScreen(AnchorPane screen){
        activeScreen.setVisible(false);
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
    private void initialize(){
        if (monitor.getCashier() != null) {
            datdoUongBtn.setOnAction(actionEvent -> toggleScreen(datdouongScreen));
            nguyenlieuBtn.setVisible(false);
            nhansuBtn.setVisible(false);
            menuBtn.setVisible(false);
            doanhthuBtn.setVisible(false);
        } else if (monitor.getBartender() != null) {
            datdoUongBtn.setText("Hóa đơn");
            datdoUongBtn.setOnAction(actionEvent -> toggleScreen(datdouongScreen));
            nhansuBtn.setVisible(false);
            menuBtn.setVisible(false);
            doanhthuBtn.setVisible(false);
        } else if (monitor.getAdmin() != null) {
            datdoUongBtn.setText("Hóa đơn");
            datdoUongBtn.setOnAction(actionEvent -> toggleScreen(datdouongScreen));
        }
    }


    @FXML
    void infBtn(ActionEvent event) throws IOException {
//        avaImg.setPickOnBounds(true);
        Parent root = FXMLLoader.load(getClass().getResource("TaiKhoanCuaBan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    void menuOnPressed(ActionEvent event) throws IOException {
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

