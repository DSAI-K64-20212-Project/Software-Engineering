package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import project.UI.InvoiceView;
import project.base.DBUtil;
import project.base.order.Invoice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonController {

    @FXML
    private ImageView avaImg;

    @FXML
    private Button billCancelButton1;

    @FXML
    private Button billCancelButton2;

    @FXML
    private Button billCancelButton3;

    @FXML
    private Button billCheckedButton1;

    @FXML
    private Button billCheckedButton2;

    @FXML
    private Button billCheckedButton3;

    @FXML
    private Label billInfoLabel1;

    @FXML
    private Label billInfoLabel2;

    @FXML
    private Label billInfoLabel3;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private VBox vboxLeft;

    @FXML
    void billBtn(ActionEvent event) {

    }

    @FXML
    void infBtn(MouseEvent event) {

    }

    @FXML
    void ingredientBtn(ActionEvent event) {

    }

    @FXML
    void menuBtn(ActionEvent event) {

    }

    @FXML
    void pauseMedia(ActionEvent event) {

    }

    @FXML
    void playMedia(ActionEvent event) {

    }
    @FXML
    private AnchorPane billPane1;
    @FXML
    private AnchorPane billPane2;
    @FXML
    private AnchorPane billPane3;

    @FXML
    private void initialize() throws Exception {
        String query = String.format("select mahoadon, trangthai from hoadon where trangthai='Dang chuan bi'");
        ResultSet resultSet = DBUtil.dbExecuteQuery(query);

        resultSet.next();
        String mahoadon = resultSet.getString("mahoadon");
        Invoice hoadon = new Invoice(mahoadon);
        billPane1.getChildren().add(new InvoiceView(hoadon, false, false));

        resultSet.next();
        String mahoadon2 = resultSet.getString("mahoadon");
        Invoice hoadon2 = new Invoice(mahoadon);
        billPane2.getChildren().add(new InvoiceView(hoadon, false, false));

        resultSet.next();
        String mahoadon3 = resultSet.getString("mahoadon");
        Invoice hoadon3 = new Invoice(mahoadon);
        ScrollPane pane = new ScrollPane();
        pane.setContent(new InvoiceView(hoadon, false, false));
        pane.setBackground(Background.EMPTY);
        billPane3.getChildren().add(pane);


    }
}
