package stringFinder;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringFinderStringIT {
  
  @Test
  public void testAddMainString() {

    assertEquals(asList("A"), new StringFinderString().addMainString("A").getWordList());
    assertEquals(asList("a"), new StringFinderString().addMainString("a").getWordList());
    
    assertNotEquals(asList("A"), new StringFinderString().addMainString("a").getWordList());
    assertNotEquals(asList("a"), new StringFinderString().addMainString("A").getWordList());
    
    assertEquals(asList("A","B","C"), new StringFinderString().addMainString("ABC").getWordList());
    assertNotEquals(asList("A","B","C"), new StringFinderString().addMainString("ABc").getWordList());

    assertEquals(asList("Aa","Bbc","C"), new StringFinderString().addMainString("AaBbcC").getWordList());
    assertNotEquals(asList("Aa","Bbc","V"), new StringFinderString().addMainString("AaBbcC").getWordList());

  }
  
  @Test(expected = NullPointerException.class) 
  public void testAddMainStringExseption() {

    assertEquals(null, new StringFinderString().addMainString(null));
  }
  @Test
  public void testAddMainStringExseption2() {

    try {
        new StringFinderString().addMainString(null);
        fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException anNullPointerException) {
        assertEquals(anNullPointerException.getMessage(), null);
    }
  }
  

  @Test
  public void testCompareLastWords() {

    assertTrue(new StringFinderString().addMainString("a").compareLastWords("a"));
    assertFalse(new StringFinderString().addMainString("A").compareLastWords("a"));
    
    assertTrue(new StringFinderString().addMainString("Aa").compareLastWords("Aa"));
    assertTrue(new StringFinderString().addMainString("Aa").compareLastWords("A"));
    assertFalse(new StringFinderString().addMainString("A").compareLastWords("Aa"));
    
    assertTrue(new StringFinderString().addMainString("BbAa").compareLastWords("Aa"));
    
     assertTrue(new StringFinderString().addMainString("Baz").compareLastWords("B*z"));
     assertFalse(new StringFinderString().addMainString("Baz").compareLastWords("B*a"));
  }
  

  @Test
  public void testGetWordsListSize() {
    
    assertEquals(0, new StringFinderString().addMainString("").getWordsListSize());
    
    assertEquals(1, new StringFinderString().addMainString("B").getWordsListSize());
    
    assertEquals(3, new StringFinderString().addMainString("ABC").getWordsListSize());
    
    assertEquals(3, new StringFinderString().addMainString("AaaBbC").getWordsListSize());
  }
  

 }
