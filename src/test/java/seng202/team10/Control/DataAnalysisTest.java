package seng202.team10.Control;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataAnalysisTest {

    private GUIController guiController;
    private DataAnalysis dataAnalysis;
    private UserProfile user;
    private ArrayList<Activity> activities;


    @Before
    public void setUp() throws Exception {

        dataAnalysis = new DataAnalysis();
        guiController = new GUIController();
        user = new UserProfile();
        user.setHeight(80);
        user.setWeight(80);
        user.setGender("Male");
        user.setMaxHeartRate(170);
        DateTime birthday = new DateTime(1996, 12, 04, 0, 0, 0);
        user.setBirthDate(birthday);
        guiController.uploadDataToUser(user, "./FilesToLoad/testdata.csv");
        activities = user.getActivities();

    }

    @Test
    public void getTimeFromActivityReturnsTotalTime() {
        ArrayList<Integer> times = dataAnalysis.getTimeFromActivity(activities.get(0));
        assertTrue((times.get(times.size()-1)) == activities.get(0).getTotalDuration());
    }

    @Test
    public void getDistanceFromActivityReturnsTotalDistance() {
        ArrayList<Double> distances = dataAnalysis.getDistanceFromActivity(activities.get(0));
        assertEquals((distances.get(distances.size()-1)), activities.get(0).getTotalDistance());
    }

    @Test
    public void getTimeFromActivity() {
        ArrayList<Integer> times = dataAnalysis.getTimeFromActivity(activities.get(1));
        ArrayList<Integer> actualTimes = new ArrayList<>();
        actualTimes.add(0);
        actualTimes.add(102);
        actualTimes.add(166);
        actualTimes.add(213);
        actualTimes.add(363);
        actualTimes.add(480);
        actualTimes.add(539);
        assertEquals(actualTimes, times);
    }

    @Test
    public void getDistanceFromActivity() {
        ArrayList<Double> distances = dataAnalysis.getDistanceFromActivity(activities.get(0));
        assertEquals((distances.get(distances.size()-1)), activities.get(0).getTotalDistance());
    }

    @Test
    public void getHeartRateFromActivity() {
        ArrayList<Integer> heartRates = dataAnalysis.getHeartRateFromActivity(activities.get(1));
        ArrayList<Integer> actualHeartRates = new ArrayList<Integer>();
        actualHeartRates.add(157);
        actualHeartRates.add(156);
        actualHeartRates.add(153);
        actualHeartRates.add(149);
        actualHeartRates.add(147);
        actualHeartRates.add(143);
        actualHeartRates.add(143);
        assertEquals(actualHeartRates, heartRates);
    }

    @Test
    public void getCaloriesFromActivityMale() {
        user.setGender("Male");
        ArrayList<Double> calories = dataAnalysis.getCaloriesFromActivity(activities.get(1), user);
        ArrayList<Double> actualcalories = new ArrayList<>();
        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        ArrayList<Integer> timeArray = dataAnalysis.getTimeFromActivity(activities.get(1));
        actualcalories.add(((-55.0969 + (0.6309 * 157) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(0)/3600.0);
        actualcalories.add(((-55.0969 + (0.6309 * 156) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(1)/3600.0);
        actualcalories.add(((-55.0969 + (0.6309 * 153) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(2)/3600.0);
        actualcalories.add(((-55.0969 + (0.6309 * 149) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(3)/3600.0);
        actualcalories.add(((-55.0969 + (0.6309 * 147) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(4)/3600.0);
        actualcalories.add(((-55.0969 + (0.6309 * 143) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(5)/3600.0);
        actualcalories.add(((-55.0969 + (0.6309 * 143) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(6)/3600.0);
        assertEquals(actualcalories, calories);
    }

    @Test
    public void getCaloriesFromActivityFemale() {
        user.setGender("Female");
        ArrayList<Double> calories = dataAnalysis.getCaloriesFromActivity(activities.get(1), user);
        ArrayList<Double> actualcalories = new ArrayList<>();
        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        ArrayList<Integer> timeArray = dataAnalysis.getTimeFromActivity(activities.get(1));
        actualcalories.add(((-20.4022 + (0.4472 * 157) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(0)/3600.0);
        actualcalories.add(((-20.4022 + (0.4472 * 156) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(1)/3600.0);
        actualcalories.add(((-20.4022 + (0.4472 * 153) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(2)/3600.0);
        actualcalories.add(((-20.4022 + (0.4472 * 149) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(3)/3600.0);
        actualcalories.add(((-20.4022 + (0.4472 * 147) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(4)/3600.0);
        actualcalories.add(((-20.4022 + (0.4472 * 143) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(5)/3600.0);
        actualcalories.add(((-20.4022 + (0.4472 * 143) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(6)/3600.0);
        assertEquals(actualcalories, calories);
    }

    @Test
    public void getCaloriesFromActivityOther() {
        user.setGender("Other");
        ArrayList<Double> calories = dataAnalysis.getCaloriesFromActivity(activities.get(1), user);
        ArrayList<Double> actualcalories = new ArrayList<>();
        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        ArrayList<Integer> timeArray = dataAnalysis.getTimeFromActivity(activities.get(1));
        actualcalories.add(((-37.5 + (0.54 * 157) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(0)/3600.0);
        actualcalories.add(((-37.5 + (0.54 * 156) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(1)/3600.0);
        actualcalories.add(((-37.5 + (0.54 * 153) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(2)/3600.0);
        actualcalories.add(((-37.5 + (0.54 * 149) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(3)/3600.0);
        actualcalories.add(((-37.5 + (0.54 * 147) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(4)/3600.0);
        actualcalories.add(((-37.5 + (0.54 * 143) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(5)/3600.0);
        actualcalories.add(((-37.5 + (0.54 * 143) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(6)/3600.0);
        assertEquals(actualcalories, calories);
    }

    @Test
    public void getPositionFromActivity() {
//        ArrayList<Position> positions = dataAnalysis.getPositionFromActivity(activities.get(1));
//        ArrayList<Position> actualPositions = new ArrayList<>();
//        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
//        actualPositions.add(new Position(30.245576, -97.823843, 220.3));
//        actualPositions.add(new Position(30.246356, -97.823326, 220.3));
//        actualPositions.add(new Position(30.246539, -97.821931, 209.7));
//        actualPositions.add(new Position(30.247105, -97.821064, 207.8));
//        actualPositions.add(new Position(30.247719, -97.820641, 205.4));
//        actualPositions.add(new Position(30.248482, -97.820708, 207.3));
//        actualPositions.add(new Position(30.24915, -97.820722, 206.8));
//        int i = 0;
//        for (Position position : positions) {
//            assertEquals(position, actualPositions.get(i));
//            i++;
//        }
    }

    @Test
    public void getMinutesFromActivity() {
        ArrayList<Double> minutes = dataAnalysis.getMinutesFromActivity(activities.get(1));
        ArrayList<Double> actualMinutes = new ArrayList<>();
        actualMinutes.add(0.0);
        actualMinutes.add(102.0/60.0);
        actualMinutes.add(166.0/60.0);
        actualMinutes.add(213.0/60.0);
        actualMinutes.add(363.0/60.0);
        actualMinutes.add(480.0/60.0);
        actualMinutes.add(539.0/60.0);
        assertEquals(actualMinutes, minutes);
    }


}