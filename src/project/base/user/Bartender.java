package project.base.user;

import project.base.functional.BartenderInterface;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class Bartender extends User implements BartenderInterface {
    public Bartender(String username) {
        super(username);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Bartender s = new Bartender("hungpham");
        s.add_ingredient(s.getUsername(), "Đường", "Cty Nước Nôi VN", "duong.png", "Con hang");
//        s.add_drink(s.getUsername(), "Trà sữa Hai Nắng","hainang.png",new HashMap<>() {{put('M',30);put('L',33);}},
//                new String[]{"Trân Châu", "Khúc Bạch", "Pudding"});
//        s.add_topping(s.getUsername(),"Hạt ngọc trai", "ngoctrai.png", 5, new String[] {"Trân Châu", "Khúc Bạch"});
    }
}
