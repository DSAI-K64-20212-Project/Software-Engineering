package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.base.functional.BartenderInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemDoUongToppingController implements BartenderInterface {

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    public Button backBtn;

    @FXML
    private RadioButton radioButtonSize2;

    @FXML
    private Pane paneSize1;

    @FXML
    private Pane paneGiaTopping;

    @FXML
    private TextField ten;

    @FXML
    private TextField giaSizeM;

    @FXML
    private TextField giaSizeL;

    @FXML
    private TextField giaTopping;

    @FXML
    private RadioButton nguyenLieu3;
    @FXML
    private RadioButton nguyenLieu4;
    @FXML
    private RadioButton nguyenLieu5;
    @FXML
    private RadioButton nguyenLieu6;
    @FXML
    private RadioButton nguyenLieu;
    @FXML
    private RadioButton nguyenLieu1;
    @FXML
    private RadioButton nguyenLieu2;
    @FXML
    private RadioButton[] nguyenLieu0 = new  RadioButton[7];

    @FXML
    private ToggleGroup loai;

    @FXML
    private Circle anhDoUongTopping;

    @FXML
    public Button imageBtn;

    private String anh = "null";


    @FXML
    private HBox hBoxNguyenLieu;

    @FXML
    public void initialize() throws IOException, SQLException, ClassNotFoundException{
        String command1 = String.format("SELECT * FROM nguyenlieu");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);

        while (result1.next()) {
            String tenNguyenLieu = result1.getString(1);

            RadioButton nguyenLieuRadioBtn = new RadioButton();
            nguyenLieuRadioBtn.setText(tenNguyenLieu);
            nguyenLieuRadioBtn.setStyle("-fx-border-color:#000000");
            nguyenLieuRadioBtn.setStyle("-fx-border-width:3");
            nguyenLieuRadioBtn.setStyle("-fx-border-radius:20");

            hBoxNguyenLieu.getChildren().add(nguyenLieuRadioBtn);
        }
    }


    @FXML
    void doUongBtn(ActionEvent event) {
        paneGiaTopping.setVisible(false);
        paneSize1.setVisible(true);
        radioButtonSize2.setVisible(true);
    }

    @FXML
    void toppingBtn(ActionEvent event) {
        paneGiaTopping.setVisible(true);
        paneSize1.setVisible(false);
        radioButtonSize2.setVisible(false);
    }

    @FXML
    void apDungBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        nguyenLieu0[0] =  nguyenLieu;
        nguyenLieu0[1] =  nguyenLieu1;
        nguyenLieu0[2] =  nguyenLieu2;
        nguyenLieu0[3] =  nguyenLieu3;
        nguyenLieu0[4] =  nguyenLieu4;
        nguyenLieu0[5] =  nguyenLieu5;
        nguyenLieu0[6] =  nguyenLieu6;

        RadioButton loaiB = (RadioButton) loai.getSelectedToggle();
        if (loaiB.getText().equals("Đồ uống")) {
            ArrayList<String> ar = new ArrayList<String>();
            for (int j = 0; j < nguyenLieu0.length; j++) {
                System.out.print(j);
                if (nguyenLieu0[j].isSelected() == true) {
                    ar.add(nguyenLieu0[j].getText());
                }
            }

            String[] nl = new String[ar.toArray().length];
            for (int i=0; i<ar.toArray().length;i++){
                nl[i] = ar.get(i);
            }

            add_drink("Tam", ten.getText(), "add.png", new HashMap<>() {{put('M',Integer.parseInt(giaSizeM.getText()));put('L',Integer.parseInt(giaSizeL.getText()));}}, nl);
        }  else {
            ArrayList<String> ar = new ArrayList<String>();
            for (int j = 0; j < nguyenLieu0.length; j++) {
                if (nguyenLieu0[j].isSelected() == true) {
                    ar.add(nguyenLieu0[j].getText());
                }
            }

            String[] nl = new String[ar.toArray().length];
            for (int i=0; i<ar.toArray().length;i++){
                nl[i] = ar.get(i);
            }

            add_topping("Tam", ten.getText(), "add.png", Integer.parseInt(giaTopping.getText()), nl);
        }
    }

    @FXML
    void uploadImageBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../screen/ChinhSuaNhanVien.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        final FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Image files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("Image files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("Image files (*.jpeg)","*jpeg");
        fileChooser.getExtensionFilters().addAll(extFilter, extFilter1, extFilter2, extFilter3);
        fileChooser.setTitle("Select Some Files");

        // Set thư mục bắt đầu khi mở FileChooser
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File file = fileChooser.showOpenDialog(stage);

        // Set image sau khi upload ảnh
        Image img = new Image(String.valueOf(file));
        ImageView view = new ImageView(img);
        view.setFitHeight(200);
        view.setFitWidth(200);
        // Hide text
        anh = String.valueOf(file);
        imageBtn.setGraphic(view);

        System.out.println(imageBtn.getText());

    }
}

