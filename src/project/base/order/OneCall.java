package project.base.order;

import project.base.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringJoiner;

public class OneCall {
    public int id;
    public String drink_name;
    public char size;
    public double sugar;
    public double ice;
    public String[] toppings;
    public int amount;

    public OneCall(int id, String drink_name, char size, double sugar, double ice, String[] toppings) throws Exception {
        if (0<=sugar && sugar<=1 && 0<=ice && ice<=1){
            throw new Exception("Invalid sugar or ice rate");
        }
        this.id = id;
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

    public int get_money() throws SQLException, ClassNotFoundException {
        int total;
        StringJoiner command = new StringJoiner("', '",
                "select sum(giatopping) + giadouong from topping, giadouong where tenTopping in ('",
                String.format("') group by tendouong, size having tendouong = '%s' and size = '%s';", this.drink_name,
                        this.size)
                );
        for (String topping: this.toppings) {
            command.add(topping);
        }
        ResultSet result = DBUtil.dbExecuteQuery(command.toString());
        if (result.next()) {
            total = result.getInt(1);
        } else {
            throw new SQLException("Invalid drink and topping");
        }
        //tra lại tổng số tiền trong 1 call, bao gồm tiền của đồ uống, phụ thuộc vào size + tiền của topping
        //viết lệnh sql query
        return total*this.amount;
    }
    public boolean check_availability() throws SQLException, ClassNotFoundException {
        StringJoiner command = new StringJoiner("', '", """
        select n.tennguyenlieu, tenTopping from thanhphantopping inner join nguyenlieu n on ThanhPhanTopping.tenNguyenLieu = n.tennguyenlieu
        where tenTopping in ('""", String.format("""
        ') and n.trangThai = 'Het hang'
        union
        select n2.tennguyenlieu, tenDoUong from thanhphandouong inner join nguyenlieu n2 on ThanhPhanDoUong.tenNguyenLieu = n2.tennguyenlieu
        where tendouong = '%s' and n2.trangThai = 'Het hang';
        return true;
        """, this.drink_name));

        for (String topping: this.toppings) {
            command.add(topping);
        }
        ResultSet result = DBUtil.dbExecuteQuery(command.toString());
        return !result.next();
    }
}
