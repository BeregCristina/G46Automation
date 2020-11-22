package tests;

import org.junit.Before;
import pages.LoginPageObject;


public class SomeTest extends BaseTest {

    private LoginPageObject page;

    @Before
    public void setPage() {
        //page = new LoginPage(driver);
        page = new LoginPageObject(driver);
    }

    //@Test
    public void ourTest() {
        page.checkAuthFields();
    }
}
