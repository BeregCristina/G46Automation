package tests.ui.authorization;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import tests.ui.BaseTest;

import java.util.NoSuchElementException;

import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPositiveTest extends BaseTest {

    private LoginPageObject page;

    @Before
    public void setPage() {
        printMessageInYellow("Test is started!");
        this.page = new LoginPageObject(driver);
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

}
