package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPageObject;
import pages.issues.IssuePage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static helpers.FileHelper.readDataFromFile;

@RunWith(Parameterized.class)
public class IssueCreationTest extends BaseTest {

    private IssuePage page;

    private String title;
    private String body;
    private List<String> labels;

    public IssueCreationTest(String title, String body, List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return readDataFromFile("C:\\Users\\khber\\IdeaProjects\\G46Automation" +
                "\\src\\test\\resources\\data\\issues.txt");
    }


    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("G46Automation")
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation() {
/*        List<String> labels = new ArrayList<>();
        labels.add("bug");
        labels.add("help wanted");
        page.pressToCreateNewIssue()
                .createNewIssue("This is MY title", "Hello!", labels)
                .validateCreatedIssue("This is MY title", "Hello!", labels);*/
        page.pressToCreateNewIssue()
                .createNewIssue(this.title, this.body, this.labels)
                .validateCreatedIssue(this.title, this.body, this.labels);
    }

    @After
    public void tearDown() {
        page.logOut2()
            .validateLogOut();
    }
}
