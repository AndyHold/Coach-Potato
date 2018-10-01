package seng202.team10.Model.Goals;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.BadGoalNameException;
import seng202.team10.Model.Exceptions.InvalidGoalDateException;
import seng202.team10.Model.Exceptions.InvalidGoalTargetException;
import seng202.team10.Model.Goals.DistanceGoal;
import seng202.team10.Model.Goals.Goal;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DistanceGoalTest {

    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private double targetDist;

    @Before
    public void setUp()
    {
        name = "Paddy";
        targetDist = 1000.0;

    }

    @Test
    public void reviewDistanceGoalFailUpperBound() throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException, InterruptedException {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new DistanceGoal(name, currentTime, target, targetDist);
        Thread.sleep(1000);
        String message = ((DistanceGoal) testGoal).reviewDistanceGoal(999.9);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewDistanceGoalFailLowerBound() throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException, InterruptedException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() , now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new DistanceGoal(name, currentTime, target, targetDist);
        Thread.sleep(1000);
        String message = ((DistanceGoal) testGoal).reviewDistanceGoal(0.0);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewDistanceGoalWorkingTowardsLowerBound() throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new DistanceGoal(name, currentTime, target, targetDist);
        String message = ((DistanceGoal) testGoal).reviewDistanceGoal(0.0);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You need to cover 1000.0 more metres to meet your goal.", message);
    }

    @Test
    public void reviewDistanceGoalWorkingTowardsUpperBound() throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new DistanceGoal(name, currentTime, target, targetDist);
        String message = ((DistanceGoal) testGoal).reviewDistanceGoal(999.9);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You need to cover 0.1 more metres to meet your goal.", message);
    }

    @Test
    public void reviewDistanceGoalAchievedJust() throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new DistanceGoal(name, currentTime, target, targetDist);
        String message = ((DistanceGoal) testGoal).reviewDistanceGoal(1000.0);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewDistanceGoalAchievedEasily() throws InvalidGoalDateException, BadGoalNameException, InvalidGoalTargetException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new DistanceGoal(name, currentTime, target, targetDist);
        String message = ((DistanceGoal) testGoal).reviewDistanceGoal(5000);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }
}