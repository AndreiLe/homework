/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringFinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class StringFinderTest {
  
  public StringFinderTest() {
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
   * Test of addFinderText method, of class StringFinder.
   */
  @Test
  public void testAddFinderText() {
    System.out.println("addFinderText");
    String finderText = "";
    StringFinder instance = new StringFinder();
    StringFinder expResult = null;
    StringFinder result = instance.addFinderText(finderText);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of contains method, of class StringFinder.
   */
  @Test
  public void testContains() {
    System.out.println("contains");
    CharSequence s = null;
    StringFinder instance = new StringFinder();
    boolean expResult = false;
    boolean result = instance.contains(s);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
