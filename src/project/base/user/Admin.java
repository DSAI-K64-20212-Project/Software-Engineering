package project.base.user;

import project.base.DBUtil;

import java.sql.SQLException;

public class Admin extends User{
    public Admin(String username){
        super(username);
    }

    public void create_new_user(String username,
                                String fullname,
                                String password,
                                String phone,
                                String avatar,
                                String position,
                                String shift
                                ) throws SQLException, ClassNotFoundException {
        String command = String.format("INSERT INTO nhanvien(tendangnhap, tennhanvien, matkhau, sdt, anhdaidien, chucvu, calam) " +
                "VALUES ('%s', '%s', '%s','%s','%s', '%s', '%s');",
                username, fullname, password, phone, avatar, position, shift);
        try {
            DBUtil.dbExecuteUpdate(command);
        } catch (SQLException e) {
            System.out.println("Error occurred while INSERT operation: "+ e);
            throw e;
        }

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Admin s = new Admin("hungpham");
        s.create_new_user("doubleK24", "Hoàng Văn Khánh", "123456", "019238", "khanh.png", "Pha Che","Chieu");
    }
}
