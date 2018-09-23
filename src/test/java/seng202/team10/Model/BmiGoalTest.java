package seng202.team10.Model;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BmiGoalTest {

    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private double targetBMI;

    @Before
    public void setUp()
    {
        name = "Paddy";
        targetBMI = 20.0;

    }



    @Test
    public void reviewBMIGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target, targetBMI);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(20.1);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewBMIGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target, targetBMI);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(2000);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewBMIGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target, targetBMI);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(20.1);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You need to decrease your BMI by 0.1 more to meet your goal.", message);
    }

    @Test
    public void reviewBMIGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target, targetBMI);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(2000);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You need to decrease your BMI by 1980.0 more to meet your goal.", message);
    }

    @Test
    public void reviewBMIGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target, targetBMI);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(20.0);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewBMIGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new BmiGoal(name, currentTime, target, targetBMI);
        String message = ((BmiGoal) testGoal).reviewBmiGoal(15.0);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }


}