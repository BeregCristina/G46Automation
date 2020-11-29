package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.util.List;

public class IssueCreationPage extends BasePage {

    public static final String TITLE = "Page of Issue List";

    public IssueCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By issueTitleField = By.xpath("//input[@id='issue_title']");
    private final By issueBodyField = By.id("issue_body");
    private final By issueCreationButton = By.xpath("//button[@class='btn btn-primary']");

    private final By issueLabels = By.xpath("//span[@class='name']");
    private final By labelsShowButton = By.id("labels-select-menu");


    public IssueInfoPage createNewIssue(String title, String body, List<String> testLabels) throws InterruptedException {
        log.info("Creating of new issue ...");
        Assert.assertTrue(driver.findElement(issueTitleField).isDisplayed());
        driver.findElement(issueTitleField).sendKeys(title);
        Assert.assertTrue(driver.findElement(issueBodyField).isDisplayed());
        driver.findElement(issueBodyField).sendKeys(body);

        Assert.assertTrue(driver.findElement(labelsShowButton).isDisplayed());
        driver.findElement(labelsShowButton).click();

        List<WebElement> labels = driver.findElements(issueLabels);
        for (WebElement label : labels) {
            if (testLabels.contains(label.getText())) {
                Assert.assertTrue(label.isDisplayed());
                label.click();
            }
        }
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(issueBodyField);
        actions.doubleClick(elementLocator).perform();

        actions.click(driver.findElement(issueCreationButton)).perform();


/*        driver.findElement(issueBodyField).
        Assert.assertTrue(driver.findElement(issueCreationButton).isDisplayed());
        driver.findElement(issueCreationButton).click();*/
        log.info("New issue is created!");

        return new IssueInfoPage(driver);
    }
}
