package seng202.team10.Model.FileOperations;

import org.junit.*;
import seng202.team10.Model.Exceptions.InvalidWeightException;
import seng202.team10.Model.Exceptions.UserNameException;
import seng202.team10.Model.UserProfile;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FileWriterTest {


    private static FileReader testReader = new FileReader();
    private static FileWriter testWriter = new FileWriter();
    private static UserProfile testProfile = new UserProfile();


    @BeforeClass
    public static void setUp() throws UserNameException, InvalidWeightException
    {
        testWriter.createProfileFolder();
        testProfile.setName("jeff");
        testProfile.setGender("Male");
        testProfile.setWeight(75);
        testWriter.saveProfile(testProfile);
    }


    @Test
    public void saveProfile() {
        testWriter.saveProfile(testProfile);
        assertTrue(testReader.checkFileExists("./profiles/" + testProfile.getName() + " - " + testProfile.getGender() + ".ser"));
    }


    @Test
    public void createProfileFolder() {
        testWriter.createProfileFolder();
        assertTrue(testReader.checkFileExists("./profiles"));

    }


    @Test
    public void deleteProfile() throws UserNameException
    {
        UserProfile secondTestProfile = new UserProfile();
        secondTestProfile.setName("bill");
        secondTestProfile.setGender("Male");
        testWriter.saveProfile(secondTestProfile);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<String> userGenders = new ArrayList<>();
        testReader.getExistingUsers(userNames, userGenders);
        int initialSize = userNames.size();
        testWriter.deleteProfile(secondTestProfile.getName() + " - " + secondTestProfile.getGender());
        testReader.getExistingUsers(userNames, userGenders);
        assertEquals(initialSize - 1, userNames.size());
    }


    @Test
    public void updateExistingProfile() throws InvalidWeightException, IOException, ClassNotFoundException
    {
        testWriter.saveProfile(testProfile);
        testProfile.setWeight(100);
        testWriter.saveProfile(testProfile);
        assertEquals(100, testReader.loadExistingProfile(testProfile.getName()).getWeight(), 1);
    }


    @AfterClass
    public static void tearDown()
    {
        testWriter.deleteProfile("jeff");
    }
}