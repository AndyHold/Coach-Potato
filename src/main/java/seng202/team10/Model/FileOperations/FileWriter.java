package seng202.team10.Model.FileOperations;

import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.UserProfile;

public class FileWriter {

    private UserProfile activeProfile;

    public void saveProfile(UserProfile profile){
        activeProfile = profile;
        if(checkProfileFolderExists(activeProfile) == false){
            createProfileFolder(activeProfile);
        }
    }

    public void saveActivity(Activity activity){

    }

    public void createProfileFolder(UserProfile profile){

    }

    private boolean checkProfileFolderExists(UserProfile profile) {

        return exists;
    }


}
