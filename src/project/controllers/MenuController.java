package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.UI.DoUong;
import project.UI.NhanVien;
import project.UI.Topping;
import project.base.DBUtil;
import javafx.scene.paint.Color;


import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuController {
    @FXML
    public Button themDoUongToppingBtn;

    @FXML
    private VBox vBoxDoUong;
    @FXML
    private VBox vBoxTopping;

    private List<DoUong> doUongs;
    private List<Topping> toppings;

    @FXML
    public void initialize() throws IOException, SQLException, ClassNotFoundException{
        doUongs = new ArrayList<>(doUongs());

        try {
            for (int i = 0; i < doUongs.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/project/screen/DoUong.fxml"));
                Pane box = fxmlLoader.load();
                DoUongController doUongController = fxmlLoader.getController();
                doUongController.setData(doUongs.get(i));

                vBoxDoUong.getChildren().add(box);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        toppings = new ArrayList<>(toppings());

        try {
            for (int i = 0; i < toppings.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/project/screen/Topping.fxml"));
                Pane box = fxmlLoader.load();
                ToppingController toppingController = fxmlLoader.getController();
                toppingController.setData(toppings.get(i));

                vBoxTopping.getChildren().add(box);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private List<DoUong> doUongs() throws SQLException, ClassNotFoundException, IOException {
        List<DoUong> ls = new ArrayList<>();

        String command1 = "SELECT * FROM douong";
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);

        while (result1.next()) {
            String tenDoUong = result1.getString(1);
            String anh = result1.getString(2);
            String onMenuStr = result1.getString(3);

            DoUong doUong = new DoUong();
            doUong.setAnhDoUong("/project/resources/image/TraSua/" +anh);
            doUong.setThongTinDoUong(tenDoUong);
            doUong.setOnMenu(Boolean.parseBoolean(onMenuStr));

            String commandGiaMDoUong = String.format("SELECT * FROM giadouong WHERE tendouong = '%s' and size = 'M'",tenDoUong);
            ResultSet resultGiaMDoUong = DBUtil.dbExecuteQuery(commandGiaMDoUong);

            if (resultGiaMDoUong.next()){
                doUong.setGiaMDoUong(resultGiaMDoUong.getString(3));
            }

            String commandGiaLDoUong = String.format("SELECT * FROM giadouong WHERE tendouong = '%s' and size = 'L'",tenDoUong);
            ResultSet resultGiaLDoUong = DBUtil.dbExecuteQuery(commandGiaLDoUong);

            if (resultGiaLDoUong.next()){
                doUong.setGiaLDoUong(resultGiaLDoUong.getString(3));
            }

            ls.add(doUong);
        }

        return ls;
    }

    private List<Topping> toppings() throws SQLException, ClassNotFoundException, IOException {
        List<Topping> ls = new ArrayList<>();

        String command1 = "SELECT * FROM topping";
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);

        while (result1.next()) {
            String tenTopping = result1.getString(1);
            String giaTopping = result1.getString(2);
            String anh = result1.getString(3);
            String onMenuStr = result1.getString(4);

            Topping topping = new Topping();
            topping.setAnhTopping("project/resources/image/Topping/" + anh);
            topping.setThongTinTopping(tenTopping);
            topping.setToppingOnMenu(Boolean.parseBoolean(onMenuStr));
            topping.setGiaTopping(giaTopping);

            ls.add(topping);
        }

        return ls;
    }

    @FXML
    void xoaBtn(ActionEvent event) {

    }
}

