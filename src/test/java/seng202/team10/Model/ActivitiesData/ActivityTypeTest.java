package seng202.team10.Model.ActivitiesData;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityTypeTest {

    @Test
    public void determineTypeWalk()
    {
        assertEquals(ActivityType.WALK, ActivityType.determineType("WALK up the wall"));
    }

    @Test
    public void determineTypeRun1()
    {
        assertEquals(ActivityType.RUN, ActivityType.determineType("Run up the wall"));
    }

    @Test
    public void determineTypeRun2()
    {
        assertEquals(ActivityType.RUN, ActivityType.determineType("JoG up the wall"));
    }

    @Test
    public void determineTypeRun3()
    {
        assertEquals(ActivityType.RUN, ActivityType.determineType("RuNNiNg up the wall"));
    }

    @Test
    public void determineTypeRun4()
    {
        assertEquals(ActivityType.RUN, ActivityType.determineType("jogging up the wall"));
    }

    @Test
    public void determineTypeHike1()
    {
        assertEquals(ActivityType.HIKE, ActivityType.determineType("hIKE down the valley"));
    }

    @Test
    public void determineTypeHike2()
    {
        assertEquals(ActivityType.HIKE, ActivityType.determineType("hiKiNg around the world"));
    }

    @Test
    public void determineTypeCycle1()
    {
        assertEquals(ActivityType.CYCLE, ActivityType.determineType("CyCle up the wall"));
    }

    @Test
    public void determineTypeCycle2()
    {
        assertEquals(ActivityType.CYCLE, ActivityType.determineType("CYCLING up the wall"));
    }

    @Test
    public void determineTypeCycle3()
    {
        assertEquals(ActivityType.CYCLE, ActivityType.determineType("BIKE up the wall"));
    }

    @Test
    public void determineTypeCycle4()
    {
        assertEquals(ActivityType.CYCLE, ActivityType.determineType("BIKING up the wall"));
    }

    @Test
    public void determineTypeSwim()
    {
        assertEquals(ActivityType.SWIM, ActivityType.determineType("SWIM up the wall"));
    }

    @Test
    public void determineTypeWorkOut1()
    {
        assertEquals(ActivityType.WORKOUT, ActivityType.determineType("WorkOut up the wall"));
    }

    @Test
    public void determineTypeWorkOut2()
    {
        assertEquals(ActivityType.WORKOUT, ActivityType.determineType("Work Out up the wall"));
    }

    @Test
    public void determineTypeWorkOut3()
    {
        assertEquals(ActivityType.WORKOUT, ActivityType.determineType("Working Out up the wall"));
    }

    @Test
    public void determineTypeOther1()
    {
        assertEquals(ActivityType.OTHER, ActivityType.determineType("Any String"));
    }

    @Test
    public void determineTypeOther2()
    {
        assertEquals(ActivityType.OTHER, ActivityType.determineType(""));
    }

    @Test
    public void determineTypeMulti1()
    {
        assertEquals(ActivityType.HIKE, ActivityType.determineType("SWIM/HIKE up the wall"));
    }

    @Test
    public void determineTypeMulti2()
    {
        assertEquals(ActivityType.SWIM, ActivityType.determineType("RUN/SWIM up the wall"));
    }

    @Test
    public void determineTypeMulti3()
    {
        assertEquals(ActivityType.RUN, ActivityType.determineType("CYCLE/RUN up the wall"));
    }

    @Test
    public void determineTypeMulti4()
    {
        assertEquals(ActivityType.CYCLE, ActivityType.determineType("WORKOUT/CYCLE up the wall"));
    }

    @Test
    public void determineTypeMulti5()
    {
        assertEquals(ActivityType.WORKOUT, ActivityType.determineType("WALK/WORKOUT up the wall"));
    }

    @Test
    public void determineTypeMulti6()
    {
        assertEquals(ActivityType.HIKE, ActivityType.determineType("WALK/HIKE up the wall"));
    }
}