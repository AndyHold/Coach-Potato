package seng202.team10.Model.ActivitiesData;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class that contains methods for processing activities for data analysis, mostly used by the DataAnalysisController class.
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class DataAnalysis {

    /**
     * Method to calculate the cumulative time spent in an activity, with each array index holding a sum of the time
     * spent so far.
     * @param activity  The activity the time spent is gotten from.
     * @return  An ArrayList&gt;Integer&lt;, each index holding a sum of the time spent before it.
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
     * @param activity  The activity the distance array is being calculated from.
     * @return  An ArrayList&gt;Double&lt; that contains distances from the first entry position.
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
     * @param activity  The activity the heart rates are being taken from.
     * @return  An ArrayList&gt;Integer&lt; that contains the heart rate values in an activity.
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
     * @param activity  The activity the calories are being calculated from.
     * @param user  The user being used for the calorie calculations.
     * @return  An ArrayList&gt;Double&lt; that contains a sum of the calories burned at a point in time for an activity.
     *
     */
    public ArrayList<Double> getCaloriesFromActivity(Activity activity, UserProfile user) {
        ArrayList<Integer> timeArray= getTimeFromActivity(activity);
        ArrayList<Double> calorieArray = new ArrayList<>();

        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        switch (user.getGender()) {
            case "Male":
                for (int index = 0; index < activity.getEntries().size(); index++) {
                    Entry entry = activity.getEntries().get(index);
                    double calories = ((-55.0969 + (0.6309 * entry.getHeartRate()) + (0.1988 * user.getWeight()) + (0.2017 * userAge)) / 4.184) * 60 * timeArray.get(index) / 3600.0;
                    calorieArray.add(calories);
                }
                break;
            case "Female":
                for (int index = 0; index < activity.getEntries().size(); index++) {
                    Entry entry = activity.getEntries().get(index);
                    double calories = ((-20.4022 + (0.4472 * entry.getHeartRate()) + (0.1263 * user.getWeight()) + (0.074 * userAge)) / 4.184) * 60 * timeArray.get(index) / 3600.0;
                    calorieArray.add(calories);
                }
                break;
            default:
                for (int index = 0; index < activity.getEntries().size(); index++) {
                    Entry entry = activity.getEntries().get(index);
                    double calories = ((-37.5 + (0.54 * entry.getHeartRate()) + (0.155 * user.getWeight()) + (0.138 * userAge)) / 4.184) * 60 * timeArray.get(index) / 3600.0;
                    calorieArray.add(calories);
                }
                break;
        }
        return calorieArray;
    }

    /**
     * Method to calculate the cumulative time spent in an activity in minutes, with each array index holding a sum of the time
     * spent before it. The final index holds the total time in minutes.
     * @param activity  The activity the time spent is gotten from.
     * @return  An ArrayLisst&gt;Double&lt;, each index holding a sum of the time spent before it.
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
