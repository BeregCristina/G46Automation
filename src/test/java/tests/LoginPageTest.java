package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.MainPage;

import java.util.NoSuchElementException;

import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPageTest extends BaseTest {

    private LoginPageObject page;
    public MainPage page2;
    private String errorMessage;
    private String errorMessage2;

    @Before
    public void setPage() {
        printMessageInYellow("Test is started!");
        this.page = new LoginPageObject(driver);
        this.errorMessage = "There have been several failed attempts to sign in from " +
                "this account or IP address. Please wait a while and try again later.";
        this.errorMessage2 = "Incorrect username or password.";
    }

    @Test
    public void negativeAuthTest() {
        page.checkAuthFields()
                .loginNegative("admin", "admin")
                .validateErrorMessage(errorMessage)
                .returnToLoginPage()
                .loginNegative("login", "abc")
                .validateErrorMessage2(errorMessage2);
    }

    @Test
    public void checkPositiveLogin() {
        try {
            page.checkAuthFields()
                    .login(System.getProperty("login"), System.getProperty("password"));
        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void positiveE2ETest() throws InterruptedException {
        page.checkAuthFields()
                .login(System.getProperty("login"), System.getProperty("password"))
                .isAuthSuccessful("Search or jump to…")
                .enterRepositoryNameForSearch("G46Automation")
                .goToFoundRepository()
                .openPomXml()
                .checkVersion("3.141.59")
                .logOut();
        //page2.logOut();
    }

    @After
    public void tearDown(){
        printMessageInYellow("Test is finished!");
        driver.quit();
    }

/*    @Test
    public void showSystemVars() {
        System.out.println(System.getProperty("login"));
        System.out.println(System.getProperty("password"));
    }*/

}
