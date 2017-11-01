import java.io.IOException;
import static java.lang.System.out;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

class ClassFinder {
  public static void main(String[] args) throws IOException {
    readAllLines(get(args[0])).stream().filter(l -> l.contains(args[1])).forEach(out::println);
  }
}
