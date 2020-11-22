package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;

public class LoginPageTest extends BaseTest {

    private LoginPageObject page;
    private String errorMessage;
    private String errorMessage2;

    @Before
    public void setPage() {
        this.page = new LoginPageObject(driver);
        this.errorMessage = "There have been several failed attempts to sign in from " +
                "this account or IP address. Please wait a while and try again later.";
        this.errorMessage2 = "Incorrect username or password.";
    }

    @Test
    public void negativeAuthTest() {
        page.checkAuthField()
                .login("admin", "admin")
                .validateErrorMessage(errorMessage)
                .returnToLoginPage()
                .login("login", "abc")
                .validateErrorMessage2(errorMessage2);
    }

    @Test
    public void positiveE2ETest() throws InterruptedException {
        page.checkAuthField()
                .login("BeregCristina", "Kris!0703")
                .isAuthSuccessful("Search or jump to…")
                .enterRepositoryNameForSearch("G46Automation")
                .goToFoundRepository()
                .openPomXml()
                .checkVersion("3.141.59");

        page.logOut();
    }


}
