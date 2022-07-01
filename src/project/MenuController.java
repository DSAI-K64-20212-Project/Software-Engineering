package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.base.user.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import static project.LogIn.monitor;

public class MenuController  {
    @FXML
    private VBox vboxLeft;
    private Stage stage;
    private Scene scene;

    @FXML
    private CheckBox onMenu;
    @FXML
    private CheckBox onMenu1;
    @FXML
    private CheckBox onMenu2;
    @FXML
    private CheckBox[] onMenu0 = {null,null,null};
    @FXML
    private Text thongTinDoUong;
    @FXML
    private Text thongTinDoUong1;
    @FXML
    private Text thongTinDoUong2;
    @FXML
    private Text[] thongTinDoUong0 = {null,null,null};

    @FXML
    private CheckBox toppingOnMenu;
    @FXML
    private CheckBox toppingOnMenu1;
    @FXML
    private CheckBox toppingOnMenu2;
    @FXML
    private CheckBox toppingOnMenu3;
    @FXML
    private CheckBox toppingOnMenu4;
    @FXML
    private CheckBox[] toppingOnMenu0 = {null,null,null,null,null};
    @FXML
    private Text thongTinTopping;
    @FXML
    private Text thongTinTopping1;
    @FXML
    private Text thongTinTopping2;
    @FXML
    private Text thongTinTopping3;
    @FXML
    private Text thongTinTopping4;
    @FXML
    private Text[] thongTinTopping0 = {null,null,null,null,null};

    @FXML
    void reloadBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        onMenu0[0] = onMenu;
        onMenu0[1] = onMenu1;
        onMenu0[2] = onMenu2;

        thongTinDoUong0[0] =  thongTinDoUong;
        thongTinDoUong0[1] =  thongTinDoUong1;
        thongTinDoUong0[2] =  thongTinDoUong2;

        String command1 = String.format("SELECT * FROM douong");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        int i1 = 0;

        while (result1.next()) {
            String tenDoUong = result1.getString(1);
            String anh = result1.getString(2);
            String onMenu = result1.getString(3);

            thongTinDoUong0[i1].setText(tenDoUong);
            onMenu0[i1].setSelected(Boolean.parseBoolean(onMenu));

            i1 += 1;
        }

        toppingOnMenu0[0] = toppingOnMenu;
        toppingOnMenu0[1] = toppingOnMenu1;
        toppingOnMenu0[2] = toppingOnMenu2;
        toppingOnMenu0[3] = toppingOnMenu3;
        toppingOnMenu0[4] = toppingOnMenu4;

        thongTinTopping0[0] =  thongTinTopping;
        thongTinTopping0[1] =  thongTinTopping1;
        thongTinTopping0[2] =  thongTinTopping2;
        thongTinTopping0[3] =  thongTinTopping3;
        thongTinTopping0[4] =  thongTinTopping4;

        String command2 = String.format("SELECT * FROM topping");
        ResultSet result2 = DBUtil.dbExecuteQuery(command2);
        int i2 = 0;

        while (result2.next()) {
            String tenTopping = result2.getString(1);
            String anh = result2.getString(2);
            String onMenu = result2.getString(3);

            thongTinTopping0[i2].setText(tenTopping);
            toppingOnMenu0[i2].setSelected(Boolean.parseBoolean(onMenu));

            i2 += 1;
        }


    }

    @FXML
    void billBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/DatDoUong.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void ingredientBtn(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/project/KhoNguyenLieu.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    void hrBtn(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/NhanSu.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void menuBtn(ActionEvent event) throws IOException{

    }

    @FXML
    void revBtn(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/DoanhThu.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void TaiKhoanCuaBanPressedBtn(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/TaiKhoanCuaBan.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
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
    void infBtn(MouseEvent event) throws IOException {
//        avaImg.setPickOnBounds(true);
        Parent root = FXMLLoader.load(getClass().getResource("TaiKhoanCuaBan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

