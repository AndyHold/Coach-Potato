package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
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
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return activities;
    }

    public ArrayList<Activity> sortByIntensity() {

        return null;
    }

    public ArrayList<Activity> showDateRange(DateTime dateTime) {

        return null;
    }

    public ArrayList<Double> getTimeFromActivity(Activity activity) {

        return null;
    }

    public ArrayList<Double> getDistanceFromActivity(Activity activity) {

        return null;
    }

    public ArrayList<Integer> getHeartRateFromActivity(Activity activity) {

        return null;
    }

    public ArrayList<Double> getCaloriesFromActivity(Activity activity) {

        return null;
    }

    public ArrayList<Position> getPositionFromActivity(Activity activity) {

        return null;
    }
}
