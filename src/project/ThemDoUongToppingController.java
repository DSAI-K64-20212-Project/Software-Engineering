package project;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.base.functional.BartenderInterface;

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
    private Button pauseButton;


    @FXML
    private ImageView avaImg;

    @FXML
    private VBox vboxLeft;

    @FXML
    private Button playButton;

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
    public void initialize() throws IOException, SQLException, ClassNotFoundException{
        nguyenLieu0[0] =  nguyenLieu;
        nguyenLieu0[1] =  nguyenLieu1;
        nguyenLieu0[2] =  nguyenLieu2;
        nguyenLieu0[3] =  nguyenLieu3;
        nguyenLieu0[4] =  nguyenLieu4;
        nguyenLieu0[5] =  nguyenLieu5;
        nguyenLieu0[6] =  nguyenLieu6;

        String command1 = String.format("SELECT * FROM nguyenlieu");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        int i1 = 0;

        while (result1.next()) {
            String tenNguyenLieu = result1.getString(1);
            String nhaCungCap = result1.getString(2);
            String trangThai = result1.getString(3);
            String anh = result1.getString(4);

            nguyenLieu0[i1].setText(tenNguyenLieu);

            i1 += 1;
        }
    }

    @FXML
    void infBtn(MouseEvent event) throws IOException {
//        avaImg.setPickOnBounds(true);
        Parent root = FXMLLoader.load(getClass().getResource("TaiKhoanCuaBan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void billBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HoaDon_temp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ingredientBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void hrBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml")); // Chưa có màn hình
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menuBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("KhoNguyenLieu.fxml")); // Chưa có màn hình
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void revBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoanhThu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ordBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DatDoUong.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void pauseMedia(ActionEvent event) {
        String f = "src/project/resources/music/home.mp3";
        Media media = new Media(Paths.get(f).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(mediaPlayer != null) {
            System.out.println("Pause !");
            mediaPlayer.setMute(true);
        }
    }

    // Music ON !!!
    @FXML
    void playMedia(ActionEvent event) {
        String f = "src/project/resources/music/home.mp3";
        Media media = new Media(Paths.get(f).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        System.out.println("Play Music !");
        mediaPlayer.setAutoPlay(true);
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
    void backBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

