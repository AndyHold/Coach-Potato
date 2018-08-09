package seng202.team10;

        import junit.framework.Test;
        import junit.framework.TestCase;
        import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AndysTestTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AndysTestTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AndysTestTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        AndysTest andysTest = new AndysTest();
        assertEquals( andysTest.getName(), "Hi my name is Andy" );
    }
}
