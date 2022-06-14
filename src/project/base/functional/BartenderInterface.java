package project.base.functional;

import project.base.DBUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
                           HashMap<Character, Double> size_giatien,
                           String[] nhungnguyenlieu
                           ) throws SQLException, ClassNotFoundException {

        String command = String.format("INSERT INTO douong(tendouong, anh) " +
                "VALUES ('%s', '%s');", tendouong, anh);
        DBUtil.dbExecuteUpdate(command);


        StringBuilder command2 = new StringBuilder("INSERT INTO giadouong(tendouong, anh) VALUES ");
        for (Map.Entry<Character, Double> entry : size_giatien.entrySet()) {
            command2.append(String.format("('%s', '%s')", entry.getKey(), entry.getValue()));
        }
        command2.append(";");
        DBUtil.dbExecuteUpdate(command2.toString());


        StringBuilder command3 = new StringBuilder("INSERT INTO thanphandouong(tendouong, tennguyenlieu) VALUES ");
        for (String nguyenlieu: nhungnguyenlieu) {
            command3.append(String.format("('%s', '%s')", tendouong, nguyenlieu));
        }
        command3.append(";");
        DBUtil.dbExecuteUpdate(command3.toString());
    }

}