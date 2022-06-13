/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import com.sun.prism.paint.Stop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mr Pham Truong
 */
public class FXMLController implements Initializable {

    private Label lbQuynhTrang;
    @FXML
    private VBox vboxLeft;
    @FXML
    private Button btnDoanhThu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        vboxLeft.setStyle("-fx-background-color: #19A1CF");
        btnDoanhThu.setStyle("-fx-background-color: #C4C4C4");
    }

    private void handleBtnDashBoard(ActionEvent event) {
        lbQuynhTrang.setText("Thanh Truong");
    }

    @FXML
    private void doanhThuPressedBtn(ActionEvent event) {

    }

    @FXML
    void nguyenLieuPressedBtn(ActionEvent event) {

    }

    @FXML
    void nhanSuPressedBtn(ActionEvent event) {

    }

    @FXML
    void menuPressedBtn(ActionEvent event) {

    }

    @FXML
    void datDoUongPressedBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/project/DatDoUong.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
