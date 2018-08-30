package seng202.team10.Model.FileOperations;

import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser testParser = new Parser();

    @Test
    /* this is an unofficial test for me to test the whole process */
    public void overallTest() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("testdata.csv");

        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);

        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
        int activityCounter = 0;
        int entryCounter = 0;
        for (Activity temp: testResults){


            ArrayList<Entry> activeEntries = temp.getEntries();
            activityCounter += 1;
            for(Entry tempEntry: activeEntries){

                entryCounter+= 1;
            }
        }
        assertEquals(12, activityCounter);
        assertEquals(1135, entryCounter);
        }



    @Test
    public void getFileContents() {
    }

    @Test
    public void formatFileContents() {
    }

    @Test
    public void processFile() {
    }

    @Test
    public void processActivity() {
    }

    @Test
    public void processLine() {
    }

    @Test
    public void processPosition() {
    }

    @Test
    public void getLineIndex() {
    }

    @Test
    public void activitiesToString() {
    }
}