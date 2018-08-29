package seng202.team10.Model.ActivitiesData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTimeTest {

    private DateTime janFirst = new DateTime(1, 1, 2018, 0, 0, 0);
    private DateTime janThirtieth = new DateTime(30, 1, 2018, 0, 0, 0);
    private DateTime janThirtyFirst = new DateTime(31, 1, 2018, 0, 0, 0);
    private DateTime febSecond = new DateTime(2, 2, 2018, 23, 59, 59);
    private DateTime febTwentySeventh = new DateTime(27, 2, 2018, 23, 59, 59);
    private DateTime febTwentyEighth = new DateTime(28, 2, 2018, 23, 59, 59);
    private DateTime febTwentyEighthLeap = new DateTime(28, 2, 2020, 23, 59, 59);
    private DateTime febTwentyNinthLeap = new DateTime(29, 2, 2024, 23, 59, 59);
    private DateTime marchThird = new DateTime(3, 3, 2018, 12, 30, 30);
    private DateTime aprilEleventh = new DateTime(11, 4, 2018, 0, 0, 0);
    private DateTime aprilTwentyNinth = new DateTime(29, 4, 2018, 0, 0, 0);
    private DateTime aprilThirtieth = new DateTime(30, 4, 2018, 0, 0, 0);
    private DateTime mayTwelfth = new DateTime(12, 5, 2018, 0, 0, 0);
    private DateTime juneThirteenth = new DateTime(13, 6, 2018, 0, 0, 0);
    private DateTime julyTwentyFirst = new DateTime(21, 7, 2018, 0, 0, 0);
    private DateTime augustTwentySecond = new DateTime(22, 8, 2018, 0, 0, 0);
    private DateTime septemberTwentyThird = new DateTime(23, 9, 2018, 0, 0, 0);
    private DateTime octoberFourth = new DateTime(4, 10, 2018, 0, 0, 0);
    private DateTime novemberTwentyFifth = new DateTime(25, 11, 2018, 0, 0, 0);
    private DateTime decemberSixteenth = new DateTime(16, 12, 2018, 0, 0, 0);
    private DateTime twoThousandYear = new DateTime(1,1,2000,0,0,0);
    private DateTime twoThousandOneYear = new DateTime(1,1,2001,0,0,0);
    private DateTime twoThousandNinetyNineYear = new DateTime(1,1,2099,0,0,0);
    private DateTime twoThousandOneHundredYear = new DateTime(1,1,2100,0,0,0);
    private DateTime zeroHour = new DateTime(1, 1, 2000, 0, 0, 0);
    private DateTime oneHour = new DateTime(1, 1, 2000, 1, 0, 0);
    private DateTime twentyTwoHour = new DateTime(1, 1, 2000, 22, 0, 0);
    private DateTime twentyThreeHour = new DateTime(1, 1, 2000, 23, 0, 0);
    private DateTime zeroMinute = new DateTime(1, 1, 2000, 0, 0, 0);
    private DateTime oneMinute = new DateTime(1, 1, 2000, 0, 1, 0);
    private DateTime fiftyEightMinute = new DateTime(1, 1, 2000, 0, 58, 0);
    private DateTime fiftyNineMinute = new DateTime(1, 1, 2000, 0, 59, 0);
    private DateTime zeroSecond = new DateTime(1, 1, 2000, 0, 0, 0);
    private DateTime oneSecond = new DateTime(1, 1, 2000, 0, 0, 1);
    private DateTime fiftyEightSecond = new DateTime(1, 1, 2000, 0, 0, 58);
    private DateTime fiftyNineSecond = new DateTime(1, 1, 2000, 0, 0, 59);
    private DateTime yearBefore = new DateTime(31, 12, 2000, 23, 59, 59);
    private DateTime yearAfter = new DateTime(1, 1, 2100, 0, 0, 0);
    private DateTime monthBefore = new DateTime(31, 1, 2000, 23, 59, 59);
    private DateTime monthAfter = new DateTime(1, 12, 2000, 0, 0, 0);
    private DateTime dayBefore = new DateTime(1, 1, 2000, 23, 59, 59);
    private DateTime dayAfter = new DateTime(31, 1, 2000, 0, 0, 0);
    private DateTime hourBefore = new DateTime(1, 1, 2000, 0, 59, 59);
    private DateTime hourAfter = new DateTime(1, 1, 2000, 23, 0, 0);
    private DateTime minuteBefore = new DateTime(1, 1, 2000, 0, 0, 59);
    private DateTime minuteAfter = new DateTime(1, 1, 2000, 0, 59, 0);
    private DateTime secondBefore = new DateTime(1, 1, 2000, 0, 0, 0);
    private DateTime secondAfter = new DateTime(1, 1, 2000, 0, 0, 59);



    @Test
    public void janFirstToString() {
        assertEquals("1st, January, 2018 - 00:00:00", janFirst.toString());
    }


    @Test
    public void febSecondToString() {
        assertEquals("2nd, February, 2018 - 23:59:59", febSecond.toString());
    }


    @Test
    public void marchThirdToString() {
        assertEquals("3rd, March, 2018 - 12:30:30", marchThird.toString());
    }


    @Test
    public void aprilEleventhToString() {
        assertEquals("11th, April, 2018 - 00:00:00", aprilEleventh.toString());
    }


    @Test
    public void mayTwelfthToString() {
        assertEquals("12th, May, 2018 - 00:00:00", mayTwelfth.toString());
    }


    @Test
    public void juneThirteenthToString() {
        assertEquals("13th, June, 2018 - 00:00:00", juneThirteenth.toString());
    }


    @Test
    public void julyTwentyFirstToString() {
        assertEquals("21st, July, 2018 - 00:00:00", julyTwentyFirst.toString());
    }


    @Test
    public void augustTwentySecondToString() {
        assertEquals("22nd, August, 2018 - 00:00:00", augustTwentySecond.toString());
    }


    @Test
    public void septemberTwentyThirdToString() {
        assertEquals("23rd, September, 2018 - 00:00:00", septemberTwentyThird.toString());
    }


    @Test
    public void octoberFourthToString() {
        assertEquals("4th, October, 2018 - 00:00:00", octoberFourth.toString());
    }


    @Test
    public void novemberTwentyFifthToString() {
        assertEquals("25th, November, 2018 - 00:00:00", novemberTwentyFifth.toString());
    }


    @Test
    public void decemberSixteenthToString() {
        assertEquals("16th, December, 2018 - 00:00:00", decemberSixteenth.toString());
    }


    @Test
    public void nineteenNinetyNineYear() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 1999, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Year parameter not valid!", message);
    }


    @Test
    public void twoThousandYear() {
        assertEquals(2000, twoThousandYear.getYear());
    }


    @Test
    public void twoThousandOneYear() {
        assertEquals(2001, twoThousandOneYear.getYear());
    }


    @Test
    public void twoThousandNinetyNineYear() {
        assertEquals(2099, twoThousandNinetyNineYear.getYear());
    }


    @Test
    public void twoThousandOneHundredYear() {
        assertEquals(2100, twoThousandOneHundredYear.getYear());
    }


    @Test
    public void twoThousandOneHundredOneYear() {
        String message = "Test failed";
        try {
            new DateTime(1, 1, 2101, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Year parameter not valid!", message);
    }


    @Test
    public void zeroMonth() {
        String message = "Test failed";
        try {
            new DateTime(1, 0, 2000, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Month parameter not valid!", message);
    }


    @Test
    public void thirteenthMonth() {
        String message = "Test failed";
        try {
            new DateTime(1, 13, 2000, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Month parameter not valid!", message);
    }


    @Test
    public void negativeDay() {
        String message = "Test failed";
        try {
            new DateTime(-1, 1, 2000, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!", message);
    }


    @Test
    public void zeroDay() {
        String message = "Test Failed";
        try {
            new DateTime(0, 1, 2000, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!", message);
    }


    @Test
    public void firstDay() {
        assertEquals(1, janFirst.getDay());
    }


    @Test
    public void secondDay() {
        assertEquals(2, febSecond.getDay());
    }


    @Test
    public void janThirtiethDay() {
        assertEquals(30, janThirtieth.getDay());
    }


    @Test
    public void janThirtyFirstDay() {
        assertEquals(31, janThirtyFirst.getDay());
    }


    @Test
    public void janThirtySecondDay() {
        String message = "Test Failed";
        try {
            new DateTime(32, 1, 2018, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!", message);
    }


    @Test
    public void febTwentySeventhDay() {
        assertEquals(27, febTwentySeventh.getDay());
    }


    @Test
    public void febTwentyEighthDay() {
        assertEquals(28, febTwentyEighth.getDay());
    }


    @Test
    public void febTwentyNinthDay() {
        String message = "Test Failed";
        try {
            new DateTime(29, 2, 2018, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!", message);
    }


    @Test
    public void febTwentyEighthLeapDay() {
        assertEquals(28, febTwentyEighthLeap.getDay());
    }


    @Test
    public void febTwentyNinthLeapDay() {
        assertEquals(29, febTwentyNinthLeap.getDay());
    }


    @Test
    public void febThirtiethLeapDay() {
        String message = "Test Failed";
        try {
            new DateTime(31, 2, 2020, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!", message);
    }


    @Test
    public void aprilTwentyNinthDay() {
        assertEquals(29, aprilTwentyNinth.getDay());
    }


    @Test
    public void aprilThirtiethDay() {
        assertEquals(30, aprilThirtieth.getDay());
    }


    @Test
    public void aprilThirtyFirstDay() {
        String message = "Test Failed";
        try {
            new DateTime(31, 4, 2018, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!", message);
    }


    @Test
    public void negativeHour() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 2000, -1, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Hour parameter not valid!", message);
    }


    @Test
    public void zeroHour() {
        assertEquals(0, zeroHour.getHour());
    }


    @Test
    public void oneHour() {
        assertEquals(1, oneHour.getHour());
    }


    @Test
    public void twentyTwoHour() {
        assertEquals(22, twentyTwoHour.getHour());
    }


    @Test
    public void twentyThreeHour() {
        assertEquals(23, twentyThreeHour.getHour());
    }


    @Test
    public void twentyFourthHour() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 2000, 24, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Hour parameter not valid!", message);
    }


    @Test
    public void negativeMinute() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 2000, 0, -1, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Minute parameter not valid!", message);
    }


    @Test
    public void zeroMinute() {
        assertEquals(0, zeroMinute.getMinute());
    }


    @Test
    public void oneMinute() {
        assertEquals(1, oneMinute.getMinute());
    }


    @Test
    public void fiftyEightMinute() {
        assertEquals(58, fiftyEightMinute.getMinute());
    }


    @Test
    public void fiftyNineMinute() {
        assertEquals(59, fiftyNineMinute.getMinute());
    }


    @Test
    public void sixtyMinute() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 2000, 0, 60, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Minute parameter not valid!", message);
    }


    @Test
    public void negativeSecond() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 2000, 0, 0, -1);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Second parameter not valid!", message);
    }


    @Test
    public void zeroSecond() {
        assertEquals(0, zeroSecond.getSecond());
    }


    @Test
    public void oneSecond() {
        assertEquals(1, oneSecond.getSecond());
    }


    @Test
    public void fiftyEightSecond() {
        assertEquals(58, fiftyEightSecond.getSecond());
    }


    @Test
    public void fiftyNineSecond() {
        assertEquals(59, fiftyNineSecond.getSecond());
    }


    @Test
    public void sixtySecond() {
        String message = "Test Failed";
        try {
            new DateTime(1, 1, 2000, 0, 0, 60);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Second parameter not valid!", message);
    }


    @Test
    public void isBeforeYear() {
        assertTrue(yearBefore.isBefore(yearAfter));
    }


    @Test
    public void isBeforeMonth() {
        assertTrue(monthBefore.isBefore(monthAfter));
    }


    @Test
    public void isBeforeDay() {
        assertTrue(dayBefore.isBefore(dayAfter));
    }


    @Test
    public void isBeforeHour() {
        assertTrue(hourBefore.isBefore(hourAfter));
    }


    @Test
    public void isBeforeMinute() {
        assertTrue(minuteBefore.isBefore(minuteAfter));
    }


    @Test
    public void isBeforeSecond() {
        assertTrue(secondBefore.isBefore(secondAfter));
    }


    @Test
    public void isNotBeforeYear() {
        assertFalse(yearAfter.isBefore(yearBefore));
    }


    @Test
    public void isNotBeforeMonth() {
        assertFalse(monthAfter.isBefore(monthBefore));
    }


    @Test
    public void isNotBeforeDay() {
        assertFalse(dayAfter.isBefore(dayBefore));
    }


    @Test
    public void isNotBeforeHour() {
        assertFalse(hourAfter.isBefore(hourBefore));
    }


    @Test
    public void isNotBeforeMinute() {
        assertFalse(minuteAfter.isBefore(minuteBefore));
    }


    @Test
    public void isNotBeforeSecond() {
        assertFalse(secondAfter.isBefore(secondBefore));
    }


    @Test
    public void isAfterYear() {
        assertTrue(yearAfter.isAfter(yearBefore));
    }


    @Test
    public void isAfterMonth() {
        assertTrue(monthAfter.isAfter(monthBefore));
    }


    @Test
    public void isAfterDay() {
        assertTrue(dayAfter.isAfter(dayBefore));
    }


    @Test
    public void isAfterHour() {
        assertTrue(hourAfter.isAfter(hourBefore));
    }


    @Test
    public void isAfterMinute() {
        assertTrue(minuteAfter.isAfter(minuteBefore));
    }


    @Test
    public void isAfterSecond() {
        assertTrue(secondAfter.isAfter(secondBefore));
    }


    @Test
    public void isNotAfterYear() {
        assertFalse(yearBefore.isAfter(yearAfter));
    }


    @Test
    public void isNotAfterMonth() {
        assertFalse(monthBefore.isAfter(monthAfter));
    }


    @Test
    public void isNotAfterDay() {
        assertFalse(dayBefore.isAfter(dayAfter));
    }


    @Test
    public void isNotAfterHour() {
        assertFalse(hourBefore.isAfter(hourAfter));
    }


    @Test
    public void isNotAfterMinute() {
        assertFalse(minuteBefore.isAfter(minuteAfter));
    }


    @Test
    public void isNotAfterSecond() {
        assertFalse(secondBefore.isAfter(secondAfter));
    }


    @Test
    public void isEqual() {
        assertTrue(zeroHour.isEqual(new DateTime(1, 1, 2000, 0, 0, 0)));
    }


    @Test
    public void isNotEqualYear() {
        assertFalse(zeroHour.isEqual(new DateTime(1, 1, 2001, 0, 0, 0)));
    }



    @Test
    public void isNotEqualMonth() {
        assertFalse(zeroHour.isEqual(new DateTime(1, 2, 2000, 0, 0, 0)));
    }


    @Test
    public void isNotEqualDay() {
        assertFalse(zeroHour.isEqual(new DateTime(2, 1, 2000, 0, 0, 0)));
    }


    @Test
    public void isNotEqualHour() {
        assertFalse(zeroHour.isEqual(new DateTime(1, 1, 2000, 1, 0, 0)));
    }


    @Test
    public void isNotEqualMinute() {
        assertFalse(zeroHour.isEqual(new DateTime(1, 1, 2000, 0, 1, 0)));
    }


    @Test
    public void isNotEqualSecond() {
        assertFalse(zeroHour.isEqual(new DateTime(1, 1, 2000, 0, 0, 1)));
    }
}