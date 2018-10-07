package seng202.team10.Model.Goals;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.Goals.WeightGoal;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class WeightGoalTest {


    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private double targetWeight;
    private UserProfile testUser;


    @Before
    public void setUp() throws InvalidHeightException, InvalidWeightException
    {
        name = "testGoal";
        targetWeight = 100.0;
        testUser = new UserProfile();
        testUser.setHeight(100);
        testUser.setWeight(100);
    }


    @Test
    public void setBadWeightTargetLow() throws BadGoalNameException, InvalidGoalDateException
    {
        WeightGoal newGoal = new WeightGoal("Weight Goal", DateTime.now(), DateTime.now());
        try {
            newGoal.setTargetValue(29.0, testUser);
        } catch (InvalidGoalTargetException e) { }
        assertEquals(0.0, newGoal.getGoalWeight(), 0.1);
    }


    @Test
    public void setBadWeightTargetHigh() throws BadGoalNameException, InvalidGoalDateException
    {
        BmiGoal newGoal = new BmiGoal("Weight Goal", DateTime.now(), DateTime.now());
        try {
            newGoal.setTargetValue(100.0, testUser);
        } catch (InvalidGoalTargetException e) { }
        assertEquals(0.0, newGoal.getGoalBmi(), 0.1);
    }


    @Test
    public void reviewWeightGoalFailLowerBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException, InvalidWeightException, InterruptedException
    {
        LocalDateTime now1 = LocalDateTime.now();
        testUser.setWeight(101.0);
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(101.0);
        testUser.setWeight(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewWeightGoalFailUpperBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException, InvalidWeightException, InterruptedException
    {
        LocalDateTime now1 = LocalDateTime.now();
        testUser.setWeight(250);
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() , now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(250);
        testUser.setWeight(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewWeightGoalWorkingTowardsLowerBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException, InvalidWeightException
    {
        LocalDateTime now1 = LocalDateTime.now();
        testUser.setWeight(101);
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(101);
        testUser.setWeight(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You need to lose 1.0 more kgs to meet your goal.", message);
    }

    @Test
    public void reviewWeightGoalWorkingTowardsUpperBound() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException, InvalidWeightException
    {
        LocalDateTime now1 = LocalDateTime.now();
        testUser.setWeight(250);
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(250);
        testUser.setWeight(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You need to lose 150.0 more kgs to meet your goal.", message);
    }

    @Test
    public void reviewWeightGoalAchievedJust() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException, InvalidWeightException
    {
        LocalDateTime now1 = LocalDateTime.now();
        testUser.setWeight(101);
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        testUser.setWeight(100);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewWeightGoalAchievedEasily() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException, InvalidWeightException
    {
        LocalDateTime now1 = LocalDateTime.now();
        testUser.setWeight(101);
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(50);
        testUser.setWeight(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }
}