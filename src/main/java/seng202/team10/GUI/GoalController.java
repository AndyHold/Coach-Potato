package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import seng202.team10.Control.GUIController;

public class GoalController {

    private GUIController app;

    @FXML
    private ComboBox goalTypeCombo;

    @FXML
    private ComboBox currentGoalsCombo;




    public void setApp(GUIController app){
        this.app = app;
    }


    public void setUpScene() {

        ObservableList<String> currentGoals = FXCollections.observableArrayList(); //TODO write getter method in GUI controller to access the user's current goals
        currentGoalsCombo.setItems(currentGoals);
        currentGoalsCombo.setVisibleRowCount(5);

        ObservableList<String> goalTypes = FXCollections.observableArrayList("Weight", "Distance", "Frequency", "BMI", "Time");
        goalTypeCombo.setItems(goalTypes);
        goalTypeCombo.setVisibleRowCount(5);

    }
}
