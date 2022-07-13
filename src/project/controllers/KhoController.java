package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.base.DBUtil;
import project.model.ImageMain;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

public class KhoController {
    private BaseController baseController;

    public void setBaseController(BaseController baseController) {
        this.baseController = baseController;
    }

    @FXML
    private GridPane imageGrid;
    private List<ImageMain> images;

    @FXML
    public void initialize(){
        try {
            images = new ArrayList<>(images());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        int columns = 0;
        int rows = 1;

        try {
            for (int i = 0; i < images.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/project/screen/thumb.fxml"));
                VBox box = fxmlLoader.load();
                ThumbController thumbController = fxmlLoader.getController();
                thumbController.setData(images.get(i));

                if (columns == 3) {
                    columns = 0;
                    ++ rows;
                }

                imageGrid.add(box, columns++, rows);
                GridPane.setMargin(box, new Insets(5));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<ImageMain> images() throws SQLException, ClassNotFoundException {
        List<ImageMain> ls = new ArrayList<>();

        ImageMain image;
        // Số lượng nguyên liệu trong db
        String countQuery = String.format(("select COUNT(*) as cnt from nguyenlieu"));
        ResultSet rs = DBUtil.dbExecuteQuery(countQuery);
        rs.next();
        int count = rs.getInt("cnt");

        // Các nguyên liệu trong db
        String query = String.format("select * from nguyenlieu");
        ResultSet resultSet = DBUtil.dbExecuteQuery(query);
        for(int i=0; i<count; i++) {
            resultSet.next();
            String tennguyenlieu = resultSet.getString("tennguyenlieu");
            String trangthai = resultSet.getString("trangthai");
            String anh = resultSet.getString("anh");

            image = new ImageMain();
            image.setThumbSrc(String.format("/project/resources/image/NguyenLieu/%s", anh));
            image.setName(tennguyenlieu);
            image.setTrangThai(trangthai);

            System.out.println(image.getName());
            System.out.println(image.getTrangThai());
            System.out.println(image.getThumbSrc());

            ls.add(image);
        }
        return ls;
    }

    @FXML
    void taoNguyenLieuOnPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/project/screen/ThemNguyenLieu.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
    }
}


//    @FXML
//    private GridPane imageGrid;
//    private List<ImageMain> images;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resourceBundle) {
//
//        int columns = 0;
//        int rows = 1;
//
//        try {
//            // Số lượng nguyên liệu trong db
//            String countQuery = String.format(("select COUNT(*) as cnt from nguyenlieu"));
//            ResultSet rs = DBUtil.dbExecuteQuery(countQuery);
//            rs.next();
//            int count = rs.getInt("cnt");
//
//            // Các nguyên liệu trong db
//            String query = String.format("select * from nguyenlieu");
//            ResultSet resultSet = DBUtil.dbExecuteQuery(query);
//
//            for(int i=0; i<count; i++) {
//                resultSet.next();
//                String tennguyenlieu = resultSet.getString("tennguyenlieu");
//                String trangthai = resultSet.getString("trangthai");
//                String anh = resultSet.getString("anh");
//
//                ImageMain image = new ImageMain(String.format("/project/resources/image/%s", anh));
//                image.setName(tennguyenlieu);
//                image.setTrangThai(trangthai);
//                image.setThumbSrc(String.format("/project/resources/image/%s", anh));
//                System.out.println(image);
//
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("/project/thumb.fxml"));
//                VBox box = fxmlLoader.load();
//
//                System.out.println(fxmlLoader);
//                ThumbController thumbController = fxmlLoader.getController();
//                System.out.println(thumbController);
//                System.out.println(image.getName());
//                System.out.println(image.getTrangThai());
//                System.out.println(image.getThumbSrc());
//
////                thumbController.setData(image);
//
//                if (columns == 3) {
//                    columns = 0;
//                    ++ rows;
//                }
//
//                imageGrid.add(box,columns++,rows);
//                GridPane.setMargin(box, new Insets(6));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        images = new ArrayList<>(images());
////        try {
////            for(int i=0; i<images.size(); i++) {
////                FXMLLoader fxmlLoader = new FXMLLoader();
////                fxmlLoader.setLocation(getClass().getResource("/project/thumb.fxml"));
////                VBox box = fxmlLoader.load();
////                ThumbController thumbController = fxmlLoader.getController();
////                thumbController.setData(images.get(i));
////
////                if (columns == 3) {
////                    columns = 0;
////                    ++ rows;
////                }
////
////                imageGrid.add(box,columns++,rows);
////                GridPane.setMargin(box, new Insets(10));
////
////                }
////            } catch (IOException e) {
////                throw new RuntimeException(e);
////        }
//    }
//
////    private List<ImageMain> images(){
////        List<ImageMain> ls = new ArrayList<>();
////
////        for (int k = 0; k < 100; k++) {
////            ImageMain image = new ImageMain("/project/resources/image/Topping/caramen.png");
////            image.setName("TEST");
////            image.setTrangThai("Con Hang");
////
////            ls.add(image);
////        }
////        return ls;
////    }
//
//    @FXML
//    void taoNguyenLieuOnPressed(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/project/ThemNguyenLieu.fxml"));
//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        window.setScene(new Scene(root));
//    }
//}
