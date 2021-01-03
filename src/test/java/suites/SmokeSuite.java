package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ui.authorization.LoginNegativeTest;
import tests.ui.authorization.LoginPositiveTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginPositiveTest.class,
                LoginNegativeTest.class
        }
)
public class SmokeSuite {
}
