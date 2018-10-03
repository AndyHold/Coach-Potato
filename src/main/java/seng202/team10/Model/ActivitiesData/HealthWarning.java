package seng202.team10.Model.ActivitiesData;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HealthWarning implements java.io.Serializable {


    private String name;
    private String URL;
    private HealthWarningType type;
    private String activityName;
    private DateTime activityDate;


    public HealthWarning(HealthWarningType type, String activityname, DateTime activityDate)
    {
        this.name = type.getName();
        this.URL = type.getURL();
        this.type = type;
        this.activityName = activityname;
        this.activityDate = activityDate;
    }


    /**
     * Method to check a heart rate from an entry in an activity for a necessary health warning.
     * @param type an <b>ActivityType</b>: ActivityType of the current activity.
     * @param firstEntry a <b>boolean</b>: True if this is the first entry in the activity (resting heart rate).
     * @param heartRate a <b>double</b>: Heart rate at the time of the entry.
     * @param age an <b>int</b>: Age in years of the user.
     */
    public static Set<HealthWarningType> addWarning(ActivityType type, boolean firstEntry, int heartRate, int age)
    {
        Set<HealthWarningType> warnings = new HashSet<>();
        int maxHeartRate = 220 - age;
        if (firstEntry && checkTachycardia(heartRate, age)) {
            warnings.add(HealthWarningType.TACHYCARDIA);
        }
        if (checkBradycardia(heartRate)) {
            warnings.add(HealthWarningType.BRADYCARDIA);
        }
        switch (type)
        {
            case WORKOUT:
                if (checkCardiovascularMortality(heartRate, maxHeartRate)) {
                    warnings.add(HealthWarningType.CARDIOVASCULAR_MORTALITY);
                }
                break;

            case WALK:
                if (checkCardiovascularMortality(heartRate, maxHeartRate)) {
                    warnings.add(HealthWarningType.CARDIOVASCULAR_MORTALITY);
                }
                break;

            case HIKE:
                if (checkCardiovascularMortality(heartRate, maxHeartRate)) {
                    warnings.add(HealthWarningType.CARDIOVASCULAR_MORTALITY);
                }
                break;

            case OTHER:
                if (checkCardiovascularMortality(heartRate, maxHeartRate)) {
                    warnings.add(HealthWarningType.CARDIOVASCULAR_MORTALITY);
                }
                break;
        }
        return warnings;
    }


    /**
     * Method to check if user needs a cardiovascular mortality warning because of a high heart rate during excersize.
     * @param heartRate double: The heart rate at point in activity
     * @param maxHeartRate int: The maximum heart rate the user should reach.
     * @return boolean: True if the heart rate is greater than the maximum heart rate.
     */
    private static boolean checkCardiovascularMortality(int heartRate, int maxHeartRate)
    {
        return (heartRate > maxHeartRate);
    }


    /**
     * Method to check a user for a Bradycardia health warning.
     * Note: This does not check for Bradycardia in children under 15 years old as in most cases this is harmless.
     * @param heartRate double: The heart rate of the user at a point in their activity.
     * @return boolean: True if heart rate suggests bradycardia warning is necessary.
     */
    private static boolean checkBradycardia(int heartRate)
    {
        return (heartRate < 60);
    }


    /**
     * Method to check a user for a Tachycardia health warning.
     * @param heartRate double: The Heart Rate of the user as they first start their activity.
     * @param age int: The users age
     * @return boolean: True if the warning is necessary.
     */
    private static boolean checkTachycardia(int heartRate, int age)
    {
        if (age <= 7 && heartRate > 133) {
            return true;
        } else if (age <= 11 && heartRate > 130) {
            return true;
        } else if (age <= 15 && heartRate > 119) {
            return true;
        } else if (age > 15 && heartRate > 100) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Getter method for the name of the health warning.
     * @return String
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method for the URL of the health warning.
     * @return String
     */
    public String getURL() {
        return URL;
    }


    /**
     * getter method for the health warning type
     * @return HealthWarningType
     */
    public HealthWarningType getType()
    {
        return type;
    }


    /**
     * Getter method for the activity name
     * @return String
     */
    public String getActivityName() {
        return activityName;
    }


    /**
     * Getter method for the start date of the activity that caused the health warning.
     * @return DateTime
     */
    public DateTime getActivityDate() {
        return activityDate;
    }
}
