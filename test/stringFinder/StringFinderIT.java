package stringFinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringFinderIT {
  
  public StringFinderIT() {
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
  }

  @Test
  public void testContains() {
    System.out.println("contains");
    
    CharSequence s = null;
    StringFinder instance = null;
    boolean result = false;
 
    //homework 
    instance = new StringFinder("a.b.FooBarBaz");
    result = instance.contains("FB");
    assertEquals(true, result);
    result = instance.contains("FoBa");
    assertEquals(true, result);
    result = instance.contains("FBar");
    assertEquals(true, result);
    
    instance = new StringFinder("c.d.FooBar");
    result = instance.contains("FB");
    assertEquals(true, result);
    result = instance.contains("FoBa");
    assertEquals(true, result);
    result = instance.contains("FBar");
    assertEquals(true, result);
    
    instance = new StringFinder("c.d.FooBar");
    result = instance.contains("BF");
    assertEquals(false, result);
    
    instance = new StringFinder("FooBarBaz");
    result = instance.contains("fbb");
    assertEquals(true, result);
    result = instance.contains("fBb");
    assertEquals(false, result);
    
    instance = new StringFinder("FooBar");
    result = instance.contains("FBar ");
    assertEquals(true, result);
    instance = new StringFinder("FooBarBaz");
    result = instance.contains("FBar ");
    assertEquals(false, result);
    
    instance = new StringFinder("FooBarBaz");
    result = instance.contains("B*rBaz");
    assertEquals(true, result);
    instance = new StringFinder("BrBaz");
    result = instance.contains("B*rBaz");
    assertEquals(false, result);
    
    instance = new StringFinder("a.b.FooBarBaz");
    result = instance.contains("Bar ");
    assertEquals(false, result);
    instance = new StringFinder("BarBaz");
    result = instance.contains("Bar");
    assertEquals(true, result);
  }
  
}
