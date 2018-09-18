package seng202.team10.Model.ActivitiesData;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeTest {

    private DateTime janFirst = new DateTime(2018, 1, 1, 10, 30, 10);
    private DateTime janThirtieth = new DateTime(2018, 1, 30, 0, 0, 0);
    private DateTime janThirtyFirst = new DateTime(2018, 1, 31, 5, 15, 20);
    private DateTime febSecond = new DateTime(2018, 2, 2, 23, 59, 59);
    private DateTime febTwentySeventh = new DateTime(2018, 2, 27, 23, 59, 59);
    private DateTime febTwentyEighth = new DateTime(2018, 2, 28, 23, 59, 59);
    private DateTime febTwentyEighthLeap = new DateTime(2020, 2, 28, 23, 59, 59);
    private DateTime febTwentyNinthLeap = new DateTime(2024, 2, 29, 23, 59, 59);
    private DateTime marchThird = new DateTime(2020, 3, 3, 12, 30, 30);
    private DateTime aprilEleventh = new DateTime(2018, 4, 11, 0, 0, 0);
    private DateTime aprilTwentyNinth = new DateTime(2018, 4, 29, 0, 0, 0);
    private DateTime aprilThirtieth = new DateTime(2018, 4, 30, 0, 0, 0);
    private DateTime mayTwelfth = new DateTime(2018, 5, 12, 0, 0, 0);
    private DateTime juneThirteenth = new DateTime(2018, 6, 13, 0, 0, 0);
    private DateTime julyTwentyFirst = new DateTime(2018, 7, 21, 0, 0, 0);
    private DateTime augustTwentySecond = new DateTime(2018, 8, 22, 0, 0, 0);
    private DateTime septemberTwentyThird = new DateTime(2018, 9, 23, 0, 0, 0);
    private DateTime octoberFourth = new DateTime(2018, 10, 4, 0, 0, 0);
    private DateTime novemberTwentyFifth = new DateTime(2018, 11, 25, 0, 0, 0);
    private DateTime decemberSixteenth = new DateTime(2017, 12, 16, 0, 0, 0);
    private DateTime nineteenHundredYear = new DateTime(1900,1,1,0,0,0);
    private DateTime nineteenHundredOneYear = new DateTime(1901,1,1,0,0,0);
    private DateTime twoThousandNinetyNineYear = new DateTime(2099,1,1,0,0,0);
    private DateTime twoThousandOneHundredYear = new DateTime(2100,1,1,0,0,0);
    private DateTime zeroHour = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime oneHour = new DateTime(2000, 1, 1, 1, 0, 0);
    private DateTime twentyTwoHour = new DateTime(2000, 1, 1, 22, 0, 0);
    private DateTime twentyThreeHour = new DateTime(2000, 1, 1, 23, 0, 0);
    private DateTime zeroMinute = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime oneMinute = new DateTime(2000, 1, 1, 0, 1, 0);
    private DateTime fiftyEightMinute = new DateTime(2000, 1, 1, 0, 58, 0);
    private DateTime fiftyNineMinute = new DateTime(2000, 1, 1, 0, 59, 0);
    private DateTime zeroSecond = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime oneSecond = new DateTime(2000, 1, 1, 0, 0, 1);
    private DateTime fiftyEightSecond = new DateTime(2000, 1, 1, 0, 0, 58);
    private DateTime fiftyNineSecond = new DateTime(2000, 1, 1, 0, 0, 59);
    private DateTime yearBefore = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime yearAfter = new DateTime(2100, 1, 1, 0, 0, 0);
    private DateTime monthBefore = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime monthAfter = new DateTime(2000, 12, 1, 0, 0, 0);
    private DateTime dayBefore = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime dayAfter = new DateTime(2000, 1, 31, 0, 0, 0);
    private DateTime hourBefore = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime hourAfter = new DateTime(2000, 1, 1, 23, 0, 0);
    private DateTime minuteBefore = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime minuteAfter = new DateTime(2000, 1, 1, 0, 59, 0);
    private DateTime secondBefore = new DateTime(2000, 1, 1, 0, 0, 0);
    private DateTime secondAfter = new DateTime(2000, 1, 1, 0, 0, 59);


    @Test
    public void janFirstToString()
    {
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void febSecondToString()
    {
        assertEquals("2nd, February, 2018 - 23:59:59", febSecond.toString());
    }


    @Test
    public void marchThirdToString()
    {
        assertEquals("3rd, March, 2020 - 12:30:30", marchThird.toString());
    }


    @Test
    public void aprilEleventhToString()
    {
        assertEquals("11th, April, 2018 - 00:00:00", aprilEleventh.toString());
    }


    @Test
    public void mayTwelfthToString()
    {
        assertEquals("12th, May, 2018 - 00:00:00", mayTwelfth.toString());
    }


    @Test
    public void juneThirteenthToString()
    {
        assertEquals("13th, June, 2018 - 00:00:00", juneThirteenth.toString());
    }


    @Test
    public void julyTwentyFirstToString()
    {
        assertEquals("21st, July, 2018 - 00:00:00", julyTwentyFirst.toString());
    }


    @Test
    public void augustTwentySecondToString()
    {
        assertEquals("22nd, August, 2018 - 00:00:00", augustTwentySecond.toString());
    }


    @Test
    public void septemberTwentyThirdToString()
    {
        assertEquals("23rd, September, 2018 - 00:00:00", septemberTwentyThird.toString());
    }


    @Test
    public void octoberFourthToString()
    {
        assertEquals("4th, October, 2018 - 00:00:00", octoberFourth.toString());
    }


    @Test
    public void novemberTwentyFifthToString()
    {
        assertEquals("25th, November, 2018 - 00:00:00", novemberTwentyFifth.toString());
    }


    @Test
    public void decemberSixteenthToString()
    {
        assertEquals("16th, December, 2017 - 00:00:00", decemberSixteenth.toString());
    }


    @Test
    public void eighteenNinetyNineYear()
    {
        String message = "Test Failed";
        try {
            new DateTime(1899, 1, 1, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Year parameter not valid!\nvalue: 1899 is not in range 1900 - 2100", message);
    }


    @Test
    public void nineteenHundredYear()
    {
        assertEquals(1900, nineteenHundredYear.getYear());
    }


    @Test
    public void nineteenHundredOneYear()
    {
        assertEquals(1901, nineteenHundredOneYear.getYear());
    }


    @Test
    public void twoThousandNinetyNineYear()
    {
        assertEquals(2099, twoThousandNinetyNineYear.getYear());
    }


    @Test
    public void twoThousandOneHundredYear()
    {
        assertEquals(2100, twoThousandOneHundredYear.getYear());
    }


    @Test
    public void twoThousandOneHundredOneYear()
    {
        String message = "Test failed";
        try {
            new DateTime(2101, 1, 1, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Year parameter not valid!\nvalue: 2101 is not in range 1900 - 2100", message);
    }


    @Test
    public void zeroMonth()
    {
        String message = "Test failed";
        try {
            new DateTime(2000, 0, 1, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Month parameter not valid!\nvalue: 0 is not in range 1 - 12", message);
    }


    @Test
    public void thirteenthMonth()
    {
        String message = "Test failed";
        try {
            new DateTime(2000, 13, 1, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Month parameter not valid!\nvalue: 13 is not in range 1 - 12", message);
    }


    @Test
    public void negativeDay()
    {
        String message = "Test failed";
        try {
            new DateTime(2000, 1, -1, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!\nvalue: -1 is not in range 1 - 31", message);
    }


    @Test
    public void zeroDay()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 0, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!\nvalue: 0 is not in range 1 - 31", message);
    }


    @Test
    public void firstDay()
    {
        assertEquals(1, janFirst.getDay());
    }


    @Test
    public void secondDay()
    {
        assertEquals(2, febSecond.getDay());
    }


    @Test
    public void janThirtiethDay()
    {
        assertEquals(30, janThirtieth.getDay());
    }


    @Test
    public void janThirtyFirstDay()
    {
        assertEquals(31, janThirtyFirst.getDay());
    }


    @Test
    public void janThirtySecondDay()
    {
        String message = "Test Failed";
        try {
            new DateTime(2018, 1, 32, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!\nvalue: 32 is not in range 1 - 31", message);
    }


    @Test
    public void febTwentySeventhDay()
    {
        assertEquals(27, febTwentySeventh.getDay());
    }


    @Test
    public void febTwentyEighthDay()
    {
        assertEquals(28, febTwentyEighth.getDay());
    }


    @Test
    public void febTwentyNinthDay()
    {
        String message = "Test Failed";
        try {
            new DateTime(2018, 2, 29, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!\nvalue: 29 is not in range 1 - 28", message);
    }


    @Test
    public void febTwentyEighthLeapDay()
    {
        assertEquals(28, febTwentyEighthLeap.getDay());
    }


    @Test
    public void febTwentyNinthLeapDay()
    {
        assertEquals(29, febTwentyNinthLeap.getDay());
    }


    @Test
    public void febThirtiethLeapDay()
    {
        String message = "Test Failed";
        try {
            new DateTime(2020, 2, 31, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!\nvalue: 31 is not in range 1 - 29", message);
    }


    @Test
    public void aprilTwentyNinthDay()
    {
        assertEquals(29, aprilTwentyNinth.getDay());
    }


    @Test
    public void aprilThirtiethDay()
    {
        assertEquals(30, aprilThirtieth.getDay());
    }


    @Test
    public void aprilThirtyFirstDay()
    {
        String message = "Test Failed";
        try {
            new DateTime(2018, 4, 31, 0, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Day parameter not valid!\nvalue: 31 is not in range 1 - 30", message);
    }


    @Test
    public void negativeHour()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 1, -1, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Hour parameter not valid!\nvalue: -1 is not in range 1 - 23", message);
    }


    @Test
    public void zeroHour()
    {
        assertEquals(0, zeroHour.getHour());
    }


    @Test
    public void oneHour()
    {
        assertEquals(1, oneHour.getHour());
    }


    @Test
    public void twentyTwoHour()
    {
        assertEquals(22, twentyTwoHour.getHour());
    }


    @Test
    public void twentyThreeHour()
    {
        assertEquals(23, twentyThreeHour.getHour());
    }


    @Test
    public void twentyFourthHour()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 1, 24, 0, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Hour parameter not valid!\nvalue: 24 is not in range 1 - 23", message);
    }


    @Test
    public void negativeMinute()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 1, 0, -1, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Minute parameter not valid!\nvalue: -1 is not in range 1 - 59", message);
    }


    @Test
    public void zeroMinute()
    {
        assertEquals(0, zeroMinute.getMinute());
    }


    @Test
    public void oneMinute()
    {
        assertEquals(1, oneMinute.getMinute());
    }


    @Test
    public void fiftyEightMinute()
    {
        assertEquals(58, fiftyEightMinute.getMinute());
    }


    @Test
    public void fiftyNineMinute()
    {
        assertEquals(59, fiftyNineMinute.getMinute());
    }


    @Test
    public void sixtyMinute()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 1, 0, 60, 0);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Minute parameter not valid!\nvalue: 60 is not in range 1 - 59", message);
    }


    @Test
    public void negativeSecond()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 1, 0, 0, -1);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Second parameter not valid!\nvalue: -1 is not in range 1 - 59", message);
    }


    @Test
    public void zeroSecond()
    {
        assertEquals(0, zeroSecond.getSecond());
    }


    @Test
    public void oneSecond()
    {
        assertEquals(1, oneSecond.getSecond());
    }


    @Test
    public void fiftyEightSecond()
    {
        assertEquals(58, fiftyEightSecond.getSecond());
    }


    @Test
    public void fiftyNineSecond()
    {
        assertEquals(59, fiftyNineSecond.getSecond());
    }


    @Test
    public void sixtySecond()
    {
        String message = "Test Failed";
        try {
            new DateTime(2000, 1, 1, 0, 0, 60);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        assertEquals("Second parameter not valid!\nvalue: 60 is not in range 1 - 59", message);
    }


    @Test
    public void isBeforeYearTrue()
    {
        assertTrue(yearBefore.isBefore(yearAfter));
    }


    @Test
    public void isBeforeYearFalse()
    {
        assertFalse(yearAfter.isBefore(yearBefore));
    }


    @Test
    public void isBeforeMonthTrue()
    {
        assertTrue(monthBefore.isBefore(monthAfter));
    }


    @Test
    public void isBeforeMonthFalse()
    {
        assertFalse(monthAfter.isBefore(monthBefore));
    }


    @Test
    public void isBeforeDayTrue()
    {
        assertTrue(dayBefore.isBefore(dayAfter));
    }


    @Test
    public void isBeforeDayFalse()
    {
        assertFalse(dayAfter.isBefore(dayBefore));
    }


    @Test
    public void isBeforeHourTrue()
    {
        assertTrue(hourBefore.isBefore(hourAfter));
    }


    @Test
    public void isBeforeHourFalse()
    {
        assertFalse(hourAfter.isBefore(hourBefore));
    }


    @Test
    public void isBeforeMinuteTrue()
    {
        assertTrue(minuteBefore.isBefore(minuteAfter));
    }


    @Test
    public void isBeforeMinuteFalse()
    {
        assertFalse(minuteAfter.isBefore(minuteBefore));
    }


    @Test
    public void isBeforeSecondTrue()
    {
        assertTrue(secondBefore.isBefore(secondAfter));
    }


    @Test
    public void isBeforeSecondFalse()
    {
        assertFalse(secondAfter.isBefore(secondBefore));
    }


    @Test
    public void isAfterYearTrue()
    {
        assertTrue(yearAfter.isAfter(yearBefore));
    }


    @Test
    public void isAfterMonthTrue()
    {
        assertTrue(monthAfter.isAfter(monthBefore));
    }


    @Test
    public void isAfterDayTrue()
    {
        assertTrue(dayAfter.isAfter(dayBefore));
    }


    @Test
    public void isAfterHourTrue()
    {
        assertTrue(hourAfter.isAfter(hourBefore));
    }



    @Test
    public void isAfterMinuteTrue()
    {
        assertTrue(minuteAfter.isAfter(minuteBefore));
    }


    @Test
    public void isAfterSecondTrue()
    {
        assertTrue(secondAfter.isAfter(secondBefore));
    }


    @Test
    public void isAfterYearFalse()
    {
        assertFalse(yearBefore.isAfter(yearAfter));
    }


    @Test
    public void isAfterMonthFalse()
    {
        assertFalse(monthBefore.isAfter(monthAfter));
    }


    @Test
    public void isAfterDayFalse()
    {
        assertFalse(dayBefore.isAfter(dayAfter));
    }


    @Test
    public void isAfterHourFalse()
    {
        assertFalse(hourBefore.isAfter(hourAfter));
    }


    @Test
    public void isAfterMinuteFalse()
    {
        assertFalse(minuteBefore.isAfter(minuteAfter));
    }


    @Test
    public void isAfterSecondFalse()
    {
        assertFalse(secondBefore.isAfter(secondAfter));
    }

    @Test
    public void isAfterEqual()
    {
        assertFalse(secondAfter.isAfter(secondAfter));
    }

    @Test
    public void isBeforeEqual()
    {
        assertFalse(secondBefore.isBefore(secondBefore));
    }


    @Test
    public void isEqual()
    {
        assertTrue(zeroHour.isEqual(new DateTime(2000, 1, 1, 0, 0, 0)));
    }


    @Test
    public void isNotEqualYear()
    {
        assertFalse(zeroHour.isEqual(new DateTime(2001, 1, 1, 0, 0, 0)));
    }



    @Test
    public void isNotEqualMonth()
    {
        assertFalse(zeroHour.isEqual(new DateTime(2000, 2, 1, 0, 0, 0)));
    }


    @Test
    public void isNotEqualDay()
    {
        assertFalse(zeroHour.isEqual(new DateTime(2000, 1, 2, 0, 0, 0)));
    }


    @Test
    public void isNotEqualHour()
    {
        assertFalse(zeroHour.isEqual(new DateTime(2000, 1, 1, 1, 0, 0)));
    }


    @Test
    public void isNotEqualMinute()
    {
        assertFalse(zeroHour.isEqual(new DateTime(2000, 1, 1, 0, 1, 0)));
    }


    @Test
    public void isNotEqualSecond()
    {
        assertFalse(zeroHour.isEqual(new DateTime(2000, 1, 1, 0, 0, 1)));
    }


    @Test
    public void subtractSameMonthDays()
    {
        assertEquals(26, febTwentyEighth.subtractDaysFromDateTime(febSecond));
    }


    @Test
    public void subtractSameYearDays()
    {
        assertEquals(2, febSecond.subtractDaysFromDateTime(janThirtyFirst));
    }


    @Test
    public void subtractSameYearLeapDays()
    {
        assertEquals(4, marchThird.subtractDaysFromDateTime(febTwentyEighthLeap));
    }


    @Test
    public void subtractDifferentYearDays()
    {
        assertEquals(16, janFirst.subtractDaysFromDateTime(decemberSixteenth));
    }

    @Test
    public void subtractDifferentYearLeapDays()
    {
        assertEquals(464, marchThird.subtractDaysFromDateTime(novemberTwentyFifth));
    }


    @Test
    public void subtractSameMonthDaysNegative()
    {
        assertEquals(-26, febSecond.subtractDaysFromDateTime(febTwentyEighth));
    }


    @Test
    public void subtractSameYearDaysNegative()
    {
        assertEquals(-2, janThirtyFirst.subtractDaysFromDateTime(febSecond));
    }


    @Test
    public void subtractSameYearLeapDaysNegative()
    {
        assertEquals(-4, febTwentyEighthLeap.subtractDaysFromDateTime(marchThird));
    }


    @Test
    public void subtractDifferentYearDaysNegative()
    {
        assertEquals(-16, decemberSixteenth.subtractDaysFromDateTime(janFirst));
    }


    @Test
    public void subtractDifferentYearLeapDaysNegative()
    {
        assertEquals(-464, novemberTwentyFifth.subtractDaysFromDateTime(marchThird));
    }


    @Test
    public void subtractSameDiffSeconds()
    {
        assertEquals(29, febTwentyEighth.subtract(new DateTime(2018, 2, 28, 23, 59, 30)));
    }


    @Test
    public void subtractSameDiffMinutes()
    {
        assertEquals(1740, febTwentyEighth.subtract(new DateTime(2018, 2, 28, 23, 30, 59)));
    }


    @Test
    public void subtractSameDiffHours()
    {
        assertEquals(36000, febTwentyEighth.subtract(new DateTime(2018, 2, 28, 13, 59, 59)));
    }


    @Test
    public void subtractSameDiffDays()
    {
        assertEquals(86400, febTwentyEighth.subtract(new DateTime(2018, 2, 27, 23, 59, 59)));
    }

    @Test
    public void subtractSameDiffMonths()
    {
        assertEquals(2678400, febTwentyEighth.subtract(new DateTime(2018, 1, 28, 23, 59, 59)));
    }


    @Test
    public void subtractSameDiffYears()
    {
        assertEquals(31536000, febTwentyEighth.subtract(new DateTime(2017, 2, 28, 23, 59, 59)));
    }


    @Test
    public void subtractSameDiffYearsLeap()
    {
        assertEquals(94694400, febTwentyEighth.subtract(new DateTime(2015, 2, 28, 23, 59, 59)));
    }


    @Test
    public void subtractSameDiffSecondsNegative()
    {
        assertEquals(-29, (new DateTime(2018, 2, 28, 23, 59, 30)).subtract(febTwentyEighth));
    }


    @Test
    public void subtractSameDiffMinutesNegative()
    {
        assertEquals(-1740, (new DateTime(2018, 2, 28, 23, 30, 59)).subtract(febTwentyEighth));
    }


    @Test
    public void subtractSameDiffHoursNegative()
    {
        assertEquals(-36000, (new DateTime(2018, 2, 28, 13, 59, 59)).subtract(febTwentyEighth));
    }


    @Test
    public void subtractSameDiffDaysNegative()
    {
        assertEquals(-86400, (new DateTime(2018, 2, 27, 23, 59, 59)).subtract(febTwentyEighth));
    }

    @Test
    public void subtractSameDiffMonthsNegative()
    {
        assertEquals(-2678400, (new DateTime(2018, 1, 28, 23, 59, 59)).subtract(febTwentyEighth));
    }


    @Test
    public void subtractSameDiffYearsNegative()
    {
        assertEquals(-31536000, (new DateTime(2017, 2, 28, 23, 59, 59)).subtract(febTwentyEighth));
    }


    @Test
    public void subtractSameDiffYearsLeapNegative()
    {
        assertEquals(-94694400, (new DateTime(2015, 2, 28, 23, 59, 59)).subtract(febTwentyEighth));
    }


    @Test
    public void changeDateGoodDateYear()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(1900, 1, 1);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 1900 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeDateBadDateYear()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(2200, 10, 20);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeDateGoodDateMonth()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(2018, 4, 1);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, April, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeDateBadDateMonth()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(2030, 17, 20);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeDateGoodDateDay()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(2018, 1, 20);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("20th, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeDateBadDateDay()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(2030, 10, 33);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeDateBadDateMessage()
    {
        String message = "Nothing";
        try{
            janFirst.changeDate(2200, 1, 1);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Invalid date, please select a correct date format DD/MM/YYYY in between 1900-2100", message);
    }


    @Test
    public void changeTimeGoodTimeHour()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(20, 30, 10);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 20:30:10", janFirst.toString());
    }


    @Test
    public void changeTimeBadTimeHour()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(30, 10, 50);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeTimeGoodTimeMinute()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(10, 15, 10);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:15:10", janFirst.toString());
    }


    @Test
    public void changeTimeBadTimeMinute()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(20, 90, 30);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeTimeGoodTimeSecond()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(10, 30, 20);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:20", janFirst.toString());
    }


    @Test
    public void changeTimeBadTimeSecond()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(20, 10, 90);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("1st, January, 2018 - 10:30:10", janFirst.toString());
    }


    @Test
    public void changeTimeBadTimeMessage()
    {
        String message = "Nothing";
        try{
            janFirst.changeTime(30, 90, 90);
        } catch(IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Invalid time, please select a correct time format HH:MM:SS", message);
    }


    @Test
    public void getDateAsString()
    {
        assertEquals("01/01/2000", secondBefore.getDateAsString());
    }


    @Test
    public void getTimeAsString()
    {
        assertEquals("00:00:00", secondBefore.getTimeAsString());
    }
}