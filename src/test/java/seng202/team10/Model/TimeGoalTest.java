package seng202.team10.Model;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.BadGoalNameException;
import seng202.team10.Model.Exceptions.InvalidGoalDateException;
import seng202.team10.Model.Exceptions.InvalidGoalTargetException;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.Goals.TimeGoal;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TimeGoalTest {

    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private double targetTime;



    @Before
    public void setUp()
    {
        name = "Paddy";
        targetTime = 200.0;

    }


    @Test
    public void reviewTimeGoalFailUpperBound() throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException, InterruptedException {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        Thread.sleep(1000);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(199.9);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewTimeGoalFailLowerBound() throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException, InterruptedException {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        Thread.sleep(1000);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(0.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewTimeGoalWorkingTowardsLowerBound() throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(0.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You need to complete 200.0 more minutes of activities to meet your goal.", message);
    }

    @Test
    public void reviewTimeGoalWorkingTowardsUpperBound() throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear() + 1, now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(199.9);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You need to complete 0.1 more minutes of activities to meet your goal.", message);
    }

    @Test
    public void reviewTimeGoalAchievedJust() throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(200.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewTimeGoalAchievedEasily() throws InvalidGoalTargetException, InvalidGoalDateException, BadGoalNameException
    {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(1000.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }
}