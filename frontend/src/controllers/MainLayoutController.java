package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Node;

public class MainLayoutController {

    @FXML
    private StackPane contentArea;

    
    @FXML
    private HeaderController headerControllerInstance;
    @FXML
    private HBox headerController;

  
    
    public HeaderController getHeaderController() {
    	return headerControllerInstance;
    }
    
    
    @FXML
    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Header.fxml"));
            HBox header = loader.load();
            headerControllerInstance = loader.getController();
            this.headerController.getChildren().setAll(header.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setContent(Node content) {
        contentArea.getChildren().setAll(content);

        // Try updating header navigation buttons
        // Use lookup to find the controller manually
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Header.fxml"));
        try {
            loader.load();
            HeaderController controller = loader.getController();
            //controller.updateNavigationButtons();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}