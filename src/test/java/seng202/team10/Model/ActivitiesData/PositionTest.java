package seng202.team10.Model.ActivitiesData;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {


    @Test
    public void badHighLatitude()
    {
        String message = "Nothing";
        try {
            new Position(90.000001, 0.0, 0.0);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Latitude Invalid, must be between -90 & 90", message);
    }


    @Test
    public void badLowLatitude()
    {
        String message = "Nothing";
        try {
            new Position(-90.000001, 0.0, 0.0);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Latitude Invalid, must be between -90 & 90", message);
    }


    @Test
    public void badHighLongitude()
    {
        String message = "Nothing";
        try {
            new Position(0.0, 180.000001, 0.0);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Longitude Invalid, must be between -180 & 180", message);
    }


    @Test
    public void badLowLongitude()
    {
        String message = "Nothing";
        try {
            new Position(0.0, -180.000001, 0.0);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Longitude Invalid, must be between -180 & 180", message);
    }


    @Test
    public void badHighElevation()
    {
        String message = "Nothing";
        try {
            new Position(0.0, 0.0, 8850.000001);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Elevation Invalid, must be above 430 meters below sea level and below 8850 meters above sea level", message);
    }


    @Test
    public void badLowElevation()
    {
        String message = "Nothing";
        try {
            new Position(0.0, 0.0, -430.000001);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Elevation Invalid, must be above 430 meters below sea level and below 8850 meters above sea level", message);
    }


    @Test
    public void goodHighLatitude()
    {
        Position testPosition = new Position(89.999999, 0.0, 0.0);
        assertEquals(89.999999, testPosition.getLatitude(), 1.0E-6);
    }


    @Test
    public void goodLowLatitude()
    {
        Position testPosition = new Position(-89.999999, 0.0, 0.0);
        assertEquals(-89.999999, testPosition.getLatitude(), 1.0E-6);
    }


    @Test
    public void goodHighLongitude()
    {
        Position testPosition = new Position(0.0, 179.999999, 0.0);
        assertEquals(179.999999, testPosition.getLongitude(), 1.0E-6);
    }


    @Test
    public void goodLowLongitude()
    {
        Position testPosition = new Position(0.0, -179.999999, 0.0);
        assertEquals(-179.999999, testPosition.getLongitude(), 1.0E-6);
    }


    @Test
    public void goodHighElevation()
    {
        Position testPosition = new Position(0.0, 0.0, 8849.999999);
        assertEquals(8849.999999, testPosition.getElevation(), 1.0E-6);
    }


    @Test
    public void goodLowElevation()
    {
        Position testPosition = new Position(0.0, 0.0, -429.999999);
        assertEquals(-429.999999, testPosition.getElevation(), 1.0E-6);
    }

    @Test
    public void subtract() {
        Position position1 = new Position(30.2553368,-97.83891084,239.5);
        Position position2 = new Position(30.25499189,-97.83913958,239);
        assertEquals(0.044,position2.subtract(position1)/1000, 1e-2);
    }

    @Test
    public void negSubtract() {

        Position position1 = new Position(30.2553368,-97.83891084,239.5);
        Position position2 = new Position(30.25499189,-97.83913958,239);
        assertEquals(0.044, position1.subtract(position2)/1000, 1e-2);
    }

    @Test
    public void toStringTest() {
        Position position1 = new Position(30.2553368,-97.83891084,239.5);
        String string = "Latitude: 30.2553368, Longitude: -97.83891084, Elevation: 239.5";
        assertEquals(string, position1.toString());
    }

}