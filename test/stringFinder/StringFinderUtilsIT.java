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

    assertEquals(0, StringFinderUtils.getFirstChar(null, 0));
    
    assertEquals(0, StringFinderUtils.getFirstChar("", 0));
    
    assertEquals(0, StringFinderUtils.getFirstChar("abc", 3));
    
    assertEquals(3, StringFinderUtils.getFirstChar("   abc", 6));

    assertEquals(4, StringFinderUtils.getFirstChar("abc.abc", 7));
    
    assertEquals(8, StringFinderUtils.getFirstChar("abc.abc.abc", 11));
  }

  /**
   * Test of getLastChar method, of class StringFinderUtils.
   */
  @Test
  public void testGetLastChar() {
    System.out.println("getLastChar");

    assertEquals(1, StringFinderUtils.getLastChar("a"));
    
    assertEquals(3, StringFinderUtils.getLastChar("abc"));
    
    assertEquals(3, StringFinderUtils.getLastChar("abc   "));

    assertEquals(3, StringFinderUtils.getLastChar("abc     "));
  }

  /**
   * Test of getName method, of class StringFinderUtils.
   */
  @Test
  public void testGetNameString() {
    System.out.println("getNameString");

    assertEquals("A", StringFinderUtils.getName("A"));
    
    assertEquals("A", StringFinderUtils.getName(" A "));
    
    assertEquals("A", StringFinderUtils.getName("   A   "));
    
    assertEquals("B", StringFinderUtils.getName("   A.B   "));
    
    assertEquals("CbbVbb", StringFinderUtils.getName("   D.Addd.CbbVbb   "));
    assertNotEquals("vbbvbb", StringFinderUtils.getName("   D.Addd.CbbVbb   "));

    
  }

  /**
   * Test of isAllLowerCase method, of class StringFinderUtils.
   */
  @Test
  public void testIsAllLowerCase() {
    System.out.println("isAllLowerCase");
  
    assertFalse(StringFinderUtils.isAllLowerCase("A"));
    assertTrue(StringFinderUtils.isAllLowerCase("a"));
    
    assertFalse(StringFinderUtils.isAllLowerCase("Aa"));
    assertTrue(StringFinderUtils.isAllLowerCase("aa"));
  }

  /**
   * Test of toUpperCase method, of class StringFinderUtils.
   */
  @Test
  public void testToUpperCase() {
    System.out.println("toUpperCase");
    
    assertEquals("ASA", StringFinderUtils.toUpperCase("aSa"));
    assertNotEquals("aSa", StringFinderUtils.toUpperCase("aSa"));
  }
  
 /**
   * Test of contains method, of class StringFinderUtils.
   */
  @Test
  public void testCompareWords() {
    System.out.println("compareWords");

    assertTrue(StringFinderUtils.contains("B", "B"));
    assertFalse(StringFinderUtils.contains("B", "S"));

    assertTrue(StringFinderUtils.contains("Baz", "B"));
    assertFalse(StringFinderUtils.contains("Baz", "A"));

    assertTrue(StringFinderUtils.contains("Baz", "Baz"));
    assertFalse(StringFinderUtils.contains("Baz", "Bar"));
    assertFalse(StringFinderUtils.contains("Baz", "Bz"));
    
    assertTrue(StringFinderUtils.contains("Baz", "B**z"));
    assertFalse(StringFinderUtils.contains("Baz", "B*r"));
    assertFalse(StringFinderUtils.contains("Baz", "B*a"));
    
    assertTrue(StringFinderUtils.contains("Bazfrdardgrazfrdar", "Ba*az"));
    assertFalse(StringFinderUtils.contains("Bazfrdardgrazfrdar", "Ba*rar"));
    
    assertTrue(StringFinderUtils.contains("Baz", "B*"));
    assertTrue(StringFinderUtils.contains("Baz", "B**"));
    
  }
  
  
}
