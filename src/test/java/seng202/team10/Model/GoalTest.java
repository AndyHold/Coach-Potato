package seng202.team10.Model;

import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GoalTest {

    private Goal testGoal;
    private String name;
    private DateTime currentTime;
    private DateTime target;
    private String type;
    private boolean achieved;
    private int targetFreq;
    private double targetTime;
    private double targetDist;
    private double targetWeight;
    private double targetBMI;


    @Before
    public void setUp()
    {
        name = "Paddy";
        targetWeight = 100.0;
        targetBMI = 20.0;
        targetDist = 1000.0;
        targetFreq = 10;
        targetTime = 200.0;

    }

    @Test
    public void reviewWeightGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Weight", false, 0, 0, targetWeight, 0,0);
        String message = testGoal.reviewWeightGoal(101);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewWeightGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Weight", false, 0, 0, targetWeight, 0,0);
        String message = testGoal.reviewWeightGoal(500);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewWeightGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Weight", false, 0, 0, targetWeight, 0,0);
        String message = testGoal.reviewWeightGoal(101);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You need to lose 1.0 more kgs to meet your goal.", message);
    }

    @Test
    public void reviewWeightGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Weight", false, 0, 0, targetWeight, 0,0);
        String message = testGoal.reviewWeightGoal(500);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "\n" +
                "You need to lose 400.0 more kgs to meet your goal.", message);
    }

    @Test
    public void reviewWeightGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Weight", false, 0, 0, targetWeight, 0,0);
        String message = testGoal.reviewWeightGoal(100);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewWeightGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Weight", false, 0, 0, targetWeight, 0,0);
        String message = testGoal.reviewWeightGoal(50);
        assertEquals("Your target for this goal was to weigh 100.0 or less by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }





//---------------------------------------------------------------------------------------------------------------------------------------------------------





    @Test
    public void reviewBMIGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "BMI", false, 0, 0, 0, 0, targetBMI);
        String message = testGoal.reviewBmiGoal(20.1);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewBMIGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "BMI", false, 0, 0, 0, 0, targetBMI);
        String message = testGoal.reviewBmiGoal(2000);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewBMIGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "BMI", false, 0, 0, 0, 0, targetBMI);
        String message = testGoal.reviewBmiGoal(20.1);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You need to decrease your BMI by 0.1 more to meet your goal.", message);
    }

    @Test
    public void reviewBMIGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "BMI", false, 0, 0, 0, 0, targetBMI);
        String message = testGoal.reviewBmiGoal(2000);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "\n" +
                "You need to decrease your BMI by 1980.0 more to meet your goal.", message);
    }

    @Test
    public void reviewBMIGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "BMI", false, 0, 0, 0, 0, targetBMI);
        String message = testGoal.reviewBmiGoal(20.0);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewBMIGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "BMI", false, 0, 0, 0, 0, targetBMI);
        String message = testGoal.reviewBmiGoal(15.0);
        assertEquals("Your target for this goal was to have a BMI less than or equal to 20.0 by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }



    //---------------------------------------------------------------------------------------------------------------------------------------------------------


    @Test
    public void reviewDistanceGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        String message = testGoal.reviewDistanceGoal(999.9);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewDistanceGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        String message = testGoal.reviewDistanceGoal(0.0);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewDistanceGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        String message = testGoal.reviewDistanceGoal(0.0);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You need to cover 1000.0 more metres to meet your goal.", message);
    }

    @Test
    public void reviewDistanceGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        String message = testGoal.reviewDistanceGoal(999.9);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "\n" +
                "You need to cover 0.1 more metres to meet your goal.", message);
    }

    @Test
    public void reviewDistanceGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        String message = testGoal.reviewDistanceGoal(1000.0);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewDistanceGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        String message = testGoal.reviewDistanceGoal(5000);
        assertEquals("Your target for this goal was to cover 1000.0 km in distance by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }





    //-------------------------------------------------------------------------------------------------------------------------------------------------------



    @Test
    public void reviewFrequencyGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Frequency", false, targetFreq, 0, 0, 0, 0);
        String message = testGoal.reviewFrequencyGoal(9);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewFrequencyGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Frequency", false, targetFreq, 0, 0, 0, 0);
        String message = testGoal.reviewFrequencyGoal(0);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewFrequencyGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Frequency", false, targetFreq, 0, 0, 0, 0);
        String message = testGoal.reviewFrequencyGoal(0);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You need to complete 10 more activities to meet your goal.", message);
    }

    @Test
    public void reviewFrequencyGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Frequency", false, targetFreq, 0, 0, 0, 0);
        String message = testGoal.reviewFrequencyGoal(9);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "\n" +
                "You need to complete 1 more activities to meet your goal.", message);
    }

    @Test
    public void reviewFrequencyGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Frequency", false, targetFreq, 0, 0, 0, 0);
        String message = testGoal.reviewFrequencyGoal(10);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewFrequencyGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Frequency", false, targetFreq, 0, 0, 0, 0);
        String message = testGoal.reviewFrequencyGoal(1000);
        assertEquals("Your target for this goal was to excersize 10 times by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }



//---------------------------------------------------------------------------------------------------------------------------------------------------


    @Test
    public void reviewTimeGoalFailUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, targetTime, 0, 0, 0);
        String message = testGoal.reviewTimeGoal(199.9);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewTimeGoalFailLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() - 1, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, targetTime, 0, 0, 0);
        String message = testGoal.reviewTimeGoal(0.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You have failed to complete this goal in time. It has been removed from your current goals and added to your failed goals.", message);
    }

    @Test
    public void reviewTimeGoalWorkingTowardsLowerBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, targetTime, 0, 0, 0);
        String message = testGoal.reviewTimeGoal(0.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You need to complete 200.0 more minutes of activities to meet your goal.", message);
    }

    @Test
    public void reviewTimeGoalWorkingTowardsUpperBound() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth() + 2, now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, 0, 0, targetDist, 0);
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, targetTime, 0, 0, 0);
        String message = testGoal.reviewTimeGoal(199.9);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "\n" +
                "You need to complete 0.1 more minutes of activities to meet your goal.", message);
    }

    @Test
    public void reviewTimeGoalAchievedJust() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, targetTime, 0, 0, 0);
        String message = testGoal.reviewTimeGoal(200.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }

    @Test
    public void reviewTimeGoalAchievedEasily() {
        LocalDateTime now1 = LocalDateTime.now();
        currentTime = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        target = new DateTime(now1.getYear(), now1.getMonthValue(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond());
        testGoal = new Goal(name, currentTime, target, "Distance", false, 0, targetTime, 0, 0, 0);
        String message = testGoal.reviewTimeGoal(1000.0);
        assertEquals("Your target for this goal was to excersize for 200.0 minutes by " + target + "\n" +
                "Congratulations you have completed this goal! It has been removed from your current goals and added to your achieved goals.", message);
    }


}