package project.base.user;

import project.base.functional.BartenderInterface;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class Bartender extends User implements BartenderInterface {
    public Bartender(String username) {
        super(username);
    }
    public void add_ingredient(String tennguyenlieu, String nhacungcap, String trangthai) throws SQLException,
            ClassNotFoundException {
        BartenderInterface.super.add_ingredient(this.getUsername(), tennguyenlieu, nhacungcap, trangthai);
    }
    public void add_drink(String tendouong,
                           String anh,
                           HashMap<Character, Integer> size_giatien,
                           String[] nhungnguyenlieu
    ) throws SQLException, ClassNotFoundException {
        BartenderInterface.super.add_drink(this.getUsername(), tendouong, anh, size_giatien, nhungnguyenlieu);
    }
    public void add_topping(String tentopping, String anh, int giatien, String[] nhungnguyenlieu) throws SQLException,
            ClassNotFoundException {
        BartenderInterface.super.add_topping(this.getUsername(), tentopping, anh, giatien, nhungnguyenlieu);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Bartender s = new Bartender("hungpham");
        s.add_ingredient("Pudding", "Cty Nước Nôi VN", "Con hang");
        s.add_drink("Trà sữa Hai Nắng","hainang.png",new HashMap<>() {{put('M',30);put('L',33);}}, new String[]{
                "Trân Châu", "Khúc Bạch", "Pudding"});
        s.add_topping("Hạt ngọc trai", "ngoctrai.png", 5, new String[] {"Trân Châu", "Khúc Bạch"});
    }
}
