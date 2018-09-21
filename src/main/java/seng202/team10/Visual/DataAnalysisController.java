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


    private XYChart.Series distanceTimeSeries;
    private XYChart.Series heartRateSeries;
    private XYChart.Series caloriesBurnedSeries;
    private XYChart.Series stressLevelTimeSeries;


    private XYChart.Series distanceTimeSeries;
    private XYChart.Series heartRateSeries;
    private XYChart.Series caloriesBurnedSeries;
    private XYChart.Series stressLevelTimeSeries;


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

            ArrayList<Double> timeArray = dataAnalysis.getMinutesFromActivity(activity);
            activityNameLabel.setText(activity.getName());
            DateTime startTime = activity.getStartDateTime();
            Integer timeTaken = activity.getTotalDuration();
            timeTakenLabel.setText("Time Taken: " + dataAnalysis.secondsToTime(timeTaken));
//            System.out.println(timeArray);

            ArrayList<Double> distanceArray = dataAnalysis.getDistanceFromActivity(activity);
            for (int i = 0; i < timeArray.size(); i++) {
                distanceTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), distanceArray.get(i)));
            }
            distanceOverTime.getData().add(distanceTimeSeries);

            ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activity);
            for (int i = 0; i < timeArray.size(); i++) {
                heartRateSeries.getData().add(new XYChart.Data(timeArray.get(i), heartRateArray.get(i)));
            }
            heartRateOverTime.getData().add(heartRateSeries);

            ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activity, currentProfile);
            for (int i = 0; i < timeArray.size(); i++) {
                caloriesBurnedSeries.getData().add(new XYChart.Data(timeArray.get(i), calorieArray.get(i)));
            }
            caloriesBurned.getData().add(caloriesBurnedSeries);

            ArrayList<Double> stressArray = new ArrayList<>();
            for (int i = 0; i < timeArray.size(); i++) {
                double stressPercent = (double)heartRateArray.get(i)/(double)currentProfile.getMaxHeartRate();
                stressArray.add(stressPercent);
                stressLevelTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), stressArray.get(i)));
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
        linechart.getXAxis().setLabel("Time (minutes)");
//        linechart.getXAxis().setAnimated(false);
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @FXML public void viewMap() {
        if (!(activity == null)) {
            guiController.launchMapScene(activity);
        } else {
            this.guiController.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an activity.");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
    }

<<<<<<< HEAD
>>>>>>> b13266a... Added a view map button to the controller
    @FXML private void drawerAction() {
=======
    /**
     * Method to draw the navigation drawer.
     */
    @FXML private void drawerAction()
    {
>>>>>>> 8a6e898... Wrote JavaDoc for the menu button and bar on most of the main controllers and also for few methods that were pending.

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
    /**
     * Method to launch the login scene.
     */
    @FXML public void openChooseProfile() throws Exception
    {
        moveDrawer();
        guiController.launchLoginScene();
    }

    /**
     * Method to launch the view profile scene.
     */
    @FXML public void openViewProfile() throws Exception
    {
        moveDrawer();
        guiController.launchProfileScene();
    }

    /**
     * Method to launch the upload data scene.
     */
    @FXML public void openUploadData() throws Exception
    {
        moveDrawer();
        guiController.launchUploadDataScene();
    }

    /**
     * Method to launch the view activities scene.
     */
    @FXML public void openViewActivities() throws Exception
    {
        moveDrawer();
        guiController.launchActivityViewerScene();
    }

    /**
     * Method to launch the goals scene.
     */
    @FXML public void openGoals() throws Exception
    {
        moveDrawer();
        guiController.launchGoalsScene();
    }

    /**
     * Method to launch the data analysis scene.
     */
    @FXML public void openAnalysis() throws Exception
    {
        moveDrawer();
        guiController.launchDataAnalysisScene();
    }

    /**
     * Method to move the navigation drawer as appropriate.
     */
    private void moveDrawer()
    {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
=======
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
>>>>>>> 6525b75... Can now view graphs from different activities. Formatting is bad however.
=======
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
>>>>>>> 6d3b4aa... Can now view graphs from different activities. Formatting is bad however.
=======
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
>>>>>>> fe7703d... Can now view graphs from different activities. Formatting is bad however.
=======
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpGraphs();
>>>>>>> 677c7c0... Can now view graphs from different activities. Formatting is bad however.
    }
}
