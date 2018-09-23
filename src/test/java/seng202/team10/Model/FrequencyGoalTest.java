package seng202.team10.Model;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class FrequencyGoalTest {

    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private int targetFreq;



    @Before
    public void setUp()
    {
        name = "Paddy";
        targetFreq = 10;


    }



    @Test
    public void reviewFrequencyGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new FrequencyGoal(name, currentTime, target, targetFreq);
        String message = ((FrequencyGoal) testGoal).reviewFrequencyGoal(9);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewFrequencyGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new FrequencyGoal(name, currentTime, target, targetFreq);
        String message = ((FrequencyGoal) testGoal).reviewFrequencyGoal(0);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewFrequencyGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new FrequencyGoal(name, currentTime, target, targetFreq);
        String message = ((FrequencyGoal) testGoal).reviewFrequencyGoal(0);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You need to complete 10 more activities to meet your goal.", message);
    }

    @Test
    public void reviewFrequencyGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new FrequencyGoal(name, currentTime, target, targetFreq);
        String message = ((FrequencyGoal) testGoal).reviewFrequencyGoal(9);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You need to complete 1 more activities to meet your goal.", message);
    }

    @Test
    public void reviewFrequencyGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new FrequencyGoal(name, currentTime, target, targetFreq);
        String message = ((FrequencyGoal) testGoal).reviewFrequencyGoal(10);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewFrequencyGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new FrequencyGoal(name, currentTime, target, targetFreq);
        String message = ((FrequencyGoal) testGoal).reviewFrequencyGoal(1000);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }



}