package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import project.base.DBUtil;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChinhSuaDoUongController {
    @FXML
    private Pane paneGiaTopping;

    @FXML
    private Pane paneSize1;

    @FXML
    private TextField giaTopping;

    @FXML
    private RadioButton nguyenLieu;

    @FXML
    private RadioButton nguyenLieu1;

    @FXML
    private RadioButton nguyenLieu2;

    @FXML
    private AnchorPane mainAddDrTp;

    @FXML
    private RadioButton nguyenLieu3;

    @FXML
    private RadioButton nguyenLieu4;

    @FXML
    private RadioButton nguyenLieu5;

    @FXML
    private RadioButton nguyenLieu6;

    @FXML
    private RadioButton radioButtonSize2;

    @FXML
    private ToggleGroup loai;

    @FXML
    private Circle anhDoUongTopping;

    @FXML
    private TextField ten;

    @FXML
    private TextField giaSizeL;

    @FXML
    private TextField giaSizeM;

    @FXML public Button backBtn;

    @FXML
    private HBox hBoxNguyenLieu;

    public String old;
    ArrayList<String> nguyenLieuHienTai = new ArrayList<>();

    public TextField getGiaTopping() {
        return giaTopping;
    }

    public TextField getTen() {
        return ten;
    }

    public TextField getGiaSizeL() {
        return giaSizeL;
    }

    public TextField getGiaSizeM() {
        return giaSizeM;
    }

    public void open() throws IOException, SQLException, ClassNotFoundException{
        hBoxNguyenLieu.getChildren().clear();

        int columns = 1;

        String command1 = String.format("SELECT * FROM nguyenlieu");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);

        String command2 = String.format("SELECT * FROM thanhphandouong WHERE tendouong = '%s'",old);
        ResultSet result2 = DBUtil.dbExecuteQuery(command2);
        while (result2.next()) {
            nguyenLieuHienTai.add(result2.getString(2));
        }

        while (result1.next()) {
            String tenNguyenLieu = result1.getString(1);

            RadioButton nguyenLieuRadioBtn = new RadioButton();
            nguyenLieuRadioBtn.setText(tenNguyenLieu);
            nguyenLieuRadioBtn.setStyle("-fx-border-color:#000000");
            nguyenLieuRadioBtn.setStyle("-fx-border-width:3");
            nguyenLieuRadioBtn.setStyle("-fx-border-radius:20");
            nguyenLieuRadioBtn.setPadding(new Insets(5, 5, 5, 5));
            if (nguyenLieuHienTai.contains(tenNguyenLieu)){
                nguyenLieuRadioBtn.setSelected(true);
            }

            hBoxNguyenLieu.getChildren().add(nguyenLieuRadioBtn);

        }

        String command3 = String.format("SELECT * FROM douong WHERE tendouong = '%s'",old);
        ResultSet result3 = DBUtil.dbExecuteQuery(command3);

        if (result3.next()) {
            anhDoUongTopping.setStroke(Color.SEAGREEN);
            Image im = new Image("project/resources/image/TraSua/"+ result3.getString(2));
            anhDoUongTopping.setFill(new ImagePattern(im));
            anhDoUongTopping.setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));
        }
    }

    @FXML
    void doUongBtn(ActionEvent event) {

    }

    @FXML
    void toppingBtn(ActionEvent event) {

    }

    @FXML
    void apDungBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String command2 = String.format("UPDATE giadouong " + "SET giadouong = '%s' WHERE size = 'M' AND tendouong = '%s'",giaSizeM.getText(),ten.getText());
        DBUtil.dbExecuteUpdate(command2);
        String command3 = String.format("UPDATE giadouong " + "SET giadouong = '%s' WHERE size = 'L' AND tendouong = '%s'",giaSizeL.getText(),ten.getText());
        DBUtil.dbExecuteUpdate(command3);

        String command1 = String.format("SELECT * FROM thanhphandouong WHERE tendouong = '%s'",old);
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        while (result1.next()) {
            nguyenLieuHienTai.add(result1.getString(2));
            String command4 = String.format("DELETE FROM thanhphandouong WHERE tendouong = '%s'",old);
            DBUtil.dbExecuteUpdate(command4);
        }

        for (Node n: hBoxNguyenLieu.getChildren()){
            RadioButton radioBtn = (RadioButton) n;
            if (radioBtn.isSelected()){
                String command5 = String.format("INSERT INTO thanhphandouong VALUES ('%s','%s')",old, radioBtn.getText());
                DBUtil.dbExecuteUpdate(command5);
            }
        }

        JOptionPane.showMessageDialog(null, "Đồ uống đã được chỉnh sửa thành công", "Notification", 1);
    }

    @FXML
    void backBtn(ActionEvent event) {

    }

    @FXML
    void xoaBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String command1 = String.format("DELETE FROM giadouong WHERE  tendouong = '%s'",old);
        DBUtil.dbExecuteUpdate(command1);
        String command2 = String.format("DELETE FROM thanhphandouong WHERE  tendouong = '%s'",old);
        DBUtil.dbExecuteUpdate(command2);
        String command3 = String.format("DELETE FROM douong WHERE  tendouong = '%s'",old);
        DBUtil.dbExecuteUpdate(command3);

        JOptionPane.showMessageDialog(null, "Đồ uống đã được xóa thành công", "Notification", 1);
    }

}
