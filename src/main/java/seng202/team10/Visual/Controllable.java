package seng202.team10.Visual;

import seng202.team10.Control.MainController;

/**
 * Interface for the controllers of screens.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public interface Controllable {

    /**
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController);

    /**
     * Method to run the initial setup of the scene.
     */
    public void setUpScene();
}
