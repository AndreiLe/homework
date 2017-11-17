import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URLDecoder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class ClassFinderIT {
  
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
  }

  @After
  public void cleanUpStreams() {
      System.out.flush();
      System.out.close();
      
      System.err.flush();
      System.err.close();
  }

  @Test
  public void testMain() throws Exception {
    
    String classesPath = getClass().getClassLoader().getResource("classesTest.txt").getPath();
    classesPath = URLDecoder.decode(classesPath, "utf-8");
    classesPath = new File(classesPath).getPath();

    String[] args = {classesPath, "'B*r '"};
    String expected = "c.d.FooBar" + System.getProperty("line.separator");
    ClassFinder.main(args);
    assertEquals(expected, outContent.toString());
    
    
    args = new String[]{classesPath, "'B*z '"};
    expected += "a.b.FooBarBaz   " + System.getProperty("line.separator");
    ClassFinder.main(args);
    assertEquals(expected, outContent.toString());

  }
}
