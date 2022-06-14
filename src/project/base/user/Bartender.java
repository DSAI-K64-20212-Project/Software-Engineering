package project.base.user;

import project.base.functional.BartenderInterface;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class Bartender extends User implements BartenderInterface {
    public Bartender(String username) {
        super(username);
    }
    @Override
    public void add_ingredient(String tennguyenlieu, String nhacungcap, String trangthai) throws SQLException,
            ClassNotFoundException {
        BartenderInterface.super.add_ingredient(tennguyenlieu, nhacungcap, trangthai);
        System.out.printf("NV pha chế %s đã thêm nguyên liệu %s, nhà cung cấp %s, trạng thái %s", this.getUsername(),
                tennguyenlieu, nhacungcap, trangthai);
    }
    @Override
    public void add_drink(String tendouong,
                           String anh,
                           HashMap<Character, Double> size_giatien,
                           String[] nhungnguyenlieu
    ) throws SQLException, ClassNotFoundException {
        BartenderInterface.super.add_drink(tendouong, anh, size_giatien, nhungnguyenlieu);
        System.out.printf("NV pha chế %s đã thêm đồ uống %s, giá size M: %s, giá size L: %s, nguyên liệu: %s",
                this.getUsername(), tendouong, size_giatien.get('M'), size_giatien.get('L'), Arrays.toString(nhungnguyenlieu));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Bartender s = new Bartender("hungpham");
        s.add_ingredient("Khúc Bạch", "Cty Nước Nôi VN", "Con hang");
    }
}
