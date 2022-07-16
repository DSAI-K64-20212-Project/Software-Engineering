package project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import project.UI.HoaDon;
import project.UI.InvoiceView;
import project.base.order.Invoice;

import java.awt.event.ActionEvent;

public class HoaDonDetailController {

    @FXML
    private Button billCancelButton;

    @FXML
    private Button billDoneButton;

    @FXML
    private AnchorPane billPane;

    @FXML
    private Label idHoaDon;
    static int ID=0;

    public void setData(HoaDon hoaDon) throws Exception {
        ID++;
        Invoice invoice = new Invoice(hoaDon.getMahoadon());
        idHoaDon.setText("Hóa Đơn " + ID);
        billPane.getChildren().add(new InvoiceView(invoice, false, false));
    }
//
//    @FXML
//    public void setBillDoneButton(ActionEvent event) {
//        int i = ID;
//        String query = String.format("update hoadon set trangthai = 'Da giao' where mahoadon = '%s';",  );
//    }
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
