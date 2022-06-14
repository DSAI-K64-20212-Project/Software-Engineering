package project.base.order;

import project.base.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OneCall {
    private String drink_name;
    private char size;
    private double sugar;
    private double ice;
    private String[] toppings;
    private int amount;

    public OneCall(String drink_name, char size, double sugar, double ice, String[] toppings) {
        this.drink_name = drink_name;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.toppings = toppings;
        this.amount = 1;
    }

    public void increase_amount(){
        this.amount += 1;
    }
    public void decrease_amount(){
        if (this.amount > 0) {
            this.amount -= 1;
        } else {
            System.out.println("Not allow negative ammount");
        }
    }

    public double get_money() throws SQLException, ClassNotFoundException {
        double total = 0;
        //TODO
        double toppingsPrice = 0;
        for (int i = 0; i < this.toppings.length; i++){
            String topping = this.toppings[i];
            String toppingPriceQuery = "BEGIN\n" +
                    "   SELECT giatopping \n" +
                    "    FROM topping \n" +
                    "   WHERE tentopping = " + topping + "\n" +
                    "END;";
            ResultSet result = DBUtil.dbExecuteQuery(toppingPriceQuery);
            if (!result.next()) {
                toppingsPrice += result.getDouble(2);
            }
        }

        total += toppingsPrice;
        String drinkPriceQuery = "BEGIN\n" +
                "   SELECT giadouong \n" +
                "    FROM giadouong \n" +
                "   WHERE tendouong = " + this.drink_name + " AND size = "+ this.size + "\n" +
                "END;";
        ResultSet result = DBUtil.dbExecuteQuery(drinkPriceQuery);
        if (!result.next()) {
            total += result.getDouble(3);
        }
        //tra lại tổng số tiền trong 1 call, bao gồm tiền của đồ uống, phụ thuộc vào size + tiền của topping
        //viết lệnh sql query

        return total*this.amount;
    }
}
public static void main(String[] args){
    OneCall newcall('Trà Thái Bede', 'M', 0.5, 0.5, ['Trân Châu Bede'], 2);
    System.out.println(newcall.get_money());
}

