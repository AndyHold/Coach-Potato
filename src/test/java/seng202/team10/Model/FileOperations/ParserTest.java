package seng202.team10.Model.FileOperations;

import org.junit.Test;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;
import seng202.team10.Model.Exceptions.NoDataFoundException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserTest {

    private Parser testParser = new Parser();


    @Test
    public void overallTest() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
        int entryCounter = 0;
        for (Activity temp: testResults){
            ArrayList<Entry> activeEntries = temp.getEntries();
            for(Entry tempEntry: activeEntries){

                entryCounter+= 1;
            }
        }
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
    public void processFile() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        ArrayList<Activity> testResults = testParser.processFile(formattedFile);
        assertEquals(12, testResults.size());
    }

    @Test
    public void processLineDateStringSame() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        testParser.setLinePosition(35);
        Entry testEntry = testParser.processLine(formattedFile);
        Entry actualEntry = new Entry(new DateTime(2015, 4, 12, 22, 0, 42), 157, new Position(30.245576, -97.823843, 220.3));
        assertTrue(actualEntry.getDateString().equals(testEntry.getDateString()));

    }

    @Test
    public void processLineTimeStringSame() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        testParser.setLinePosition(35);
        Entry testEntry = testParser.processLine(formattedFile);
        Entry actualEntry = new Entry(new DateTime(2015, 4, 12, 22, 0, 42), 157, new Position(30.245576, -97.823843, 220.3));
        assertTrue(actualEntry.getTimeString().equals(testEntry.getTimeString()));
    }

    @Test
    public void processLineHeartRateSame() throws FileNotFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("./FilesToLoad/testdata.csv");
        ArrayList<ArrayList<String>> formattedFile = testParser.formatFileContents(fileContents);
        testParser.setLinePosition(35);
        Entry testEntry = testParser.processLine(formattedFile);
        Entry actualEntry = new Entry(new DateTime(2015, 4, 12, 22, 0, 42), 157, new Position(30.245576, -97.823843, 220.3));
        assertTrue(actualEntry.getHeartRateString().equals(testEntry.getHeartRateString()));
    }


    @Test
    public void changeLinePos(){
        testParser.setLinePosition(50);
        assertEquals(50, testParser.getLineIndex());
    }

    @Test
    public void nonExistentFile(){
        String message = "Test Failed";
        try {
            testParser.getFileContents("failtest");
        } catch(FileNotFoundException f) {
            message = "File Not Found";
        }
        assertEquals("File Not Found", message);
    }


    /*
     * The following tests all test that the correct number of activities are uploaded depending on the file.
     * Some files should throw exceptions when there is no data found, and these ones are caught.
     */

    @Test
    public void tooManyBadEntriesAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/toomanycommas.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 0);
    }

    @Test
    public void justTooManyBadEntriesAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/justTooManyBadEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 0);
    }

    @Test
    public void justNotEnoughBadEntriesAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/justNotEnoughBadEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 12);
    }

    @Test
    public void allGoodEntriesAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        boolean worked = true;
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/allGoodEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 12);

    }

    @Test
    public void allBadEntriesAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/allBadEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 0);
    }

    @Test
    public void allBadActivityHeadersAssertException() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/allBadHeaders.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        try {
            testParser.processFile(formattedFileContents);
            assertTrue(false);
        } catch (NoDataFoundException e) {
            assertEquals("No activities found in file.", e.getMessage());
        }
    }

    @Test
    public void fourBadActivityHeadersAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        boolean worked = true;
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/someBadActivityHeaders.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 8);
    }

    @Test
    public void emptyActivityAssertException() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/emptyFile.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        try {
            testParser.processFile(formattedFileContents);
            assertTrue(false);
        } catch (NoDataFoundException e) {
            assertEquals("No activities found in file.", e.getMessage());
        }
    }

    @Test
    public void oneEntryInActivityAssertActivityNumber() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/oneEntry.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(activities.size() == 0);
    }

    @Test
    public void wrongFileTypeAssertException() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/picture.png");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        try {
            testParser.processFile(formattedFileContents);
            assertTrue(false);
        } catch (NoDataFoundException e) {
            assertEquals("No activities found in file.", e.getMessage());
        }
    }

    @Test
    public void emptyFileAssertException() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/emptyFile.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        try {
            testParser.processFile(formattedFileContents);
            assertTrue(false);
        } catch (NoDataFoundException e) {
            assertEquals("No activities found in file.", e.getMessage());
        }
    }

    @Test
    public void twoActivityHeadersInARowAssertException() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/twoActivityHeaders.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        try {
            ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
            assertTrue(false);
        } catch (NoDataFoundException e) {
            assertEquals("No activities found in file.", e.getMessage());
        }
    }

    /*
     * The following tests all check that the correct number of entries are uploaded for the user depending on the file
     * uploaded. The overall sum of entries for all data entered will be found and compared. The correct value is
     * found by counting the number of lines. Sometimes the correct number of "Bad activities" is checked if the file
     * uploads zero entries anyway.
     */

    @Test
    public void tooManyCommas() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/toomanycommas.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(testParser.getBadActivities() == 1);
    }

    @Test
    public void justTooManyBadEntries() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/justTooManyBadEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(testParser.getBadActivities() == 12);
    }

    @Test
    public void justNotEnoughBadEntries() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/justNotEnoughBadEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        int numberOfEntriesSuccessfullyUploaded = 0;
        for (Activity activity : activities) {
            numberOfEntriesSuccessfullyUploaded += activity.getEntries().size();
        }
        assertEquals(1071, numberOfEntriesSuccessfullyUploaded);
    }

    @Test
    public void allGoodEntries() throws FileNotFoundException, NoDataFoundException {
        boolean worked = true;
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/allGoodEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        int numberOfEntriesSuccessfullyUploaded = 0;
        for (Activity activity : activities) {
            numberOfEntriesSuccessfullyUploaded += activity.getEntries().size();
        }
        assertEquals(1135, numberOfEntriesSuccessfullyUploaded);

    }

    @Test
    public void allBadEntries() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/allBadEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(testParser.getBadActivities() == 12);
    }

    @Test
    public void allBadActivityHeaders() throws FileNotFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/allBadHeaders.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = null;
        try {
            activities = testParser.processFile(formattedFileContents);
            assertTrue(false);
        } catch (NoDataFoundException e) {
            assertEquals(null, activities);
        }
    }

    @Test
    public void fourBadActivityHeaders() throws FileNotFoundException, NoDataFoundException {
        boolean worked = true;
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/someBadActivityHeaders.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        int numberOfEntriesSuccessfullyUploaded = 0;
        for (Activity activity : activities) {
            numberOfEntriesSuccessfullyUploaded += activity.getEntries().size();
        }
        assertEquals(961, numberOfEntriesSuccessfullyUploaded);
    }

    @Test
    public void oneEntryInActivity() throws FileNotFoundException, NoDataFoundException {
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/oneEntry.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(testParser.getBadActivities() == 1);
    }

    @Test
    public void parseDateTimeFromStringThrowsException() {
        DateTime dateTime = null;
        try {
            dateTime = testParser.parseDateTimeFromStrings("this is a test", "throw exception");
            assertTrue(false);
        } catch (IllegalArgumentException exception) {
            assertTrue(dateTime == null);
        }

    }

    @Test
    public void parseDateTimeFromStringReturnsCorrectDate() {
        DateTime dateTime = null;
        DateTime dateTime1 = new DateTime(2018, 4, 3, 23,46, 12);
        dateTime = testParser.parseDateTimeFromStrings("03/04/2018", "23:46:12");
        assertTrue(dateTime.isEqual(dateTime1));
    }

    @Test
    public void entryDateTimeMangled() throws FileNotFoundException, NoDataFoundException{
        ArrayList<String> fileContents = testParser.getFileContents("FilesToLoad/TestData/badDateEntries.csv");
        ArrayList<ArrayList<String>> formattedFileContents = testParser.formatFileContents(fileContents);
        ArrayList<Activity> activities = testParser.processFile(formattedFileContents);
        assertTrue(testParser.getBadActivities() == 4);
    }
}