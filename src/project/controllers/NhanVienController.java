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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.UI.NhanVien;

import java.io.IOException;

public class NhanVienController {
    @FXML
    private Button chinhSuaNhanVien;

    @FXML
    private Text luongChuaTra;

    @FXML
    private Button traLuong;

    @FXML
    private Circle anhNhanVien;

    @FXML
    private Text caLam;

    @FXML
    private Text thongTin;

    @FXML
    void traLuongBtn(ActionEvent event) {
        luongChuaTra.setText("0");
    }

    @FXML
    void chinhSuaNhanVienBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/project/screen/ChinhSuaNhanVien.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));

        ChinhSuaNhanVienController chinhSuaNhanVienController = fxmlLoader.getController();
        int nIndex = thongTin.getText().indexOf("\n");
        chinhSuaNhanVienController.getHoVaTen().setText(thongTin.getText().substring(0,nIndex));
        chinhSuaNhanVienController.getSoDienThoai().setText(thongTin.getText().substring(nIndex+1,nIndex+11));
        switch (caLam.getText().substring(0,caLam.getText().indexOf("\n"))){
            case ("Pha Che"):
                chinhSuaNhanVienController.getChucVu().selectToggle(chinhSuaNhanVienController.getPhaCheBtn());
            case ("Thu Ngan"):
                chinhSuaNhanVienController.getChucVu().selectToggle(chinhSuaNhanVienController.getThuNganBtn());
            case ("Quan Ly"):
                chinhSuaNhanVienController.getChucVu().selectToggle(chinhSuaNhanVienController.getQuanLyBtn());
        }
        if (caLam.getText().substring(caLam.getText().indexOf("\n")) == "Sang"){
            chinhSuaNhanVienController.getCaLam().selectToggle(chinhSuaNhanVienController.getSangBtn());
        }else{
            chinhSuaNhanVienController.getCaLam().selectToggle(chinhSuaNhanVienController.getChieuBtn());
        }
        chinhSuaNhanVienController.getUsername().setText(thongTin.getText().substring(nIndex+12));
    }

    public void setData(NhanVien nhanVien){
        anhNhanVien.setStroke(Color.SEAGREEN);
        Image im = new Image(nhanVien.getAnhNhanVienSrc());
        anhNhanVien.setFill(new ImagePattern(im));
        anhNhanVien.setEffect(new DropShadow(+25d,0d,+2d,Color.DARKSEAGREEN));

        luongChuaTra.setText(nhanVien.getLuongChuaTra());
        caLam.setText(nhanVien.getCaLam());
        thongTin.setText(nhanVien.getThongTin());
    }
}
