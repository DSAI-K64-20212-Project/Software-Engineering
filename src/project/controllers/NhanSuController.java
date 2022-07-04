package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.base.DBUtil;

import java.io.IOException;
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
    private Text[] thongTin0 = new Text[6];

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
    private Text[] caLam0 = new Text[6];


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
    private Button[] traLuong0 = new Button[6];

    @FXML
    private Button chinhSuaNhanVien;
    @FXML
    private Button chinhSuaNhanVien1;
    @FXML
    private Button chinhSuaNhanVien2;
    @FXML
    private Button chinhSuaNhanVien3;
    @FXML
    private Button chinhSuaNhanVien4;
    @FXML
    private Button chinhSuaNhanVien5;

    @FXML
    private Circle anhNhanVien;
    @FXML
    private Circle anhNhanVien1;
    @FXML
    private Circle anhNhanVien2;
    @FXML
    private Circle anhNhanVien3;
    @FXML
    private Circle anhNhanVien4;
    @FXML
    private Circle anhNhanVien5;
    @FXML
    private Circle[] anhNhanVien0 = new Circle[6];
    @FXML
    public Button themNvBtn;

    @FXML
    public void initialize() throws IOException, SQLException, ClassNotFoundException{
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

        anhNhanVien0[0] =  anhNhanVien;
        anhNhanVien0[1] =  anhNhanVien1;
        anhNhanVien0[2] =  anhNhanVien2;
        anhNhanVien0[3] =  anhNhanVien3;
        anhNhanVien0[4] =  anhNhanVien4;
        anhNhanVien0[5] =  anhNhanVien5;

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

            anhNhanVien0[i1].setStroke(Color.SEAGREEN);
            Image im = new Image("project/resources/image/icons/user.png");
            anhNhanVien0[i1].setFill(new ImagePattern(im));
            anhNhanVien0[i1].setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

            i1 += 1;
        }
    }


    @FXML
    void traLuongBtn(ActionEvent event) throws IOException {
        luongChuaTra0[0] =  luongChuaTra;
        luongChuaTra0[1] =  luongChuaTra1;
        luongChuaTra0[2] =  luongChuaTra2;
        luongChuaTra0[3] =  luongChuaTra3;
        luongChuaTra0[4] =  luongChuaTra4;
        luongChuaTra0[5] =  luongChuaTra5;

        Button tl = (Button) event.getTarget();
        if (tl.getId().equals("traLuong")){
            luongChuaTra.setText("0");
        } else {
            Text lct = luongChuaTra0[Integer.parseInt(tl.getId().substring(8))];
            lct.setText("0");
        }
    }

    @FXML
    void chinhSuaNhanVienBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/screen/ChinhSuaNhanVien.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

}

