package pl.rogol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bulls & Cows");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("http://4.bp.blogspot.com/-aEyKD1Xib4Q/TVdllZNNlDI/AAAAAAAAL30/9pAbWqdacVI/s1600/fat%2Bcow.jpg"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
