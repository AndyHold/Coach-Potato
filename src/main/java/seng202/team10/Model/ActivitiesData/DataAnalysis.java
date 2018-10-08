package seng202.team10.Model.ActivitiesData;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class that contains methods for processing activities for data analysis, mostly used by the GraphsController class.
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class DataAnalysis {

    /**
     * Method to calculate the cumulative time spent in an activity, with each array index holding a sum of the time
     * spent so far.
     * @param activity  The <b>Activity</b> the time spent is gotten from.
     * @return  An <b>ArrayList&lt;Integer&gt;</b>, each index holding a sum of the time spent before it.
     */
    public ArrayList<Integer> getTimeFromActivity(Activity activity) {
        ArrayList<Integer> timeArray = new ArrayList<>();
        Integer timeSum = 0;
        int i = 0;
        while (i < activity.getEntries().size()-1) {
            DateTime time1 = activity.getEntries().get(i).getTime();
            DateTime time2 = activity.getEntries().get(i+1).getTime();
            timeArray.add(timeSum);
            timeSum += time2.subtract(time1);
            i++;
        }
        timeArray.add(timeSum);
        return timeArray;
    }

    /**
     * Method to get an array of distances between entries from an activity. Each index in the array is the distance
     * between the first entry and the entry at that index.
     * @param activity The <b>Activity</b> the distance array is being calculated from.
     * @return  An <b>ArrayList&lt;double&gt;</b> that contains distances from the first entry position.
     */
    public ArrayList<Double> getDistanceFromActivity(Activity activity) {

        ArrayList<Double> distanceArray = new ArrayList<>();
        double distanceSum = 0;
        int i = 0;
        while (i < activity.getEntries().size()-1) {
            Entry entryA = activity.getEntries().get(i);
            Entry entryB = activity.getEntries().get(i+1);
            entryA.calculateDistance(entryB);
            double distance = entryA.getDistance();
            distanceArray.add(distanceSum);
            distanceSum += distance;
            i++;
        }
        distanceArray.add(distanceSum);
        return distanceArray;
    }

    /**
     * Method to get an array of heart rates from an activity. Each heart rate corresponds to one entry.
     * @param activity The <b>Activity</b> the heart rates are being taken from.
     * @return  An <b>ArrayList&lt;Integer&gt;</b> that contains the heart rate values in an activity.
     */
    public ArrayList<Integer> getHeartRateFromActivity(Activity activity) {

        ArrayList<Integer> heartRateArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            heartRateArray.add(entry.getHeartRate());
        }
        return heartRateArray;
    }


    /**
     * Method to find the calories burned at each point in an activity. This is calculated from the gender, weight, age and
     * heart rate of the user. For the gender "other", an average of the male and female calculations are used.
     * The total calories burned is the last index of the returned array.
     * @param activity The <b>Activity</b> the calories are being calculated from.
     * @param user  The <b>UserProfile</b> being used for the calorie calculations.
     * @return  An <b>ArrayList&lt;Double&gt;</b> that contains a sum of the calories burned at a point in time for an activity.
     *
     */
    public ArrayList<Double> getCaloriesFromActivity(Activity activity, UserProfile user) {
        ArrayList<Integer> timeArray= getTimeFromActivity(activity);
        ArrayList<Double> calorieArray = new ArrayList<>();

        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        double calorieSum = 0;
        int i = 0;
        switch (user.getGender()) {
            case "Male":
                while (i < activity.getEntries().size()-1) {
                    Entry entryA = activity.getEntries().get(i);
                    Entry entryB = activity.getEntries().get(i + 1);
                    int timeFromLastEntry = entryB.getTime().subtract(entryA.getTime());
                    double calories = ((-55.0969 + (0.6309 * entryB.getHeartRate()) + (0.1988 * user.getWeight()) + (0.2017 * userAge)) / 4.184) * 60 * timeFromLastEntry / 3600.0;
                    calorieArray.add(calorieSum);
                    calorieSum += calories;
                    i++;
                }
                calorieArray.add(calorieSum);
                break;
            case "Female":
                while (i < activity.getEntries().size()-1) {
                    Entry entryA = activity.getEntries().get(i);
                    Entry entryB = activity.getEntries().get(i + 1);
                    int timeFromLastEntry = entryB.getTime().subtract(entryA.getTime());
                    double calories = ((-20.4022 + (0.4472 * entryB.getHeartRate()) + (0.1263 * user.getWeight()) + (0.074 * userAge)) / 4.184) * 60 * timeFromLastEntry / 3600.0;
                    calorieArray.add(calorieSum);
                    calorieSum += calories;
                    i++;
                }
                calorieArray.add(calorieSum);
                break;
            default:
                while (i < activity.getEntries().size()-1) {
                    Entry entryA = activity.getEntries().get(i);
                    Entry entryB = activity.getEntries().get(i + 1);
                    int timeFromLastEntry = entryB.getTime().subtract(entryA.getTime());
                    double calories = ((-37.5 + (0.54 * entryB.getHeartRate()) + (0.155 * user.getWeight()) + (0.138 * userAge)) / 4.184) * 60 * timeFromLastEntry / 3600.0;
                    calorieArray.add(calorieSum);
                    calorieSum += calories;
                    i++;
                }
                calorieArray.add(calorieSum);
                break;
        }
        return calorieArray;
    }

    /**
     * Method to calculate the cumulative time spent in an activity in minutes, with each array index holding a sum of the time
     * spent before it. The final index holds the total time in minutes.
     * @param activity The <b>Activity</b> the time spent is gotten from.
     * @return  An <b>ArrayList&lt;Double&gt;</b>, each index holding a sum of the time spent before it.
     */
    public ArrayList<Double> getMinutesFromActivity(Activity activity) {

        ArrayList<Double> minutesArray = new ArrayList<>();
        Double minutesSum = 0.0;
        int i = 0;
        while (i < activity.getEntries().size()-1) {
            DateTime time1 = activity.getEntries().get(i).getTime();
            DateTime time2 = activity.getEntries().get(i+1).getTime();
            minutesArray.add(minutesSum);
            minutesSum += time2.subtract(time1)/60.0;
            i++;
        }
        minutesArray.add(minutesSum);
        return minutesArray;
    }
}
