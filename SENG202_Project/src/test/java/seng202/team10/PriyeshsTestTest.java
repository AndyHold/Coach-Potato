package seng202.team10;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PriyeshsTestTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PriyeshsTestTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PriyeshsTestTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        PriyeshsTest priyeshsTest = new PriyeshsTest();
        assertEquals( priyeshsTest.printName(), "Hello I am Priyesh" );
    }
}
