package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
import javafx.fxml.Initializable;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import static project.LogIn.monitor;

public class MenuController {
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
    private CheckBox onMenu6;
    @FXML
    private CheckBox onMenu7;
    @FXML
    private CheckBox onMenu8;
    @FXML
    private CheckBox onMenu9;
    @FXML
    private CheckBox[] onMenu0 = new CheckBox[10];
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
    private Text thongTinDoUong6;
    @FXML
    private Text thongTinDoUong7;
    @FXML
    private Text thongTinDoUong8;
    @FXML
    private Text thongTinDoUong9;
    @FXML
    private Text[] thongTinDoUong0 = new Text[10];

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
    private Circle anhDoUong6;
    @FXML
    private Circle anhDoUong7;
    @FXML
    private Circle anhDoUong8;
    @FXML
    private Circle anhDoUong9;
    @FXML
    private Circle[] anhDoUong0 = new Circle[10];

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
    private RadioButton xoaDoUong6;
    @FXML
    private RadioButton xoaDoUong7;
    @FXML
    private RadioButton xoaDoUong4;
    @FXML
    private RadioButton xoaDoUong5;
    @FXML
    private RadioButton xoaDoUong2;
    @FXML
    private RadioButton xoaDoUong3;
    @FXML
    private RadioButton xoaDoUong1;
    @FXML
    private RadioButton xoaDoUong;
    @FXML
    private RadioButton xoaDoUong8;
    @FXML
    private RadioButton xoaDoUong9;
    @FXML
    private RadioButton[] xoaDoUong0 = new RadioButton[10];

    @FXML
    private Pane paneDoUong;
    @FXML
    private Pane paneDoUong1;
    @FXML
    private Pane paneDoUong2;
    @FXML
    private Pane paneDoUong3;
    @FXML
    private Pane paneDoUong4;
    @FXML
    private Pane paneDoUong5;
    @FXML
    private Pane paneDoUong6;
    @FXML
    private Pane paneDoUong7;
    @FXML
    private Pane paneDoUong8;
    @FXML
    private Pane paneDoUong9;
    @FXML
    private Pane[] paneDoUong0 = new Pane[10];

    @FXML
    private Text sizeMDoUong;
    @FXML
    private Text sizeMDoUong1;
    @FXML
    private Text sizeMDoUong2;
    @FXML
    private Text sizeMDoUong3;
    @FXML
    private Text sizeMDoUong4;
    @FXML
    private Text sizeMDoUong5;
    @FXML
    private Text sizeMDoUong6;
    @FXML
    private Text sizeMDoUong7;
    @FXML
    private Text sizeMDoUong8;
    @FXML
    private Text sizeMDoUong9;
    @FXML
    private Text[] sizeMDoUong0 = new Text[10];

    @FXML
    private Text sizeLDoUong8;
    @FXML
    private Text sizeLDoUong7;
    @FXML
    private Text sizeLDoUong6;
    @FXML
    private Text sizeLDoUong5;
    @FXML
    private Text sizeLDoUong4;
    @FXML
    private Text sizeLDoUong;
    @FXML
    private Text sizeLDoUong1;
    @FXML
    private Text sizeLDoUong2;
    @FXML
    private Text sizeLDoUong3;
    @FXML
    private Text sizeLDoUong9;
    @FXML
    private Text[] sizeLDoUong0 = new Text[10];

    @FXML
    private RadioButton xoaTopping;
    @FXML
    private RadioButton xoaTopping1;
    @FXML
    private RadioButton xoaTopping2;
    @FXML
    private RadioButton xoaTopping3;
    @FXML
    private RadioButton xoaTopping4;
    @FXML
    private RadioButton xoaTopping5;
    @FXML
    private RadioButton xoaTopping6;
    @FXML
    private RadioButton xoaTopping7;
    @FXML
    private RadioButton xoaTopping8;
    @FXML
    private RadioButton xoaTopping9;
    @FXML
    private RadioButton[] xoaTopping0 = new RadioButton[10];

    @FXML
    private Text giaTopping;
    @FXML
    private Text giaTopping1;
    @FXML
    private Text giaTopping2;
    @FXML
    private Text giaTopping3;
    @FXML
    private Text giaTopping4;
    @FXML
    private Text giaTopping5;
    @FXML
    private Text giaTopping6;
    @FXML
    private Text giaTopping7;
    @FXML
    private Text giaTopping8;
    @FXML
    private Text giaTopping9;
    @FXML
    private Text[] giaTopping0 = new Text[10];

    @FXML
    private Pane paneTopping;
    @FXML
    private Pane paneTopping1;
    @FXML
    private Pane paneTopping2;
    @FXML
    private Pane paneTopping3;
    @FXML
    private Pane paneTopping4;
    @FXML
    private Pane paneTopping5;
    @FXML
    private Pane paneTopping6;
    @FXML
    private Pane paneTopping7;
    @FXML
    private Pane paneTopping8;
    @FXML
    private Pane paneTopping9;
    @FXML
    private Pane[] paneTopping0 = new Pane[10];

