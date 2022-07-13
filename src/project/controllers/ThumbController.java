package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import project.base.DBUtil;
import project.model.ImageMain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ThumbController {
    private String idnguyenlieu;
    @FXML
    private Button trangThai;

    @FXML
    private Label tenNguyenLieu;

    @FXML
    private ImageView anhNguyenLieu;

    @FXML
    void trangThaiBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (trangThai.getText().equals("Het hang")) {
            trangThai.setText("Con hang");
            String command = String.format("UPDATE nguyenlieu SET trangthai = 'Con hang' WHERE idnguyenlieu = '%s'", idnguyenlieu);
            ResultSet result = DBUtil.dbExecuteUpdate(command);
        }
        else if (trangThai.getText().equals("Con hang")){
            System.out.println("OK Con hang");
            trangThai.setText("Sap het");
            String command = String.format("UPDATE nguyenlieu SET trangthai = 'Sap het' WHERE idnguyenlieu = '%s'", idnguyenlieu);
            ResultSet result = DBUtil.dbExecuteUpdate(command);
        }
        else if (trangThai.getText().equals("Sap het")){
            trangThai.setText("Het hang");
            String command = String.format("UPDATE nguyenlieu SET trangthai = 'Het hang' WHERE idnguyenlieu = '%s'", idnguyenlieu);
            ResultSet result = DBUtil.dbExecuteUpdate(command);
        }
    }

    public void setData(ImageMain image){
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(image.getThumbSrc())), 163, 122, false, false);
        anhNguyenLieu.setImage(img);
        trangThai.setText(image.getTrangThai());
        tenNguyenLieu.setText(image.getName());
        idnguyenlieu = image.getIdNguyenLieu();
    }
}