package seng202.team10;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CamTestTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CamTestTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CamTestTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        CamTest camsTest = new CamTest();
        assertEquals( camsTest.printName(), "This is Cams test" );
    }
}