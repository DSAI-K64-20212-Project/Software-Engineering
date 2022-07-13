package project.UI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.InputStream;

public class VBoxCell extends VBox {
    ImageView imageView = new ImageView();
    public Label ten = new Label();
    Label gia = new Label();

    public VBoxCell(String ten, String tenanh) {
        super();
        InputStream imagestream = getClass().getResourceAsStream(String.format("../resources/image" +
                        "/TraSua/%s",
                tenanh));
        if (imagestream == null){
            imagestream = getClass().getResourceAsStream("../resources/image/TraSua/matcha.jpg");
        }
        Image background = new Image(imagestream, 100, 100, false, false);
        imageView.setImage(background);

        this.ten.setText(ten);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(this.imageView, this.ten);
    }

    public VBoxCell(String tentopping, String tenanh, String giatien) {
        InputStream imagestream = getClass().getResourceAsStream(String.format("../resources/image" +
                        "/Topping/%s",
                tenanh));
        if (imagestream == null){
            imagestream = getClass().getResourceAsStream("../resources/image/Topping/senvang.jpg");
        }
        Image background = new Image(imagestream, 100, 100, false, false);
        imageView.setImage(background);

        this.ten.setText(tentopping);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.gia.setText(giatien+".000đ");
        this.getChildren().addAll(this.imageView, this.ten, this.gia);
    }
}
