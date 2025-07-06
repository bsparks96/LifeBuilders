package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CourseManagementController {

    @FXML private ListView<String> courseListView;
    @FXML private StackPane detailsPane;
    @FXML private Button newCourseButton;
    @FXML private TextField courseNameField;
    @FXML private TextField instructorField;
    @FXML private TextField courseLengthField;

    @FXML private VBox courseDetailPane;
    @FXML private VBox iterationsBox;
    @FXML private DatePicker iterationStartPicker;
    @FXML private DatePicker iterationEndPicker;


    @FXML
    public void initialize() {
        // TODO: Fetch courses from backend and populate courseListView
        // courseListView.getItems().addAll(courseService.fetchAllCourses());

        courseListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                showCourseDetails(newVal);
            }
        });
        
        iterationStartPicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (iterationEndPicker.getValue() == null && newDate != null) {
                String weeksStr = courseLengthField.getText();
                try {
                    int weeks = Integer.parseInt(weeksStr);
                    iterationEndPicker.setValue(newDate.plusWeeks(weeks));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid course length format.");
                }
            }
        });
    }

    @FXML
    private void sortAlphabetically() {
        // TODO: Sort the list alphabetically
    }

    @FXML
    private void sortMostRecent() {
        // TODO: Sort the list by recent dates
    }

    @FXML
    private void handleNewCourse() {
        detailsPane.getChildren().clear();
        VBox form = new VBox(10);
        form.getChildren().addAll(
            new Label("Course Name:"),
            new TextField(),
            new Label("Instructors:"),
            new TextField(),
            new Button("Save")
        );
        detailsPane.getChildren().add(form);
    }
    
    @FXML
    private void handleAddIteration(ActionEvent event) {
        HBox iterationRow = new HBox(10);

        DatePicker newStartPicker = new DatePicker();
        newStartPicker.setPromptText("Start Date");
        newStartPicker.setMaxWidth(150);

        DatePicker newEndPicker = new DatePicker();
        newEndPicker.setPromptText("End Date");
        newEndPicker.setMaxWidth(150);

        // Listener: auto-set end date based on course length if empty
        newStartPicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newEndPicker.getValue() == null && newDate != null) {
                try {
                    int weeks = Integer.parseInt(courseLengthField.getText());
                    newEndPicker.setValue(newDate.plusWeeks(weeks));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid course length format.");
                }
            }
        });

        Button removeBtn = new Button("Remove");
        removeBtn.setOnAction(e -> iterationsBox.getChildren().remove(iterationRow));

        iterationRow.getChildren().addAll(newStartPicker, newEndPicker, removeBtn);
        iterationsBox.getChildren().add(iterationRow);
    }
    
    @FXML
    private void handleSaveCourse(ActionEvent event) {
    	
    	System.out.println("Saving Course...");
    }
    
    
    @FXML
    private void handleNewCourseClick(ActionEvent event) {
        // Toggle visibility of form or clear fields as needed
        courseNameField.clear();
        instructorField.clear();
        courseLengthField.clear();
        iterationStartPicker.setValue(null);
        iterationEndPicker.setValue(null);
        courseDetailPane.setVisible(true);
        courseDetailPane.setManaged(true);
    }
    
    

    private void showCourseDetails(String courseName) {
        detailsPane.getChildren().clear();

        // TODO: Fetch course details from backend
        VBox detailBox = new VBox(10);
        detailBox.getChildren().addAll(
            new Text(courseName + ":"),
            new Label("Instructors: (populate list)"),
            new Label("Current Iterations: (populate list)"),
            new Label("Past Iterations: (clickable items to view clients)")
        );
        detailsPane.getChildren().add(detailBox);
    }
}