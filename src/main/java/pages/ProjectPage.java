package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.issues.IssuePage;

public class ProjectPage extends BasePage {

    private final static String TITLE = "Project Page";

    private final By issuesTab = By.xpath("//span[@data-content=\"Issues\"]");

    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssuePage openProjectIssues(){
        try {
            driver.findElement(issuesTab).click();
        }catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new IssuePage(driver);
    }
}
