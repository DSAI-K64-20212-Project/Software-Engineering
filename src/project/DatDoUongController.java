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
    void nhanSuPressedBtn(ActionEvent event) {

    }

    @FXML
    void menuPressedBtn(ActionEvent event) {

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
        Nr -= 1;
        l1.setText("X" + String.valueOf(Nr));
    }

    @FXML
    void PlusPressedBtn(ActionEvent event) {
        Nr += 1;
        l1.setText("X" + String.valueOf(Nr));
    }

    @FXML
    void AddPressedBtn(ActionEvent event) {
        String da = String.valueOf(daSlider.getValue());
        String duong = String.valueOf(duongSlider.getValue());
        String s = String.valueOf(size.getSelectedToggle());
        System.out.print(da + '\n');
        System.out.print(duong + '\n');
        System.out.print(s + '\n');
    }

    @FXML
    void KhachTraPressedBtn(ActionEvent event) {
        int i = Integer.parseInt(khachTra.getText());
        System.out.print(i + '\n');

    }


}
