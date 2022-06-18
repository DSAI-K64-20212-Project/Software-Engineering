package project;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Mr Pham Truong
 */
public class Base extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/project/Base.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
//        stage.setTitle("Hust Milk Tea ♥");
//        stage.getIcons().add(new Image("/project/resources/Logo/programIcon.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}