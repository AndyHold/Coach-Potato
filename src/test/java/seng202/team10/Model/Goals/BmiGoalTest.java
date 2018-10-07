package seng202.team10.Model.Goals;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.BmiGoal;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BmiGoalTest {

    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private double targetBMI;
    private UserProfile testUser;


    @Before
    public void setUp() throws InvalidHeightException, InvalidWeightException
    {
        name = "testGoal";
        targetBMI = 20.0;
        testUser = new UserProfile();
        testUser.setHeight(100);
        testUser.setWeight(100);
    }


    @Test
    public void reviewBMIGoalFailLowerBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException, InterruptedException
    {
        currentTime = DateTime.now();
        target = DateTime.now();
        testGoal = new BmiGoal(name, currentTime, target);
        ((BmiGoal) testGoal).setTargetValue(targetBMI, testUser);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(20.1);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewBMIGoalFailUpperBound() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException, InterruptedException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target);
        ((BmiGoal) testGoal).setTargetValue(targetBMI, testUser);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(2000);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewBMIGoalWorkingTowardsLowerBound() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 4, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target);
        ((BmiGoal) testGoal).setTargetValue(targetBMI, testUser);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(20.1);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You need to decrease your BMI by 0.1 more to meet your goal.", message);
    }

    @Test
    public void reviewBMIGoalWorkingTowardsUpperBound() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 4, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target);
        ((BmiGoal) testGoal).setTargetValue(targetBMI, testUser);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(2000);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You need to decrease your BMI by 1980.0 more to meet your goal.", message);
    }

    @Test
    public void reviewBMIGoalAchievedJust() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target);
        ((BmiGoal) testGoal).setTargetValue(targetBMI, testUser);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(20.0);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewBMIGoalAchievedEasily() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target);
        ((BmiGoal) testGoal).setTargetValue(targetBMI, testUser);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(15.0);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }


}