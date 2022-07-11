package project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import project.model.ImageMain;

public class ThumbController {
    @FXML
    private Button trangThai;

    @FXML
    private Label tenNguyenLieu;

    @FXML
    private ImageView anhNguyenLieu;

    public void setData(ImageMain image){
        Image img = new Image(getClass().getResourceAsStream(image.getThumbSrc()));
        anhNguyenLieu.setImage(img);

        trangThai.setText(image.getTrangThai());
        tenNguyenLieu.setText(image.getName());
    }
}