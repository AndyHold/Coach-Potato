package seng202.team10.Model;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;

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
    public void reviewTimeGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(199.9);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewTimeGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(0.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewTimeGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(0.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You need to complete 200.0 more minutes of activities to meet your goal.", message);
    }

    @Test
    public void reviewTimeGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(199.9);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You need to complete 0.1 more minutes of activities to meet your goal.", message);
    }

    @Test
    public void reviewTimeGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(200.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewTimeGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new TimeGoal(name, currentTime, target, targetTime);
        String message = ((TimeGoal) testGoal).reviewTimeGoal(1000.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }
}