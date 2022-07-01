package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import project.base.DBUtil;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThemDoUongController {

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
    private RadioButton nguyenLieu3;
    @FXML
    private RadioButton nguyenLieu4;
    @FXML
    private RadioButton nguyenLieu5;
    @FXML
    private RadioButton nguyenLieu6;
    @FXML
    private RadioButton nguyenLieu;
    @FXML
    private RadioButton nguyenLieu1;
    @FXML
    private RadioButton nguyenLieu2;
    @FXML
    private RadioButton[] nguyenLieu0 = {null,null,null,null,null,null,null,null,null,null,null};


    @FXML
    void reloadBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        nguyenLieu0[0] =  nguyenLieu;
        nguyenLieu0[1] =  nguyenLieu1;
        nguyenLieu0[2] =  nguyenLieu2;
        nguyenLieu0[3] =  nguyenLieu3;
        nguyenLieu0[4] =  nguyenLieu4;
        nguyenLieu0[5] =  nguyenLieu5;
        nguyenLieu0[5] =  nguyenLieu6;

        String command1 = String.format("SELECT * FROM nguyenlieu");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        int i1 = 0;

        while (result1.next()) {
            String tenNguyenLieu = result1.getString(1);
            String nhaCungCap = result1.getString(2);
            String trangThai = result1.getString(3);
            String anh = result1.getString(4);

            nguyenLieu0[i1].setText(tenNguyenLieu);

            i1 += 1;
        }

    }

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

