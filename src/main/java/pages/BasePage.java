package pages;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;


public abstract class BasePage {

    protected WebDriver driver;
    protected Logger log;
    private String title;

    private final By userLabel = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//form[@class='logout-form']/button");

    private final By signInForm = By.xpath("//form[@class='home-hero-signup text-gray-dark js-signup-form js-signup-form-submit']");
    private final By textH1 = By.xpath("//h1[@class='h000-mktg text-white lh-condensed-ultra mb-3']");

    public BasePage(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
        this.log = LogManager.getLogger(this.title);
        printColorMessage("New page object is created for:" + title + ", class: " +
                this.getClass().getName(), log, Level.DEBUG);
    }

    public void logOut() throws InterruptedException {
        printColorMessage("Logging out...", log, Level.DEBUG);
        Thread.sleep(1000);
        driver.findElement(userLabel).click();
        driver.findElement(signOut).click();
        Assert.assertTrue(driver.findElement(signInForm).isDisplayed());
        Assert.assertEquals(driver.findElement(textH1).getText(), "Built for developers");
        printColorMessage("Logout is finished!", log, Level.DEBUG);
    }
}
