import java.io.IOException;
import static java.lang.System.out;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import stringFinder.StringFinder;

class ClassFinder {
  public static void main(String[] args2) throws IOException {
    String[] args = {"F:\\Desktop\\работа\\codeborne\\work 1\\javaHome\\src\\classes.txt", "t"};
         
	StringFinder stringFinder = new StringFinder();
	
    readAllLines(get(args[0]))
            .stream()
            .filter(
                    l -> stringFinder
                            .addFinderText(l)
                            .contains(args[1])
            )
            .forEach(out::println);
  }
}


