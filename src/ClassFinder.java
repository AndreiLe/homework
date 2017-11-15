import java.io.IOException;
import static java.lang.System.out;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import java.util.Comparator;
import stringFinder.StringFinder;
import stringFinder.StringFinderUtils;
import static stringFinder.StringFinderUtils.getName;

class ClassFinder {
  public static void main(String[] args2) throws IOException {
    
    String[] args;

    if (args2 != null && args2.length > 0) {
      args = args2;
    }else{
      args = new String[]{"F:\\Desktop\\работа\\codeborne\\work 1\\javaHome\\classes.txt", "'B*r'"};
    }
         
	StringFinder stringFinder = new StringFinder();
	
    readAllLines(get(args[0]))
            .stream()
            .filter( s -> 
                    stringFinder
                            .addFinderText(s)
                            .contains(args[1])
            ).sorted(
                    Comparator.comparing((String s) -> 
                            getName(s).toString()
            )
            )
            .forEach(s -> 
                    out.println(s)
            );

  }
}


