package seng202.team10;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TorbensTestTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TorbensTestTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TorbensTestTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        TorbensTest torbensTest = new TorbensTest();
        assertEquals( torbensTest.printName(), "Hello I am Torben" );
    }
}
