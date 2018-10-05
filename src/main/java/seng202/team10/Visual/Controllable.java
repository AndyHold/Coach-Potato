package seng202.team10.Visual;

import seng202.team10.Control.GUIController;

/**
<<<<<<< HEAD
 * Controllable Interface for Coach Potato
 * SENG202 2018S2
=======
 * Interface for the controllers of screens.
 *
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public interface Controllable {

    /**
     * method to set the currently active scene to this one
     * @param guiController The main controller
     */
    public void setApp(GUIController guiController);

    /**
     * method to run the initial setup of the scene
     */
    public void setUpScene();
}
