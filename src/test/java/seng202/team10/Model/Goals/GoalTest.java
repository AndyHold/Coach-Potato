package seng202.team10.Model.Goals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.BadGoalNameException;
import seng202.team10.Model.Exceptions.InvalidGoalDateException;

import static org.junit.Assert.*;

public class GoalTest {


    DateTime now = DateTime.now();
    DateTime pastDate;
    DateTime nowPlusFourYears;
    DateTime nowPlusEightYears;


    @Before
    public void setUp()
    {
        pastDate = new DateTime(now.getYear() - 4, now.getMonth(), now.getDay(), now.getHour(), now.getMinute(), now.getSecond());
        nowPlusFourYears = new DateTime(now.getYear() + 4, now.getMonth(), now.getDay(), now.getHour(), now.getMinute(), now.getSecond());
        nowPlusEightYears = new DateTime(now.getYear() + 8, now.getMonth(), now.getDay(), now.getHour(), now.getMinute(), now.getSecond());
    }


    @After
    public void tearDown()
    {
        pastDate = null;
        now = null;
        nowPlusFourYears = null;
        nowPlusEightYears = null;
    }


    @Test
    public void pastDate() throws BadGoalNameException {
        String message = null;
        try {
            Goal newGoal = new Goal("Test Goal", pastDate, now, "BMI");
        } catch (InvalidGoalDateException exception) {
            message = exception.getMessage();
        }
        assertEquals("You cannot select a date in the past.", message);
    }


    @Test
    public void targetBeforeStart() throws BadGoalNameException {
        String message = null;
        try {
            Goal newGoal = new Goal("Test Goal", nowPlusEightYears, nowPlusFourYears, "BMI");
        } catch (InvalidGoalDateException exception) {
            message = exception.getMessage();
        }
        assertEquals("Target date must be after start date.", message);
    }


    @Test
    public void startTooFarAway() throws BadGoalNameException {
        String message = null;
        try {
            Goal newGoal = new Goal("Test Goal", nowPlusFourYears, nowPlusFourYears, "BMI");
        } catch (InvalidGoalDateException exception) {
            message = exception.getMessage();
        }
        assertEquals("Start date must be before the end of next year.", message);
    }


    @Test
    public void targetTooFarAway() throws BadGoalNameException {
        String message = null;
        try {
            Goal newGoal = new Goal("Test Goal", now, nowPlusEightYears, "BMI");
        } catch (InvalidGoalDateException exception) {
            message = exception.getMessage();
        }
        assertEquals("Target date must be before the end of the year, five years from now.", message);
    }


    @Test
    public void nameTooShort() throws InvalidGoalDateException {
        Goal newGoal = null;
        try {
            newGoal = new Goal("a", now, nowPlusEightYears, "BMI");
        } catch (BadGoalNameException exception) {  }
        assertNull(newGoal);
    }


    @Test
    public void nameTooLong() throws InvalidGoalDateException {
        Goal newGoal = null;
        try {
            newGoal = new Goal("aaaaaaaaaaaaaaaaaaaaa", now, nowPlusEightYears, "BMI");
        } catch (BadGoalNameException exception) {  }
        assertNull(newGoal);
    }


    @Test
    public void goalAchievedStatusInitialised() throws BadGoalNameException, InvalidGoalDateException {
        Goal newGoal = new Goal("Test Goal", now, now, "BMI");
        assertFalse(newGoal.isGoalAchieved());
    }


    @Test
    public void toStringtest() throws BadGoalNameException, InvalidGoalDateException {
        Goal newGoal = new Goal("Test Goal", now, now, "BMI");
        assertEquals("Test Goal: BMI", newGoal.toString());
    }

}