package seng202.team10.Control;

import seng202.team10.Model.FileOperations.FileReader;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

public class MainController {

    private static ArrayList<UserProfile> users;
    private static UserProfile currentUser;
    private static Parser parser;
    private static GUIController guiController;
    private static FileWriter dataWriter = new FileWriter();
    private static FileReader dataReader = new FileReader();

    public void openLoginScreen() {
        //guiController.openLoginScreen(guiController);
    }

    public void saveData() {
        dataWriter.saveProfile(currentUser);
    }

    public void loadData() {
        dataReader.loadExistingProfile(currentUser.getName());
    }

    public static void main(String[] args) {
        if(!dataReader.checkFileExists("./profiles")){
            dataWriter.createProfileFolder();
        }
        users = dataReader.getExistingUsers();
    }

    public UserProfile getCurrentUser() {
        return currentUser;
    }
}
