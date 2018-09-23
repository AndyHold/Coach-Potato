package seng202.team10.Model.ActivitiesData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityTest {


    private DateTime startDateTime = new DateTime(2018, 8, 30, 15, 1, 0);
    private Position firstPosition = new Position(-43.5222767, 172.5809189, 14.000);
    private Entry firstEntry = new Entry(startDateTime, 60, firstPosition);
    private DateTime secondDateTime = new DateTime(2018, 8, 30, 15, 1, 10);
    private Position secondPosition = new Position(-43.5221523, 172.5810262, 14.000);
    private Entry secondEntry = new Entry(secondDateTime, 70, secondPosition);
    private DateTime thirdDateTime = new DateTime(2018, 8, 30, 15, 1, 20);
    private Position thirdPosition = new Position(-43.5219967, 172.5811335, 14.000);
    private Entry thirdEntry = new Entry(thirdDateTime, 80, thirdPosition);
    private DateTime fourthDateTime = new DateTime(2018, 8, 30, 15, 1, 30);
    private Position fourthPosition = new Position(-43.5218722, 172.5812408, 14.000);
    private Entry fourthEntry = new Entry(fourthDateTime, 90, fourthPosition);
    private DateTime fifthDateTime = new DateTime(2018, 8, 30, 15, 1, 40);
    private Position fifthPosition = new Position(-43.5217010, 172.5813481, 14.000);
    private Entry fifthEntry = new Entry(fifthDateTime, 100, fifthPosition);
    private DateTime sixthDateTime = new DateTime(2018, 8, 30, 15, 1, 50);
    private Position sixthPosition = new Position(-43.5215921, 172.5814768, 14.000);
    private Entry sixthEntry = new Entry(sixthDateTime, 110, sixthPosition);
    private Activity activity = new Activity("Walk in the park");


    @Before
    public void setUp()
    {
        firstEntry.setFirstEntry(true);
        secondEntry.setFirstEntry(false);
        thirdEntry.setFirstEntry(false);
        fourthEntry.setFirstEntry(false);
        fifthEntry.setFirstEntry(false);
        sixthEntry.setFirstEntry(false);
        activity.addEntry(firstEntry);
        activity.addEntry(secondEntry);
        activity.addEntry(thirdEntry);
        activity.addEntry(fourthEntry);
        activity.addEntry(fifthEntry);
        activity.addEntry(sixthEntry);
        activity.postEntriesSetUp();
    }


    @Test
    public void badNameEmpty()
    {
        String message = "Test Failed!";
        try {
            new Activity("");
        } catch (IllegalArgumentException exception) {
            message = exception.getMessage();
        }
        assertEquals("Activity name invalid, either blank or too long. Please change to between 1 - 30 characters", message);
    }


    @Test
    public void badNameLong()
    {
        String message = "Test Failed!";
        try {
            new Activity("0000000000000000000000000000000");
        } catch (IllegalArgumentException exception) {
            message = exception.getMessage();
        }
        assertEquals("Activity name invalid, either blank or too long. Please change to between 1 - 30 characters", message);
    }


    @Test
    public void goodNameShort()
    {
        Activity testActivity = new Activity("a");
        assertEquals("a", testActivity.getName());
    }

    @Test
    public void secondsToTimeAddsZeros() {
        assertEquals(activity.secondsToTime(7748), "02:09:08");
    }

    @Test
    public void secondsToTimeDoesntAddZeros() {
        assertEquals(activity.secondsToTime(38970), "10:49:30");
    }

    @Test
    public void secondsToTimeReturnsNullWhenOver23() {
        //24 hours in seconds
        assertEquals(activity.secondsToTime(86400), null);
    }

    @Test
    public void secondsToTimeReturnsNullWhenNegative() {
        assertEquals(activity.secondsToTime(-1), null);
    }


    @Test
    public void goodNameLong()
    {
        Activity testActivity = new Activity("abcdefghijklmnopqrstuvwxyz0123");
        assertEquals("abcdefghijklmnopqrstuvwxyz0123", testActivity.getName());
    }


    @Test
    public void addEntry()
    {
        int initialSize = activity.getEntries().size();
        Entry newEntry = new Entry(new DateTime(2000, 1, 1, 0, 0, 0), 120, new Position(0.0, 0.0, 0.0));
        newEntry.setFirstEntry(false);
        activity.addEntry(newEntry);
        activity.postEntriesSetUp();
        assertEquals(initialSize + 1, activity.getEntries().size());
    }


    @Test
    public void calculateTotalDistance()
    {
        activity.calculateTotalDistance();
<<<<<<< HEAD
<<<<<<< HEAD
        assertEquals(177.68, activity.getTotalDistance(), 0.01);
=======
        assertEquals("0.18", activity.getDistanceString());
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
=======
        assertEquals(88.84, activity.getTotalDistance(), 0.01);
>>>>>>> 5065dd35... fixed 2 tests in ActivityTest
    }


    @Test
    public void calculateTotalDuration()
    {
        activity.calculateTotalDuration();
<<<<<<< HEAD
        assertEquals(50, activity.getTotalDuration());
=======
        assertEquals("0.83", activity.getDurationString());
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
    }

    @Test
    public void calculateAverageVelocity()
    {
        activity.calculateTotalDistance();
        activity.calculateTotalDuration();
        activity.calculateAverageVelocity();
<<<<<<< HEAD
<<<<<<< HEAD
        assertEquals(3.55, activity.getAverageVelocity(), 0.01);
=======
        assertEquals("12.79", activity.getSpeedString());
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
=======
        assertEquals(1.78, activity.getAverageVelocity(), 0.01);
>>>>>>> 5065dd35... fixed 2 tests in ActivityTest
    }

    @Test
    public void calculateAverageHeartRate()
    {
        activity.calculateAverageHeartRate();
<<<<<<< HEAD
<<<<<<< HEAD
        assertEquals(85, activity.getAverageHeartRate());
=======
        assertEquals("85", activity.getHeartString());
<<<<<<< HEAD
>>>>>>> a30807bb... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
=======
>>>>>>> ff79906... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
<<<<<<< HEAD
>>>>>>> 9bd0c9a0... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
=======
        assertEquals(85, activity.getAverageHeartRate(), 0.01);
>>>>>>> c1f92832... Fixed a test case to fix the pipeline
=======
=======
        assertEquals(85, activity.getAverageHeartRate(), 0.01);
>>>>>>> 92ee04f... Fixed a test case to fix the pipeline
>>>>>>> a0057934... Fixed a test case to fix the pipeline
    }

    @Test
    public void getDurationMinutes()
    {
        assertEquals(0.83, activity.getDurationMins(), 1e-20);
    }

    @Test
    public void getSpeedKMH()
    {
        assertEquals(6.4, activity.getSpeedKMH(), 1e-20);
    }

    @Test
    public void getDistanceKM()
    {
        assertEquals(0.09, activity.getDistanceKM(), 1e-20);
    }

    @Test
    public void getEntryNo()
    {
        assertEquals(6, activity.getEntryno(), 1e-20);
    }

    @Test
    public void getHeartString()
    {
        assertEquals("85", activity.getHeartString());
    }

    @Test
    public void getTypeString()
    {
        assertEquals("Walk", activity.getTypeString());
    }

    @Test
    public void getTimeString()
    {
        assertEquals("30th, August, 2018 - 15:01:00", activity.getTimeString());
    }

}