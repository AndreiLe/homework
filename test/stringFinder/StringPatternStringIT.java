package stringFinder;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringPatternStringIT {

  @Test
  public void testAddMainString() {
    assertEquals(asList("A"), new StringPatternString().addMainString("A").getWordList());

    assertEquals(asList("A"), new StringPatternString().addMainString("a").getWordList());

    assertEquals(asList("A","A","A"), new StringPatternString().addMainString("AAA").getWordList());

    assertEquals(asList("Aa","Bbc","C"), new StringPatternString().addMainString("AaBbcC").getWordList());

    assertEquals(asList("Aa","B*c","C"), new StringPatternString().addMainString("AaB*cC ").getWordList());
  }
  
  @Test(expected = NullPointerException.class) 
  public void testAddMainStringExseption() {

    assertEquals(null, new StringPatternString().addMainString(null));
  }

  @Test
  public void testIsLastCharacterWhitespace() {
    
    assertFalse(new StringPatternString().addMainString("ABC").isLastCharacterWhitespace());
    
    assertTrue(new StringPatternString().addMainString("ABC ").isLastCharacterWhitespace());
  }

  @Test
  public void testGetWordsListSize() {
    
    assertEquals(0, new StringPatternString().addMainString("").getWordsListSize());
    
    assertEquals(1, new StringPatternString().addMainString("B").getWordsListSize());
  }

  
}
