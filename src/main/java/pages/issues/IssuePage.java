package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;

public class IssuePage extends BaseAuthorizedPage {

    public static final String TITLE = "Page of Creation New Issue";

    public IssuePage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By newIssueButton = By.xpath("//a[@class='btn btn-primary']");


    private final By allIssuesRef = By.xpath("//a[@class='link-gray-dark v-align-middle no-underline h4 js-navigation-open']");
    private final By deleteButton = By.xpath("//span[contains(strong,'Delete issue')]");
    private final By deleteThisIssue = By.xpath("//button[@class='btn btn-danger input-block float-none']");

    public IssueCreationPage pressToCreateNewIssue() {
        log.info("Clicking on 'New Issue' button...");
        Assert.assertTrue(driver.findElement(newIssueButton).isDisplayed());
        driver.findElement(newIssueButton).click();
        log.info("Button is clicked!");
        return new IssueCreationPage(driver);
    }


    public void deleteAllIssues() {
        log.info("Deleting issue ...");
        List<WebElement> myIssues = driver.findElements(allIssuesRef);
        System.out.println(myIssues.size());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int k = myIssues.size();
        for (int i = 0; i < k; i++) {
            driver.findElement(allIssuesRef).click();
            log.info("Clicking on DELETE button...");
            driver.findElement(deleteButton).click();
            log.info("Confirming deletion...");
            driver.findElement(deleteThisIssue).click();
            log.info("Issue was deleted!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