    @FXML
    public void initialize() throws IOException, SQLException, ClassNotFoundException{
        onMenu0[0] = onMenu;
        onMenu0[1] = onMenu1;
        onMenu0[2] = onMenu2;
        onMenu0[3] = onMenu3;
        onMenu0[4] = onMenu4;
        onMenu0[5] = onMenu5;
        onMenu0[6] = onMenu6;
        onMenu0[7] = onMenu7;
        onMenu0[8] = onMenu8;
        onMenu0[9] = onMenu9;


        thongTinDoUong0[0] =  thongTinDoUong;
        thongTinDoUong0[1] =  thongTinDoUong1;
        thongTinDoUong0[2] =  thongTinDoUong2;
        thongTinDoUong0[3] =  thongTinDoUong3;
        thongTinDoUong0[4] =  thongTinDoUong4;
        thongTinDoUong0[5] =  thongTinDoUong5;
        thongTinDoUong0[6] =  thongTinDoUong6;
        thongTinDoUong0[7] =  thongTinDoUong7;
        thongTinDoUong0[8] =  thongTinDoUong8;
        thongTinDoUong0[9] =  thongTinDoUong9;

        anhDoUong0[0] =  anhDoUong;
        anhDoUong0[1] =  anhDoUong1;
        anhDoUong0[2] =  anhDoUong2;
        anhDoUong0[3] =  anhDoUong3;
        anhDoUong0[4] =  anhDoUong4;
        anhDoUong0[5] =  anhDoUong5;
        anhDoUong0[6] =  anhDoUong6;
        anhDoUong0[7] =  anhDoUong7;
        anhDoUong0[8] =  anhDoUong8;
        anhDoUong0[9] =  anhDoUong9;


        paneDoUong0[0] = paneDoUong;
        paneDoUong0[1] = paneDoUong1;
        paneDoUong0[2] = paneDoUong2;
        paneDoUong0[3] = paneDoUong3;
        paneDoUong0[4] = paneDoUong4;
        paneDoUong0[5] = paneDoUong5;
        paneDoUong0[6] = paneDoUong6;
        paneDoUong0[7] = paneDoUong7;
        paneDoUong0[8] = paneDoUong8;
        paneDoUong0[9] = paneDoUong9;

        sizeMDoUong0[0] = sizeMDoUong;
        sizeMDoUong0[1] = sizeMDoUong1;
        sizeMDoUong0[2] = sizeMDoUong2;
        sizeMDoUong0[3] = sizeMDoUong3;
        sizeMDoUong0[4] = sizeMDoUong4;
        sizeMDoUong0[5] = sizeMDoUong5;
        sizeMDoUong0[6] = sizeMDoUong6;
        sizeMDoUong0[7] = sizeMDoUong7;
        sizeMDoUong0[8] = sizeMDoUong8;
        sizeMDoUong0[9] = sizeMDoUong9;

        sizeLDoUong0[0] = sizeLDoUong;
        sizeLDoUong0[1] = sizeLDoUong1;
        sizeLDoUong0[2] = sizeLDoUong2;
        sizeLDoUong0[3] = sizeLDoUong3;
        sizeLDoUong0[4] = sizeLDoUong4;
        sizeLDoUong0[5] = sizeLDoUong5;
        sizeLDoUong0[6] = sizeLDoUong6;
        sizeLDoUong0[7] = sizeLDoUong7;
        sizeLDoUong0[8] = sizeLDoUong8;
        sizeLDoUong0[9] = sizeLDoUong9;

        String command1 = "SELECT * FROM douong";
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);

        int i1 = 0;

