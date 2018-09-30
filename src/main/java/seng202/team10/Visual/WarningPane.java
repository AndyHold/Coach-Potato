package seng202.team10.Visual;


import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Model.ActivitiesData.HealthWarning;

public class WarningPane {


    private HealthWarning healthWarning;
    private VBox container;
    private Button clearButton;
    private HealthWarningsController healthWarningsController;
    private VBox mainVBox;


    public WarningPane(HealthWarning healthWarning, HealthWarningsController healthWarningsController, VBox mainVBox)
    {
        this.healthWarning = healthWarning;
        this.healthWarningsController = healthWarningsController;
        this.mainVBox = mainVBox;
        this.container = new VBox();
        setStyle();
        fillContainer();
        extendVBox(mainVBox, 115);
        mainVBox.getChildren().add(container);
    }


    private void extendVBox(VBox mainVBox, int amount)
    {
        double currentHeight = mainVBox.getHeight();
        mainVBox.setMaxHeight(currentHeight + amount);
        mainVBox.setMinHeight(currentHeight + amount);
    }


    private void fillContainer()
    {
        HBox activityHBox = new HBox();
        Label activityLabel = new Label("Activity:");
        activityLabel.setStyle("-fx-min-width: 75;\n" +
                               "-fx-max-width: 75;");
        activityHBox.getChildren().add(activityLabel);
        Label activity = new Label(healthWarning.getActivityName());
        activity.setStyle("-fx-min-width: 295;\n" +
                          "-fx-max-width: 295;");
        activityHBox.getChildren().add(activity);
        container.getChildren().add(activityHBox);
        HBox timeHBox = new HBox();
        Label timeLabel = new Label("Time:");
        timeLabel.setStyle("-fx-min-width: 75;\n" +
                           "-fx-max-width: 75;");
        timeHBox.getChildren().add(timeLabel);
        Label time = new Label(healthWarning.getActivityDate().toString());
        time.setStyle("-fx-min-width: 295;\n" +
                      "-fx-max-width: 295;");
        timeHBox.getChildren().add(time);
        container.getChildren().add(timeHBox);
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        this.clearButton = new Button("Clear Warning");
        buttonBox.getChildren().add(clearButton);
        container.getChildren().add(buttonBox);
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TranslateTransition clear = new TranslateTransition(new Duration(350), container);
                clear.setToX(container.getLayoutX() - 380);
                clear.play();
//                for (int i = 0; i < mainVBox.getChildren().size(); i++) {
//                    TranslateTransition raise = new TranslateTransition(new Duration(350), mainVBox.getChildren().get(i));
//                    raise.setToY(mainVBox.getChildren().get(i).getLayoutY() - 115);
//                    raise.play();
//                }
                mainVBox.getChildren().remove(container);
                extendVBox(mainVBox, -115);
                healthWarningsController.removeWarning(healthWarning);
            }
        });
    }


    public HealthWarning getHealthWarning()
    {
        return healthWarning;
    }

    private void setStyle()
    {
        String css = this.getClass().getResource("/css/warningPane.css").toExternalForm();
        container.getStylesheets().add(css);
        container.setPadding(new Insets(5, 5, 5, 5));
    }
}