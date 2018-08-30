package seng202.team10.Model.ActivitiesData;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntryTest {

    Position position1 = new Position(0,0,0);
    DateTime time1 = new DateTime(2018,1,1, 0,0,0);
    Entry entry1 = new Entry(true, time1, 140, position1);

    Position position2 = new Position(1,2,3);
    DateTime time2 = new DateTime(2018,1,1, 0,1,0);
    Entry entry2 = new Entry(false, time2, 140, position2);

    @Test
    public void calculateDistance() {
        entry2.calculateDistance(entry1);
        assertTrue(entry2.getDistance() == Math.sqrt(14));
    }

    @Test
    public void calculateVelocity() {
        entry2.calculateDistance(entry1);
        entry2.calculateVelocity(entry1);
        assertEquals(Math.sqrt(14)/60, entry2.getVelocity(), 0.001);
    }
}