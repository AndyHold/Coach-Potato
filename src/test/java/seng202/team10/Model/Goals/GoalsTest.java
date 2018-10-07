package seng202.team10.Model.Goals;

<<<<<<< HEAD
<<<<<<< HEAD

=======
import com.sun.xml.internal.bind.v2.TODO;
import javafx.geometry.Pos;
>>>>>>> 831a7d65... Got rid of getBmi func and replaced all usages with calls to calcBmi. Wrote more tests for Goals class.
=======
>>>>>>> f4a09959... Made Goals package and refactored goal classes into it
import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.*;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoalsTest {

    private String name;
    private DateTime startDate;
    private DateTime targetDate;
    private String type;
    private double value;
    private int freq;
    private UserProfile testUser;
    private ArrayList<Goal> currentGoals = new ArrayList<Goal>();
    private ArrayList<String> currentGoalNames = new ArrayList<String>();
    private ArrayList<Goal> createdGoals = new ArrayList<Goal>();
    private ArrayList<String> createdGoalNames = new ArrayList<String>();
    private ArrayList<Goal> futureGoals = new ArrayList<Goal>();
    private ArrayList<String> futureGoalNames = new ArrayList<String>();
    private ArrayList<Goal> failedGoals = new ArrayList<Goal>();
    private ArrayList<String> failedGoalNames = new ArrayList<String>();
    private ArrayList<Goal> achievedGoals = new ArrayList<Goal>();
    private ArrayList<String> achievedGoalNames = new ArrayList<String>();

    private Goals goalsInstance;
    private UserProfile user;

    @Before
    public void setUp() throws Exception
    {
        name = "Paddy";
        value = 100.0;
        DateTime birthDate = new DateTime(1990, 8, 8, 8, 8, 8);
        user = new UserProfile();
        user.setName(name);
        user.setWeight(100);
        user.setHeight(200);
        user.setBirthDate(birthDate);
        user.setGender("Male");
        goalsInstance = user.getGoals();
        testUser = new UserProfile();
        testUser.setHeight(100);
        testUser.setWeight(100);
    }


    @Test
    public void createCurrentWeightGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);
        goalsInstance.createGoal("WeightGoal1", startDate, targetDate, "Weight", 75.0, testUser);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("WeightGoal1", currentGoalNames.get(0));
        assertEquals("WeightGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureWeightGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        startDate = new DateTime(year + 1, 1, 1, 0, 0, 0);
        targetDate = new DateTime(year + 2, 1, 1, 0, 0, 0);
        goalsInstance.createGoal("WeightGoal1", startDate, targetDate, "Weight", 75.0, testUser);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("WeightGoal1", futureGoalNames.get(0));
        assertEquals("WeightGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentDistanceGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);
        goalsInstance.createGoal("DistGoal1", startDate, targetDate, "Distance", 200.0, testUser);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("DistGoal1", currentGoalNames.get(0));
        assertEquals("DistGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureDistanceGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        startDate = new DateTime(year + 1, 1, 1, 0, 0, 0);
        targetDate = new DateTime(year + 2, 1, 1, 0, 0, 0);
        goalsInstance.createGoal("DistGoal1", startDate, targetDate, "Distance", 200.0, testUser);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("DistGoal1", futureGoalNames.get(0));
        assertEquals("DistGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentTimeGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);
        goalsInstance.createGoal("TimeGoal1", startDate, targetDate, "Time", 200.0, testUser);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("TimeGoal1", currentGoalNames.get(0));
        assertEquals("TimeGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureTimeGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        startDate = new DateTime(year + 1, 1, 1, 0, 0, 0);
        targetDate = new DateTime(year + 2, 1, 1, 0, 0, 0);
        goalsInstance.createGoal("TimeGoal1", startDate, targetDate, "Time", 200.0, testUser);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("TimeGoal1", futureGoalNames.get(0));
        assertEquals("TimeGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentBmiGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);
        goalsInstance.createGoal("BmiGoal1", startDate, targetDate, "BMI", 30.0, testUser);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("BmiGoal1", currentGoalNames.get(0));
        assertEquals("BmiGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureBmiGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        startDate = new DateTime(year + 1, 1, 1, 0, 0, 0);
        targetDate = new DateTime(year + 2, 1, 1, 0, 0, 0);
        goalsInstance.createGoal("BmiGoal1", startDate, targetDate, "BMI", 30.0, testUser);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("BmiGoal1", futureGoalNames.get(0));
        assertEquals("BmiGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentFrequencyGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);
        goalsInstance.createGoal("FreqGoal1", startDate, targetDate, 10, "Frequency");
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("FreqGoal1", currentGoalNames.get(0));
        assertEquals("FreqGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureFrequencyGoal() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        startDate = new DateTime(year + 1, 1, 1, 0, 0, 0);
        targetDate = new DateTime(year + 2, 1, 1, 0, 0, 0);
        goalsInstance.createGoal("FreqGoal1", startDate, targetDate, 10, "Frequency");
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("FreqGoal1", futureGoalNames.get(0));
        assertEquals("FreqGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }


    @Test
    public void removeCurrentGoal() throws BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        createdGoals = goalsInstance.getCreatedGoals();
        createdGoalNames = goalsInstance.getCreatedGoalNames();

        Goal goalToAddThenRemove = new Goal("WeightGoal1", startDate, targetDate, "Weight");
        currentGoals.add(goalToAddThenRemove);
        currentGoalNames.add(goalToAddThenRemove.getGoalName());
        createdGoals.add(goalToAddThenRemove);
        createdGoalNames.add(goalToAddThenRemove.getGoalName());

        goalsInstance.setCurrentGoals(currentGoals);
        goalsInstance.setCurrentGoalNames(currentGoalNames);
        goalsInstance.setCreatedGoals(createdGoals);
        goalsInstance.setCreatedGoalNames(createdGoalNames);

        goalsInstance.removeCurrentGoal("WeightGoal1");

        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals(0, createdGoals.size());
        assertEquals(0, createdGoalNames.size());
    }


    @Test
    public void checkWeightGoalAchieved() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException, InvalidWeightException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        achievedGoals = goalsInstance.getAchievedGoals();
        achievedGoalNames = goalsInstance.getAchievedGoalNames();

        WeightGoal goalToCheck = new WeightGoal("WeightGoal1", startDate, targetDate);
        testUser.setWeight(102);
        goalToCheck.setTargetValue(101.0, testUser);
        testUser.setWeight(100);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());

        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, achievedGoals.size());
        assertEquals(1, achievedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("achieved", message);
    }

<<<<<<< HEAD
<<<<<<< HEAD











//    @Test
//    public void checkGoal() {
//    }
//
//    @Test
//    public void refreshGoals() {
//    }
=======
=======

>>>>>>> 950d69ba... Wrote more tests for All goal classes, FileReader, Parser,
    @Test
    public void checkWeightGoalFailed() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year, month, day, 0, 0, 0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        failedGoals = goalsInstance.getFailedGoals();
        failedGoalNames = goalsInstance.getFailedGoalNames();

        WeightGoal goalToCheck = new WeightGoal("WeightGoal1", startDate, targetDate);
        goalToCheck.setTargetValue(99.0, testUser);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());
        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, failedGoals.size());
        assertEquals(1, failedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("failed", message);
    }


    @Test
    public void checkBMIGoalAchieved() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year + 4, month, day, 0, 0, 0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        achievedGoals = goalsInstance.getAchievedGoals();
        achievedGoalNames = goalsInstance.getAchievedGoalNames();

        BmiGoal goalToCheck = new BmiGoal("BMIGoal1", startDate, targetDate);
        goalToCheck.setTargetValue(30.0, testUser);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());

        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, achievedGoals.size());
        assertEquals(1, achievedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("achieved", message);
    }


    @Test
    public void checkBMIGoalFailed() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException, InvalidWeightException
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0, 0, 0);
        targetDate = new DateTime(year, month, day, 0, 0, 0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        failedGoals = goalsInstance.getFailedGoals();
        failedGoalNames = goalsInstance.getFailedGoalNames();

        BmiGoal goalToCheck = new BmiGoal("BMIGoal1", startDate, targetDate);
        goalToCheck.setTargetValue(10.0, testUser);
        testUser.setWeight(100);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());
        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, failedGoals.size());
        assertEquals(1, failedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("failed", message);
    }

<<<<<<< HEAD
>>>>>>> 831a7d65... Got rid of getBmi func and replaced all usages with calls to calcBmi. Wrote more tests for Goals class.
=======

    @Test
    public void duplicateGoalNames() throws InvalidGoalTargetException, InvalidGoalDateException
    {
        try {
            goalsInstance.createGoal("test", DateTime.now(), DateTime.now(), "BMI", 11.0, testUser);
        } catch (BadGoalNameException e) {
            e.printStackTrace();
        }
        try {
            goalsInstance.createGoal("test", DateTime.now(), DateTime.now(), "BMI", 11.0, testUser);
        } catch (BadGoalNameException e) {
            assertTrue(true);
        }
    }


    @Test
    public void duplicateGoalNamesFrequency() throws InvalidGoalTargetException, InvalidGoalDateException
    {
        try {
            goalsInstance.createGoal("test", DateTime.now(), DateTime.now(), 11, "Frequency");
        } catch (BadGoalNameException e) {
            e.printStackTrace();
        }
        try {
            goalsInstance.createGoal("test", DateTime.now(), DateTime.now(), 11, "Frequency");
        } catch (BadGoalNameException e) {
            assertTrue(true);
        }
    }


    @Test
    public void removeFutureGoalSuccess() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        goalsInstance.createGoal("test", new DateTime(DateTime.now().getYear() + 1, 1, 1, 0, 0, 0), new DateTime(DateTime.now().getYear() + 2, 1, 1, 0, 0, 0), "Weight", 35.0, testUser);
        int initialSize = goalsInstance.getFutureGoals().size();
        goalsInstance.removeFutureGoal("test");
        assertEquals(initialSize - 1, goalsInstance.getFutureGoals().size());
    }


    @Test
    public void removeFutureGoalFail() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException
    {
        goalsInstance.createGoal("test", new DateTime(DateTime.now().getYear() + 1, 1, 1, 0, 0, 0), new DateTime(DateTime.now().getYear() + 2, 1, 1, 0, 0, 0), "Weight", 35.0, testUser);
        int initialSize = goalsInstance.getFutureGoals().size();
        goalsInstance.removeFutureGoal("test2");
        assertEquals(initialSize, goalsInstance.getFutureGoals().size());
    }


    @Test
    public void refreshFutureToCurrent() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException, InterruptedException
    {
        DateTime now = DateTime.now();
        int year = now.getYear();
        int month = now.getMonth();
        int day = now.getDay();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        if (second == 59) {
            if (minute == 59) {
                if (hour == 23) {
                    day += 1;
                    hour = 0;
                    minute = 0;
                    second = 0;
                } else {
                    hour += 1;
                    minute = 0;
                    second = 0;
                }
            } else {
                minute += 1;
                second = 0;
            }
        } else {
            second += 1;
        }
        goalsInstance.createGoal("test", new DateTime(year, month, day, hour, minute, second), new DateTime(year + 4, month, day, hour, minute, second), "Weight", 35.0, testUser);
        int intitialSize = goalsInstance.getFutureGoals().size();
        Thread.sleep(2000);
        goalsInstance.refreshGoals();
        assertNotEquals(intitialSize, goalsInstance.getFutureGoals().size());
    }


    @Test
    public void refreshFutureToFuture() throws InvalidGoalDateException, InvalidGoalTargetException, BadGoalNameException, InterruptedException
    {
        DateTime now = DateTime.now();
        goalsInstance.createGoal("test", new DateTime(now.getYear() + 1, 1, 1, 0, 0, 0), new DateTime(now.getYear() + 1, 1, 1, 0, 1, 0), "Weight", 35.0, testUser);
        int intitialSize = goalsInstance.getFutureGoals().size();
        goalsInstance.refreshGoals();
        assertEquals(intitialSize, goalsInstance.getFutureGoals().size());
    }

>>>>>>> 950d69ba... Wrote more tests for All goal classes, FileReader, Parser,
}