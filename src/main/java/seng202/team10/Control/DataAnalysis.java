package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;

import java.util.ArrayList;
import java.util.Comparator;

public class DataAnalysis {

    private ArrayList<Activity> activities;

    public ArrayList<Activity> sortByDate() {

//        ArrayList<Activity> sortedActivities = activities;
//        try {
//            int lenOfArray = sortedActivities.size();
//            for (int i = 0; i < lenOfArray-1; i++) {
//                DateTime minDateTime = sortedActivities.get(i).getStartDateTime();
//                for (int j = i + 1; j < lenOfArray; j++) {
//                    if (minDateTime.isAfter(sortedActivities.get(j).getStartDateTime())) {
//                        minDateTime = sortedActivities.get(j).getStartDateTime();
//                    }
//                }
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

//    public ArrayList<Activity> sortByIntensity() {
//
//        return null;
//    }

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

    public ArrayList<DateTime> getTimeFromActivity(Activity activity) {
        ArrayList<DateTime> timeArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            timeArray.add(entry.getTime());
        }
        return timeArray;
    }

    public ArrayList<Double> getDistanceFromActivity(Activity activity) {

        ArrayList<Double> distanceArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            distanceArray.add(entry.getDistance());
        }
        return distanceArray;
    }

    public ArrayList<Integer> getHeartRateFromActivity(Activity activity) {

        ArrayList<Integer> heartRateArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            heartRateArray.add(entry.getHeartRate());
        }
        return heartRateArray;
    }

//    public ArrayList<Double> getCaloriesFromActivity(Activity activity) {

//        ArrayList<Double> calorieArray = new ArrayList<>();
//        for (Entry entry : activity.getEntries()) {
//        }
//        return calorieArray;
//    }

    public ArrayList<Position> getPositionFromActivity(Activity activity) {

        ArrayList<Position> positionArray = new ArrayList<>();
        for (Entry entry : activity.getEntries()) {
            positionArray.add(entry.getPosition());
        }
        return positionArray;
    }
}