        while (result1.next()) {
            String tenDoUong = result1.getString(1);
            String anh = result1.getString(2);
            String onMenu = result1.getString(3);

            thongTinDoUong0[i1].setText(tenDoUong);
            onMenu0[i1].setSelected(Boolean.parseBoolean(onMenu));

            anhDoUong0[i1].setStroke(Color.SEAGREEN);
            Image im = new Image("/project/resources/image/TraSua/"+anh);
            anhDoUong0[i1].setFill(new ImagePattern(im));
            anhDoUong0[i1].setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));
            paneDoUong0[i1].setVisible(true);

            i1 += 1;
        }

        for (int i11 = i1; i11<paneDoUong0.length-1; i11++){
            paneDoUong0[i11].setVisible(false);
        }

        String command3 = "SELECT * FROM giadouong WHERE size = 'M';";
        ResultSet result3 = DBUtil.dbExecuteQuery(command3);

        while (result3.next()) {
            String tenDoUong = result3.getString(1);
            String size = result3.getString(2);
            String gdu = result3.getString(3);

            for (int i3 = 0; i3<i1;i3++){
                if (tenDoUong.equals(thongTinDoUong0[i3].getText())){
                    sizeMDoUong0[i3].setText(String.format("Size M\n%s",gdu));
                }
            }
        }

        String command4 = "SELECT * FROM giadouong WHERE size = 'L';";
        ResultSet result4 = DBUtil.dbExecuteQuery(command4);

        while (result4.next()) {
            String tenDoUong = result4.getString(1);
            String size = result4.getString(2);
            String gdu = result4.getString(3);

            for (int i4 = 0; i4<i1;i4++){
                if (tenDoUong.equals(thongTinDoUong0[i4].getText())){
                    sizeLDoUong0[i4].setText(String.format("Size L\n%s",gdu));
                }
            }
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

        giaTopping0[0] =  giaTopping;
        giaTopping0[1] =  giaTopping1;
        giaTopping0[2] =  giaTopping2;
        giaTopping0[3] =  giaTopping3;
        giaTopping0[4] =  giaTopping4;
        giaTopping0[5] =  giaTopping5;
        giaTopping0[6] =  giaTopping6;
        giaTopping0[7] =  giaTopping7;
        giaTopping0[8] =  giaTopping8;
        giaTopping0[9] =  giaTopping9;

        paneTopping0[0] =  paneTopping;
        paneTopping0[1] =  paneTopping1;
        paneTopping0[2] =  paneTopping2;
        paneTopping0[3] =  paneTopping3;
        paneTopping0[4] =  paneTopping4;
        paneTopping0[5] =  paneTopping5;
        paneTopping0[6] =  paneTopping6;
        paneTopping0[7] =  paneTopping7;
        paneTopping0[8] =  paneTopping8;
        paneTopping0[9] =  paneTopping9;


        String command2 = String.format("SELECT * FROM topping");
        ResultSet result2 = DBUtil.dbExecuteQuery(command2);
        int i2 = 0;

        while (result2.next()) {
            String tenTopping = result2.getString(1);
            String gia = result2.getString(2);
            String anh = result2.getString(3);
            String onMenu = result2.getString(4);

            thongTinTopping0[i2].setText(tenTopping);
            giaTopping0[i2].setText(gia);
            toppingOnMenu0[i2].setSelected(Boolean.parseBoolean(onMenu));

            anhTopping0[i2].setStroke(Color.SEAGREEN);
            Image im = new Image("project/resources/image/Topping/" +anh);
            anhTopping0[i2].setFill(new ImagePattern(im));
            anhTopping0[i2].setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));
            paneTopping0[i2].setVisible(true);

            i2 += 1;
        }

        for (int i21 = i2; i21<paneDoUong0.length-1; i21++){
            paneTopping0[i21].setVisible(false);
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
        xoaDoUong0[0] =  xoaDoUong;
        xoaDoUong0[1] =  xoaDoUong1;
        xoaDoUong0[2] =  xoaDoUong2;
        xoaDoUong0[3] =  xoaDoUong3;
        xoaDoUong0[4] =  xoaDoUong4;
        xoaDoUong0[5] =  xoaDoUong5;
        xoaDoUong0[6] =  xoaDoUong6;
        xoaDoUong0[7] =  xoaDoUong7;
        xoaDoUong0[8] =  xoaDoUong8;
        xoaDoUong0[9] =  xoaDoUong9;
    }

    @FXML
    void themDoUongTopping(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/ThemDoUongTopping.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void onMenuBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        CheckBox om = (CheckBox) event.getTarget();

        if (om.getId().equals("onMenu")){
            String command2 = String.format("UPDATE douong SET onmenu = '%s' WHERE tendouong = '%s'",om.isSelected(),thongTinDoUong.getText());
            DBUtil.dbExecuteUpdate(command2);
        } else {
            String command2 = String.format("UPDATE douong SET onmenu = '%s' WHERE tendouong =  '%s'",om.isSelected(),thongTinDoUong0[Integer.parseInt(om.getId().substring(6))].getText());
            DBUtil.dbExecuteUpdate(command2);
        }

    }

    @FXML
    void toppingOnMenuBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        CheckBox om = (CheckBox) event.getTarget();

        if (om.getId().equals("toppingOnMenu")){
            String command2 = String.format("UPDATE topping SET onmenu = '%s' WHERE tentopping = '%s'",om.isSelected(),thongTinTopping.getText());
            DBUtil.dbExecuteUpdate(command2);
        } else {
            String command2 = String.format("UPDATE topping SET onmenu = '%s' WHERE tentopping =  '%s'",om.isSelected(),thongTinTopping0[Integer.parseInt(om.getId().substring(13))].getText());
            DBUtil.dbExecuteUpdate(command2);
        }

    }
}

