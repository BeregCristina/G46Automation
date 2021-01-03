package tests.ui.issues;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPageObject;
import pages.issues.IssuePage;
import tests.ui.BaseTest;

import java.util.Collection;
import java.util.List;

import static helpers.FileHelper.readParamsForIssueCreationFromFile;

@RunWith(Parameterized.class)
public class IssueCreationTestParameterizedTest extends BaseTest {

    private IssuePage page;

    private String title;
    private String comment;
    private List<String> labels;

    public IssueCreationTestParameterizedTest(String title, String comment, List<String> labels) {
        this.title = title;
        this.comment = comment;
        this.labels = labels;
    }

    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("G46Automation")
                .openProjectIssues();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
/*      List<String> l1 = new ArrayList<>();
        l1.add("bug");
        List<String> l2 = new ArrayList<>();
        l2.add("documentation");
        List<String> l3 = new ArrayList<>();
        l3.add("question");
        List<String> l4 = new ArrayList<>();
        l4.add("bug");
        l4.add("documentation");
        List<String> l5 = new ArrayList<>();
        l5.add("bug");
        l5.add("question");
        List<String> l6 = new ArrayList<>();
        l6.add("documentation");
        l6.add("question");
        List<String> l7 = new ArrayList<>();
        l7.add("bug");
        l7.add("documentation");
        l7.add("question");

        return Arrays.asList(new Object[][]{
                {"login1", "comment", l1},
                {"login2", "comment", l2},
                {"login2", "comment", l3},
                {"login2", "comment", l4},
                {"login2", "comment", l5},
                {"login2", "comment", l6},
                {"login2", "comment", l7},
                //{"login1", "comment", new String[]{"aaaa","b"}},
        });*/
        return readParamsForIssueCreationFromFile("C:\\Users\\khber\\IdeaProjects\\G46Automation\\" +
                "src\\test\\resources\\data\\issueParams.txt");
    }

    @Test
    public void createBunchOfComments() {
        page.pressToCreateNewIssue()
                .createNewIssue(this.title, this.comment, this.labels)
                .validateCreatedIssue(this.title, this.comment, this.labels);
    }

    @After
    public void tearDown() {
        page.logOut2()
                .validateLogOut();
    }

}
