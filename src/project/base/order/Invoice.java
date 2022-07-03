package project.base.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.base.DBUtil;

import java.io.Reader;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Invoice {
    private final ObservableList<OneCall> inFo = FXCollections.observableArrayList();
    public int soorder;
    public int khachdua = 0;
    public String tenkhachhang;
    public String id;
    private int buy_id = 0;

    public Invoice(String mahoadon) throws Exception {
        String query = String.format("select * from thanhphanhoadon where mahoadon='%s';", mahoadon);
        ResultSet resultSet = DBUtil.dbExecuteQuery(query);
        while (resultSet.next()) {
            int buyId = resultSet.getInt("buyid");
            String invoiceCode = resultSet.getString("mahoadon");
            String drinkName = resultSet.getString("tendouong");
            char size = resultSet.getString("size").charAt(0);
            Double da = resultSet.getDouble("da");
            Double duong = resultSet.getDouble("duong");
            int soLuong = resultSet.getInt("soluong");

            String queryTopping = String.format("select tentopping from toppingtronghoadon where mahoadon = '%s' and buyid = %d;", invoiceCode, buyId);
            ResultSet resultSet1 = DBUtil.dbExecuteQuery(queryTopping);
            ArrayList<String> toppingList = new ArrayList<String>();
            while (resultSet1.next()) {
                String topping = resultSet1.getString("tentopping");
                toppingList.add(topping);
            }
            String[] topppingArray = Arrays.copyOf(toppingList.toArray(), toppingList.size(), String[].class);
            this.inFo.add(new OneCall(buyId, drinkName, size, duong, da, topppingArray));
        }
    }
    public Invoice() {
        //tam thoi random so order
        soorder = ThreadLocalRandom.current().nextInt(0, 50 + 1);
        id = UUID.randomUUID().toString(); //Generates random UUID.
    }
    public ObservableList<OneCall> getInFo() {
        return inFo;
    }

    public void addCall(String drink_name, char size, double sugar, double ice, String[] toppings) throws Exception {
        this.buy_id += 1;
        this.inFo.add(new OneCall(buy_id, drink_name, size, sugar, ice, toppings));
    }

    public OneCall getCall(int index) {
        return this.inFo.get(index);
    }

    public int getBill() throws SQLException, ClassNotFoundException {
        int total = 0;
        for (OneCall call : inFo) {
            total += call.get_money();
        }
        return total;
    }

    public void pay(int amount, String tenkhachhang) throws SQLException, ClassNotFoundException {
        int total = this.getBill();
        if (amount < total) {
            System.out.println("Chưa đủ số tiền cần trả");
        } else {
            this.khachdua = amount;
            this.tenkhachhang = tenkhachhang;
            System.out.printf("Khách hàng %s thanh toán thành công. Tổng: %d, đã trả: %d, còn dư: %d\n", tenkhachhang
                    , total, amount, amount - total);
        }
    }

    public boolean check_payment() throws SQLException, ClassNotFoundException {
        return (khachdua >= this.getBill());
    }

    public boolean check_availability() throws SQLException, ClassNotFoundException {
        boolean avail = true;
        for (OneCall call : inFo) {
            avail = avail && call.check_availability();
        }
        return avail;
    }

    public static void main(String[] args) throws Exception {
        Invoice invoice = new Invoice("5e7c1583-bb5b-4e6a-ab41-97fde6bb6edd");
        System.out.println(invoice.getBill());
    }
}
