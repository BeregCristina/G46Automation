package pages;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;


public abstract class BasePage {

    protected WebDriver driver;
    protected Logger log;
    private String title;

    private final By userLabel = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//form[@class='logout-form']/button");

    private final By signInForm = By.xpath("//input[@id='user_email']");
    private final By textH1 = By.xpath("//h1[contains(@class,'h2-5-mktg-fluid h1-sm-mktg-fluid')]");

    protected WebDriverWait webDriverWait_10, webDriverWait_15, webDriverWait_20;

    public BasePage(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
        this.log = LogManager.getLogger(this.title);
        printColorMessage("New page object is created for:" + title + ", class: " +
                this.getClass().getName(), log, Level.DEBUG);

        webDriverWait_10 = new WebDriverWait(driver, 10);
        webDriverWait_15 = new WebDriverWait(driver, 15);
        webDriverWait_20 = new WebDriverWait(driver, 20);
    }

    public void logOut() throws InterruptedException {
        printColorMessage("Logging out...", log, Level.INFO);
        Thread.sleep(1000);
        driver.findElement(userLabel).click();
        driver.findElement(signOut).click();
        Assert.assertTrue(driver.findElement(signInForm).isDisplayed());
        Assert.assertEquals(driver.findElement(textH1).getText(), "Where the world\nbuilds software");
        printColorMessage("Logout is finished!", log, Level.INFO);
    }

    public void logOut(boolean check) {
        printColorMessage("Logging out without a check...", log, Level.INFO);
        driver.findElement(userLabel).click();
        driver.findElement(signOut).click();
        printColorMessage("Logout is finished!", log, Level.INFO);
    }
}
