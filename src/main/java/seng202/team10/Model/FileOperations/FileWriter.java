package seng202.team10.Model.FileOperations;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.UserProfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter
{

    private UserProfile activeProfile;


    /**
    saves the inputted user profile as a serialized file
     */
    public void saveProfile(UserProfile profile){
        activeProfile = profile;
        String filename = "./profiles/" + activeProfile.getName() + ".ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(activeProfile);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }


    }

    public void createProfileFolder(){
        new File("./profiles").mkdirs();
    }

    /** returns the last profile that was saved */
    public UserProfile getActiveProfile() {
        return activeProfile;
    }


}

