package project.controllers;

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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import project.UI.InvoiceView;
import project.base.DBUtil;
import project.base.order.Invoice;
import project.base.user.Cashier;

import javax.swing.*;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static project.LogIn.monitor;


public class DatDoUongController {
    @FXML
    private ToggleGroup size;

    @FXML
    private JFXSlider daSlider;

    @FXML
    private JFXSlider duongSlider;

    @FXML
    private TextField khachTra;
    @FXML
    private TextField tenKhach;
    @FXML
    private JFXListView toppingList;
    @FXML
    private JFXListView douongList;
    @FXML
    private ScrollPane hoadonList;
    @FXML
    private Label totalBillLabel;
    @FXML
    private Text khachTraLabel;
    @FXML
    private Label soDuLabel;


    private static Invoice hoadon = new Invoice();
    private static String chosenDrink;
    private static String[] chosenTopping;

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
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
                Image background = new Image(getClass().getResourceAsStream(String.format("../resources/image" +
                                "/TraSua/%s",
                        tenanh)), 100, 100, false, false);
                imageView.setImage(background);

                this.ten.setText(ten);
                this.setSpacing(10);
                this.setAlignment(Pos.CENTER);

                this.getChildren().addAll(this.imageView, this.ten);
            }

            VBoxCell(String tentopping, String tenanh, String giatien) {
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
            if (n != null) {
                chosenDrink = n.ten.getText();
            } else { chosenDrink = null;}
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
        ObservableStringValue formattedPaid = Bindings.createStringBinding(() ->
                String.format("Khách trả: %d.000đ",hoadon.getPaid()), hoadon.getPaidProperty());
        khachTraLabel.textProperty().bind(formattedPaid);
        ObservableStringValue formattedOdd = Bindings.createStringBinding(() ->
                String.format("Số dư: %d.000đ",hoadon.getPaid() - hoadon.getBill()), hoadon.getBillProperty(),
                hoadon.getPaidProperty());
        soDuLabel.textProperty().bind(formattedOdd);
    }

    @FXML
    void AddPressedBtn(ActionEvent event) throws Exception {
        double da = daSlider.getValue()/100;
        double duong = duongSlider.getValue()/100;
        RadioButton s = (RadioButton) size.getSelectedToggle();
        hoadon.addCall(chosenDrink, s.getText().charAt(s.getText().length()-1), duong, da, chosenTopping);
    }

    @FXML
    void KhachTraPressedBtn(ActionEvent event) {
        if (tenKhach.getText().trim().isEmpty() || khachTra.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Field", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        try {
            int i = Integer.parseInt(khachTra.getText());
            hoadon.pay(i, tenKhach.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Number", "ERROR!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void XacNhanPressedBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (monitor.getCashier() != null){
            Cashier user = monitor.getCashier();
            String message = user.confirm_new_invoice(user.getUsername(), hoadon);
            JOptionPane.showMessageDialog(null, message);
            if (Objects.equals(message, "Success!")){
                hoadon = new Invoice();
                initialize();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid user, not cashier, pls log out and log in again!");
        }
    }
    @FXML
    void printButtonPressed(ActionEvent event){
        JOptionPane.showMessageDialog(null, "Đã in ra hóa đơn", "Sucess", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        InputStream imagestream = DatDoUongController.class.getResourceAsStream(".." +
                "/screen/resources/image/Topping" +
                "/caramen.png");
        System.out.println(imagestream);
    }
}
