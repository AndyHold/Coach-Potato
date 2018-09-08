package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import seng202.team10.Control.DataAnalysis;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

public class DataAnalysisController implements Controllable{

    private GUIController guiController;
    private Activity activity;
    private DataAnalysis dataAnalysis;

    @FXML private Label activityNameLabel;
    @FXML private Label timeTakenLabel;
    @FXML private TabPane tabPane;
    @FXML private LineChart distanceOverTime;
    @FXML private LineChart heartRateOverTime;
    @FXML private LineChart caloriesBurned;
    @FXML private LineChart stressLevelOverTime;
    @FXML private Label noActivitiesLabel;
    @FXML private ListView activityList;

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
                String activityString = activity.getStartDateTime().toString() + ": " + activity.getName();
                activityNames.add(activityString);
            }
            activityList.setItems(activityNames);

            this.displayNoData(false);
            activity = currentProfile.getActivities().get(0); //for now

            activityNameLabel.setText(activity.getName());
            ArrayList<Integer> timeArray = dataAnalysis.getTimeFromActivity(activity);
            DateTime startTime = activity.getStartDateTime();
            Integer timeTaken = activity.getTotalDuration();
            timeTakenLabel.setText("Time Taken: " + dataAnalysis.secondsToTime(timeTaken));

            setUpGraphs();
            XYChart.Series dtSeries = new XYChart.Series();
            ArrayList<Double> distanceArray = dataAnalysis.getDistanceFromActivity(activity);
            double totalDistance = 0;
            for (int i = 0; i < timeArray.size(); i++) {
                totalDistance = totalDistance + distanceArray.get(i);
                dtSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), totalDistance));
            }
            distanceOverTime.getData().add(dtSeries);

            XYChart.Series hrtSeries = new XYChart.Series();
            ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activity);
            for (int i = 0; i < timeArray.size(); i++) {
                hrtSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), heartRateArray.get(i)));
            }
            heartRateOverTime.getData().add(hrtSeries);

            XYChart.Series cbSeries = new XYChart.Series();
            ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activity, currentProfile);
            for (int i = 0; i < timeArray.size(); i++) {
                cbSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), calorieArray.get(i)));
            }
            caloriesBurned.getData().add(cbSeries);

            XYChart.Series sltSeries = new XYChart.Series();
            ArrayList<Double> stressArray = new ArrayList<>();
            for (int i = 0; i < timeArray.size(); i++) {
                double stressPercent = (double)heartRateArray.get(i)/(double)currentProfile.getMaxHeartrate();
                stressArray.add(stressPercent);
                sltSeries.getData().add(new XYChart.Data(dataAnalysis.secondsToTime(timeArray.get(i)), stressArray.get(i)));
            }
            stressLevelOverTime.getData().add(sltSeries);
        }

    }

    private void setUpGraphs() {
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
}
