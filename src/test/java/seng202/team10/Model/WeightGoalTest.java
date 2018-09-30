package seng202.team10.Model;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.Goals.WeightGoal;

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

    // TODO test the constructor method properly
    @Test
    public void reviewWeightGoalFailLowerBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(101.0);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewWeightGoalFailUpperBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(500);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewWeightGoalWorkingTowardsLowerBound() throws BadGoalNameException, InvalidGoalDateException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(101);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You need to lose 1.0 more kgs to meet your goal.", message);
    }

    @Test
    public void reviewWeightGoalWorkingTowardsUpperBound() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(500);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You need to lose 400.0 more kgs to meet your goal.", message);
    }

    @Test
    public void reviewWeightGoalAchievedJust() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewWeightGoalAchievedEasily() throws InvalidGoalTargetException, BadGoalNameException, InvalidGoalDateException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new WeightGoal(name, currentTime, target);
        ((WeightGoal) testGoal).setTargetValue(targetWeight, testUser);
        String message = ((WeightGoal) testGoal).reviewWeightGoal(50);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }
}