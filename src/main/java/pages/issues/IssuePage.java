package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.BasePage;

public class IssuePage extends BaseAuthorizedPage {

    public static final String TITLE = "Page of Creation New Issue";

    public IssuePage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By newIssueButton = By.xpath("//a[@class='btn btn-primary']");

    public IssueCreationPage pressToCreateNewIssue() {
        log.info("Clicking on 'New Issue' button...");
        Assert.assertTrue(driver.findElement(newIssueButton).isDisplayed());
        driver.findElement(newIssueButton).click();
        log.info("Button is clicked!");
        return new IssueCreationPage(driver);
    }
}
