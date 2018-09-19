package seng202.team10.Model.ActivitiesData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntryTest {


    private DateTime testTime;
    private Position testPosition;
    private Entry testEntry;



    @Before
    public void setUp()
    {
        testTime = new DateTime(2018, 9, 19, 20, 50, 0);
        testPosition = new Position(0.0, 0.0, 0.0);
        testEntry = new Entry(testTime, 100, testPosition);
    }
    //---------------------------Tests for the constructor:----------------------------
    @Test
    public void badHeartRateLow()
    {
        String message = "Test Failed!";
        try {
            Entry testEntry = new Entry(testTime, 0, testPosition);
        } catch (IllegalArgumentException exception) {
            message = exception.getMessage();
        }
        assertEquals("Heart Rate Invalid, must be between 1 & 300", message);
    }


    @Test
    public void badHeartRateHigh()
    {
        String message = "Test Failed!";
        try {
            Entry testEntry = new Entry(testTime, 301, testPosition);
        } catch (IllegalArgumentException exception) {
            message = exception.getMessage();
        }
        assertEquals("Heart Rate Invalid, must be between 1 & 300", message);
    }


    @Test
    public void goodHeartRateLow()
    {
        Entry testEntry = new Entry(testTime, 1, testPosition);
        assertEquals(1, testEntry.getHeartRate());
    }


    @Test
    public void goodHeartRateHigh()
    {
        Entry testEntry = new Entry(testTime, 300, testPosition);
        assertEquals(300, testEntry.getHeartRate());
    }


    //-----------------------------------Tests for calculators------------------


    @Test
    public void calculateDistance()
    {
        testEntry.calculateDistance(new Entry(testTime, 1, new Position(1.0, 1.0, 0.0)));
        assertEquals("157249.38", testEntry.getDistanceString());
    }


    @Test
    public void calculateDistanceReverse()
    {
        Entry otherTestEntry = new Entry(testTime, 1, new Position(1.0, 1.0, 0.0));
        otherTestEntry.calculateDistance(testEntry);
        assertEquals("157249.38", otherTestEntry.getDistanceString());
    }


    @Test
    public void calculateVelocity()
    {
        Entry otherTestEntry = new Entry(new DateTime(2018, 9, 19, 20, 20, 0), 1, new Position(1.0, 1.0, 0.0));
        testEntry.calculateDistance(otherTestEntry);
        testEntry.calculateVelocity(otherTestEntry);
        assertEquals("87.36", testEntry.getVelocityString());
    }


    @Test
    public void calculateVelocityReverse()
    {
        Entry otherTestEntry = new Entry(new DateTime(2018, 9, 19, 20, 20, 0), 1, new Position(1.0, 1.0, 0.0));
        otherTestEntry.calculateDistance(testEntry);
        otherTestEntry.calculateVelocity(testEntry);
        assertEquals("-87.36", otherTestEntry.getVelocityString());
    }


    //---------------------------Tests for change methods----------------


    @Test
    public void changeDateBadFormat1()
    {
        boolean caught = false;
        try {
            testEntry.changeDate("02/03");
        } catch (ArrayIndexOutOfBoundsException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeDateBadFormat2()
    {
        boolean caught = false;
        try {
            testEntry.changeDate("02MMYYYY");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeDateBadDay()
    {
        boolean caught = false;
        try {
            testEntry.changeDate("DD/01/2018");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeDateBadMonth()
    {
        boolean caught = false;
        try {
            testEntry.changeDate("01/MM/2018");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeDateBadYear()
    {
        boolean caught = false;
        try {
            testEntry.changeDate("01/01/YYYY");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeDateGoodDate()
    {
        testEntry.changeDate("01/01/2018");
        assertEquals("01/01/2018", testEntry.getDateString());
    }


    @Test
    public void changeTimeBadFormat1()
    {
        boolean caught = false;
        try {
            testEntry.changeTime("02:03");
        } catch (ArrayIndexOutOfBoundsException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeTimeBadFormat2()
    {
        boolean caught = false;
        try {
            testEntry.changeTime("02MMSS");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeTimeBadHour()
    {
        boolean caught = false;
        try {
            testEntry.changeTime("HH:00:00");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeTimeBadMinute()
    {
        boolean caught = false;
        try {
            testEntry.changeTime("00:MM:00");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeTimeBadSecond()
    {
        boolean caught = false;
        try {
            testEntry.changeTime("00:00:SS");
        } catch (NumberFormatException exception) {
            caught = true;
        }
        assertTrue(caught);
    }


    @Test
    public void changeTimeGoodTime()
    {
        testEntry.changeTime("00:00:00");
        assertEquals("00:00:00", testEntry.getTimeString());
    }


    //---------------------------Tests for getString() methods----------------------


    @Test
    public void getLatitudeString()
    {
        assertEquals("0.000000", testEntry.getLatitudeString());
    }


    @Test
    public void getLongitudeString()
    {
        assertEquals("0.000000", testEntry.getLongitudeString());
    }


    @Test
    public void getElevationString()
    {
        assertEquals("0.00", testEntry.getElevationString());
    }




//    Position position1 = new Position(0,0,0);
//    DateTime time1 = new DateTime(2018,1,1, 0,0,0);
//    Entry entry1 = new Entry(true, time1, 140, position1);
//
//    Position position2 = new Position(1,2,3);
//    DateTime time2 = new DateTime(2018,1,1, 0,1,0);
//    Entry entry2 = new Entry(false, time2, 140, position2);
//
//    @Test
//    public void calculateDistance() {
//        entry2.calculateDistance(entry1);
//        assertTrue(entry2.getDistance() == Math.sqrt(14));
//    }
//
//    @Test
//    public void calculateVelocity() {
//        entry2.calculateDistance(entry1);
//        entry2.calculateVelocity(entry1);
//        assertEquals(Math.sqrt(14)/60, entry2.getVelocity(), 0.001);
//    }
}