package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;

import java.awt.*;
import java.time.YearMonth;

public class ProfileController {

    private GUIController app;

    @FXML Pane calendarPane;
    @FXML private javafx.scene.control.Label welcomeProfileLabel;
    @FXML private javafx.scene.control.Label qoutesLabel;
    @FXML private javafx.scene.control.Label weightValueLabel;
    @FXML private javafx.scene.control.Label heightValueLabel;
    @FXML private javafx.scene.control.Label bmiValueLabel;

    public void setApp(GUIController app){
        this.app = app;
    }

    public void setUpScene() {
        calendarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
        UserProfile currentUser = app.getCurrentProfile();
        //welcomeProfileLabel.setText("Welcome " + currentUser.getName() + ", Let's do it!");
        //weightValueLabel.setText(String.valueOf(currentUser.getWeight()));
        //heightValueLabel.setText(String.valueOf(currentUser.getHeight()));
        //bmiValueLabel.setText(String.valueOf(currentUser.getBmi()));
    }
}
