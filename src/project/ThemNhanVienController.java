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
import project.base.functional.AdminInterface;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

public class ThemNhanVienController implements AdminInterface {

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

    @FXML
    void apDungBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String tenNhanVien = hoVaTen.getText();
        String sdt = soDienThoai.getText();
        String tenDangNhap = username.getText();
        String mk = matKhau.getText();
        String avatar = "images.jpeg";
        RadioButton cv0 = (RadioButton) chucVu.getSelectedToggle();
        String cv = cv0.getText();
        String cv1;
        if (cv == "Thu ngân"){
            cv1 = "Thu Ngan";
        } else if (cv == "Pha chế"){
            cv1 = "Pha Che";
        } else {
            cv1 = "Quan Ly";
        }

        RadioButton cl0 = (RadioButton) caLam.getSelectedToggle();
        String cl = cl0.getText();
        String cl1;
        if (cl == "Sáng"){
            cl1 = "Sang";
        } else {
            cl1 = "Chieu";
        }

        create_new_user("Tam",tenDangNhap,tenNhanVien,mk,sdt,avatar,cv1,cl1);
    }

    @FXML
    void backBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NhanVien.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

