import java.io.IOException;
import static java.lang.System.out;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import java.util.Comparator;
import stringFinder.StringFinder;
import stringFinder.StringFinderUtils;
import static stringFinder.StringFinderUtils.getName;

class ClassFinder {
  public static void main(String[] args) throws IOException {

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


