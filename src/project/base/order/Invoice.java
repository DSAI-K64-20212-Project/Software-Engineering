package project.base.order;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Invoice {
    private final ObservableList<OneCall> inFo = FXCollections.observableArrayList();
    public int soorder;
    public int khachdua = 0;
    public String tenkhachhang;
    private int buy_id = 0;
    public String id;
    public SimpleIntegerProperty bill = new SimpleIntegerProperty(0);

    public Invoice(){
        //tam thoi random so order
        soorder = ThreadLocalRandom.current().nextInt(0, 50 + 1);
        id = UUID.randomUUID().toString(); //Generates random UUID.
    };
    public ObservableList<OneCall> getInFo() {
        return inFo;
    }
    public void addCall(String drink_name, char size, double sugar, double ice, String[] toppings) throws Exception {
        this.buy_id += 1;
        OneCall oneCall = new OneCall(buy_id, drink_name, size, sugar, ice, toppings);
        oneCall.getAmountProperty().addListener((observableValue, number, t1) -> {
            try {
                updateBill();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        this.inFo.add(oneCall);
        updateBill();
    }
    public OneCall getCall(int index){
        return this.inFo.get(index);
    }

    public void updateBill() throws SQLException, ClassNotFoundException {
        int total = 0;
        for (OneCall call : inFo){
            total += call.get_money();
        }
        bill.setValue(total);
    }

    public int getBill() {
        return bill.getValue();
    }
    public SimpleIntegerProperty getBillProperty(){return bill;}

    public void pay(int amount, String tenkhachhang) throws SQLException, ClassNotFoundException {
        int total = this.getBill();
        if (amount < total){
            System.out.println("Chưa đủ số tiền cần trả");
        } else {
            this.khachdua = amount;
            this.tenkhachhang = tenkhachhang;
            System.out.printf("Khách hàng %s thanh toán thành công. Tổng: %d, đã trả: %d, còn dư: %d\n", tenkhachhang
                    , total, amount, amount-total);
        }
    }
    public boolean check_payment() throws SQLException, ClassNotFoundException {
        return (khachdua >= this.getBill());
    }
    public boolean check_availability() throws SQLException, ClassNotFoundException {
        boolean avail = true;
        for (OneCall call: inFo){
            avail = avail && call.check_availability();
        }
        return avail;
    }
}