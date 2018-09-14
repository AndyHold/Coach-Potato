package seng202.team10.Model.FileOperations;

import seng202.team10.Control.InputValidator;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Parser {

    private int linePosition = 0;


    /**
     * Constructs and uses the methods of a FileReader object to
     * open and read the contents of a file. Must be a csv file.
     *
     * @return fileContents  An ArrayList containing an ArrayList containing string values.
     */
    public ArrayList<String> getFileContents(String filePath) throws FileNotFoundException { //handle this with gui message in what calls this
        ArrayList<String> fileContents;
        FileReader reader = new FileReader();
        InputValidator inputValidator = new InputValidator();
//        if(reader.checkFileExists("./FilesToLoad/" + filePath)) {
        if(reader.checkFileExists(filePath)) {
            try {
                fileContents = reader.openNewFile(filePath);
            } catch (IllegalArgumentException e) {
                throw new FileNotFoundException();
            }
        } else {
            throw new FileNotFoundException();
        }
        return fileContents;

    }

    /**
     * Formats an unparsed CSV file and returns an ArrayList with the values in indexes
     * and easily accessible.
     *
     * @param fileContents The unparsed contents of the file, in arraylist form with values
     *                     seperated with commas.
     * @return formattedFile  An ArrayList<ArrayList<String>> that contains a list of lines,
     * that are each lists that contain each value in an index.
     */
    public ArrayList<ArrayList<String>> formatFileContents(ArrayList<String> fileContents) {
        ArrayList<ArrayList<String>> formattedFile = new ArrayList<>();
        String[] splitLine;
        for (int i = 0; i < fileContents.size(); i++) {
            formattedFile.add(new ArrayList<>());
            splitLine = fileContents.get(i).split(",");
            for (String aSplitLine : splitLine) {
                formattedFile.get(i).add(aSplitLine);
            }
        }
        return formattedFile;
    }

    /**
     *Processes a list of activities from the contents of a file.
     *Calls processActivity() in a loop.
     *
     * @return activites  An ArrayList<Activity> that contains every activity in the file.
     */
    public ArrayList<Activity> processFile(ArrayList<ArrayList<String>> formattedFile) throws IllegalArgumentException {
        ArrayList<Activity> activities = new ArrayList<>();
        if (formattedFile.size() == 0) {
            throw new IllegalArgumentException("No data found in file");
        } else {
            while (linePosition < formattedFile.size()) {
                activities.add(processActivity(formattedFile));
            }
            this.linePosition = 0;
            return activities;
        }
    }


    /**
     * Parses a DateTime object from a date string and a time string.
     * Checks that there are the correct amount of values in
     * each, but does not check that the values are valid.
     *
     * @param dateString  A string that describes a date, should be in the format "DD/MM/YYYY"
     * @param timeString  A string that describes a time, should be in the format "HH:MM:SS"
     * @return  A new DateTime object initialized with the values gotten from the date and time strings.
     * @throws IllegalArgumentException  When the date or time string are not in the correct format
     */
    public DateTime parseDateTimeFromStrings(String dateString, String timeString) throws IllegalArgumentException
    {
        String[] dateArray = dateString.split("/");
        if (dateArray.length != 3) {
            throw new IllegalArgumentException("Date format wrong, needs to be of the format DD/MM/YYYY");
        }
        String[] timeArray = timeString.split(":");
        if (timeArray.length != 3) {
            throw new IllegalArgumentException("Time format wrong, needs to be of the format HH:MM:SS");
        }
        int day = Integer.valueOf(dateArray[0]);
        int month = Integer.valueOf(dateArray[1]);
        int year = Integer.valueOf(dateArray[2]);
        int hour = Integer.valueOf(timeArray[0]);
        int minute = Integer.valueOf(timeArray[1]);
        int second = Integer.valueOf(timeArray[2]);
        return new DateTime(year, month, day, hour, minute, second);
    }


    /**
     * Processes an activity in the file contents, called by the processFile() function.
     * Sets the name and date of the activity, then loops through the file
     * calling processLine() on each line, which is added to the activity object.
     *
     * @return activity  An Activity object that contains a number of entries.
     */
    public Activity processActivity(ArrayList<ArrayList<String>> formattedFile) throws IllegalArgumentException
    {
        InputValidator inputValidator = new InputValidator();
        if (!inputValidator.validActivityHeader(formattedFile.get(linePosition))) {
            while (!inputValidator.validActivityHeader(formattedFile.get(linePosition)) && linePosition < formattedFile.size()-1) {
                linePosition++;
            }
            throw new IllegalArgumentException("Invalid activity header");
        }
        String name = formattedFile.get(linePosition).get(1);
        linePosition += 1;

        int badEntries = 0;
        int totalEntries = 0;

//        boolean dateIsParsable = false;
//
//        String dateString = (formattedFile.get(linePosition).get(0));
//        String timeString = (formattedFile.get(linePosition).get(1));
//        DateTime dateTime = null;
//        while (!dateIsParsable && linePosition < formattedFile.size()) {
//            try {
//                dateTime = parseDateTimeFromStrings(dateString, timeString);
//                dateIsParsable = true;
//            } catch (IllegalArgumentException e) {
//                badEntries += 1;
//                totalEntries += 1;
//                linePosition += 1;
//            }
//        }
//
//        if((badEntries * 10) > totalEntries || !dateIsParsable) {
//            throw new IllegalArgumentException("Too many bad entries! Activity discarded!");
//        }

<<<<<<< HEAD
//        if (!inputValidator.isValidDateString(dateString) || !inputValidator.isValidTimeString(timeString)) {
//            badEntries += 1;
//        }


        Activity activity = new Activity(name);



=======
        //TODO get rid of dateTime in constructor
        Activity activity = new Activity(name, dateTime);
>>>>>>> 59ccd0b... Javadocced a function
        while (linePosition < formattedFile.size() && (formattedFile.get(linePosition)).size() != 2) {

            if(inputValidator.isValidEntryLine(formattedFile.get(linePosition))){
                activity.addEntry(processLine(formattedFile));
            } else {
                badEntries += 1;
            }

            totalEntries += 1;
            linePosition += 1;
        }

        if((badEntries * 10) > totalEntries) {
            throw new IllegalArgumentException("Too many bad entries! Activity discarded!");
        }

<<<<<<< HEAD
        activity.postEntriesSetUp();
=======
        //todo move these to activity
        activity.calculateTotalDistance();
        activity.calculateTotalDuration();
        activity.calculateAverageHeartRate();
        activity.calculateAverageVelocity();
        activity.determineType();
        activity.setEndDateTime();
        activity.setStrings();
>>>>>>> 59ccd0b... Javadocced a function


//        while (linePosition < formattedFile.size() && formattedFile.get(linePosition).get(0) != "#start"){
////            linePosition+=1;
////        }
        return activity;
    }

    /**
     * Processes an entry in the file contents, called by the processActivity() function.
     * Sets the time, heart rate and position of the entry, converting to int for time and
     * heart rate, and to a Position object for position.
     *
     * @return entry  An entry which details a moment in time in an activity .
     */
    public Entry processLine(ArrayList<ArrayList<String>> formattedFile){
        boolean isFirst = false;
        if(formattedFile.get(linePosition-1).size() != 6){
            isFirst = true;
        }
        ArrayList<String> currentLine = formattedFile.get(linePosition);
        String[] timeArray = (currentLine.get(1)).split(":");
        String[] dateArray = (currentLine.get(0)).split("/");
        int day = Integer.valueOf(dateArray[0]);
        int month = Integer.valueOf(dateArray[1]);
        int year = Integer.valueOf(dateArray[2]);
        int hour = Integer.valueOf(timeArray[0]);
        int minute = Integer.valueOf(timeArray[1]);
        int second = Integer.valueOf(timeArray[2]);

        DateTime dateTime = new DateTime(year, month, day, hour, minute, second);
        int heartRate = Integer.valueOf(currentLine.get(2));
        Position position = processPosition(currentLine);

        Entry newEntry = new Entry(dateTime, heartRate, position);
        newEntry.setFirstEntry(isFirst);
        return newEntry;
    }

    /**
     * Processes the position from the file by converting it to a position object from strings.
     * Called by the processLine() function.
     *
     * @param currentLine The current line the parser is on.
     * @return position  A Position object that details the position for an Entry.
     */
    private Position processPosition(ArrayList<String> currentLine){
        double latitude = Double.valueOf(currentLine.get(3));
        double longitude = Double.valueOf(currentLine.get(4));
        double elevation = Double.valueOf(currentLine.get(5));

        return new Position(latitude, longitude, elevation);
    }


    //POSSIBLY AN UNUSED FUNCTION.
    private int removeDuplicateEntries(Activity activity) {
        int removeCount = 0;
        for (int i = 0; i < activity.getEntries().size(); i++) {
            for (int j = 0; j < activity.getEntries().size(); j++) {
                if (activity.getEntries().get(i).equals(activity.getEntries().get(j))) {
                    if (activity.getEntries().get(i) == activity.getEntries().get(j)) {
                        ;
                    } else {
                        activity.getEntries().remove(j);
                        removeCount += 1;
                    }
                }

            }
        }
        return removeCount;
    }

    public int getLineIndex (){
        return linePosition;
    }

    public void setLinePosition(int linePosition) {
        this.linePosition = linePosition;
    }


}