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
<<<<<<< HEAD
<<<<<<< HEAD
     * Very Thorough Test :-)
=======
     * Rigourous Test :-)
>>>>>>> f818a58... an example test
=======
     * Very Thorough Test :-)
>>>>>>> 606e5f7... an example test
     */
    public void testApp()
    {
        CamTest camsTest = new CamTest();
        assertEquals( camsTest.printName(), "This is Cams test" );
    }
}