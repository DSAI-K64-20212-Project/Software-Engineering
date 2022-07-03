package project;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import project.base.DBUtil;
import javax.sql.rowset.*;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HoaDonController implements Initializable {

    @FXML
    private ImageView avaImg;

    @FXML
    private Button billCancelButton1;

    @FXML
    private Button billCancelButton2;

    @FXML
    private Button billCancelButton3;

    @FXML
    private Button billCheckedButton1;

    @FXML
    private Button billCheckedButton2;

    @FXML
    private Button billCheckedButton3;

    @FXML
    private Label billInfoLabel1;

    @FXML
    private Label billInfoLabel2;

    @FXML
    private Label billInfoLabel3;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private VBox vboxLeft;

    @FXML
    void billBtn(ActionEvent event) {

    }

    @FXML
    void infBtn(MouseEvent event) {

    }

    @FXML
    void ingredientBtn(ActionEvent event) {

    }

    @FXML
    void menuBtn(ActionEvent event) {

    }

    @FXML
    void pauseMedia(ActionEvent event) {

    }

    @FXML
    void playMedia(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        billInfoLabel1.setText(null);
        billInfoLabel2.setText(null);
        billInfoLabel3.setText(null);
        String query = "select (tendouong, size, da, duong, soluong) from thanhphanhoadon";
        ResultSet resultSet = null;
        try {
            resultSet = DBUtil.dbExecuteQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String tendouong = null;
            try {
                tendouong = resultSet.getString(1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            billInfoLabel1.setText(null);
            billInfoLabel1.setText(tendouong);
        }
    }
}    //    private void showBillInfo1(ActionEvent event) throws SQLException, ClassNotFoundException {
//        String query = "select (tendouong, size, da, duong, soluong) from thanhphanhoadon";
//        ResultSet resultSet = DBUtil.dbExecuteQuery(query);
//
//        while (resultSet.next()) {
//            String tendouong = resultSet.getString(1);
//            billInfoLabel1.setText(tendouong);
//        }
//    }
//    private void showBillInfo1(ActionEvent event) throws SQLException, ClassNotFoundException {
//        String query = "select (tendouong, size, da, duong, soluong) from thanhphanhoadon";
//        ResultSet resultSet = DBUtil.dbExecuteQuery(query);
//
//        ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));
//
//        //Giving readable names to columns
//        for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++) {
//            TableColumn column = new TableColumn<>();
//            switch (resultSet.getMetaData().getColumnName(i+1)) {
//                case "id":
//                    column.setText("ID #");
//                    break;
//                case "name":
//                    column.setText("Person Name");
//                    break;
//                case "married":
//                    column.setText("Marital Status");
//                    break;
//                default: column.setText(resultSet.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
//                    break;
//            }
//            column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
//            tableView.getColumns().add(column);
//        }
//
//        //Filling up tableView with data
//        tableView.setItems(dbData);
//        public void initialize(URL url, ResourceBundle rb) {
//            data = FXCollections.observableArrayList();
//            try{
//                String sql = "SELECT * FROM FRUITS ";
//                rs = db.query(sql);
//                con = DriverManager.getConnection("jdbc:sqlite:src/customers/fruits.db");
//                stat = con.createStatement();
//                while(rs.next()){
//                    Customers cn = new Customers();
//                    cn.firstName.set(rs.getString("FirstName"));
//                    data.add(cn);
//
//                    System.out.println(rs.getString("FirstName"));
//
//                }
//                firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
//
//                tableView.setItems(data);
//                tableView.getColumns().add(firstName);
//            }
//            catch (Exception e){
//                e.printStackTrace();;
//                System.out.println("error");
//            }
//        }

