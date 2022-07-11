package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import project.base.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChinhSuaToppingController {
    @FXML
    private AnchorPane mainAddDrTp;

    @FXML
    private Pane paneGiaTopping;

    @FXML
    private RadioButton doUong;

    @FXML
    private Button backBtn;

    @FXML
    private ToggleGroup loai;

    @FXML
    private Circle anhDoUongTopping;

    @FXML
    private HBox hBoxNguyenLieu;

    @FXML
    private TextField ten;

    @FXML
    private RadioButton topping;

    @FXML
    private TextField giaTopping;

    ArrayList<String> nguyenLieuHienTai = new ArrayList<>();
    public String old;

    public TextField getTen() {
        return ten;
    }

    public void setTen(TextField ten) {
        this.ten = ten;
    }

    public TextField getGiaTopping() {
        return giaTopping;
    }

    public void setGiaTopping(TextField giaTopping) {
        this.giaTopping = giaTopping;
    }

    @FXML
    void doUongBtn(ActionEvent event) {

    }

    @FXML
    void toppingBtn(ActionEvent event) {

    }

    @FXML
    void apDungBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String command2 = String.format("UPDATE topping " + "SET giatopping = '%s' WHERE tentopping = '%s'",giaTopping.getText(),old);
        DBUtil.dbExecuteUpdate(command2);

        String command1 = String.format("SELECT * FROM thanhphantopping WHERE tentopping = '%s'",old);
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        while (result1.next()) {
            nguyenLieuHienTai.add(result1.getString(2));
            String command3 = String.format("DELETE FROM thanhphantopping WHERE tentopping = '%s'",old);
            DBUtil.dbExecuteUpdate(command3);
        }

        System.out.print(hBoxNguyenLieu.getChildren());
        for (Node n: hBoxNguyenLieu.getChildren()){
            RadioButton radioBtn = (RadioButton) n;
            if (radioBtn.isSelected()){
                String command4 = String.format("INSERT INTO thanhphantopping VALUES ('%s','%s')",old, radioBtn.getText());
                DBUtil.dbExecuteUpdate(command4);
            }
        }
    }

    public void open() throws IOException, SQLException, ClassNotFoundException{
        String command1 = String.format("SELECT * FROM nguyenlieu");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);

        String command2 = String.format("SELECT * FROM thanhphantopping WHERE tentopping = '%s'",old);
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
            if (nguyenLieuHienTai.contains(tenNguyenLieu)){
                nguyenLieuRadioBtn.setSelected(true);
            }

            hBoxNguyenLieu.getChildren().add(nguyenLieuRadioBtn);

        }

        String command3 = String.format("SELECT * FROM topping WHERE tentopping = '%s'",old);
        ResultSet result3 = DBUtil.dbExecuteQuery(command3);

        while (result3.next()) {
            anhDoUongTopping.setStroke(Color.SEAGREEN);
            Image im = new Image("project/resources/image/Topping/" + result3.getString(3));
            anhDoUongTopping.setFill(new ImagePattern(im));
            anhDoUongTopping.setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));
        }
    }

    @FXML
    void xoaBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String command1 = String.format("DELETE FROM topping WHERE  tentopping = '%s'",old);
        DBUtil.dbExecuteUpdate(command1);
        String command2 = String.format("DELETE FROM thanhphantopping WHERE  tentopping = '%s'",old);
        DBUtil.dbExecuteUpdate(command2);
    }

}
