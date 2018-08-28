package seng202.team10.Model.ActivitiesData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTimeTest {

    private DateTime janFirst = new DateTime(1, 1, 2018, 0, 0, 0);
    private DateTime febSecond = new DateTime(2, 2, 2018, 23, 59, 59);
    private DateTime marchThird = new DateTime(3, 3, 2018, 12, 30, 30);
    private DateTime aprilEleventh = new DateTime(11, 4, 2018, 0, 0, 0);
    private DateTime mayTwelfth = new DateTime(12, 5, 2018, 0, 0, 0);
    private DateTime juneThirteenth = new DateTime(13, 6, 2018, 0, 0, 0);
    private DateTime julyTwentyFirst = new DateTime(21, 7, 2018, 0, 0, 0);
    private DateTime augustTwentySecond = new DateTime(22, 8, 2018, 0, 0, 0);
    private DateTime septemberTwentyThird = new DateTime(23, 9, 2018, 0, 0, 0);
    private DateTime octoberFourth = new DateTime(4, 10, 2018, 0, 0, 0);
    private DateTime novemberTwentyFifth = new DateTime(25, 11, 2018, 0, 0, 0);
    private DateTime decemberSixteenth = new DateTime(16, 12, 2018, 0, 0, 0);


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

//    @Test
//    public void negativeDate() {
//
//        assertEquals(new IllegalArgumentException("Day parameter not valid!"), new DateTime(-1, 1, 2000, 0, 0, 0));
//    }
}