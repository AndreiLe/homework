package stringFinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({stringFinder.StringFinderIT.class, stringFinder.StringPatternStringIT.class, stringFinder.StringFinderUtilsIT.class, stringFinder.StringFinderStringIT.class})
public class Test {

}
