package seng202.team10.Model.FileOperations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FileReaderTest {

    private static FileReader testReader = new FileReader();
    private static FileWriter testWriter = new FileWriter();
    private static UserProfile testProfile = new UserProfile();


    @BeforeClass
    public static void setUp() throws Exception {
        testWriter.createProfileFolder();
        testProfile.setName("jeff");
        testProfile.setWeight(75);
        testWriter.saveProfile(testProfile);
    }

/*    @AfterClass
    public static void tearDown() {

    }*/

    @Test
    public void loadExistingProfile() {
        UserProfile loadedProfile = testReader.loadExistingProfile(testProfile.getName());
        assertEquals("jeff", loadedProfile.getName());
        assertEquals(75, loadedProfile.getWeight(), 1);
    }

    @Test
    public void openNewFile() {
    }

    @Test
    public void getExistingUsers(){
        UserProfile secondTestProfile = new UserProfile();
        secondTestProfile.setName("bill");
        testWriter.saveProfile(secondTestProfile);
        ArrayList<String> testFileNames = testReader.getExistingUsers();
        ArrayList<String> expectedNames = new ArrayList<String>(Arrays.asList("bill", "jeff"));
        assertEquals(expectedNames , testFileNames);
    }

    @Test
    public void checkFileExists() {
        assertTrue(testReader.checkFileExists("./profiles/" + testProfile.getName() + ".ser"));
    }

}