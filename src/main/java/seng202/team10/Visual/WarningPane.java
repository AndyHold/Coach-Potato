package seng202.team10.Visual;


import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Model.ActivitiesData.HealthWarning;

public class WarningPane {


    private HealthWarning healthWarning;
    private VBox container;
    private Button clearButton;
    private HealthWarningsController healthWarningsController;
    private Pane mainPane;


    public WarningPane(HealthWarning healthWarning, HealthWarningsController healthWarningsController, Pane mainPane)
    {
        this.healthWarning = healthWarning;
        this.healthWarningsController = healthWarningsController;
        this.mainPane = mainPane;
        this.container = new VBox();
        setStyle();
        fillContainer();
        container.setLayoutY(mainPane.getChildren().size() * 115);
        this.mainPane.getChildren().add(container);
        resizePane(this.mainPane);
    }


    /**
     * Method to extend the Pane to fit the new container
     * @param mainPane the <b>Pane</b> to be resized
     */
    private void resizePane(Pane mainPane)
    {
        double newHeight = mainPane.getChildren().size() * 115;
        mainPane.setStyle("-fx-min-height: " + newHeight + "; " +
                          "-fx-max-height: " + newHeight + ";");
        mainPane.getParent().setStyle("-fx-min-height: " + newHeight + "; " +
                                      "-fx-max-height: " + newHeight + ";");
    }


    /**
     * Fills the warning pane with the elements assosciated with the health warning.
     */
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
        setButtonAction();
    }


    /**
     * Setter method for the Action Listener assosciated with the clear button
     */
    private void setButtonAction()
    {
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearWarning();
                System.out.println(mainPane.getChildren().size());
                if (mainPane.getChildren().size() == 1) {
                    healthWarningsController.hideWarningsScrollPane();
                }
            }
        });
    }


    /**
     * Method to clear this warning from the warnings scroll pane.
     * Called when the clear all button is pushed together with all the other warnings of this type.
     */
    public void clearWarningSolo()
    {
        healthWarningsController.removeWarning(healthWarning);
        mainPane.getChildren().remove(container);
    }


    /**
     * Method to clear this warning from the warnings scroll pane.
     * Called when the clear warning button or the clear all button is selected
     */
    public void clearWarning()
    {
        int i = 0;
        while (i < mainPane.getChildren().size() && mainPane.getChildren().get(i) != container) {
            i++;
        }
        TranslateTransition clear = new TranslateTransition(new Duration(350), container);
        clear.setToX(-380);
        clear.play();
        clear.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainPane.getChildren().remove(container);
                resizePane(mainPane);
            }
        });
        i++;
        while (i < mainPane.getChildren().size()) {
            TranslateTransition raise = new TranslateTransition(new Duration(350), mainPane.getChildren().get(i));
            raise.setToY(mainPane.getChildren().get(i).getTranslateY() - 115);
            raise.play();
            i++;
        }
        healthWarningsController.removeWarning(healthWarning);
    }


    /**
     * Setter method for the style sheet assosciated with this pane.
     */
    private void setStyle()
    {
        String css = this.getClass().getResource("/css/warningPane.css").toExternalForm();
        container.getStylesheets().add(css);
        container.setPadding(new Insets(5, 5, 5, 5));
    }
}