package project;

import javafx.event.ActionEvent;
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

    @FXML
    void trangThaiBtn(ActionEvent event) {
        if (trangThai.getText() == "Het Hang") {
            trangThai.setText("Con Hang");
        }
        else {
            trangThai.setText("Het Hang");
        }
    }

    public void setData(ImageMain image){
        Image img = new Image(getClass().getResourceAsStream(image.getThumbSrc()), 163, 122, false, false);
        anhNguyenLieu.setImage(img);

        trangThai.setText(image.getTrangThai());
        tenNguyenLieu.setText(image.getName());
    }
}