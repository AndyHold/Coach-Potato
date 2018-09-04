package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import seng202.team10.Control.DataAnalysis;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;

import java.util.ArrayList;

public class DataAnalysisController implements Controllable{

    private GUIController guiController;
    private Activity activity;
    private DataAnalysis dataAnalysis;

    @FXML
    private Label activityNameLabel;

    @FXML
    private Label timeTakenLabel;

    @FXML
    private TabPane tabPane;

    @FXML
    private LineChart distanceOverTime;

    @FXML
    private LineChart heartRateOverTime;

    @FXML
    private LineChart caloriesBurned;

    @FXML
    private LineChart stressLevelOverTime;

    @Override
    public void setApp(GUIController guiController) {
        this.guiController = guiController;
    }

    @Override
    public void setUpScene() {
        dataAnalysis = new DataAnalysis();
        activityNameLabel.setText(activity.getName());
        ArrayList<DateTime> timeArray = dataAnalysis.getTimeFromActivity(activity);
//        DateTime startTime = activity.getStartDateTime();
//        DateTime endTime = activity.getTotalDuration();
//        startTime.subtract(endTime);
//        timeTakenLabel.setText();

        XYChart.Series dtSeries = new XYChart.Series();
        ArrayList<Double> distanceArray = dataAnalysis.getDistanceFromActivity(activity);
        double totalDistance = 0;
        for (int i = 0; i < timeArray.size(); i++) {
            totalDistance = totalDistance + distanceArray.get(i);
            dtSeries.getData().add(new XYChart.Data(timeArray.get(i).toString(), totalDistance));
        }
        System.out.println(totalDistance);
        System.out.println(distanceArray);
        distanceOverTime.getData().add(dtSeries);

        XYChart.Series hrtSeries = new XYChart.Series();
        ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activity);
        for (int i = 0; i < timeArray.size(); i++) {
            hrtSeries.getData().add(new XYChart.Data(timeArray.get(i).toString(), heartRateArray.get(i)));
        }
        heartRateOverTime.getData().add(hrtSeries);

//        XYChart.Series cbSeries = new XYChart.Series();
//        ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activity);
//        for (int i = 0; i < timeArray.size(); i++) {
//            cbSeries.getData().add(new XYChart.Data(timeArray.get(i).toString(), calorieArray.get(i)));
//        }
//        caloriesBurned.getData().add(cbSeries);

//        XYChart.Series sltSeries = new XYChart.Series();
//        ArrayList<Double> stressArray = dataAnalysis.getStressFromActivity(activity);
//        for (int i = 0; i < timeArray.size(); i++) {
//            sltSeries.getData().add(new XYChart.Data(timeArray.get(i).toString(), stressArray.get(i)));
//        }
//        stressLevelOverTime.getData().add(sltSeries);

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
