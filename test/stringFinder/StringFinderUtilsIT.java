package stringFinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringFinderUtilsIT {
  
  public StringFinderUtilsIT() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getFirstChar method, of class StringFinderUtils.
   */
  @Test
  public void testGetFirstChar() {
    System.out.println("getFirstChar");
    CharSequence string = null;
    int lastChar = 0;
    int expResult = 0;
    int result = 0;
    
    string = null;
    lastChar = 0;
    expResult = 0;
    result = StringFinderUtils.getFirstChar(string, lastChar);
    assertEquals(expResult, result);
    
    string = "";
    lastChar = 0;
    expResult = 0;
    result = StringFinderUtils.getFirstChar(string, lastChar);
    assertEquals(expResult, result);

    string = "abc";
    lastChar = 3;
    expResult = 0;
    result = StringFinderUtils.getFirstChar(string, lastChar);
    assertEquals(expResult, result);
    
    string = "   abc";
    lastChar = 6;
    expResult = 3;
    result = StringFinderUtils.getFirstChar(string, lastChar);
    assertEquals(expResult, result);
    
    string = "abc.abc";
    lastChar = 7;
    expResult = 4;
    result = StringFinderUtils.getFirstChar(string, lastChar);
    assertEquals(expResult, result);
    
    string = "abc.abc.abc";
    lastChar = 11;
    expResult = 8;
    result = StringFinderUtils.getFirstChar(string, lastChar);
    assertEquals(expResult, result);
  }

  /**
   * Test of getLastChar method, of class StringFinderUtils.
   */
  @Test
  public void testGetLastChar() {
    System.out.println("getLastChar");
    CharSequence string = null;
    int expResult = 0;
    int result = 0;
    
    string = "a";
    expResult = 1;
    result = StringFinderUtils.getLastChar(string);
    assertEquals(expResult, result);
    
    string = "abc";
    expResult = 3;
    result = StringFinderUtils.getLastChar(string);
    assertEquals(expResult, result);
    
    string = "abc   ";
    expResult = 3;
    result = StringFinderUtils.getLastChar(string);
    assertEquals(expResult, result);
    
    string = "abc     ";
    expResult = 3;
    result = StringFinderUtils.getLastChar(string);
    assertEquals(expResult, result);
  }

  /**
   * Test of getNameString method, of class StringFinderUtils.
   */
  @Test
  public void testGetNameString_3args() {
    System.out.println("getNameString");
    CharSequence mainString = null;
    int firstCharPosition = 0;
    int lastCharPosition = 0;
    CharSequence expResult = null;
    CharSequence result = null;

    mainString = "A";
    firstCharPosition = 0;
    lastCharPosition = 1;
    expResult = "A";
    result = StringFinderUtils.getNameString(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);

    mainString = " A";
    firstCharPosition = 1;
    lastCharPosition = 2;
    expResult = "A";
    result = StringFinderUtils.getNameString(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);
    
    mainString = "   A   ";
    firstCharPosition = 3;
    lastCharPosition = 4;
    expResult = "A";
    result = StringFinderUtils.getNameString(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);
    
    mainString = "   A.B   ";
    firstCharPosition = 5;
    lastCharPosition = 6;
    expResult = "B";
    result = StringFinderUtils.getNameString(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);
    
  }

  /**
   * Test of isAllLowerCase method, of class StringFinderUtils.
   */
  @Test
  public void testIsAllLowerCase_3args() {
    System.out.println("isAllLowerCase");
    CharSequence mainString = null;
    int firstCharPosition = 0;
    int lastCharPosition = 0;
    boolean expResult = false;
    boolean result = false;

    mainString = "A";
    firstCharPosition = 0;
    lastCharPosition = 1;
    expResult = false;
    result = StringFinderUtils.isAllLowerCase(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);
    
    mainString = "a";
    firstCharPosition = 0;
    lastCharPosition = 1;
    expResult = true;
    result = StringFinderUtils.isAllLowerCase(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);
    
    mainString = "Aa";
    firstCharPosition = 0;
    lastCharPosition = 1;
    expResult = false;
    result = StringFinderUtils.isAllLowerCase(mainString, firstCharPosition, lastCharPosition);
    assertEquals(expResult, result);
  }

  /**
   * Test of toUpperCase method, of class StringFinderUtils.
   */
  @Test
  public void testToUpperCase() {
    System.out.println("toUpperCase");
    CharSequence mainString = "aSa";
    CharSequence expResult = "ASA";
    CharSequence result = StringFinderUtils.toUpperCase(mainString);
    assertEquals(expResult, result);
  }
  
}
