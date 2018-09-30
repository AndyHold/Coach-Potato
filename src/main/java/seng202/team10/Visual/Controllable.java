package seng202.team10.Visual;

import seng202.team10.Control.GUIController;

/**
 * Interface for the controllers of screens.
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public interface Controllable {

    /**
     * Setter method to pass the GUIController into this controller.
     * @param guiController <b>GUIController:</b> The main controller.
     */
    public void setApp(GUIController guiController);

    /**
     * Method to run the initial setup of the scene.
     */
    public void setUpScene();
}
