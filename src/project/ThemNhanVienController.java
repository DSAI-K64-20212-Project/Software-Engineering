package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class ThemNhanVienController {

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
    private RadioButton thuNganBtn;
    @FXML
    private RadioButton phaCheBtn;
    @FXML
    private RadioButton quanLyBtn;
    @FXML
    private RadioButton sangBtn;
    @FXML
    private RadioButton chieuBtn;
    @FXML
    private Button apDungBtn;

    @FXML
    private TextField hoVaTen;
    @FXML
    private TextField soDienThoai;
    @FXML
    private TextField username;
    @FXML
    private TextField matKhau;

    @FXML
    private ToggleGroup chucVu;
    @FXML
    private ToggleGroup caLam;


    @FXML
    void infBtn(MouseEvent event) throws IOException {
//        avaImg.setPickOnBounds(true);
        Parent root = FXMLLoader.load(getClass().getResource("TaiKhoanCuaBan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void billBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HoaDon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ingredientBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void hrBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml")); // Chưa có màn hình
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menuBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml")); // Chưa có màn hình
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void revBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoanhThu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ordBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DatDoUong.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        String f = "src/project/resources/music/home.mp3";
        Media media = new Media(Paths.get(f).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        System.out.println("Play Music !");
        mediaPlayer.setAutoPlay(true);
    }


}

