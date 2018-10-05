package seng202.team10.Model.ActivitiesData;


/**
 * Enum for different types of health warnings.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public enum HealthWarningType implements java.io.Serializable {


    TACHYCARDIA("Tachycardia", "https://www.google.co.nz/search?ei=9I-uW4XRHc_X-Qae4ZOoDg&q=tachycardia&oq=tachycardia&gs_l=psy-ab.4..0i67k1l9j0.2429.2836.0.3438.2.2.0.0.0.0.202.402.2-2.2.0....0...1c.1.64.psy-ab..0.2.402....0.5kH3TaeveXI"),
    BRADYCARDIA("Bradycardia", "https://www.google.co.nz/search?ei=-I-uW6j7PNLT-QbK95-oDA&q=bradycardia&oq=br&gs_l=psy-ab.3.0.0i67k1l8j0j0i67k1.223410.223552.0.225128.2.2.0.0.0.0.340.340.3-1.1.0....0...1c.1.64.psy-ab..1.1.340....0.Gc5VgwHgisc"),
    CARDIOVASCULAR_MORTALITY("Cardiovascular Mortality", "https://www.google.co.nz/search?ei=2pCuW8G_Osek-QaFh7GQDA&q=cardiovascular+mortality&oq=cardiovascular+mor&gs_l=psy-ab.3.0.0l10.28798.42260.0.43509.22.20.2.0.0.0.308.3167.0j2j11j1.14.0....0...1c.1.64.psy-ab..11.11.1971...0i67k1j0i131i67k1j0i22i30k1.0.H1lNS_Hbb7A");


    private String name;
    private String URL;


    /**
     * Constructor method for the HealthWarning Enum.
     */
    HealthWarningType(String name, String URL)
    {
        this.name = name;
        this.URL = URL;
    }


    /**
     * Getter method for the name of the health warning.
     * @return A <b>String</b> name of the health warning.
     */
    public String getName()
    {
        return name;
    }


    /**
     * Getter method for the URL of the health warning.
     * @return A <b>String</b> URL of the health warning.
     */
    public String getURL()
    {
        return URL;
    }


    @Override
    public String toString()
    {
        return name;
    }
}
