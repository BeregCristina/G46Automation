package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.List;

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
        log.info("Try to Login (with INVALID credentials)...");
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        log.info("Log in is finished! Access is not allowed!");
        return new LoginPageObject(driver);
    }

    public LoginPageObject checkAuthFields() {
        log.info("Check the presence of fields...");
        Assert.assertTrue("There is no login field", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("There is no password field", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("There IS no Sign In button field", this.driver.findElement(signInButton).isDisplayed());
        log.info("Fields are found!");
        return this;
        //login.shouldBe(Condition.visible).sendKeys("my login");
    }

    public LoginPageObject returnToLoginPage() {
        log.info("Returning to Login Page...");
        driver.navigate().back();
        log.info("You are on the Login Page!");
        return new LoginPageObject(driver);
    }


    //---------------homework-------------------------------------------------------------------------------------------
    public MainPage login(String login, String password) {
        log.info("Try to Login (with VALID credentials)...");
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        log.info("Login is finished SUCCESSFULLY");
        return new MainPage(driver);
    }

}
