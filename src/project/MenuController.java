package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.base.user.User;
import javafx.scene.paint.Color;

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
    private CheckBox onMenu3;
    @FXML
    private CheckBox onMenu4;
    @FXML
    private CheckBox onMenu5;
    @FXML
    private CheckBox[] onMenu0 = new CheckBox[6];
    @FXML
    private Text thongTinDoUong;
    @FXML
    private Text thongTinDoUong1;
    @FXML
    private Text thongTinDoUong2;
    @FXML
    private Text thongTinDoUong3;
    @FXML
    private Text thongTinDoUong4;
    @FXML
    private Text thongTinDoUong5;
    @FXML
    private Text[] thongTinDoUong0 = new Text[6];

    @FXML
    private Circle anhDoUong;
    @FXML
    private Circle anhDoUong1;
    @FXML
    private Circle anhDoUong2;
    @FXML
    private Circle anhDoUong3;
    @FXML
    private Circle anhDoUong4;
    @FXML
    private Circle anhDoUong5;
    @FXML
    private Circle[] anhDoUong0 = new Circle[6];

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
    private CheckBox toppingOnMenu5;
    @FXML
    private CheckBox toppingOnMenu6;
    @FXML
    private CheckBox toppingOnMenu7;
    @FXML
    private CheckBox toppingOnMenu8;
    @FXML
    private CheckBox toppingOnMenu9;
    @FXML
    private CheckBox[] toppingOnMenu0 = new CheckBox[10];
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
    private Text thongTinTopping5;
    @FXML
    private Text thongTinTopping6;
    @FXML
    private Text thongTinTopping7;
    @FXML
    private Text thongTinTopping8;
    @FXML
    private Text thongTinTopping9;
    @FXML
    private Text[] thongTinTopping0 = new Text[10];

    @FXML
    private Circle anhTopping;
    @FXML
    private Circle anhTopping1;
    @FXML
    private Circle anhTopping2;
    @FXML
    private Circle anhTopping3;
    @FXML
    private Circle anhTopping4;
    @FXML
    private Circle anhTopping5;
    @FXML
    private Circle anhTopping6;
    @FXML
    private Circle anhTopping7;
    @FXML
    private Circle anhTopping8;
    @FXML
    private Circle anhTopping9;
    @FXML
    private Circle[] anhTopping0 = new Circle[10];

    @FXML
    void reloadBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        onMenu0[0] = onMenu;
        onMenu0[1] = onMenu1;
        onMenu0[2] = onMenu2;
        onMenu0[3] = onMenu3;
        onMenu0[4] = onMenu4;
        onMenu0[5] = onMenu5;

        thongTinDoUong0[0] =  thongTinDoUong;
        thongTinDoUong0[1] =  thongTinDoUong1;
        thongTinDoUong0[2] =  thongTinDoUong2;
        thongTinDoUong0[3] =  thongTinDoUong3;
        thongTinDoUong0[4] =  thongTinDoUong4;
        thongTinDoUong0[5] =  thongTinDoUong5;

        anhDoUong0[0] =  anhDoUong;
        anhDoUong0[1] =  anhDoUong1;
        anhDoUong0[2] =  anhDoUong2;
        anhDoUong0[3] =  anhDoUong3;
        anhDoUong0[4] =  anhDoUong4;
        anhDoUong0[5] =  anhDoUong5;

        String command1 = String.format("SELECT * FROM douong WHERE onmenu = True");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        int i1 = 0;

        while (result1.next()) {
            String tenDoUong = result1.getString(1);
            String anh = result1.getString(2);
            String onMenu = result1.getString(3);

            thongTinDoUong0[i1].setText(tenDoUong);
            onMenu0[i1].setSelected(Boolean.parseBoolean(onMenu));

            anhDoUong0[i1].setStroke(Color.SEAGREEN);
            Image im = new Image("/project/resources/image/TraSua/images.jpeg");
            anhDoUong0[i1].setFill(new ImagePattern(im));
            anhDoUong0[i1].setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

            i1 += 1;
        }

        toppingOnMenu0[0] = toppingOnMenu;
        toppingOnMenu0[1] = toppingOnMenu1;
        toppingOnMenu0[2] = toppingOnMenu2;
        toppingOnMenu0[3] = toppingOnMenu3;
        toppingOnMenu0[4] = toppingOnMenu4;
        toppingOnMenu0[5] = toppingOnMenu5;
        toppingOnMenu0[6] = toppingOnMenu6;
        toppingOnMenu0[7] = toppingOnMenu7;
        toppingOnMenu0[8] = toppingOnMenu8;
        toppingOnMenu0[9] = toppingOnMenu9;

        thongTinTopping0[0] =  thongTinTopping;
        thongTinTopping0[1] =  thongTinTopping1;
        thongTinTopping0[2] =  thongTinTopping2;
        thongTinTopping0[3] =  thongTinTopping3;
        thongTinTopping0[4] =  thongTinTopping4;
        thongTinTopping0[5] =  thongTinTopping5;
        thongTinTopping0[6] =  thongTinTopping6;
        thongTinTopping0[7] =  thongTinTopping7;
        thongTinTopping0[8] =  thongTinTopping8;
        thongTinTopping0[9] =  thongTinTopping9;

        anhTopping0[0] =  anhTopping;
        anhTopping0[1] =  anhTopping1;
        anhTopping0[2] =  anhTopping2;
        anhTopping0[3] =  anhTopping3;
        anhTopping0[4] =  anhTopping4;
        anhTopping0[5] =  anhTopping5;
        anhTopping0[6] =  anhTopping6;
        anhTopping0[7] =  anhTopping7;
        anhTopping0[8] =  anhTopping8;
        anhTopping0[9] =  anhTopping9;

        String command2 = String.format("SELECT * FROM topping WHERE onmenu = True");
        ResultSet result2 = DBUtil.dbExecuteQuery(command2);
        int i2 = 0;

        while (result2.next()) {
            String tenTopping = result2.getString(1);
            String anh = result2.getString(2);
            String onMenu = result2.getString(3);

            thongTinTopping0[i2].setText(tenTopping);
            toppingOnMenu0[i2].setSelected(Boolean.parseBoolean(onMenu));

            anhTopping0[i2].setStroke(Color.SEAGREEN);
            Image im = new Image("/project/resources/image/Topping/images.jpeg");
            anhTopping0[i2].setFill(new ImagePattern(im));
            anhTopping0[i2].setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

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

    @FXML
    void xoaBtn(MouseEvent event) {

    }

    @FXML
    void themDoUongTopping(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/ThemDoUongTopping.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

}

