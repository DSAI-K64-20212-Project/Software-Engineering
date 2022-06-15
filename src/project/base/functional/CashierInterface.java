package project.base.functional;

import project.base.DBUtil;
import project.base.order.Invoice;

import java.sql.SQLException;

public interface CashierInterface {
    default String confirm_new_invoice(String username, Invoice invoice) throws SQLException, ClassNotFoundException {
        if (invoice.check_availability()){
            String command = String.format("INSERT INTO hoadon(tendangnhap, soorder, khachdua, trangthai, " +
                    "mahoadon) VALUES ('%s', %d, %d, '%s', '%s');", username, invoice.soorder, invoice.khachdua,
                    "Dang chuan bi", invoice.id);
            DBUtil.dbExecuteUpdate(command);
            return "Success!";
        } else {
            System.out.printf("User %s add new invoice unsuccessfully, out of ingredients\n",username);
            return "Out of ingredients!";
        }
    }
}
