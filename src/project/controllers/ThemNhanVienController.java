package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import project.base.functional.AdminInterface;

import java.sql.SQLException;

public class ThemNhanVienController implements AdminInterface {

    @FXML
    private TextField hoVaTen;
    @FXML
    private TextField soDienThoai;
    @FXML
    private TextField username;
    @FXML
    private TextField matKhau;

    @FXML
    private ToggleGroup chucVu;
    @FXML
    private ToggleGroup caLam;
    @FXML
    public Button backBtn;


    @FXML
    void apDungBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String tenNhanVien = hoVaTen.getText();
        String sdt = soDienThoai.getText();
        String tenDangNhap = username.getText();
        String mk = matKhau.getText();
        String avatar = "images.jpeg";
        RadioButton cv0 = (RadioButton) chucVu.getSelectedToggle();
        String cv = cv0.getText();
        String cv1;
        if (cv == "Thu ngân"){
            cv1 = "Thu Ngan";
        } else if (cv == "Pha chế"){
            cv1 = "Pha Che";
        } else {
            cv1 = "Quan Ly";
        }

        RadioButton cl0 = (RadioButton) caLam.getSelectedToggle();
        String cl = cl0.getText();
        String cl1;
        if (cl == "Sáng"){
            cl1 = "Sang";
        } else {
            cl1 = "Chieu";
        }

        create_new_user("Tam",tenDangNhap,tenNhanVien,mk,sdt,avatar,cv1,cl1);
    }
}

