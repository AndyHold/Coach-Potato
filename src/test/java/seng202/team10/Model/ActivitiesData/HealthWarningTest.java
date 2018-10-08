package seng202.team10.Model.ActivitiesData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class HealthWarningTest {


    HealthWarning tachycardia;
    HealthWarning bradycardia;
    HealthWarning cardiovascularMortality;
    DateTime now;


    @Before
    public void setUp()
    {
        now = DateTime.now();
        tachycardia = new HealthWarning(HealthWarningType.TACHYCARDIA, "Test Activity", now);
        bradycardia = new HealthWarning(HealthWarningType.BRADYCARDIA, "Test Activity", now);
        cardiovascularMortality = new HealthWarning(HealthWarningType.CARDIOVASCULAR_MORTALITY, "Test Activity", now);
    }


    @After
    public void tearDown()
    {
        now = null;
        tachycardia = null;
        bradycardia = null;
        cardiovascularMortality = null;
    }


    //----------------------------------------------Tachycardia tests---------------------------------------------------
    @Test
    public void addWarningAllGood()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, false, 85, 21);
        assertTrue(warnings.isEmpty());
    }


    @Test
    public void addWarningNoTachycardiaUnderSeven()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 133, 7);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaUnderSeven()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 134, 7);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningNoTachycardiaEight()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 130, 8);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaEight()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 131, 8);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningNoTachycardiaEleven()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 130, 11);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaEleven()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 131, 11);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningNoTachycardiaTwelve()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 119, 12);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaTwelve()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 120, 12);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningNoTachycardiaFifteen()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 119, 15);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaFifteen()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 120, 15);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningNoTachycardiaSixteen()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 100, 16);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaSixteen()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 101, 16);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningNoTachycardiaOld()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 100, 112);
        assertFalse(warnings.contains(HealthWarningType.TACHYCARDIA));
    }


    @Test
    public void addWarningTachycardiaOld()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 101, 112);
        assertTrue(warnings.contains(HealthWarningType.TACHYCARDIA));
    }

    //----------------------------------------------Bradycardia tests---------------------------------------------------


    @Test
    public void addWarningNoBradycardiaFirstEntry()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 60, 20);
        assertFalse(warnings.contains(HealthWarningType.BRADYCARDIA));
    }


    @Test
    public void addWarningBradycardiaFirstEntry()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, true, 59, 20);
        assertTrue(warnings.contains(HealthWarningType.BRADYCARDIA));
    }


    @Test
    public void addWarningNoBradycardia()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, false, 60, 20);
        assertFalse(warnings.contains(HealthWarningType.BRADYCARDIA));
    }


    @Test
    public void addWarningBradycardia()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.RUN, false, 59, 20);
        assertTrue(warnings.contains(HealthWarningType.BRADYCARDIA));
    }

    //----------------------------------------------Cardiovascular Mortality tests---------------------------------------------------


    @Test
    public void addWarningNoCardioVascularYoung()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.WALK, false, 214, 6);
        assertFalse(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningCardioVascularYoung()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.WALK, false, 215, 6);
        assertTrue(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningNoCardioVascularOld()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.WALK, false, 108, 112);
        assertFalse(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningCardioVascularOld()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.WALK, false, 109, 113);
        assertTrue(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningNoCardioVascularWorkout()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.WORKOUT, false, 108, 112);
        assertFalse(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningCardioVascularWorkout()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.WORKOUT, false, 109, 113);
        assertTrue(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningNoCardioVascularHike()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.HIKE, false, 108, 112);
        assertFalse(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningCardioVascularHike()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.HIKE, false, 109, 113);
        assertTrue(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningNoCardioVascularOther()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.OTHER, false, 108, 112);
        assertFalse(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    @Test
    public void addWarningCardioVascularOther()
    {
        Set<HealthWarningType> warnings = HealthWarning.addWarning(ActivityType.OTHER, false, 109, 113);
        assertTrue(warnings.contains(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    //----------------------------------------------Constructor tests---------------------------------------------------


    @Test
    public void constructorTachycardiaName()
    {
        assertEquals("Tachycardia" ,tachycardia.getName());
    }


    @Test
    public void constructorTachycardiaActivityName()
    {
        assertEquals("Test Activity" ,tachycardia.getActivityName());
    }


    @Test
    public void constructorTachycardiaURL()
    {
        assertEquals("https://www.google.co.nz/search?ei=9I-uW4XRHc_X-Qae4ZOoDg&q=tachycardia&oq=tachycardia&gs_l=psy-ab.4..0i67k1l9j0.2429.2836.0.3438.2.2.0.0.0.0.202.402.2-2.2.0....0...1c.1.64.psy-ab..0.2.402....0.5kH3TaeveXI" , tachycardia.getType().getURL());
    }


    @Test
    public void constructorTachycardiaType()
    {
        assertEquals(HealthWarningType.TACHYCARDIA , tachycardia.getType());
    }


    @Test
    public void constructorTachycardiaDate()
    {
        assertTrue(tachycardia.getActivityDate().isEqual(now));
    }


    @Test
    public void constructorBradycardiaName()
    {
        assertEquals("Bradycardia" ,bradycardia.getName());
    }


    @Test
    public void constructorBradycardiaActivityName()
    {
        assertEquals("Test Activity" ,bradycardia.getActivityName());
    }


    @Test
    public void constructorBradycardiaURL()
    {
        assertEquals("https://www.google.co.nz/search?ei=-I-uW6j7PNLT-QbK95-oDA&q=bradycardia&oq=br&gs_l=psy-ab.3.0.0i67k1l8j0j0i67k1.223410.223552.0.225128.2.2.0.0.0.0.340.340.3-1.1.0....0...1c.1.64.psy-ab..1.1.340....0.Gc5VgwHgisc" , bradycardia.getType().getURL());
    }


    @Test
    public void constructorBradycardiaType()
    {
        assertEquals(HealthWarningType.BRADYCARDIA , bradycardia.getType());
    }


    @Test
    public void constructorBradycardiaDate()
    {
        assertTrue(bradycardia.getActivityDate().isEqual(now));
    }


    @Test
    public void constructorCardiovascularMortalityName()
    {
        assertEquals("Cardiovascular Mortality" ,cardiovascularMortality.getName());
    }


    @Test
    public void constructorCardiovascularMortalityActivityName()
    {
        assertEquals("Test Activity" ,cardiovascularMortality.getActivityName());
    }


    @Test
    public void constructorCardiovascularMortalityURL()
    {
        assertEquals("https://www.google.co.nz/search?ei=2pCuW8G_Osek-QaFh7GQDA&q=cardiovascular+mortality&oq=cardiovascular+mor&gs_l=psy-ab.3.0.0l10.28798.42260.0.43509.22.20.2.0.0.0.308.3167.0j2j11j1.14.0....0...1c.1.64.psy-ab..11.11.1971...0i67k1j0i131i67k1j0i22i30k1.0.H1lNS_Hbb7A" , cardiovascularMortality.getType().getURL());
    }


    @Test
    public void constructorCardiovascularMortalityType()
    {
        assertEquals(HealthWarningType.CARDIOVASCULAR_MORTALITY , cardiovascularMortality.getType());
    }


    @Test
    public void constructorCardiovascularMortalityDate()
    {
        assertTrue(cardiovascularMortality.getActivityDate().isEqual(now));
    }
}