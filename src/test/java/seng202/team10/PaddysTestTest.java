package seng202.team10;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PaddysTestTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PaddysTestTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PaddysTestTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        PaddysTest paddysTest = new PaddysTest();
        assertEquals( paddysTest.getName(), "Hi my name is Paddy" );
    }
}
