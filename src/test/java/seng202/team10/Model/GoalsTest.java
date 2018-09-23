package seng202.team10.Model;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;

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

    private ArrayList<Activity> activities = new ArrayList<>();
    private Goals goalsInstance;
    private UserProfile user;

    @Before
    public void setUp() throws  Exception
    {
        name = "Paddy";
        value = 100.0;
        DateTime birthDate = new DateTime(1990, 8, 8, 8, 8, 8);
        user = new UserProfile(name, 100, 200, birthDate, "Male");
        goalsInstance = user.getGoals();
    }


    @Test
    public void createCurrentWeightGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);
        goalsInstance.createGoal("WeightGoal1", startDate, targetDate, "Weight", 75.0);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("WeightGoal1", currentGoalNames.get(0));
        assertEquals("WeightGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureWeightGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth() + 1;
        startDate = new DateTime(year, month, day+1, 0,0,0);
        targetDate = new DateTime(year, month, day+2, 0,0,0);
        goalsInstance.createGoal("WeightGoal1", startDate, targetDate, "Weight", 75.0);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("WeightGoal1", futureGoalNames.get(0));
        assertEquals("WeightGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentDistanceGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);
        goalsInstance.createGoal("DistGoal1", startDate, targetDate, "Distance", 200.0);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("DistGoal1", currentGoalNames.get(0));
        assertEquals("DistGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureDistanceGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth() + 1;
        startDate = new DateTime(year, month, day+1, 0,0,0);
        targetDate = new DateTime(year, month, day+2, 0,0,0);
        goalsInstance.createGoal("DistGoal1", startDate, targetDate, "Distance", 200.0);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("DistGoal1", futureGoalNames.get(0));
        assertEquals("DistGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentTimeGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);
        goalsInstance.createGoal("TimeGoal1", startDate, targetDate, "Time", 200.0);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("TimeGoal1", currentGoalNames.get(0));
        assertEquals("TimeGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureTimeGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth() + 1;
        startDate = new DateTime(year, month, day+1, 0,0,0);
        targetDate = new DateTime(year, month, day+2, 0,0,0);
        goalsInstance.createGoal("TimeGoal1", startDate, targetDate, "Time", 200.0);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("TimeGoal1", futureGoalNames.get(0));
        assertEquals("TimeGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentBmiGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);
        goalsInstance.createGoal("BmiGoal1", startDate, targetDate, "BMI", 30.0);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("BmiGoal1", currentGoalNames.get(0));
        assertEquals("BmiGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureBmiGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth() + 1;
        startDate = new DateTime(year, month, day+1, 0,0,0);
        targetDate = new DateTime(year, month, day+2, 0,0,0);
        goalsInstance.createGoal("BmiGoal1", startDate, targetDate, "BMI", 30.0);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("BmiGoal1", futureGoalNames.get(0));
        assertEquals("BmiGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }

    @Test
    public void createCurrentFrequencyGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);
        goalsInstance.createGoal("FreqGoal1", startDate, targetDate,10);
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        currentGoals = goalsInstance.getCurrentGoals();
        assertEquals("FreqGoal1", currentGoalNames.get(0));
        assertEquals("FreqGoal1", currentGoals.get(0).getGoalName());
        assertEquals(1, currentGoalNames.size());
        assertEquals(1, currentGoals.size());
    }


    @Test
    public void createFutureFrequencyGoal()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth() + 1;
        startDate = new DateTime(year, month, day+1, 0,0,0);
        targetDate = new DateTime(year, month, day+2, 0,0,0);
        goalsInstance.createGoal("FreqGoal1", startDate, targetDate,10);
        futureGoalNames = goalsInstance.getFutureGoalNames();
        futureGoals = goalsInstance.getFutureGoals();
        assertEquals("FreqGoal1", futureGoalNames.get(0));
        assertEquals("FreqGoal1", futureGoals.get(0).getGoalName());
        assertEquals(1, futureGoalNames.size());
        assertEquals(1, futureGoals.size());
    }



    @Test
    public void removeCurrentGoal()
    {
        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        createdGoals = goalsInstance.getCreatedGoals();
        createdGoalNames = goalsInstance.getCreatedGoalNames();

        Goal goalToAddThenRemove = new Goal("WeightGoal1", startDate, targetDate, "Weight", false);
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
    public void checkWeightGoalAchieved()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        achievedGoals = goalsInstance.getAchievedGoals();
        achievedGoalNames = goalsInstance.getAchievedGoalNames();

        WeightGoal goalToCheck = new WeightGoal("WeightGoal1", startDate, targetDate, 101.0);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());

        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, achievedGoals.size());
        assertEquals(1, achievedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("Your target for this goal was to weigh 101.0 or less by " + targetDate + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void checkWeightGoalFailed()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day-1, 0,0,0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        failedGoals = goalsInstance.getFailedGoals();
        failedGoalNames = goalsInstance.getFailedGoalNames();

        WeightGoal goalToCheck = new WeightGoal("WeightGoal1", startDate, targetDate, 99.0);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());

        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, failedGoals.size());
        assertEquals(1, failedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("Your target for this goal was to weigh 99.0 or less by " + targetDate + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void checkBMIGoalAchieved()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day+1, 0,0,0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        achievedGoals = goalsInstance.getAchievedGoals();
        achievedGoalNames = goalsInstance.getAchievedGoalNames();

        BmiGoal goalToCheck = new BmiGoal("BMIGoal1", startDate, targetDate, 30.0);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());

        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, achievedGoals.size());
        assertEquals(1, achievedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("Your target for this goal was to have a BMI less than or equal to 30.0 by " + targetDate + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void checkBMIGoalFailed()
    {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        startDate = new DateTime(year, month, day, 0,0,0);
        targetDate = new DateTime(year, month, day-1, 0,0,0);

        currentGoals = goalsInstance.getCurrentGoals();
        currentGoalNames = goalsInstance.getCurrentGoalNames();
        failedGoals = goalsInstance.getFailedGoals();
        failedGoalNames = goalsInstance.getFailedGoalNames();

        BmiGoal goalToCheck = new BmiGoal("BMIGoal1", startDate, targetDate, 10.0);
        currentGoals.add(goalToCheck);
        currentGoalNames.add(goalToCheck.getGoalName());

        String message = goalsInstance.checkGoal(goalToCheck.getGoalName());

        assertEquals(1, failedGoals.size());
        assertEquals(1, failedGoalNames.size());
        assertEquals(0, currentGoals.size());
        assertEquals(0, currentGoalNames.size());
        assertEquals("Your target for this goal was to have a BMI less than or equal to 10.0 by " + targetDate + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

}