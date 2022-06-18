package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController {

    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private VBox vboxLeft;

    @FXML
    void billBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HoaDon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ingredientBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void hrBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml")); // Chưa có màn hình
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menuBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml")); // Chưa có màn hình
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void revBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoanhThu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void infBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TaiKhoanCuaBan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ordBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DatDoUong.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

