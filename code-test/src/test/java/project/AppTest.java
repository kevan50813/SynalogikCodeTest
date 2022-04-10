package project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    App a = new App();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    public void testWordCount(){
        assertEquals(a.wordCount("a a"),2);
        assertEquals(a.wordCount("aa"),1);
        assertEquals(a.wordCount("11"),1);
        assertEquals(a.wordCount("A a &&"),3);
        assertEquals(a.wordCount("qwertyuiop[]asdfghjkl;'#zxcvbnm,./"),1);
    }

    public void testAverage(){
        assertEquals(a.avgWordLen(5,2),2.5);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
