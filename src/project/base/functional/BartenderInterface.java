package project.base.functional;

import project.base.DBUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public interface BartenderInterface {
    default void add_ingredient(String tennguyenlieu,
                                String nhacungcap,
                                String trangthai
    ) throws SQLException, ClassNotFoundException {
        String command = String.format("INSERT INTO nguyenlieu(tenNguyenLieu, nhaCungCap, trangThai) " +
                        "VALUES ('%s', '%s', '%s');", tennguyenlieu, nhacungcap, trangthai);
        DBUtil.dbExecuteUpdate(command);
    }

    default void add_drink(String tendouong,
                           String anh,
                           HashMap<Character, Integer> size_giatien,
                           String[] nhungnguyenlieu
                           ) throws SQLException, ClassNotFoundException {

        String command = String.format("INSERT INTO douong(tendouong, anh) " +
                "VALUES ('%s', '%s');", tendouong, anh);
        DBUtil.dbExecuteUpdate(command);


        StringJoiner command2 = new StringJoiner(",", "INSERT INTO giadouong(tendouong, size, giadouong) VALUES ",";");
        for (Map.Entry<Character, Integer> entry : size_giatien.entrySet()) {
            System.out.println(entry.getValue());
            command2.add(String.format("('%s','%s', %d)", tendouong, entry.getKey(), entry.getValue()));
        }
        DBUtil.dbExecuteUpdate(command2.toString());


        StringJoiner command3 = new StringJoiner(",", "INSERT INTO thanhphandouong(tendouong, tennguyenlieu) VALUES ",
                ";");
        for (String nguyenlieu: nhungnguyenlieu) {
            command3.add(String.format("('%s', '%s')", tendouong, nguyenlieu));
        }
        DBUtil.dbExecuteUpdate(command3.toString());
    }
    default void add_topping(String tentopping, String anh, int giatien, String[] nhungnguyenlieu) throws SQLException, ClassNotFoundException {
        String command = String.format("INSERT INTO topping(tentopping, anh, giatopping) " +
                "VALUES ('%s', '%s', %d);", tentopping, anh, giatien);
        DBUtil.dbExecuteUpdate(command);

        StringJoiner command2 = new StringJoiner(",", "INSERT INTO thanhphantopping(tentopping, tennguyenlieu) VALUES ",
                ";");
        for (String nguyenlieu: nhungnguyenlieu) {
            command2.add(String.format("('%s', '%s')", tentopping, nguyenlieu));
        }
        DBUtil.dbExecuteUpdate(command2.toString());
    }
}