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
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.base.functional.AdminInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

public class ChinhSuaNhanVienController implements AdminInterface {

    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Button pauseButton;

    @FXML public Button backBtn;

    @FXML
    private Button imageBtn;

    @FXML
    private ImageView avaImg;

    @FXML
    private VBox vboxLeft;

    @FXML
    private Button playButton;

    @FXML
    private RadioButton thuNganBtn;
    @FXML
    private RadioButton phaCheBtn;
    @FXML
    private RadioButton quanLyBtn;
    @FXML
    private RadioButton sangBtn;
    @FXML
    private RadioButton chieuBtn;

    @FXML
    private TextField hoVaTen;
    @FXML
    private TextField soDienThoai;
    @FXML
    private TextField username;
    @FXML
    private TextField matKhau;
    @FXML
    private ToggleGroup chucVu;
    @FXML
    private ToggleGroup caLam;

    public RadioButton getThuNganBtn() {
        return thuNganBtn;
    }

    public RadioButton getPhaCheBtn() {
        return phaCheBtn;
    }

    public RadioButton getQuanLyBtn() {
        return quanLyBtn;
    }

    public RadioButton getSangBtn() {
        return sangBtn;
    }

    public RadioButton getChieuBtn() {
        return chieuBtn;
    }

    public TextField getHoVaTen() {
        return hoVaTen;
    }

    public TextField getSoDienThoai() {
        return soDienThoai;
    }

    public TextField getUsername() {
        return username;
    }

    public TextField getMatKhau() {
        return matKhau;
    }

    public ToggleGroup getChucVu() {
        return chucVu;
    }

    public ToggleGroup getCaLam() {
        return caLam;
    }

    private String oldUsername;
    private String anh = "null";

    @FXML
    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        oldUsername = username.getText();
    }


    @FXML
    void apDungBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String cv = "null";
        String cl;
        if (thuNganBtn.isSelected()) {
            cv = "Thu Ngan";
        }
        if (phaCheBtn.isSelected()) {
            cv = "Pha Che";
        }
        if (quanLyBtn.isSelected()) {
            cv = "Quan Ly";
        }
        if (sangBtn.isSelected()) {
            cl = "Sang";
        } else {
            cl = "Chieu";
        }
        String command2 = String.format("UPDATE nhanvien SET tendangnhap = '%s',tennhanvien = '%s', sdt = '%s', matkhau = '%s', chucvu = '%s', calam = '%s' WHERE tendangnhap = '%s'", username.getText(),hoVaTen.getText(),soDienThoai.getText(),matKhau.getText(),cv,cl,username.getText());
        DBUtil.dbExecuteUpdate(command2);
    }

    @FXML
    void backBtn(ActionEvent event) throws IOException {

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

