package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;


public class ClientFormController {

    @FXML private TextField firstNameField;
    @FXML private TextField middleField;
    @FXML private TextField lastNameField;
    @FXML private DatePicker dobPicker;
    @FXML private TextField ssnField;
    @FXML private TextField genderField;
    @FXML private ComboBox<String> educationCombo;
    

    

    @FXML private VBox incarcerationBox;
    @FXML private VBox coursesBox;
    

    @FXML private void initialize() {
        educationCombo.getItems().addAll(
            "Did Not Graduate",
            "GED",
            "High School Graduate",
            "Some College",
            "College Degree"
        );
    }

    @FXML
    private void handleViewClients(javafx.event.ActionEvent event) {
    	HeaderController.pushScene("ClientView.fxml");
    }

    @FXML
    private void handlePreAssessment() {
        // TODO: Transition to pre-assessment view
    }

    @FXML
    private void handleSubmit() {
        // TODO: Package and send form data to the API
    }

    @FXML
    private void addIncarcerationPeriod() {
        HBox newRow = new HBox(10);

        DatePicker start = new DatePicker();
        DatePicker end = new DatePicker();
        Button addButton = new Button("+");
        addButton.setOnAction(e -> addIncarcerationPeriod()); // recursion to keep adding more

        newRow.getChildren().addAll(start, end, addButton);
        incarcerationBox.getChildren().add(newRow);
    }
    
    @FXML
    private void addCourse() {
        HBox newRow = new HBox(10);

        TextField courseName = new TextField();
        courseName.setPromptText("Course Name");

        DatePicker courseDate = new DatePicker();

        Button addButton = new Button("+");
        addButton.setOnAction(e -> addCourse());

        newRow.getChildren().addAll(courseName, courseDate, addButton);
        coursesBox.getChildren().add(newRow);
    }
}
