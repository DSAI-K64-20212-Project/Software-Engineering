package project;

import com.jfoenix.controls.JFXSlider;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import project.base.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DatDoUongController {
    @FXML
    private RadioButton sizeM;
    @FXML
    private RadioButton sizeL;
    @FXML
    private ToggleGroup size;
    @FXML
    private Label doUong1;
    @FXML
    private Label tenTopping1;
    @FXML
    private Label giaTopping1;

    @FXML
    private JFXSlider daSlider;

    @FXML
    private JFXSlider duongSlider;

    @FXML
    private Label l1;

    @FXML
    private Pane pane1;
    @FXML
    private VBox vboxLeft;

    @FXML
    private TextField khachTra;
    @FXML
    private VBox hoaDon1;
    @FXML
    private Text tenDoUong1;
    @FXML
    private Text modDoUong1;
    @FXML
    private Text tongTien;
    @FXML
    private Text soDu;

    @FXML
    private Label l11;

    @FXML
    private VBox hoaDon11;

    @FXML
    private Text tenDoUong11;

    @FXML
    private Pane pane11;
    @FXML
    private Text modDoUong11;

    @FXML
    private Label l12;

    @FXML
    private VBox hoaDon12;

    @FXML
    private Text tenDoUong12;

    @FXML
    private Pane pane12;
    @FXML
    private Text modDoUong12;
    @FXML
    private Pane topping1;
    @FXML
    private Text giaHoaDon1;

    @FXML
    private Button buttonLoai1;

    @FXML
    private Button buttonLoai11;
    @FXML
    private Button buttonLoai12;
    @FXML
    private Label giaLoai1;

    @FXML
    private Label giaLoai11;
    @FXML
    private Text giaHoaDon11;
    @FXML
    private Label giaTopping11;
    @FXML
    private Label giaLoai12;
    @FXML
    private Text giaHoaDon12;
    @FXML
    private Label giaTopping12;
    @FXML
    private Button buttonTopping1;
    @FXML
    private Button buttonTopping11;
    @FXML
    private Pane topping11;
    @FXML
    private Label tenTopping11;
    @FXML
    private Button buttonTopping12;
    @FXML
    private Pane topping12;
    @FXML
    private Label tenTopping12;
    @FXML
    private Label doUong11;
    @FXML
    private Label doUong12;
    @FXML
    private HBox loaiDoPane;
    @FXML
    private Pane pane;


    Label doUong;
    Label giaDoUong;
    private static String chosenDrink;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        String command = "SELECT * FROM douong WHERE onmenu = True;";
        ResultSet result = DBUtil.dbExecuteQuery(command);
        while (result.next()) {

            Image background = new Image(getClass().getResourceAsStream("resources/image/TraSua/images.jpeg"));
            Button button = new Button(result.getString("tendouong"), new ImageView(background));
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            button.getStyleClass().add("button-image");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    chosenDrink = button.getText();
                }
            });

            Label label = new Label(result.getString("tendouong"));
            label.setFont(Font.font("Arial",15));
            VBox vBox = new VBox(button, label);
            vBox.setSpacing(10);
            vBox.setAlignment(Pos.CENTER);
            loaiDoPane.getChildren().add(vBox);
        }

    }
    @FXML
    void DoUongPressedBtn(ActionEvent event) {
        Button doUongButtonId = (Button) event.getTarget();
        if (doUongButtonId == buttonLoai1) {
            if (pane1.isVisible()) {
                pane1.setVisible(false);
            } else {
                pane1.setVisible(true);
                doUong = doUong1;
                giaDoUong = giaLoai1;
            }
        } else if (doUongButtonId == buttonLoai11) {
            if (pane11.isVisible()) {
                pane11.setVisible(false);
            } else {
                pane11.setVisible(true);
                doUong = doUong11;
                giaDoUong = giaLoai11;
            }
        } else if (doUongButtonId == buttonLoai12) {
            if (pane12.isVisible()) {
                pane12.setVisible(false);
            } else {
                pane12.setVisible(true);
                doUong = doUong12;
                giaDoUong = giaLoai12;
        }
    }
}

    Label tenTopping;
    Label giaTopping;

    @FXML
    void ToppingPressedBtn(ActionEvent event) {
        Button toppingButtonId = (Button) event.getTarget();
        if (toppingButtonId == buttonTopping1) {
            if (topping1.isVisible()) {
                topping1.setVisible(false);
            } else {
                topping1.setVisible(true);
                tenTopping = tenTopping1;
                giaTopping = giaTopping1;
            }
        }  else if   (toppingButtonId == buttonTopping11) {
            if (topping11.isVisible()) {
                topping11.setVisible(false);
            } else {
                topping11.setVisible(true);
                tenTopping = tenTopping11;
                giaTopping = giaTopping11;
            }
        }  else if (toppingButtonId == buttonTopping12) {
            if (topping12.isVisible()) {
                topping12.setVisible(false);
            } else {
                topping12.setVisible(true);
                tenTopping = tenTopping12;
                giaTopping = giaTopping12;
            }
        }
    }

    @FXML
    private Button minus1;
    @FXML
    private Button plus1;
    @FXML
    private Button minus11;
    @FXML
    private Button plus11;
    @FXML
    private Button minus12;
    @FXML
    private Button plus12;
    private int Nr1 = 1;
    private int Nr11 = 1;
    private int Nr12 = 1;
    @FXML
    void MinusPressedBtn(ActionEvent event) {
        Button minusButtonId = (Button) event.getTarget();
        if (minusButtonId == minus1) {
            if (Nr1 == 1) {
                hoaDon1.setVisible(false);
                giaHoaDon1.setText("0");
            } else {
                Nr1 -= 1;
                l1.setText(String.valueOf(Nr1));
            }
        } else if (minusButtonId == minus11){
            if (Nr11 == 1) {
                hoaDon11.setVisible(false);
                giaHoaDon11.setText("0");
            } else {
                Nr11 -= 1;
                l11.setText(String.valueOf(Nr11));
            }
        }else if (minusButtonId == minus12){
            if (Nr12 == 1) {
                hoaDon12.setVisible(false);
                giaHoaDon12.setText("0");

            } else {
                Nr12 -= 1;
                l12.setText(String.valueOf(Nr12));
            }
        }

        tongTien.setText(String.valueOf(Integer.parseInt(giaHoaDon1.getText())*Integer.parseInt(l1.getText())+Integer.parseInt(giaHoaDon11.getText())*Integer.parseInt(l11.getText())+Integer.parseInt(giaHoaDon12.getText())*Integer.parseInt(l12.getText())));
    }

    @FXML
    void PlusPressedBtn(ActionEvent event) {
        Button plusButtonId = (Button) event.getTarget();
        if (plusButtonId == plus1) {
            Nr1 += 1;
            l1.setText(String.valueOf(Nr1));
        } else if (plusButtonId == plus11) {
            Nr11 += 1;
            l11.setText(String.valueOf(Nr11));
        }else if (plusButtonId == plus12) {
            Nr12 += 1;
            l12.setText(String.valueOf(Nr12));
        }
        tongTien.setText(String.valueOf(Integer.parseInt(giaHoaDon1.getText())*Integer.parseInt(l1.getText())+Integer.parseInt(giaHoaDon11.getText())*Integer.parseInt(l11.getText())+Integer.parseInt(giaHoaDon12.getText())*Integer.parseInt(l12.getText())));

    }

    int cAdd = 0;

    @FXML
    void AddPressedBtn(ActionEvent event) {
        int da = (int) daSlider.getValue();
        int duong = (int) duongSlider.getValue();
        RadioButton t = (RadioButton) size.getSelectedToggle();
        cAdd += 1;
        if (cAdd == 1) {
            hoaDon1.setVisible(true);
            modDoUong1.setText('-' + t.getText() + "\n"
                    + '-' + tenTopping.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong1.setText(doUong.getText());
            giaHoaDon1.setText(String.valueOf(Integer.parseInt(giaDoUong.getText())+Integer.parseInt(giaTopping.getText())));
        } else if  ( cAdd ==2){
            hoaDon11.setVisible(true);
            modDoUong11.setText('-' + t.getText() + "\n"
                    + '-' + tenTopping.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong11.setText(doUong.getText());
            giaHoaDon11.setText(String.valueOf(Integer.parseInt(giaDoUong.getText())+Integer.parseInt(giaTopping.getText())));
        }else if  ( cAdd ==3){
            hoaDon12.setVisible(true);
            modDoUong12.setText('-' + t.getText() + "\n"
                    + '-' + tenTopping.getText() + "\n"
                    + '-' + da + "% đá \n"
                    + '-' + duong + "% đường \n");
            tenDoUong12.setText(doUong.getText());
            giaHoaDon12.setText(String.valueOf(Integer.parseInt(giaDoUong.getText())+Integer.parseInt(giaTopping.getText())));
        }
        tongTien.setText(String.valueOf(Integer.parseInt(giaHoaDon1.getText())*Integer.parseInt(l1.getText())+Integer.parseInt(giaHoaDon11.getText())*Integer.parseInt(l11.getText())+Integer.parseInt(giaHoaDon12.getText())*Integer.parseInt(l12.getText())));

    }

    @FXML
    void KhachTraPressedBtn(ActionEvent event) {
        int i = Integer.parseInt(khachTra.getText());
        System.out.print(i);
        soDu.setText(String.valueOf(i-Integer.parseInt(tongTien.getText())));
    }

    @FXML
    void XacNhanPressedBtn(ActionEvent event) {
        hoaDon1.setVisible(false);
        hoaDon11.setVisible(false);
        hoaDon12.setVisible(false);
        cAdd = 0;
        tongTien.setText("0");
        soDu.setText("0");
    }
}
