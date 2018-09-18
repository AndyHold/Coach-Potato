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
    public void addEntry()
    {
        int initialSize = activity.getEntries().size();
        Entry newEntry = new Entry(new DateTime(2000, 1, 1, 0, 0, 0), 120, new Position(0.0, 0.0, 0.0));
        newEntry.setFirstEntry(false);
        activity.addEntry(newEntry);
        activity.postEntriesSetUp();
        assertEquals(initialSize + 1, activity.getEntries().size());
    }


//    @Test
//    public void calculateTotalDistance()
//    {
//        activity.calculateTotalDistance();
//        assertEquals(0.023865612348432826, activity.getTotalDistance(), 1.0E-18);
//    }


    @Test
    public void calculateTotalDuration()
    {
        activity.calculateTotalDuration();
        assertEquals(50, activity.getTotalDuration());
    }

//    @Test
//    public void calculateAverageVelocity()
//    {
//        activity.calculateTotalDistance();
//        activity.calculateTotalDuration();
//        activity.calculateAverageVelocity();
//        assertEquals(4.773122469686565E-4, activity.getAverageVelocity(), 1.0E-19);
//    }

    @Test
    public void calculateAverageHeartRate()
    {
        activity.calculateAverageHeartRate();
        assertEquals(85.0, activity.getAverageHeartRate(), 1.0E-19);
    }
}