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
                           HashMap<Character, Integer> size_giatien,
                           String[] nhungnguyenlieu
    ) throws SQLException, ClassNotFoundException {
        BartenderInterface.super.add_drink(tendouong, anh, size_giatien, nhungnguyenlieu);
        System.out.printf("NV pha chế %s đã thêm đồ uống %s, giá size M: %s, giá size L: %s, nguyên liệu: %s",
                this.getUsername(), tendouong, size_giatien.get('M'), size_giatien.get('L'), Arrays.toString(nhungnguyenlieu));
    }
    @Override
    public void add_topping(String tentopping, String anh, int giatien, String[] nhungnguyenlieu) throws SQLException,
            ClassNotFoundException {
        BartenderInterface.super.add_topping(tentopping, anh, giatien, nhungnguyenlieu);
        System.out.printf("NV pha chế %s đã thêm topping %s, giá %d, nguyên liệu: %s", this.getUsername(), tentopping
                , giatien, Arrays.toString(nhungnguyenlieu));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Bartender s = new Bartender("hungpham");
//        s.add_ingredient("Pudding", "Cty Nước Nôi VN", "Con hang");
//        s.add_drink("Trà sữa Hai Nắng","hainang.png",new HashMap<>() {{put('M',30);put('L',33);}}, new String[]{
//                "Trân Châu", "Khúc Bạch", "Pudding"});
        s.add_topping("Hạt ngọc trai", "ngoctrai.png", 5, new String[] {"Trân Châu", "Khúc Bạch"});
    }
}
