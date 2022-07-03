package project;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import project.UI.InvoiceView;
import project.base.DBUtil;
import project.base.order.Invoice;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static project.LogIn.monitor;


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
    private Text giaHoaDon12;

    @FXML
    private JFXListView toppingList;
    @FXML
    private JFXListView douongList;
    @FXML
    private ScrollPane hoadonList;
    @FXML
    private Label totalBillLabel;


    private static Invoice hoadon = new Invoice();
    private static String chosenDrink;
    private static String[] chosenTopping;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        hoadonList.setContent(new InvoiceView(hoadon));
        ObservableStringValue formattedBill = Bindings.createStringBinding(() ->
                "Tổng tiền: " + String.format("%d.000đ",hoadon.getBill()), hoadon.getBillProperty());
        totalBillLabel.textProperty().bind(formattedBill);

        class VBoxCell extends VBox {
            ImageView imageView = new ImageView();
            Label ten = new Label();
            Label gia = new Label();

            VBoxCell(String ten, String tenanh) {
                super();
                Image background = new Image(getClass().getResourceAsStream(String.format("resources/image/TraSua/%s",
                        tenanh)), 100, 100, false, false);
                imageView.setImage(background);

                this.ten.setText(ten);
                this.setSpacing(10);
                this.setAlignment(Pos.CENTER);

                this.getChildren().addAll(this.imageView, this.ten);
            }

            VBoxCell(String tentopping, String tenanh, String giatien) {
                InputStream imagestream = getClass().getResourceAsStream(String.format("resources/image/Topping/%s",
                        tenanh));
                if (imagestream == null){
                    imagestream = getClass().getResourceAsStream("resources/image/Topping/senvang.jpg");
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
        String command = "SELECT * FROM douong WHERE onmenu = True;";
        ResultSet result = DBUtil.dbExecuteQuery(command);
        List<VBoxCell> list = new ArrayList<>();
        while (result.next()) {
            list.add(new VBoxCell(result.getString("tendouong"),
                    result.getString("anh")));
        }
        ObservableList<VBoxCell> douong = FXCollections.observableList(list);
        douongList.setItems(douong);
        douongList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<VBoxCell>) (observableValue
                , old, n) -> {
            chosenDrink = n.ten.getText();
            System.out.println(chosenDrink);
        });

        //topping
        String command2 = "SELECT * FROM topping WHERE onmenu = True;";
        ResultSet result2 = DBUtil.dbExecuteQuery(command2);
        List<VBoxCell> list2 = new ArrayList<>();
        while (result2.next()){
            list2.add(new VBoxCell(result2.getString("tentopping"),
                    result2.getString("anh"),
                    result2.getString("giatopping")));
        }
        ObservableList<VBoxCell> myObservableList = FXCollections.observableList(list2);
        toppingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        toppingList.setItems(myObservableList);
        toppingList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<VBoxCell>) (observableValue, o, t1) -> {
            ObservableList<VBoxCell> selectedItems = toppingList.getSelectionModel().getSelectedItems();
            List<String> local = new ArrayList<>();
            for (VBoxCell v:selectedItems){
                local.add(v.ten.getText());
            }
            chosenTopping = local.toArray(new String[0]);
            System.out.println(Arrays.toString(chosenTopping));
        });
    }

    int cAdd = 0;

    @FXML
    void AddPressedBtn(ActionEvent event) throws Exception {
        double da = daSlider.getValue()/100;
        double duong = duongSlider.getValue()/100;
        RadioButton s = (RadioButton) size.getSelectedToggle();
        hoadon.addCall(chosenDrink, s.getText().charAt(s.getText().length()-1), duong, da, chosenTopping);
    }

    @FXML
    void KhachTraPressedBtn(ActionEvent event) {
        int i = Integer.parseInt(khachTra.getText());
        System.out.print(i);
        soDu.setText(String.valueOf(i-Integer.parseInt(tongTien.getText())));
    }

    @FXML
    void XacNhanPressedBtn(ActionEvent event) {

    }
}
