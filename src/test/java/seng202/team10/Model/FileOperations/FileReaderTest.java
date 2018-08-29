package seng202.team10.Model.FileOperations;

import org.junit.BeforeClass;
import org.junit.Test;
import seng202.team10.Model.UserProfile;

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
    public void checkFileExists() {
        assertTrue(testReader.checkFileExists("./profiles/" + testProfile.getName() + ".ser"));
    }
    
}