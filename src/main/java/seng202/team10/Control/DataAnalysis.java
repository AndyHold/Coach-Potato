package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

public class DataAnalysis {

    private ArrayList<Activity> activities;

    public ArrayList<Activity> sortByDate() {

        activities.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if(a2.getStartDateTime().isAfter(a1.getStartDateTime())) {
                    return -1;
                } else if ((a2.getStartDateTime().isBefore(a1.getStartDateTime()))) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return activities;
    }

    public ArrayList<Activity> sortByIntensity() {

//        activities.sort(new Comparator<Activity>() {
//            @Override
//            public int compare(Activity a1, Activity a2) {
//                if (a2.getIntensity() == LOW) {
//                    if (a1.getIntensity() == LOW) {
//                        return 0;
//                    } else {
//                        return 1;
//                    }
//                } else if (a2.getIntensity() == MEDIUM) {
//                    if (a1.getIntensity() == LOW) {
//                        return -1;
//                    } else if (a1.getIntensity() == HIGH) {
//                        return 1;
//                    } else {
//                        return 0;
//                    }
//                } else {
//                    if (a1.getIntensity() == HIGH) {
//                        return 0;
//                    } else {
//                        return -1;
//                    }
//                }
//            }
//
//        });
//        return activities;
        return null;
    }

    public ArrayList<Activity> showDateRange(DateTime dateTime) {
//        if (!activities.isEmpty()) {
//            DateTime minDateTime = activities.get(0).getStartDateTime();
//            DateTime maxDateTime = activities.get(0).getStartDateTime();
//            for (Activity activity: activities) {
//                if (minDateTime.isAfter(activity.getStartDateTime())) {
//                    minDateTime = activity.getStartDateTime();
//                }
//            }
//        }


        return null;
    }

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

    public ArrayList<Integer> getHeartRateFromActivity(Activity activity) {

        ArrayList<Integer> heartRateArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            heartRateArray.add(entry.getHeartRate());
        }
        return heartRateArray;
    }

    /**
     * Method to find the calories burned at each point in an activity. This is based on the gender, weight, age and
     * heartrate of the user. For the not specified gender, an average of the male and female calculations are used.
     * @param activity
     * @param user
     * @return
     */
    public ArrayList<Double> getCaloriesFromActivity(Activity activity, UserProfile user) {
        ArrayList<Integer> timeArray= getTimeFromActivity(activity);
        ArrayList<Double> calorieArray = new ArrayList<>();

        int userAge = Calendar.getInstance().get(Calendar.YEAR) - user.getBirthDate().getYear();
        if (user.getGender() == "Male") {
            for (int index = 0; index < activity.getEntries().size(); index++) {
                Entry entry = activity.getEntries().get(index);
                double calories = ((-55.0969 + (0.6309 * entry.getHeartRate()) + (0.1988 * user.getWeight()) + (0.2017 * userAge))/4.184) * 60 * timeArray.get(index)/3600;
                calorieArray.add(calories);
            }
        } else if (user.getGender() == "Female") {
            for (int index = 0; index < activity.getEntries().size(); index++) {
                Entry entry = activity.getEntries().get(index);
                double calories = ((-20.4022 + (0.4472 * entry.getHeartRate()) + (0.1263 * user.getWeight()) + (0.074 * userAge))/4.184) * 60 * timeArray.get(index)/3600;
                calorieArray.add(calories);
            }
        } else {
            for (int index = 0; index < activity.getEntries().size(); index++) {
                Entry entry = activity.getEntries().get(index);
                double calories = ((-37.5 + (0.54 * entry.getHeartRate()) + (0.155 * user.getWeight()) + (0.138 * userAge))/4.184) * 60 * timeArray.get(index)/3600;
                calorieArray.add(calories);
            }
        }
        return calorieArray;
    }


    public ArrayList<Position> getPositionFromActivity(Activity activity) {

        ArrayList<Position> positionArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            positionArray.add(entry.getPosition());
        }
        return positionArray;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
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

    public static void main(String[] args) throws Exception {
        GUIController guiController = new GUIController();
        UserProfile user = new UserProfile();
        user.setHeight(80);
        user.setWeight(80);
        user.setGender("Male");
        DateTime birthday = new DateTime(1996, 12, 04, 0, 0, 0);
        user.setBirthdate(birthday);
        guiController.uploadDataToUser(user, "/home/cosc/student/tkl34/Desktop/SENG202/SENG202_Project/SENG202_Project/FilesToLoad/testdata.csv");
        ArrayList<Activity> activities = user.getActivities();
        DataAnalysis dataAnalysis = new DataAnalysis();
        ArrayList<Double> calorieArray = dataAnalysis.getCaloriesFromActivity(activities.get(0), user);
        System.out.println(calorieArray);
    }
}
