package seng202.team10.Visual;

import seng202.team10.Control.MainController;

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
<<<<<<< HEAD
     * method to set the currently active scene to this one
     * @param guiController The main controller
=======
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
     */
    public void setMainController(MainController mainController);

    /**
     * method to run the initial setup of the scene
     */
    public void setUpScene();
}
