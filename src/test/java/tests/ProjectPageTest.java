package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.code.ProjectPage;


public class ProjectPageTest extends BaseTest {

    private ProjectPage page;

    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject();
    }

    @Test
    public void printListOfTabs() {
        page.printListOfTabs().logOut(false);
    }

    @Test
    public void printListOfTabs2() throws InterruptedException {
        page.printListOfTabs().logOut();
    }

/*    @After
    public void logOut() throws InterruptedException {
        page.logOut();
    }*/

}
