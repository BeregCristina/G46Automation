package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPageObject;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import static helpers.ColorPrinter.printMessageInYellow;
import static helpers.FileHelper.readAuthFromFile;

@RunWith(Parameterized.class)
public class LoginNegativeTest extends BaseTest {

    private LoginPageObject page;
    public MainPage page2;
    private String errorMessage;
    private String errorMessage2;

    private String login;
    private String password;

    public LoginNegativeTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data(){
/*        Collection<String[]> result = new ArrayList<>();
        result.add(new String[]{"login1", "password1"});
        result.add(new String[]{"login2", "password2"});
        result.add(new String[]{"login3", "password3"});
        result.add(new String[]{"login4", "password4"});
        result.add(new String[]{"login5", "password5"});
        return result;*/
        return readAuthFromFile("C:\\Users\\khber\\IdeaProjects\\G46Automation\\" +
                "src\\test\\resources\\data\\authData.txt");
    }


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
                //todo non-standard system behavior
/*                .loginNegative("admin", "admin")
                .validateErrorMessage(errorMessage)
                .returnToLoginPage()*/
                .loginNegative(this.login, this.password)
                .validateErrorMessage2(errorMessage2);
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
