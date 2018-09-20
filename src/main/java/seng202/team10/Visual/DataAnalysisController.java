package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.DataAnalysis;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.UserProfile;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DataAnalysisController implements Controllable, Initializable{

    private GUIController guiController;
    private Activity activity;
    private DataAnalysis dataAnalysis;
    private int currentIndex;

    @FXML private Label activityNameLabel;
    @FXML private Label timeTakenLabel;
    @FXML private TabPane tabPane;
    @FXML private LineChart distanceOverTime;
    @FXML private LineChart heartRateOverTime;
    @FXML private LineChart caloriesBurned;
    @FXML private LineChart stressLevelOverTime;
    @FXML private Label noActivitiesLabel;
    @FXML private ListView activityList;
    @FXML private VBox drawer;

    private XYChart.Series distanceTimeSeries;
    private XYChart.Series heartRateSeries;
    private XYChart.Series caloriesBurnedSeries;
    private XYChart.Series stressLevelTimeSeries;


    @Override
    public void setApp(GUIController guiController) {
        this.guiController = guiController;
    }

    @Override
    public void setUpScene() {

        dataAnalysis = new DataAnalysis();
        UserProfile currentProfile = guiController.getCurrentProfile();
        if (currentProfile.getActivities().isEmpty()) {
            this.displayNoData(true);
        } else {
            ObservableList<String> activityNames = FXCollections.observableArrayList();
            for (Activity activity : currentProfile.getActivities()) {
                String activityString = activity.getStartDateTime().toString() + " : " + activity.getName();
                activityNames.add(activityString);
            }
            activityList.setItems(activityNames);
            if (activityList.getSelectionModel().getSelectedIndex() == -1) {
                activityList.getSelectionModel().selectFirst();
                currentIndex = 0;
            }
            currentIndex = activityList.getSelectionModel().getSelectedIndex();
                    activity = currentProfile.getActivities().get(currentIndex);


            this.displayNoData(false);

            distanceTimeSeries = new XYChart.Series();
            heartRateSeries = new XYChart.Series();
            caloriesBurnedSeries = new XYChart.Series();
            stressLevelTimeSeries = new XYChart.Series();

            distanceOverTime.getData().clear();
            heartRateOverTime.getData().clear();
            caloriesBurned.getData().clear();
            stressLevelOverTime.getData().clear();

            ArrayList<Integer> timeArray = dataAnalysis.getTimeFromActivity(activity);
            activityNameLabel.setText(activity.getName());
            DateTime startTime = activity.getStartDateTime();
            Integer timeTaken = activity.getTotalDuration();
            timeTakenLabel.setText("Time Taken: " + dataAnalysis.secondsToTime(timeTaken));

            ArrayList<Double> distanceArray = dataAnalysis.getDistanceFromActivity(activity);
            for (int i = 0; i < timeArray.size(); i++) {
                distanceTimeSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), distanceArray.get(i)));
            }
            distanceOverTime.getData().add(distanceTimeSeries);

            ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activity);
            for (int i = 0; i < timeArray.size(); i++) {
                heartRateSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), heartRateArray.get(i)));
            }
            heartRateOverTime.getData().add(heartRateSeries);

            ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activity, currentProfile);
            for (int i = 0; i < timeArray.size(); i++) {
                caloriesBurnedSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), calorieArray.get(i)));
            }
            caloriesBurned.getData().add(caloriesBurnedSeries);

            ArrayList<Double> stressArray = new ArrayList<>();
            for (int i = 0; i < timeArray.size(); i++) {
                double stressPercent = (double)heartRateArray.get(i)/(double)currentProfile.getMaxHeartrate();
                stressArray.add(stressPercent);
                stressLevelTimeSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), stressArray.get(i)));
            }
            stressLevelOverTime.getData().add(stressLevelTimeSeries);
        }
    }

    @FXML
    private void refresh() {
        if (activityList.getSelectionModel().getSelectedIndex() != currentIndex) {
            setUpScene();
        }
    }

    private void setUpGraphs() {
        distanceTimeSeries = new XYChart.Series();
        heartRateSeries = new XYChart.Series();
        caloriesBurnedSeries = new XYChart.Series();
        stressLevelTimeSeries = new XYChart.Series();

        setUpOneGraph(distanceOverTime);
        setUpOneGraph(heartRateOverTime);
        setUpOneGraph(caloriesBurned);
        setUpOneGraph(stressLevelOverTime);

        distanceOverTime.getYAxis().setLabel("Distance (m)");
        heartRateOverTime.getYAxis().setLabel("Heart rate (bpm)");
        caloriesBurned.getYAxis().setLabel("Calories burned");
        stressLevelOverTime.getYAxis().setLabel("Stress level");
    }

    private void setUpOneGraph(LineChart linechart) {
        linechart.getXAxis().setLabel("Time");
//        NumberAxis xAxis = (NumberAxis)linechart.getXAxis();
//        xAxis.setLowerBound();
        linechart.setCreateSymbols(false);
    }

    private void displayNoData(boolean noDataFound) {
        if (noDataFound) {
            tabPane.setVisible(false);
            activityNameLabel.setVisible(false);
            timeTakenLabel.setVisible(false);
            noActivitiesLabel.setVisible(true);
        } else {
            tabPane.setVisible(true);
            activityNameLabel.setVisible(true);
            timeTakenLabel.setVisible(true);
            noActivitiesLabel.setVisible(false);
        }
    }


    public void setActivity(Activity activity) {
        this.activity = activity;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 93aee887... Added a view map button to the controller
=======
    @FXML public void viewMap() {
        if (!(activity == null)) {
            guiController.launchMapScene(activity);
        } else {
            createPopUp(Alert.AlertType.ERROR, "Error", "Please select an activity.");
        }

    }

    private void createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        errorPopUp.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
    }

<<<<<<< HEAD
>>>>>>> 845b91d6... Added a view map button to the controller
=======
>>>>>>> b13266a... Added a view map button to the controller
>>>>>>> 93aee887... Added a view map button to the controller
    @FXML private void drawerAction() {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        if (drawer.getTranslateX() != 0) {
            openNav.play();
        } else {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
        }
    }

    @FXML public void openChooseProfile() throws Exception {
        moveDrawer();
        guiController.launchLoginScene();
    }

    @FXML public void openViewProfile()
    {
        moveDrawer();
        guiController.launchProfileScene();
    }

    @FXML public void openUploadData()
    {
        moveDrawer();
        guiController.launchUploadDataScene();
    }

    @FXML public void openViewActivities() throws Exception {
        moveDrawer();
        guiController.launchActivityViewerScene();
    }

    @FXML public void openGoals()
    {
        moveDrawer();
        guiController.launchGoalsScene();
    }

    @FXML public void openAnalysis() throws Exception {
        moveDrawer();
        guiController.launchDataAnalysisScene();
    }

    private void moveDrawer() {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
=======
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
>>>>>>> 677c7c0b... Can now view graphs from different activities. Formatting is bad however.
    }
}
