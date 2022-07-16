package project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import project.UI.HoaDon;
import project.UI.InvoiceView;
import project.base.DBUtil;
import project.base.order.Invoice;

import javafx.event.ActionEvent;

import java.sql.SQLException;

public class HoaDonDetailController {

    @FXML
    private Button billCancelButton;

    @FXML
    private Button billDoneButton;

    @FXML
    private AnchorPane billPane;
    @FXML
    private Label timeStampLabel;

    @FXML
    private Label idHoaDon;
    private HoaDonController hoaDonController;
    private String mahoadon;
    private String date;

    public void setData(HoaDon hoaDon) throws Exception {
        this.mahoadon = hoaDon.getMahoadon();
        Invoice invoice = new Invoice(hoaDon.getMahoadon());
        idHoaDon.setText("Hóa Đơn " + this.mahoadon);
        idHoaDon.setMaxWidth(300);
        billPane.getChildren().add(new InvoiceView(invoice, false, false));
    }

    public void setHoaDonController(HoaDonController hoaDonController) {
        this.hoaDonController = hoaDonController;
    }

    @FXML
    void setBillDoneButton(ActionEvent event) throws Exception {
        String query = String.format("update hoadon set trangthai = 'Da giao' where mahoadon = '%s';", this.mahoadon );
        DBUtil.dbExecuteUpdate(query);
        hoaDonController.initialize();
    }
    @FXML
    void setBillCancelButton(ActionEvent event) throws Exception {
        String query = String.format("update hoadon set trangthai = 'Huy' where mahoadon = '%s';", this.mahoadon );
        DBUtil.dbExecuteUpdate(query);
        hoaDonController.initialize();
    }

}
//    private void initialize() throws Exception, SQLException {
//        String query = String.format("select mahoadon, trangthai from hoadon where trangthai='Dang chuan bi'");
//        ResultSet resultSet = DBUtil.dbExecuteQuery(query);
//
//        resultSet.next();
//        String mahoadon = resultSet.getString("mahoadon");
//        Invoice hoadon = new Invoice(mahoadon);
//        billPane1.getChildren().add(new InvoiceView(hoadon, false, false));
//
//
//        resultSet.next();
//        String mahoadon2 = resultSet.getString("mahoadon");
//        Invoice hoadon2 = new Invoice(mahoadon2);
//        billPane2.getChildren().add(new InvoiceView(hoadon2, false, false));
//
//        resultSet.next();
//        String mahoadon3 = resultSet.getString("mahoadon");
//        Invoice hoadon3 = new Invoice(mahoadon3);
//        billPane3.getChildren().add(new InvoiceView(hoadon3, false, false));
//    }
