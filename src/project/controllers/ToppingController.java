package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import project.UI.DoUong;
import project.UI.Topping;
import project.base.DBUtil;

import java.sql.SQLException;

public class ToppingController {
    @FXML
    private RadioButton xoaTopping;

    @FXML
    private Circle anhTopping;

    @FXML
    private Pane paneTopping;

    @FXML
    private Text thongTinTopping;

    @FXML
    private Text giaTopping;

    @FXML
    private CheckBox toppingOnMenu;

    @FXML
    void toppingOnMenuBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String command2 = String.format("UPDATE topping SET onmenu = '%s' WHERE tentopping = '%s'",toppingOnMenu.isSelected(),thongTinTopping.getText());
        DBUtil.dbExecuteUpdate(command2);
    }

    public void setData(Topping topping){
        anhTopping.setStroke(Color.SEAGREEN);
        Image im = new Image(topping.getAnhTopping());
        anhTopping.setFill(new ImagePattern(im));
        anhTopping.setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

        thongTinTopping.setText(topping.getThongTinTopping());
        giaTopping.setText("Gia\n" + topping.getGiaTopping());
        toppingOnMenu.setSelected(topping.getToppingOnMenu());
    }
}
