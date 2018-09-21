package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class that contains methods for processing activities for data analysis, mostly used by the DataAnalysisController class.
 */
public class DataAnalysis {

    private ArrayList<Activity> activities;

    /**
     * Method to sort a list of activities by their date.
     * @return  A sorted list of activities.
     */
//    public ArrayList<Activity> sortByDate() {
//
//        activities.sort(new Comparator<Activity>() {
//            @Override
//            public int compare(Activity a1, Activity a2) {
//                if(a2.getStartDateTime().isAfter(a1.getStartDateTime())) {
//                    return -1;
//                } else if ((a2.getStartDateTime().isBefore(a1.getStartDateTime()))) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//        });
//        return activities;
//    }


    /**
     * Method to calculate the cumulative time spent in an activity, with each array index holding a sum of the time
     * spent before it.
     * @param activity  The activity the time spent is gotten from.
     * @return  An array of integers, each index holding a sum of the time spent before it.
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
     * @return  An ArrayList<Double> that contains distances from the first entry position.
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
     * @return  An ArrayList<Integer> that contains the heart rate values in an activity.
     */
    public ArrayList<Integer> getHeartRateFromActivity(Activity activity) {

        ArrayList<Integer> heartRateArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            heartRateArray.add(entry.getHeartRate());
        }
        return heartRateArray;
    }


    /**
     * Method to find the calories burned at each point in an activity. This is based on the gender, weight, age and
     * heart rate of the user. For the not specified gender, an average of the male and female calculations are used.
     * The total calories burned is the last index of the returned array.
     * @param activity  The activity the calories are being calculated from.
     * @param user  The user being used for the calorie calculations.
     * @return  An ArrayList<Double> that contains a sum of the calories burned at a point in time for an activity.
     *
     */
    public ArrayList<Double> getCaloriesFromActivity(Activity activity, UserProfile user) {
        ArrayList<Integer> timeArray= getTimeFromActivity(activity);
        ArrayList<Double> calorieArray = new ArrayList<>();

        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        if (user.getGender() == "Male") {
            for (int index = 0; index < activity.getEntries().size(); index++) {
                Entry entry = activity.getEntries().get(index);
                double calories = ((-55.0969 + (0.6309 * entry.getHeartRate()) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(index)/3600.0;
                calorieArray.add(calories);
            }
        } else if (user.getGender() == "Female") {
            for (int index = 0; index < activity.getEntries().size(); index++) {
                Entry entry = activity.getEntries().get(index);
                double calories = ((-20.4022 + (0.4472 * entry.getHeartRate()) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(index)/3600.0;
                calorieArray.add(calories);
            }
        } else {
            for (int index = 0; index < activity.getEntries().size(); index++) {
                Entry entry = activity.getEntries().get(index);
                double calories = ((-37.5 + (0.54 * entry.getHeartRate()) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(index)/3600.0;
                calorieArray.add(calories);
            }
        }
        //activities.setCaloriesBurned(calorieArray[-1]);
        return calorieArray;
    }


    /**
     * Method to get the positions of entries from an activity.
     * @param activity  The activity the entries are being taken from
     * @return  An ArrayList<Position> that contains the positions in an activity.
     */
    public ArrayList<Position> getPositionFromActivity(Activity activity) {

        ArrayList<Position> positionArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            positionArray.add(entry.getPosition());
        }
        return positionArray;
    }

    /**
     * Sets the activities value.
     * @param activities  An ArrayList<Activity>
     */
    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }


    /**
     * Method to convert a number of seconds to a string in the format HH:MM:SS. Returns null if the hours are greater than 23
     * or if seconds are negative.
     * @param seconds  The time in seconds to be converted.
     * @return  A string in the format HH:MM:SS that describes the time. Null if hours > 23
     */
    public String secondsToTime(int seconds) {
        if (seconds < 0) {
            return null;
        }
        int minutes = 0;
        int hours = 0;

        while (seconds > 59) {
            seconds = seconds - 60;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
        }
        String strSeconds = String.valueOf(seconds);
        String strMinutes = String.valueOf(minutes);
        String strHours = String.valueOf(hours);
        if (strSeconds.length() == 1) {
            strSeconds = "0" + strSeconds;
        }
        if (strMinutes.length() == 1) {
            strMinutes = "0" + strMinutes;
        }
        if (strHours.length() == 1) {
            strHours = "0" + strHours;
        }
        if (hours > 23) {
            return null;
        }
        return strHours + ":" + strMinutes + ":" + strSeconds;

    }

    /**
     * Method to calculate the cumulative time spent in an activity in minutes, with each array index holding a sum of the time
     * spent before it. The final index holds the total time in minutes.
     * @param activity  The activity the time spent is gotten from.
     * @return  An array of Doubles, each index holding a sum of the time spent before it.
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

//    /**
//     * Takes an arraylist of entries and fills in any missing gaps in the data for analysis.
//     *
//     * @param entryArrayList
//     * @return
//     */
//    public ArrayList<Entry> interpolateEntries(ArrayList<Entry> entryArrayList) {
//        ArrayList<Entry> interpolatedEntries = new ArrayList<>();
//        DateTime entryTime;
//        for (Entry entry : entryArrayList) {
//            entryTime = entry.getTime();
//            interpolatedEntries.add(entry);
//
//        }
//
//    }

<<<<<<< HEAD
=======
    public static void main(String[] args) throws Exception {
//        DataAnalysis dataAnalysis = new DataAnalysis();
//        System.out.println(dataAnalysis.secondsToTime(800));
//        GUIController guiController = new GUIController();
//        UserProfile user = new UserProfile();
//        user.setHeight(80);
//        user.setWeight(80);
//        user.setGender("Male");
//        user.setMaxHeartRate(170);
//        DateTime birthday = new DateTime(1996, 12, 04, 0, 0, 0);
//        user.setBirthDate(birthday);
//        guiController.uploadDataToUser(user, "/home/cosc/student/tkl34/Desktop/SENG202/SENG202_Project/SENG202_Project/FilesToLoad/testdata.csv");
//        ArrayList<Activity> activities = user.getActivities();
//        dataAnalysis.getMinutesFromActivity(activities.get(0));
//        DataAnalysis dataAnalysis = new DataAnalysis();
//        ArrayList<Double> stressArray = new ArrayList<>();
//        ArrayList<Integer> timeArray = dataAnalysis.getTimeFromActivity(activities.get(0));
//        ArrayList<Integer> heartRateArray = dataAnalysis.getHeartRateFromActivity(activities.get(0));
//        for (int i = 0; i < timeArray.size(); i++) {
//            double stressPercent = (double)heartRateArray.get(i) / (double)user.getMaxHeartRate();
//            stressArray.add(stressPercent);
//        }
//        System.out.println(stressArray);
    }


>>>>>>> 4d39bd8... Wrote some more tests for Activity, Entry, Position classes and JavaDocs for those classes.
}
