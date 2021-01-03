package tests.ui;

import org.junit.Before;
import pages.LoginPageObject;


public class SomeTest {

    private LoginPageObject page;

    //@DataProvider
    public Object[][] testData() {
        return new Object[][]{{"login1", "password1"}, {"admin1", "admin1"}};
    }

    //@Test(dataProvider = "testData")
    public void ourTest(String login, String password) {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }
}
