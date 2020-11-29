package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginParameterizedTest {

    private String login;
    private String password;

    @Parameterized.Parameters
    public static Collection<String[]> testData() {
        Collection<String[]> result = new ArrayList<>();
        result.add(new String[]{"login", "password"});
        result.add(new String[]{"admin", "admin"});
        return result;
    }

    public LoginParameterizedTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Test
    public void checkParams() {
        System.out.println("Login: " + this.login);
        System.out.println("Password: " + this.password);
    }

}
