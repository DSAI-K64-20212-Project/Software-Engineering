package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.base.user.Admin;
import project.base.user.Bartender;
import project.base.user.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static project.LogIn.monitor;

public class ThemNguyenLieuController {

    private Stage stage;

    @FXML
    private Button imageBtn;

    @FXML
    private Text uploadTxt;

    @FXML
    private TextField tenNguyenLieu;

    @FXML
    private TextField nhaCungCap;

    @FXML
    private ToggleGroup status;

    private List imgList;

    @FXML
    void uploadImageBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ThemNguyenLieu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        final FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Image files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("Image files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("Image files (*.jpeg)","*jpeg");
        fileChooser.getExtensionFilters().addAll(extFilter, extFilter1, extFilter2, extFilter3);
        fileChooser.setTitle("Select Some Files");

        // Set thư mục bắt đầu khi mở FileChooser
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File file = fileChooser.showOpenDialog(stage);
        System.out.println(file);


        // Set image sau khi upload ảnh
        Image img = new Image(String.valueOf(file));
        ImageView view = new ImageView(img);
        view.setFitHeight(200);
        view.setFitWidth(200);
        // Hide text
        uploadTxt.setVisible(false);
        imageBtn.setGraphic(view);

        System.out.println(imageBtn.getText());

    }

    @FXML
    void addNewBtn(ActionEvent event) throws SQLException, ClassNotFoundException {

        User user = monitor.getActiveUser();
        if (user instanceof Bartender) {
            Bartender user2 = (Bartender) user;
            user2.add_ingredient(monitor.getActiveUser().getUsername(), tenNguyenLieu.getText(), nhaCungCap.getText(), String.valueOf(status.getSelectedToggle()), "TEST");
        }
        else if (user instanceof Admin){
            Admin user2 = (Admin) user;
            user2.add_ingredient(monitor.getActiveUser().getUsername(), tenNguyenLieu.getText(), nhaCungCap.getText(), String.valueOf(status.getSelectedToggle()), "TEST");
        }


//        String command = String.format("INSERT INTO nguyenlieu (tennguyenlieu, nhacungcap, trangthai, anh) VALUES ('%s', '%s', '%s', '%s')",
//                );
        // Notification
        JOptionPane.showMessageDialog(null, "Topping đã được thêm thành công", "Notification", 1);
    }
}
