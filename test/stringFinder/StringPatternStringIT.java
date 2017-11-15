package stringFinder;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringPatternStringIT {
  
  public StringPatternStringIT() {
  }
 
  @Test
  public void testAddMainString() {

    CharSequence mainString = null;
    StringPatternString instance = new StringPatternString();
    ArrayList<CharSequence> expResult = null;
    ArrayList<CharSequence> result = null;
    
    mainString = "A";
    expResult = new ArrayList<CharSequence>();
    expResult.add("A");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "a";
    expResult = new ArrayList<CharSequence>();
    expResult.add("A");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "ABC";
    expResult = new ArrayList<CharSequence>();
    expResult.add("A");
    expResult.add("B");
    expResult.add("C");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "AaBbcC";
    expResult = new ArrayList<CharSequence>();
    expResult.add("Aa");
    expResult.add("Bbc");
    expResult.add("C");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "AaBbcC ";
    expResult = new ArrayList<CharSequence>();
    expResult.add("Aa");
    expResult.add("Bbc");
    expResult.add("C");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
    
    mainString = "AaB*cC ";
    expResult = new ArrayList<CharSequence>();
    expResult.add("Aa");
    expResult.add("B*c");
    expResult.add("C");
    result = instance.addMainString(mainString).getWordList();
    assertEquals(expResult, result);
  }
  
  @Test(expected = NullPointerException.class) 
  public void testAddMainStringExseption() {

    assertEquals(null, new StringPatternString().addMainString(null));
  }

  @Test
  public void testIsLastCharacterWhitespace() {

    StringPatternString instance = null;
    boolean expResult = false;
    boolean result = false;
    
    instance = new StringPatternString().addMainString("ABC");
    expResult = false;
    result = instance.isLastCharacterWhitespace();
    assertEquals(expResult, result);
    
    instance = new StringPatternString().addMainString("ABC ");
    expResult = true;
    result = instance.isLastCharacterWhitespace();
    assertEquals(expResult, result);

  }

  @Test
  public void testGetWordsListSize() {
    
    assertEquals(0, new StringPatternString().addMainString("").getWordsListSize());
    
    assertEquals(1, new StringPatternString().addMainString("B").getWordsListSize());
  }

  
}
