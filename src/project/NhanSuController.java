package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.base.DBUtil;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanSuController {

    @FXML
    private VBox vboxLeft;
    private Stage stage;
    private Scene scene;

    @FXML
    private Text thongTin;
    @FXML
    private Text thongTin1;
    @FXML
    private Text thongTin2;
    @FXML
    private Text thongTin3;
    @FXML
    private Text thongTin4;
    @FXML
    private Text thongTin5;
    @FXML
    private Text[] thongTin0 = {null,null,null,null,null,null};

    @FXML
    private Text caLam4;
    @FXML
    private Text caLam5;
    @FXML
    private Text caLam2;
    @FXML
    private Text caLam3;
    @FXML
    private Text caLam1;
    @FXML
    private Text caLam;
    @FXML
    private Text[] caLam0 = {null,null,null,null,null,null};


    @FXML
    private Text luongChuaTra3;
    @FXML
    private Text luongChuaTra4;
    @FXML
    private Text luongChuaTra5;
    @FXML
    private Text luongChuaTra2;
    @FXML
    private Text luongChuaTra1;
    @FXML
    private Text luongChuaTra;
    @FXML
    private Text[] luongChuaTra0 = {null,null,null,null,null,null};


    @FXML
    private Button traLuong1;
    @FXML
    private Button traLuong3;
    @FXML
    private Button traLuong2;
    @FXML
    private Button traLuong4;
    @FXML
    private Button traLuong5;
    @FXML
    private Button traLuong;
    @FXML
    private Button[] traLuong0 = {null,null,null,null,null,null};

    @FXML
    void reloadBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        thongTin0[0] = thongTin;
        thongTin0[1] = thongTin1;
        thongTin0[2] = thongTin2;
        thongTin0[3] = thongTin3;
        thongTin0[4] = thongTin4;
        thongTin0[5] = thongTin5;

        caLam0[0] =  caLam;
        caLam0[1] =  caLam1;
        caLam0[2] =  caLam2;
        caLam0[3] =  caLam3;
        caLam0[4] =  caLam4;
        caLam0[5] =  caLam5;

        luongChuaTra0[0] =  luongChuaTra;
        luongChuaTra0[1] =  luongChuaTra1;
        luongChuaTra0[2] =  luongChuaTra2;
        luongChuaTra0[3] =  luongChuaTra3;
        luongChuaTra0[4] =  luongChuaTra4;
        luongChuaTra0[5] =  luongChuaTra5;

        traLuong0[0] =  traLuong;
        traLuong0[1] =  traLuong1;
        traLuong0[2] =  traLuong2;
        traLuong0[3] =  traLuong3;
        traLuong0[4] =  traLuong4;
        traLuong0[5] =  traLuong5;

        String command1 = String.format("SELECT * FROM nhanvien");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        int i1 = 0;

        while (result1.next()) {
            String tenDangNhap = result1.getString(1);
            String tenNhanVien = result1.getString(2);
            String sdt = result1.getString(3);
            String matKhau = result1.getString(4);
            String chucVu = result1.getString(6);
            String caLam = result1.getString(7);

            thongTin0[i1].setText(tenNhanVien + "\n"  + sdt + "\n" + chucVu);
            caLam0[i1].setText(caLam);

            i1 += 1;
        }
    }
    @FXML
    void billBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/DatDoUong.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void ingredientBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/KhoNguyenLieu.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void hrBtn(ActionEvent event) {

    }

    @FXML
    void menuBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/Menu.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void revBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/FXML.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void TaiKhoanCuaBanPressedBtn(ActionEvent event) throws IOException {
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
    void themNhanVienBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/ThemNhanVien.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }
}

