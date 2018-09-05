package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
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

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public static void main(String[] args) throws Exception {
        GUIController guiController = new GUIController();
        UserProfile user = new UserProfile();
//        user.setHeight(80);
//        user.setWeight(80);
        guiController.uploadDataToUser(user, "/home/cosc/student/tkl34/Desktop/SENG202/SENG202_Project/SENG202_Project/FilesToLoad/testdata.csv");
        ArrayList<Activity> activities = user.getActivities();
        DataAnalysis dataAnalysis = new DataAnalysis();
        ArrayList<Integer> timesum = dataAnalysis.getTimeFromActivity(activities.get(0));
        dataAnalysis.setActivities(activities);
        dataAnalysis.sortByDate();
    }
}
