package seng202.team10.Model.ActivitiesData;


import java.util.HashSet;
import java.util.Set;

/**
 * Class that contains information about a health warning.
 */
public class HealthWarning implements java.io.Serializable {


    private String name;
    private String URL;
    private HealthWarningType type;
    private String activityName;
    private DateTime activityDate;


    /**
     * Constructor for the Health Warning Class.
     * @param type  A <b>HealthWarningType</b> enum of the type of health warning.
     * @param activityname A <b>String</b> of the activity name.
     * @param activityDate A <b>DateTime</b> of the activity date and time.
     */
    HealthWarning(HealthWarningType type, String activityname, DateTime activityDate)
    {
        this.name = type.getName();
        this.URL = type.getURL();
        this.type = type;
        this.activityName = activityname;
        this.activityDate = activityDate;
    }


    /**
     * Method to check a heart rate from an entry in an activity for a necessary health warning.
     * @param type An <b>ActivityType</b>: ActivityType of the current activity.
     * @param firstEntry A <b>boolean</b>: True if this is the first entry in the activity (resting heart rate).
     * @param heartRate A <b>double</b>: Heart rate at the time of the entry.
     * @param age An <b>int</b>: Age in years of the user.
     * @return A <b>Set&lt;HealthWarningType&gt;</b> of health warning types.
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
     * @param heartRate An <b>int</b> of the heart rate at a point in an activity.
     * @param maxHeartRate An <b>int</b> of the maximum heart rate the user should reach.
     * @return <b>true</b> if the heart rate is greater than the maximum heart rate, <b>false</b> otherwise.
     */
    private static boolean checkCardiovascularMortality(int heartRate, int maxHeartRate)
    {
        return (heartRate > maxHeartRate);
    }


    /**
     * Method to check a user for a Bradycardia health warning.
     * Note: This does not check for Bradycardia in children under 15 years old as in most cases this is harmless.
     * @param heartRate A <b>double</b> of the heart rate of the user at a point in an activity.
     * @return <b>true</b> if the heart rate suggests bradycardia warning is necessary, <b>false</b> otherwise.
     */
    private static boolean checkBradycardia(int heartRate)
    {
        return (heartRate < 60);
    }


    /**
     * Method to check a user for a Tachycardia health warning.
     * @param heartRate A <b>Double</b> of the heart rate of the user as they first start their activity.
     * @param age An <b>int</b> The users' age.
     * @return <b>true</b> if the warning is necessary, <b>false</b> otherwise.
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
     * @return A <b>String</b> of the name of the health warning.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the health warning type.
     * @return A <b>HealthWarningType</b> an enum of the type of health warning.
     */
    public HealthWarningType getType()
    {
        return type;
    }


    /**
     * Getter method for the activity name.
     * @return A <b>String</b> of the activity name.
     */
    public String getActivityName() {
        return activityName;
    }


    /**
     * Getter method for the start date of the activity that caused the health warning.
     * @return A <b>DateTime</b> of the start date of an activity.
     */
    public DateTime getActivityDate() {
        return activityDate;
    }
}
