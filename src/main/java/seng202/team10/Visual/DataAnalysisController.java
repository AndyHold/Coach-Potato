package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.DataAnalysis;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.UserProfile;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * DataAnalysisController Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class DataAnalysisController implements Controllable, Initializable{

    private GUIController guiController;
    private Activity activity;
    private UserProfile currentProfile;
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
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Button mapButton;

    private XYChart.Series distanceTimeSeries;
    private XYChart.Series heartRateSeries;
    private XYChart.Series caloriesBurnedSeries;
    private XYChart.Series stressLevelTimeSeries;


<<<<<<< HEAD
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


=======
    /**
     * Method to pass the guiController into this class.
     * @param guiController  The main controller class that contains most information
     */
>>>>>>> 05b3b8e... Refactored, javadocced and cleaned up classes
    @Override
    public void setApp(GUIController guiController) {
        this.guiController = guiController;
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
        activityList.setTooltip(new Tooltip("Select an activity from the list to update the graphs with that activity."));
        tabPane.setTooltip(new Tooltip("Select the tab of the graph you wish to see."));
        mapButton.setTooltip(new Tooltip("Click here to view a map of the selected Activity."));
        helpButton.setTooltip(new Tooltip("Need Help?"));

        // Set help text
        helpTextArea.setText("Welcome to the Analysis Screen!\n\n" +
                "On this screen you can view graphs of an activity or select to view a map of the route taken.\n\n" +
                "- To view graphs of an activity:\n" +
                "\t- Select the activity you wish to view by clicking on\n" +
                "\t  it in the list.\n" +
                "\t- The graph will now be updated automatically\n" +
                "\t  with the data from that activity.\n" +
                "\t- Now you can select a different graph to view by\n" +
                "\t  clicking on the tabs above the graph.\n" +
                "- To view a map:\n" +
                "\t- Select the activity you wish to view by clicking on\n" +
                "\t  it in the list.\n" +
                "\t- Click the View Map button to view the map.\n" +
                "\t- You will now be taken to the map view screen\n\n" +
                "Hover the mouse over each button to see a brief discription of what it does.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);

        dataAnalysis = new DataAnalysis();
        currentProfile = guiController.getCurrentProfile();
        if (currentProfile.getActivities().isEmpty()) {
            this.displayNoData(true);
        } else {

            this.setUpListView();

            this.displayNoData(false);

            this.initializeSeries();

            this.clearGraphs();

            ArrayList<Double> timeArray = dataAnalysis.getMinutesFromActivity(activity);
            ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activity);
            Integer timeTaken = activity.getTotalDuration();

            activityNameLabel.setText(activity.getName());
            timeTakenLabel.setText("Time Taken: " + dataAnalysis.secondsToTime(timeTaken));


            this.populateDistanceTimeGraph(timeArray);

            this.populateHeartRateTimeGraph(timeArray, heartRateArray);

            this.populateCaloriesBurnedGraph(timeArray);

            this.populateStressTimeGraph(timeArray, heartRateArray);
        }

        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
    }


    @FXML public void hideHelpTextArea()
    {
        helpTextArea.setVisible(false);
        helpButton.requestFocus();
    }

    /**
     * Method to set up the ListView that contains a list of activities for the user to view. It displays the activity
     * name and date.
     */
    private void setUpListView() {
        ObservableList<String> activityNames = FXCollections.observableArrayList();
        for (Activity activity : currentProfile.getActivities()) {
            String activityString = activity.getName() + " : " + activity.getStartDateTime().toString();
            activityNames.add(activityString);
        }
        activityList.setItems(activityNames);
        if (activityList.getSelectionModel().getSelectedIndex() == -1) {
            activityList.getSelectionModel().selectFirst();
            currentIndex = 0;
        }
        currentIndex = activityList.getSelectionModel().getSelectedIndex();
        activity = currentProfile.getActivities().get(currentIndex);
    }

    /**
     * Method to populate the distance over time graph with data.
     * @param timeArray  An ArrayList<Double> that contains the total time that has passed at each point in the activity.
     */
    private void populateDistanceTimeGraph(ArrayList<Double> timeArray) {
        ArrayList<Double> distanceArray = dataAnalysis.getDistanceFromActivity(activity);
        for (int i = 0; i < timeArray.size(); i++) {
            distanceTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), distanceArray.get(i)));
        }
        distanceOverTime.getData().add(distanceTimeSeries);
    }

    /**
     * Method to populate the heart rate over time graph with data.
     * @param timeArray  An ArrayList<Double> that contains the total time that has passed at each point in the activity.
     * @param heartRateArray  An ArrayList<Integer> that contains a list of heartrates at each point in the activity.
     */
    private void populateHeartRateTimeGraph(ArrayList<Double> timeArray, ArrayList<Integer> heartRateArray) {
        for (int i = 0; i < timeArray.size(); i++) {
            heartRateSeries.getData().add(new XYChart.Data(timeArray.get(i), heartRateArray.get(i)));
        }
        heartRateOverTime.getData().add(heartRateSeries);
    }

    /**
     * Method to populate the calories burned over time graph with data.
     * @param timeArray  An ArrayList<Double> that contains the total time that has passed at each point in the activity.
     */
    private void populateCaloriesBurnedGraph(ArrayList<Double> timeArray) {
        ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activity, currentProfile);
        for (int i = 0; i < timeArray.size(); i++) {
            caloriesBurnedSeries.getData().add(new XYChart.Data(timeArray.get(i), calorieArray.get(i)));
        }
        caloriesBurned.getData().add(caloriesBurnedSeries);
    }

    /**
     * Method to populate the stress level over time graph with data.
     * @param timeArray  An ArrayList<Double> that contains the total time that has passed at each point in the activity.
     * @param heartRateArray  An ArrayList<Integer> that contains a list of heartrates at each point in the activity.
     */
    private void populateStressTimeGraph(ArrayList<Double> timeArray, ArrayList<Integer> heartRateArray) {
        ArrayList<Double> stressArray = new ArrayList<>();
        for (int i = 0; i < timeArray.size(); i++) {
            double stressPercent = (double)heartRateArray.get(i)/(double)currentProfile.getMaxHeartRate();
            stressArray.add(stressPercent);
            stressLevelTimeSeries.getData().add(new XYChart.Data(timeArray.get(i), stressArray.get(i)));
        }
        stressLevelOverTime.getData().add(stressLevelTimeSeries);
    }

    /**
     * Method to initialize the series in the graphs.
     */
    private void initializeSeries() {
        distanceTimeSeries = new XYChart.Series();
        heartRateSeries = new XYChart.Series();
        caloriesBurnedSeries = new XYChart.Series();
        stressLevelTimeSeries = new XYChart.Series();
    }

    /**
     * Method to remove all data currently in the graphs.
     */
    private void clearGraphs() {
        distanceOverTime.getData().clear();
        heartRateOverTime.getData().clear();
        caloriesBurned.getData().clear();
        stressLevelOverTime.getData().clear();
    }

    /**
     * Method to set up the scene if a different index than the currently selected one is chosen. Called when any
     * actvity in the list view is clicked.
     */
    @FXML
    private void refresh() {
        if (activityList.getSelectionModel().getSelectedIndex() != currentIndex) {
            setUpScene();
        }
    }

    /**
     * Method to set up the graphs by initializing them and setting labels.
     */
    private void setUpGraphs() {
        this.initializeSeries();

        setUpOneGraph(distanceOverTime);
        setUpOneGraph(heartRateOverTime);
        setUpOneGraph(caloriesBurned);
        setUpOneGraph(stressLevelOverTime);

        distanceOverTime.getYAxis().setLabel("Distance (m)");
        heartRateOverTime.getYAxis().setLabel("Heart rate (bpm)");
        caloriesBurned.getYAxis().setLabel("Calories burned");
        stressLevelOverTime.getYAxis().setLabel("Stress level");
    }

    /**
     * Method to set up a graph by setting its label and disabling symbols.
     * @param linechart  The graph being set up.
     */
    private void setUpOneGraph(LineChart linechart) {
        linechart.setLegendVisible(false);
        linechart.getXAxis().setLabel("Time (minutes)");
        linechart.setCreateSymbols(false);
    }

    /**
     * Method to display a message if there is no data to display, or to disable the message if there is data.
     * @param noDataFound True if there is no data to display. False if there is.
     */
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


    /**
     * Method to set the activity attribute.
     * @param activity  The activity that the local value is being set to.
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
    /**
     *Method to launch the map for the currently selected activity.
     */
>>>>>>> 05b3b8e... Refactored, javadocced and cleaned up classes
    @FXML public void viewMap() {
        if (!(activity == null)) {
            guiController.launchMapScene(activity);
        } else {
            this.guiController.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an activity.");
        }

    }

    /**
     * Method to initialize the class. Calls the setUpScene method when called. Called when the class is constructed.
     */
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
