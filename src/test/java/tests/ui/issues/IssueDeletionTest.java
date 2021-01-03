package tests.ui.issues;

import org.junit.After;
import org.junit.Before;
import pages.LoginPageObject;
import pages.issues.IssuePage;
import tests.ui.BaseTest;

public class IssueDeletionTest extends BaseTest {

    private IssuePage page;

    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("G46Automation").openProjectIssues();
    }


    //@Test
    public void deleteAllIssues() {
        page.deleteAllIssues();
    }

    @After
    public void tearDown() {
        page.logOut2()
                .validateLogOut();
    }
}
