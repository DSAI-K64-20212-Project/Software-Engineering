/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.base.user.User;

import javax.swing.*;
import static project.LogIn.monitor;


/**
 * FXML Controller class
 *
 * @author Mr Pham Truong
 */
public class LogInController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    public void loginPressedBtn(ActionEvent e) throws SQLException, ClassNotFoundException, IOException {
        String command = String.format("SELECT tendangnhap FROM nhanvien WHERE tendangnhap = '%s' AND matkhau = '%s';",
                username.getText(), password.getText());
        ResultSet result = DBUtil.dbExecuteQuery(command);
        if (!result.next()) {
            JOptionPane.showMessageDialog(null, "Wrong username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println(result.getString(1));
            monitor.newSession(new User(result.getString(1)));

            //move to dashboard
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/project/FXML.fxml")));
            Stage window = (Stage) username.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }
}