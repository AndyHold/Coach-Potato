package seng202.team10.Visual;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import seng202.team10.Model.ActivitiesData.DataAnalysis;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * GraphsController Class for Coach Potato
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class GraphsController implements Controllable, Initializable{

    private MainController mainController ;
    private Activity activity;
    private DataAnalysis dataAnalysis;
    private int currentIndex;

    @FXML private Label activityNameLabel;
    @FXML private TabPane tabPane;
    @FXML private LineChart distanceOverTime;
    @FXML private LineChart heartRateOverTime;
    @FXML private LineChart caloriesBurned;
    @FXML private LineChart stressLevelOverTime;
    @FXML private LineChart speedOverTime;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Button backButton;

    private XYChart.Series distanceTimeSeries;
    private XYChart.Series heartRateSeries;
    private XYChart.Series caloriesBurnedSeries;
    private XYChart.Series stressLevelTimeSeries;
    private XYChart.Series speedTimeSeries;


    /**
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    @Override
    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }

    /**
     *Method to set up the scene. This is run whenever a new activity is selected or this scene is loaded.
     * This method calls methods to initialize the graphs and populate them with data. It also initializes the
     * ListView that contains a list of activities.
     */
    @Override
    public void setUpScene()
    {
        // Set Button tool tips
        setUpToolTips();
        // Set help text
        setUpHelpTextArea();
        // Create a new data analysis
        dataAnalysis = new DataAnalysis();
        // Check for activities in the profile
        this.initializeSeries();
        this.clearGraphs();
        // Get arrays
        ArrayList<Double> timeArray = dataAnalysis.getMinutesFromActivity(activity);
        ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activity);
        // Set the name
        activityNameLabel.setText(activity.getName());
        // Populate the graphs
        this.populateDistanceTimeGraph(timeArray);
        this.populateSpeedTimeGraph(timeArray);
        this.populateHeartRateTimeGraph(timeArray, heartRateArray);
        this.populateCaloriesBurnedGraph(timeArray);
        this.populateStressTimeGraph(timeArray, heartRateArray);

        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }

    /**
     * Set up method for the help text area
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to the Graphs Screen!\n\n" +
                             "On this screen you can view different graphs of an activity.\n\n" +
                             "To change graphs, simply click on the tabs to the left of the graph.\n" +
                             "Hover the mouse over each button to see a brief discription of what it does.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
    }


    /**
     * Set up method for the tool tips
     */
    private void setUpToolTips()
    {
        tabPane.setTooltip(new Tooltip("Select the tab of the graph you wish to see."));
        helpButton.setTooltip(new Tooltip("Need Help?"));
        backButton.setTooltip(new Tooltip("Click here to return to the View Activities screen."));
    }


    /**
     * Method called when the help button is pushed.
     * Displays the help text area.
     */
    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
    }


    /**
     * Method called when focus to the help text area is lost or when the pane is clicked on.
     * Hides the help text area.
     */
    @FXML public void hideHelpTextArea()
    {
        helpTextArea.setVisible(false);
        helpButton.requestFocus();
    }


    /**
     * Method to populate the distance over time graph with data.
     * @param timeArray  An ArrayList&lt;Double&gt;that contains the total time that has passed at each point in the activity.
     */
    private void populateDistanceTimeGraph(ArrayList<Double> timeArray)
    {
        ArrayList<Double> distanceArray = dataAnalysis.getDistanceFromActivity(activity);
        for (int i = 0; i < timeArray.size(); i++) {
            distanceTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), distanceArray.get(i)));
        }
        distanceOverTime.getData().add(distanceTimeSeries);
    }

    /**
     * Method to populate the speed over time graph with data.
     * @param timeArray  An ArrayList&gt;Double&lt; that contains the total time that has passed at each point in the activity.
     */
    private void populateSpeedTimeGraph(ArrayList<Double> timeArray)
    {
        ArrayList<Double> speedArray = new ArrayList<>();
        for(Entry eachEntry: activity.getEntries()){
            speedArray.add(eachEntry.getVelocity());
        }
        for (int i = 0; i < timeArray.size(); i++) {
            speedTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), speedArray.get(i)));
        }
        speedOverTime.getData().add(speedTimeSeries);
    }


    /**
     * Method to populate the heart rate over time graph with data.
     * @param timeArray  An ArrayList&lt;Double&gt;that contains the total time that has passed at each point in the activity.
     * @param heartRateArray  An ArrayList&lt;Integer&gt;that contains a list of heartrates at each point in the activity.
     */
    private void populateHeartRateTimeGraph(ArrayList<Double> timeArray, ArrayList<Integer> heartRateArray)
    {
        for (int i = 0; i < timeArray.size(); i++) {
            heartRateSeries.getData().add(new XYChart.Data(timeArray.get(i), heartRateArray.get(i)));
        }
        heartRateOverTime.getData().add(heartRateSeries);
    }


    /**
     * Method to populate the calories burned over time graph with data.
     * @param timeArray  An ArrayList&lt;Double&gt;that contains the total time that has passed at each point in the activity.
     */
    private void populateCaloriesBurnedGraph(ArrayList<Double> timeArray)
    {
        ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activity, mainController .getTitleBar().getCurrentProfile());
        for (int i = 0; i < timeArray.size(); i++) {
            caloriesBurnedSeries.getData().add(new XYChart.Data(timeArray.get(i), calorieArray.get(i)));
        }
        caloriesBurned.getData().add(caloriesBurnedSeries);
    }


    /**
     * Method to populate the stress level over time graph with data.
     * @param timeArray  An ArrayList&lt;Double&gt;that contains the total time that has passed at each point in the activity.
     * @param heartRateArray  An ArrayList&lt;Integer&gt;that contains a list of heartrates at each point in the activity.
     */
    private void populateStressTimeGraph(ArrayList<Double> timeArray, ArrayList<Integer> heartRateArray)
    {
        ArrayList<Double> stressArray = new ArrayList<>();
        for (int i = 0; i < timeArray.size(); i++) {
            double stressPercent = (double)heartRateArray.get(i)/((double) 220 - mainController .getTitleBar().getCurrentProfile().calculateAge());
            stressArray.add(stressPercent);
            stressLevelTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), stressArray.get(i)));
        }
        stressLevelOverTime.getData().add(stressLevelTimeSeries);
    }


    /**
     * Method to initialize the series in the graphs.
     */
    private void initializeSeries()
    {
        distanceTimeSeries = new XYChart.Series();
        heartRateSeries = new XYChart.Series();
        caloriesBurnedSeries = new XYChart.Series();
        stressLevelTimeSeries = new XYChart.Series();
        speedTimeSeries = new XYChart.Series();
    }


    /**
     * Method to remove all data currently in the graphs.
     */
    private void clearGraphs()
    {
        distanceOverTime.getData().clear();
        heartRateOverTime.getData().clear();
        caloriesBurned.getData().clear();
        stressLevelOverTime.getData().clear();
        speedOverTime.getData().clear();
    }

    /**
     * Method to set up the graphs by initializing them and setting labels.
     */
    private void setUpGraphs()
    {
        this.initializeSeries();

        setUpOneGraph(distanceOverTime);
        setUpOneGraph(speedOverTime);
        setUpOneGraph(heartRateOverTime);
        setUpOneGraph(caloriesBurned);
        setUpOneGraph(stressLevelOverTime);

        distanceOverTime.getYAxis().setLabel("Distance (m)");
        speedOverTime.getYAxis().setLabel("Speed (m/s)");
        heartRateOverTime.getYAxis().setLabel("Heart rate (bpm)");
        caloriesBurned.getYAxis().setLabel("Calories burned");
        stressLevelOverTime.getYAxis().setLabel("Stress level (% of max heart rate)");
    }

    @FXML public void openViewActivities() {
        mainController .getTitleBar().openViewActivities();
    }


    /**
     * Method to set up a graph by setting its label and disabling symbols and legends.
     * @param linechart  The graph being set up.
     */
    private void setUpOneGraph(LineChart linechart)
    {
        linechart.setLegendVisible(false);
        linechart.getXAxis().setLabel("Time (minutes)");
        linechart.setCreateSymbols(false);
    }


    /**
     * Method to set the activity attribute.
     * @param activity  The activity that the local value is being set to.
     */
    public void setActivity(Activity activity)
    {
        this.activity = activity;
    }

    /**
     * Method to initialize the class. Calls the setUpGraphs method when called. Called when the class is constructed.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setUpGraphs();
    }
}
