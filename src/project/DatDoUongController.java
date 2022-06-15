package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DatDoUongController {

    @FXML
    private VBox vboxLeft;

    @FXML
    void doanhThuPressedBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/project/FXML.fxml"));
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
}
