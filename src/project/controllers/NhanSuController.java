package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.UI.NhanVien;
import project.base.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanSuController {
    private BaseController baseController;

    public void setBaseController(BaseController baseController) {
        this.baseController = baseController;
    }


    @FXML
    public Button themNvBtn;

    @FXML
    private VBox vBoxNhanVien;

    private List<NhanVien> nhanViens;

    @FXML
    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        vBoxNhanVien.getChildren().clear();
        nhanViens = new ArrayList<>(nhanViens());

        try {
            for (int i = 0; i < nhanViens.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/project/screen/NhanVien.fxml"));
                AnchorPane box = fxmlLoader.load();
                NhanVienController nhanVienController = fxmlLoader.getController();
                nhanVienController.setData(nhanViens.get(i));
                nhanVienController.setBaseController(baseController);

                vBoxNhanVien.getChildren().add(box);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private List<NhanVien> nhanViens() throws SQLException, ClassNotFoundException, IOException {
        List<NhanVien> ls = new ArrayList<>();

        String command1 = String.format("SELECT * FROM nhanvien");
        ResultSet result1 = DBUtil.dbExecuteQuery(command1);
        int i1 = 0;

        while (result1.next()) {
            String tenDangNhap = result1.getString(1);
            String tenNhanVien = result1.getString(2);
            String sdt = result1.getString(3);
            String matKhau = result1.getString(4);
            String anhNhanVien = result1.getString(5);
            String chucVu = result1.getString(6);
            String caLam = result1.getString(7);

            NhanVien nhanVien = new NhanVien();
            nhanVien.setAnhNhanVienSrc("project/resources/image/icons/" + anhNhanVien);
            nhanVien.setCaLam(chucVu+ "\n" + caLam);
            nhanVien.setThongTin(tenNhanVien + "\n" + sdt + "\n" + tenDangNhap);

            String commandNgay = String.format("SELECT COUNT(*) FROM lichsulamviec WHERE tendangnhap = '%s' and datraluong = '%b'",tenDangNhap,false);
            ResultSet resultNgay = DBUtil.dbExecuteQuery(commandNgay);
            if (resultNgay.next()) {
                int ngayChuaTraLuong = resultNgay.getInt("count");
                String commandTienCa = String.format("SELECT * FROM tienluong WHERE chucvu = '%s' AND calam = '%s'",chucVu,caLam);
                ResultSet resultTienCa = DBUtil.dbExecuteQuery(commandTienCa);
                if (resultTienCa.next()){
                    int TienCa = resultTienCa.getInt("tiencalam");
                    nhanVien.setLuongChuaTra(String.format("%oX%o\n%o",ngayChuaTraLuong,TienCa,ngayChuaTraLuong*TienCa));
                }
            } else{
                nhanVien.setLuongChuaTra(String.format("0"));
            }

            ls.add(nhanVien);
        }

        return ls;
    }

}

