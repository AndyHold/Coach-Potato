package seng202.team10.Control;

import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;


public class DataAnalysisTest {

    private GUIController guiController = new GUIController();

    @Test
    public void sortByDate() throws Exception{
        UserProfile user = new UserProfile();
        guiController.uploadDataToUser(user, "/home/cosc/student/tkl34/Desktop/SENG202/SENG202_Project/SENG202_Project/FilesToLoad/testdata.csv");
        ArrayList<Activity> activities = user.getActivities();
        DataAnalysis dataAnalysis = new DataAnalysis();
        ArrayList<Integer> timesum = dataAnalysis.getTimeFromActivity(activities.get(0));
        dataAnalysis.setActivities(activities);
        dataAnalysis.sortByDate();
    }

    @Test
    public void name() {
    }
}