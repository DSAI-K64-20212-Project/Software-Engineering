package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DatDoUongController {
    @FXML
    private RadioButton sizeM;
    @FXML
    private RadioButton sizeL;
    @FXML
    private ToggleGroup size;
    @FXML
    private Label doUong;
    @FXML
    private Label topping;
    private int Nr = 1;

    @FXML
    private Slider daSlider;

    @FXML
    private Slider duongSlider;

    @FXML
    private Label l1;

    @FXML
    private Pane pane1;
    @FXML
    private VBox vboxLeft;

    @FXML
    private TextField khachTra;
    @FXML
    private VBox hoaDon1;
    @FXML
    private Text tenDoUong1;
    @FXML
    private Text modDoUong1;
    @FXML
    private Text tongTien;
    @FXML
    private Text soDu;

    @FXML
    private Label l11;

    @FXML
    private VBox hoaDon11;

    @FXML
    private Text tenDoUong11;

    @FXML
    private Pane pane11;
    @FXML
    private Text modDoUong11;

    @FXML
    private Label l12;

    @FXML
    private VBox hoaDon12;

    @FXML
    private Text tenDoUong12;

    @FXML
    private Pane pane12;
    @FXML
    private Text modDoUong12;


    @FXML
    void doanhThuPressedBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/project/DoanhThu.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    void nguyenLieuPressedBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/KhoNguyenLieu.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void nhanSuPressedBtn(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/project/NhanSu.fxml"));
        Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window2.setScene(new Scene(root2));
    }

    @FXML
    void menuPressedBtn(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/project/Menu.fxml"));
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
    }

    @FXML
    void datDoUongPressedBtn(ActionEvent event) {

    }

    @FXML
    void TaiKhoanCuaBanPressedBtn(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/project/TaiKhoanCuaBan.fxml"));
        Stage window2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window2.setScene(new Scene(root2));
    }

    @FXML
    void DoUongPressedBtn(ActionEvent event) {
        if (pane1.isVisible() == true) {
            pane1.setVisible(false);
        } else {
            pane1.setVisible(true);
        }

    }

    @FXML
    void MinusPressedBtn(ActionEvent event) {
        if (Nr == 1){
            hoaDon1.setVisible(false);
        }else {
            Nr -= 1;
            l1.setText("X" + String.valueOf(Nr));
        }
    }

    @FXML
    void PlusPressedBtn(ActionEvent event) {
        Nr += 1;
        l1.setText("X" + String.valueOf(Nr));
    }

    int cAdd = 0;
    @FXML
    void AddPressedBtn(ActionEvent event) {
        int da = (int) daSlider.getValue();
        int duong = (int) duongSlider.getValue();
        RadioButton t = (RadioButton) size.getSelectedToggle();
        cAdd += 1;
        if (cAdd == 1) {
            hoaDon1.setVisible(true);
            modDoUong1.setText('-' + t.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong1.setText(doUong.getText());
        } else if  ( cAdd ==2){
            hoaDon11.setVisible(true);
            modDoUong11.setText('-' + t.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong11.setText(doUong.getText());
        }else if  ( cAdd ==3){
            hoaDon12.setVisible(true);
            modDoUong12.setText('-' + t.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong12.setText(doUong.getText());
        }
    }

    @FXML
    void KhachTraPressedBtn(ActionEvent event) {
        int i = Integer.parseInt(khachTra.getText());
        System.out.print(i);
        soDu.setText(String.valueOf(i-Integer.parseInt(tongTien.getText())));
    }


}
