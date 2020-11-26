package tests;


import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.ProjectPage;
import pages.issues.IssuePage;

public class IssueCreationTest extends BaseTest {

    private IssuePage page;

    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject()
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation() {
        page.pressToCreateNewIssue()
                .createNewIssue("This is MY title", "Hello!")
                .validateCreatedIssue("This is MY title", "Hello!");
    }
}
