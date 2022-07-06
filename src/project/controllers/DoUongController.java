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
import project.base.DBUtil;

import java.sql.SQLException;

public class DoUongController {
    @FXML
    private Pane paneDoUong;

    @FXML
    private CheckBox onMenu;

    @FXML
    private Text sizeMDoUong;

    @FXML
    private RadioButton xoaDoUong;

    @FXML
    private Circle anhDoUong;

    @FXML
    private Text thongTinDoUong;

    @FXML
    private Text sizeLDoUong;

    @FXML
    void onMenuBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
            String command2 = String.format("UPDATE douong SET onmenu = '%s' WHERE tendouong = '%s'",onMenu.isSelected(),thongTinDoUong.getText());
            DBUtil.dbExecuteUpdate(command2);
    }

    @FXML
    void xoaBtn(ActionEvent event){

    }

    public void setData(DoUong doUong){
        anhDoUong.setStroke(Color.SEAGREEN);
        Image im = new Image(doUong.getAnhDoUong());
        anhDoUong.setFill(new ImagePattern(im));
        anhDoUong.setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

        thongTinDoUong.setText(doUong.getThongTinDoUong());
        sizeLDoUong.setText("SizeL\n" + doUong.getGiaLDoUong());
        sizeMDoUong.setText("SizeM\n" + doUong.getGiaMDoUong());
        onMenu.setSelected(doUong.getOnMenu());
    }
}
