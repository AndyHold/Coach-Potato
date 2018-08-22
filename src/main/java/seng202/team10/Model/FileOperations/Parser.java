package FileOperations;

import seng202.team10.Model.FileOperations.FileReader;

import java.util.ArrayList;

public class Parser {


    private ArrayList fileContents;
    private int linePosition = 0;
    private Activities activities;
    private Activity currentActivity;
    private Entry currentEntry;
    private FileReader fileReader;
    private FileWriter fileWriter;


    /**
     * Constructs and uses the methods of a FileReader object to
     * open and read a files' contents. Must be a csv file.
     *
     *
     * @return fileContents  An ArrayList containing an ArrayList containing string values.
     */
    public String getFileContents() {
        fileReader = new FileReader();
        if (fileReader.checkFileExists(filename) == true) {
            fileReader.openFile(filename);
            fileContents = fileReader.getFileContents();
        }
        return fileContents;
    }

    /**
     *
     * @return activites  Every activity in the file should now be stored here.
     */
    public Activities processFile() {
        Activities activities = new Activities;
        while (linePosition < fileContents.size()) {
            activities.add(processActivity());
        }
        return activities;
    }

    public Activity processActivity() {
        Activity activity = new Activity();
        activity.setName(fileContents[linePosition][1]);
        linePosition += 1;
        activity.setDate(fileContents[linePosition][0]);
        while (fileContents[linePosition].size() == 6) {
            activity.addEntry(processLine());
            linePosition += 1;
        }
        return activity;
    }

    public Entry processLine(){
        Entry entry = new Entry();
        ArrayList<String> currentLine = fileContents[linePosition];
        entry.setTime(currentLine[1]);
        entry.setHeartRate(currentLine[2]);
        entry.setPosition(currentLine[3], currentLine[4], currentLine[5]);
        return entry;
    }

    public int getLineIndex (){
        return linePosition;
    }

    public String activitiesToString(){
        return "";
    }

//    public String userProfileToString(UserProfile) {
//        return;
//    }

    public void writeDataToFile(String data) {
        fileWriter = new FileWriter();
        if (fileWriter.checkFileExists() == true) {
            fileWriter.createFile();
            fileWriter.openFile();
            fileWriter.writeFileContents(data);

        }
    }
}