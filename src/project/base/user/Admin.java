package project.base.user;

import project.base.DBUtil;
import project.base.functional.AdminInterface;

import java.sql.SQLException;

public class Admin extends User implements AdminInterface {
    public Admin(String username){
        super(username);
    }

    @Override
    public void create_new_user(String username, String fullname, String password, String phone, String avatar, String position, String shift) throws SQLException, ClassNotFoundException {
        AdminInterface.super.create_new_user(username, fullname, password, phone, avatar, position, shift);
        System.out.printf("Admin %s đã tạo user mới:\nusername\t%s\nfull name\t%s\nposition\t%s", this.getUsername(),
                username, fullname, position);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Admin s = new Admin("hungpham");
        //s.create_new_user("doubleK24", "Hoàng Văn Khánh", "123456", "019238", "khanh.png", "Pha Che","Chieu");
//        s.create_new_user("hthientam2402", "Hoàng Thiện Tâm", "123456", "0913887814", "khanh.png", "Pha Che","Chieu");
        s.create_new_user("nhatdeptrai", "Minh Nhat", "123456", "0913887814", "nhat.png", "Quan Ly",
                "Sang");
    }

}
