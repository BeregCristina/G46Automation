package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static helpers.ColorPrinter.*;
import static helpers.Level.INFO;

public class LoginPageObject extends BasePage {

    private final static String TITLE = "Authorization Page";

    private final By loginField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@id='login']/p");
    private final By errorMessage2 = By.xpath("//div[@class=\"container-lg px-2\"]");

/*    private SelenideElement login = $(byId("login_field"));
    private SelenideElement password = $(byId("password"));
    private SelenideElement signIn = $(byName("commit"));*/


    public LoginPageObject(WebDriver driver) {
        super(driver, TITLE);
    }

    public LoginPageObject validateErrorMessage(String message) {
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPageObject validateErrorMessage2(String message) {
        Assert.assertEquals(message, driver.findElement(errorMessage2).getText());
        return this;
    }

    public LoginPageObject loginNegative(String login, String password) {
        printMessageInYellow("Try to Login with INVALID credentials: " + login + " " + password, log);
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        printMessageInYellow("Log in is finished! Access is not allowed!", log);
        return new LoginPageObject(driver);
    }

    public LoginPageObject checkAuthFields() {
        printColorMessage("Check the presence of fields...", log, INFO);
        Assert.assertTrue("There is no login field", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("There is no password field", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("There IS no Sign In button field", this.driver.findElement(signInButton).isDisplayed());
        printColorMessage("Fields are found!", log, INFO);
        return this;
        //login.shouldBe(Condition.visible).sendKeys("my login");
    }

    public LoginPageObject returnToLoginPage() {
        printColorMessage("Returning to Login Page...", log, INFO);
        driver.navigate().back();
        printColorMessage("You are on the Login Page!", log, INFO);
        return new LoginPageObject(driver);
    }


    //---------------homework-------------------------------------------------------------------------------------------
    public MainPage login(String login, String password) {
        printColorMessage("Login (with VALID credentials)...", log, INFO);
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        printColorMessage("Login is finished!", log, INFO);
        return new MainPage(driver);
    }

}
