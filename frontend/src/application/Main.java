package application;

import controllers.HeaderController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    	HeaderController.setMainStage(primaryStage);
    	Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        primaryStage.setTitle("Life Builders");
        primaryStage.setScene(new Scene(root, 850, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
