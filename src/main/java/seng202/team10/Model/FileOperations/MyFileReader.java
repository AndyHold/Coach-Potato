package seng202.team10.Model.FileOperations;

import seng202.team10.Model.UserProfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileReader {

    private static final String FILENAME = "/home/cosc/student/tkl34/Desktop/SENG202/SENG202_Project/SENG202_Project/CSV Activity Files/data.txt";
    private UserProfile localProfile;

    /* loads an already established profile from file */
//    public UserProfile loadExistingProfile{
//
//        //
//
//        return localProfile;
//    }


    /* opens a csv file for reading and returns an arraylist of strings of each line*/
    public ArrayList<String> openNewFile(String filePath) {
        BufferedReader bReader = null;
        FileReader fReader = null;
        ArrayList<String> fileContents = new ArrayList<String>();

        try {
            fReader = new FileReader(FILENAME);
            bReader = new BufferedReader(fReader);

            String currentLine;

            while ((currentLine = bReader.readLine()) != null) {
                fileContents.add(currentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bReader != null)
                    bReader.close();

                if (fReader != null)
                    fReader.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
        return fileContents;
    }
}

//    /* returns an arraylist of the lines of the csv file, used after openNewFile */
//    public ArrayList getFileContents() {
//
//        return fileContents;
//    }
//
//
//
//    /* checks whether the specified file exists, used as part of the file opening functions */
//    private boolean checkFileExists(String filename){
//
//        return exists;
//    }
//
//    /* sets the local profile for the filereader to use */
//    public void setLocalProfile(UserProfile activeProfile) {
//        localProfile = activeProfile;
//    }
//
//    /* returns the current profile the filereader is using */
//    public UserProfile getLocalProfile(){
//        return localProfile;
//    }
//}
