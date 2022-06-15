package project.base.order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Invoice {
    private final ObservableList<OneCall> inFo = FXCollections.observableArrayList();
    public int soorder;
    public int khachdua;
    private int buy_id = 0;
    public String id;

    public Invoice(){
        //tam thoi random so order
        soorder = ThreadLocalRandom.current().nextInt(0, 50 + 1);
        id = UUID.randomUUID().toString(); //Generates random UUID.
    };
    public void addCall(String drink_name, char size, double sugar, double ice, String[] toppings) throws Exception {
        this.buy_id += 1;
        this.inFo.add(new OneCall(buy_id, drink_name, size, sugar, ice, toppings));
    }
    public OneCall getCall(int index){
        return this.inFo.get(index);
    }

    public int getBill() throws SQLException, ClassNotFoundException {
        int total = 0;
        for (OneCall call : inFo){
            total += call.get_money();
        }
        return total;
    }

    public void pay(int amount) throws SQLException, ClassNotFoundException {
        int total = this.getBill();
        if (amount < total){
            System.out.println("Chưa đủ số tiền cần trả");
        } else {
            this.khachdua = amount;
            System.out.printf("Thanh toán thành công. Tổng: %d, đã trả: %d, còn dư: %d", total, amount, amount-total);
        }
    }
    public boolean check_availability() throws SQLException, ClassNotFoundException {
        boolean avail = true;
        for (OneCall call: inFo){
            avail = avail && call.check_availability();
        }
        return avail;
    }
}