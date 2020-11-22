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

    private final static Logger LOG = LogManager.getLogger();

    private final By loginField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@id='login']/p");
    private final By errorMessage2 = By.xpath("//div[@class=\"container-lg px-2\"]");


    private final By searchField = By.xpath("//input[@name='q']");
    private final By searchResultList = By.xpath("//ul[@id='jump-to-results']/li[contains(@class, " +
            "'d-flex flex-justify-start flex-items-center p-0 f5 navigation-item js-navigation-item js-jump-to-suggestion')]");
    private final By pomXml = By.xpath("//a[@title='pom.xml']");
    private final By version = By.id("LC28");
    private final By userLabel = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//form[@class='logout-form']/button");

    private final By signInForm = By.xpath("//form[@class='home-hero-signup text-gray-dark js-signup-form js-signup-form-submit']");
    private final By textH1 = By.xpath("//h1[@class='h000-mktg text-white lh-condensed-ultra mb-3']");
/*    private SelenideElement login = $(byId("login_field"));
    private SelenideElement password = $(byId("password"));
    private SelenideElement signIn = $(byName("commit"));*/


    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public LoginPageObject validateErrorMessage(String message) {
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPageObject validateErrorMessage2(String message) {
        Assert.assertEquals(message, driver.findElement(errorMessage2).getText());
        return this;
    }

    public LoginPageObject login(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPageObject(driver);
    }

    public LoginPageObject checkAuthField() {
        Assert.assertTrue("There is no login field", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("There is no password field", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("There IS no Sign In button field", this.driver.findElement(signInButton).isDisplayed());
        return this;
        //login.shouldBe(Condition.visible).sendKeys("my login");
    }

    public LoginPageObject returnToLoginPage() {
        driver.navigate().back();
        return new LoginPageObject(driver);
    }


    //---------------homework-------------------------------------------------------------------------------------------
    public LoginPageObject isAuthSuccessful(String name) {
        Assert.assertEquals(name, driver.findElement(searchField).getAttribute("placeholder"));
        return this;
    }

    public LoginPageObject enterRepositoryNameForSearch(String repository) throws InterruptedException {
        driver.findElement(searchField).sendKeys(repository);
        Thread.sleep(1000);
        return this;
    }

    public void checkDropdown(String text) {
        List<WebElement> list = driver.findElements(searchResultList);

        System.out.println(list.size());

        for (WebElement w : list) {
            System.out.println(w.getText());
        }

        for (WebElement w : list) {
            Assert.assertTrue("There is at least 1 element which is not fit search criteria!!!", w.getText().contains(text));
        }
    }

    public LoginPageObject goToFoundRepository() {
        List<WebElement> list = driver.findElements(searchResultList);

        if (list.isEmpty())
            Assert.fail("Search result is empty!!!");
        else {
            list.get(0).click();
        }
        //Assert.assertNotNull("Search result is empty!!!",list);
        return new LoginPageObject(driver);
    }

    public LoginPageObject openPomXml() throws InterruptedException {
        driver.findElement(pomXml).click();
        Thread.sleep(1000);
        return new LoginPageObject(driver);
    }

    public void checkVersion(String version) {
        String myVersion = driver.findElement(this.version).getText();
        myVersion = myVersion.substring(myVersion.indexOf(">") + 1, myVersion.lastIndexOf("<"));
        LOG.info(myVersion);
        Assert.assertEquals("Verstion is not correct!!!", version, myVersion);
    }

    public void logOut() {
        driver.findElement(userLabel).click();
        driver.findElement(signOut).click();
        Assert.assertTrue(driver.findElement(signInForm).isDisplayed());
        Assert.assertEquals(driver.findElement(textH1).getText(), "Built for developers");
    }

}
