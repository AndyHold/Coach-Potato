package seng202.team10.Model.FileOperations;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser testParser = new Parser();


    @Test
    /* this is an unofficial test for me to test the whole process */
    public void overallTest() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
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
    public void getFileContents() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        assertEquals(1147, fileContents.size());
    }

    @Test
    public void formatFileContents() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        assertEquals(1147, formattedFile.size());
    }

    @Test
    public void processFile() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
        assertEquals(12, testResults.size());
    }

    @Test
    public void processActivity() throws FileNotFoundException, IllegalArgumentException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        Activity testActivity = testParser.processActivity(formattedFile);
        assertEquals("Name= 'Walk in the woods', startDateTime=10th, April, 2015 - 23:42:28, averageVelocity=0.05050964943354281, averageHeartRate=138.15151515151516, totalDistance=49.80251434147321, totalDuration=986", testActivity.toString());
    }

    @Test
    public void processLine() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        testParser.setLinePosition(35);
        Entry testEntry = testParser.processLine(formattedFile);
        assertTrue(testEntry.isFirstEntry());
    }


    @Test
    public void changeLinePos(){
        testParser.setLinePosition(50);
        assertEquals(50, testParser.getLineIndex());
    }

    @Test
    public void nonexistantFile(){
        String message = "Test Failed";
        try {
            testParser.getFileContents("failtest");
        } catch(FileNotFoundException f) {
            message = "File Not Found";
        }
        assertEquals("File Not Found", message);
    }
}