package seng202.team10.Model.FileOperations;

import seng202.team10.Control.InputValidator;
import seng202.team10.Model.ActivitiesData.*;
import seng202.team10.Model.Exceptions.BadActivityException;
import seng202.team10.Model.Exceptions.NoActivityFoundException;
import seng202.team10.Model.Exceptions.NoDataFoundException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Parser Class for Coach Potato SENG202 2018S2
 */
public class Parser {

    private int linePosition = 0;
    private int badActivities;
    private boolean badActivitiesInFile;



    /**
     * Constructs and uses the methods of a FileReader object to
     * open and read the contents of a file. Must be a csv file.
     * @param filePath  the location of the file.
     * @throws  FileNotFoundException when there is no file at the location.
     * @return fileContents  An ArrayList containing an ArrayList containing string values.
     */
    public ArrayList<String> getFileContents(String filePath) throws FileNotFoundException
    { //handle this with gui message in what calls this
        ArrayList<String> fileContents;
        FileReader reader = new FileReader();
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
     * @return formattedFile  An ArrayList&gt;ArrayList&gt;String&lt;&lt; that contains a list of lines,
     * that are each lists that contain each value in an index.
     */
    public ArrayList<ArrayList<String>> formatFileContents(ArrayList<String> fileContents)
    {
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
     * @param formattedFile  The formatted file to be processed.
     * @throws NoDataFoundException when there is no data in the formatted file.
     * @return activites  An ArrayList&gt;Activity&lt; that contains every activity in the file.
     */
    public ArrayList<Activity> processFile(ArrayList<ArrayList<String>> formattedFile) throws NoDataFoundException
    {
        badActivities = 0;
        ArrayList<Activity> activities = new ArrayList<>();
        if (formattedFile.size() == 0) {
            throw new NoDataFoundException();
        } else {
            while (linePosition < formattedFile.size()) {
                badActivitiesInFile = false;
                try {
                    activities.add(processActivity(formattedFile));
                } catch (BadActivityException exception) {
                    badActivities += 1;
                } catch (NoActivityFoundException exception) {
                    badActivitiesInFile = true;
                }
            }
            this.linePosition = 0;

            if (activities.size() == 0 && badActivities == 0) {
                throw new NoDataFoundException();
            }
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
     * @param formattedFile  The formatted file to be processed for one activity.
     * @throws BadActivityException  when the activity cannot be parsed.
     * @throws NoActivityFoundException when there is no activity in the file to process.
     * @return activity  An Activity object that contains a number of entries.
     */
    public Activity processActivity(ArrayList<ArrayList<String>> formattedFile) throws BadActivityException, NoActivityFoundException
    {
        InputValidator inputValidator = new InputValidator();
        if (!inputValidator.validActivityHeader(formattedFile.get(linePosition))) {
            while (!inputValidator.validActivityHeader(formattedFile.get(linePosition)) && linePosition < formattedFile.size()-1) {
                linePosition++;
            }
            if (!(inputValidator.validActivityHeader(formattedFile.get(linePosition)))) {
                this.linePosition++;
                throw new NoActivityFoundException();
            }


        }
        String name = formattedFile.get(linePosition).get(1);
        linePosition += 1;

        int badEntries = 0;
        int totalEntries = 0;

        Activity activity = new Activity(name);
        DateTime currentDateTime = null;
        DateTime previousDateTime = null;

        while (linePosition < formattedFile.size() && (formattedFile.get(linePosition)).size() != 2) {

            if(inputValidator.isValidEntryLine(formattedFile.get(linePosition))){
                Entry currentEntry = processLine(formattedFile);
                currentDateTime = currentEntry.getTime();
                if (previousDateTime != null && !dateIsValid(currentDateTime, previousDateTime)) {
                    throw new BadActivityException();
                }
                activity.addEntry(currentEntry);
            } else {
                badEntries += 1;
            }

            totalEntries += 1;
            linePosition += 1;
            previousDateTime = currentDateTime;
        }

        if((badEntries * 10) > totalEntries) {
            throw new BadActivityException();
        }

        if (activity.getEntries().size() < 2) {
            throw new BadActivityException();
        }

        activity.postEntriesSetUp();

//        while (linePosition < formattedFile.size() && formattedFile.get(linePosition).get(0) != "#start"){
////            linePosition+=1;
////        }

        return activity;
    }

    /**
     * Method to check that the next date of an activity is valid. It checks that the next entry's dateTime is not
     * more than 3 hours away and not before the previous date. In these cases, the activity is dumped
     * as the date and time of the activity is compromised and will likely be incorrect.
     * @param currentEntryDateTime The DateTime of the current entry being looked at
     * @param previousDateTime The DateTime being compared with the current entry
     * @return True if the next date is within 3 hours after the current date, false if it isn't, or is before the current.
     */
    private boolean dateIsValid(DateTime currentEntryDateTime, DateTime previousDateTime) {
        if (currentEntryDateTime.subtract(previousDateTime) > (3*60*60)) { //that's 3 hours in seconds.
            return false;
        }
        if (previousDateTime.isAfter(currentEntryDateTime)) {
            return false;
        }
        return true;
    }

    /**
     * Processes an entry in the file contents, called by the processActivity() function.
     * Sets the time, heart rate and position of the entry, converting to int for time and
     * heart rate, and to a Position object for position.
     * @param formattedFile  The formatted file to be processed.
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
//    private int removeDuplicateEntries(Activity activity) {
//        int removeCount = 0;
//        for (int i = 0; i < activity.getEntries().size(); i++) {
//            for (int j = 0; j < activity.getEntries().size(); j++) {
//                if (activity.getEntries().get(i).equals(activity.getEntries().get(j))) {
//                    if (activity.getEntries().get(i) == activity.getEntries().get(j)) {
//                        ;
//                    } else {
//                        activity.getEntries().remove(j);
//                        removeCount += 1;
//                    }
//                }
//
//            }
//        }
//        return removeCount;
//    }

    /**
     * returns the number of activities that were not imported for various reasons
     * @return int count of bad activities
     */
    public int getBadActivities() {
        return badActivities;
    }

    /**
     * returns the current line index that the parser is working at
     * @return index of line
     */
    public int getLineIndex (){
        return linePosition;
    }

    /**
     * manually sets the parser to move to a specific line
     * @param linePosition the line number to move to
     */
    public void setLinePosition(int linePosition) {
        this.linePosition = linePosition;
    }


}