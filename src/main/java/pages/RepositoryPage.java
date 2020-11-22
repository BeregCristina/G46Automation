package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RepositoryPage extends BasePage {

    private final static String TITLE = "Repository Page";

    public RepositoryPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By pomXml = By.xpath("//a[@title='pom.xml']");
    private final By version = By.id("LC28");


    public RepositoryPage openPomXml() throws InterruptedException {
        log.info("Opening pom.xml file...");
        driver.findElement(pomXml).click();
        Thread.sleep(1000);
        log.info("pom.xml file is opened!");
        return new RepositoryPage(driver);
    }

    public RepositoryPage checkVersion(String version) {
        log.info("Checking the version....");
        String myVersion = driver.findElement(this.version).getText();
        myVersion = myVersion.substring(myVersion.indexOf(">") + 1, myVersion.lastIndexOf("<"));
        log.info("(selenium-api version :" + myVersion + ")");
        Assert.assertEquals("Version is not correct!!!", version, myVersion);
        log.info("Check is done!");
        return this;
    }

}
