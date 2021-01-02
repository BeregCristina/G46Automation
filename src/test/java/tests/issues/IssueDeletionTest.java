package tests.issues;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.issues.IssueInfoPage;
import pages.issues.IssuePage;
import tests.BaseTest;

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
