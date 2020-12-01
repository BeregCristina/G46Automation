package tests.settings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import pages.issues.IssuePage;
import pages.settings.SettingsPage;
import tests.BaseTest;

public class SettingsTest extends BaseTest {

    private SettingsPage page;

    @Before
    public void signIn() {
        page = new LoginPageObject(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("G46Automation")
                .openSettingsPage();
    }

    @Test
    public void checkRepositoryRenaming(){
        page.renameRepository("G46Automation")
                .validateRenaming("G46Automation");
    }

    @After
    public void tearDown() {
        page.logOut2()
                .validateLogOut();
    }

}
