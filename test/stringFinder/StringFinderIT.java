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
  
  @Test
  public void testContainsHomeworkRules() {
    
    StringFinder instance;
 
    assertTrue(new StringFinder("a.b.FooBarBaz").contains("FB"));
    assertTrue(new StringFinder("a.b.FooBarBaz").contains("FoBa"));
    assertTrue(new StringFinder("a.b.FooBarBaz").contains("FBar"));
    
    assertTrue(new StringFinder("c.d.FooBar").contains("FB"));
    assertTrue(new StringFinder("c.d.FooBar").contains("FoBa"));
    assertTrue(new StringFinder("c.d.FooBar").contains("FBar"));
    
    assertFalse(new StringFinder("c.d.FooBar").contains("BF"));
    
    assertTrue(new StringFinder("FooBarBaz").contains("fbb"));
    assertFalse(new StringFinder("FooBarBaz").contains("fBb"));
    
    assertTrue(new StringFinder("FooBar").contains("FBar "));
    assertFalse(new StringFinder("FooBarBaz").contains("FBar "));
    
    assertTrue(new StringFinder("FooBarBaz").contains("B*rBaz"));
    assertFalse(new StringFinder("BrBaz").contains("B*rBaz"));
    
    assertFalse(new StringFinder("a.b.FooBarBaz").contains("Bar "));
    assertTrue(new StringFinder("BarBaz").contains("Bar"));
  }
  
}
