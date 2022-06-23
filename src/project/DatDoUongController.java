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
    private Label doUong1;
    @FXML
    private Label tenTopping1;
    @FXML
    private Label giaTopping1;
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
    private Pane topping1;
    @FXML
    private Text giaHoaDon1;

    @FXML
    private Button buttonLoai1;

    @FXML
    private Button buttonLoai11;
    @FXML
    private Button buttonLoai12;
    @FXML
    private Label giaLoai1;

    @FXML
    private Label giaLoai11;
    @FXML
    private Text giaHoaDon11;
    @FXML
    private Label giaTopping11;
    @FXML
    private Label giaLoai12;
    @FXML
    private Text giaHoaDon12;
    @FXML
    private Label giaTopping12;

    @FXML
    private Button buttonTopping1;
    @FXML
    private Button buttonTopping11;
    @FXML
    private Pane topping11;
    @FXML
    private Label tenTopping11;
    @FXML
    private Button buttonTopping12;
    @FXML
    private Pane topping12;
    @FXML
    private Label tenTopping12;

    @FXML
    private Label doUong11;
    @FXML
    private Label doUong12;

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

    Label doUong;
    @FXML
    void DoUongPressedBtn(ActionEvent event) {
        Button doUongButtonId = (Button) event.getTarget();
        if (doUongButtonId == buttonLoai1) {
            if (pane1.isVisible() == true) {
                pane1.setVisible(false);
            } else {
                pane1.setVisible(true);
                doUong = doUong1;
            }
        }  else if   (doUongButtonId == buttonLoai11) {
            if (pane11.isVisible() == true) {
                pane11.setVisible(false);
            } else {
                pane11.setVisible(true);
                doUong = doUong11;
            }
        }  else if   (doUongButtonId == buttonLoai12) {
            if (pane12.isVisible() == true) {
                pane12.setVisible(false);
            } else {
                pane12.setVisible(true);
                doUong = doUong12;
        }
    }
}

    Label topping;
    Label giaTopping;
    @FXML
    void ToppingPressedBtn(ActionEvent event) {
        Button toppingButtonId = (Button) event.getTarget();
        if (toppingButtonId == buttonTopping1) {
            if (topping1.isVisible() == true) {
                topping1.setVisible(false);
            } else {
                topping1.setVisible(true);
                topping = tenTopping1;
                giaTopping = giaTopping1;
            }
        }  else if   (toppingButtonId == buttonTopping11) {
            if (topping11.isVisible() == true) {
                topping11.setVisible(false);
            } else {
                topping11.setVisible(true);
                topping = tenTopping11;
                giaTopping = giaTopping11;
            }
        }  else if   (toppingButtonId == buttonTopping12) {
            if (topping12.isVisible() == true) {
                topping12.setVisible(false);
            } else {
                topping12.setVisible(true);
                topping = tenTopping12;
                giaTopping = giaTopping12;
            }
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
                    + '-' + topping.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong1.setText(doUong.getText());
            giaHoaDon1.setText(String.valueOf(Integer.parseInt(giaLoai1.getText())+Integer.parseInt(giaTopping.getText())) + "đ");
        } else if  ( cAdd ==2){
            hoaDon11.setVisible(true);
            modDoUong11.setText('-' + t.getText() + "\n"
                    + '-' + topping.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong11.setText(doUong.getText());
            giaHoaDon11.setText(String.valueOf(Integer.parseInt(giaLoai11.getText())+Integer.parseInt(giaTopping.getText())) + "đ");
        }else if  ( cAdd ==3){
            hoaDon12.setVisible(true);
            modDoUong12.setText('-' + t.getText() + "\n"
                    + '-' + topping.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong12.setText(doUong.getText());
            giaHoaDon12.setText(String.valueOf(Integer.parseInt(giaLoai12.getText())+Integer.parseInt(giaTopping.getText())) + "đ");
        }
    }

    @FXML
    void KhachTraPressedBtn(ActionEvent event) {
        int i = Integer.parseInt(khachTra.getText());
        System.out.print(i);
        soDu.setText(String.valueOf(i-Integer.parseInt(tongTien.getText())));
    }


}
