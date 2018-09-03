package seng202.team10.Model.ActivitiesData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityTest {


    private DateTime startDateTime = new DateTime(2018, 8, 30, 15, 1, 0);
    private Position firstPosition = new Position(-43.5222767, 172.5809189, 14.000);
    private Entry firstEntry = new Entry(true, startDateTime, 60.0, firstPosition);
    private DateTime secondDateTime = new DateTime(2018, 8, 30, 15, 1, 10);
    private Position secondPosition = new Position(-43.5221523, 172.5810262, 14.000);
    private Entry secondEntry = new Entry(false, secondDateTime, 70, secondPosition);
    private DateTime thirdDateTime = new DateTime(2018, 8, 30, 15, 1, 20);
    private Position thirdPosition = new Position(-43.5219967, 172.5811335, 14.000);
    private Entry thirdEntry = new Entry(false, thirdDateTime, 80.0, thirdPosition);
    private DateTime fourthDateTime = new DateTime(2018, 8, 30, 15, 1, 30);
    private Position fourthPosition = new Position(-43.5218722, 172.5812408, 14.000);
    private Entry fourthEntry = new Entry(false, fourthDateTime, 90.0, fourthPosition);
    private DateTime fifthDateTime = new DateTime(2018, 8, 30, 15, 1, 40);
    private Position fifthPosition = new Position(-43.5217010, 172.5813481, 14.000);
    private Entry fifthEntry = new Entry(false, fifthDateTime, 100.0, fifthPosition);
    private DateTime sixthDateTime = new DateTime(2018, 8, 30, 15, 1, 50);
    private Position sixthPosition = new Position(-43.5215921, 172.5814768, 14.000);
    private Entry sixthEntry = new Entry(false, sixthDateTime, 110.0, sixthPosition);
    private Activity activity = new Activity("testActivity", startDateTime);


    @Before
    public void setUp() {
        activity.addEntry(firstEntry);
        activity.addEntry(secondEntry);
        activity.addEntry(thirdEntry);
        activity.addEntry(fourthEntry);
        activity.addEntry(fifthEntry);
        activity.addEntry(sixthEntry);
    }


    @Test
    public void addEntry() {
        int initialSize = activity.getEntries().size();
        activity.addEntry(new Entry(false, new DateTime(2000, 1, 1, 0, 0, 0), 120, new Position(0.0, 0.0, 0.0)));
        assertEquals(initialSize + 1, activity.getEntries().size());
    }


    @Test
    public void calculateTotalDistance() {
        activity.calculateTotalDistance();
        assertEquals(0.0008882871265815719, activity.getTotalDistance(), 1.0E-19);
    }


    @Test
    public void calculateTotalDuration() {
        activity.calculateTotalDuration();
        assertEquals(50, activity.getTotalDuration());
    }

    @Test
    public void calculateAverageVelocity() {
        activity.calculateTotalDistance();
        activity.calculateTotalDuration();
        activity.calculateAverageVelocity();
        assertEquals(0.000017765742531631437, activity.getAverageVelocity(), 1.0E-19);
    }

    @Test
    public void calculateAverageHeartRate() {
        activity.calculateAverageHeartRate();
        assertEquals(85.0, activity.getAverageHeartRate(), 1.0E-19);
    }

    @Test
    public void determineType1() {
        activity.determineType();
        assertEquals("other", activity.getType());
    }

    @Test
    public void determineType2() {
        activity.setName("cycling with mates");
        activity.determineType();
        assertEquals("cycle", activity.getType());
    }

}