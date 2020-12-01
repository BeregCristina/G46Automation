package pages.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.issues.IssuePage;
import pages.settings.SettingsPage;

import java.util.List;

import static helpers.ColorPrinter.printInPurple;

public class ProjectPage extends BasePage {

    private final static String TITLE = "Project Page";

    private final By issuesTab = By.xpath("//span[@data-content=\"Issues\"]");
    private final By settingsTab = By.xpath("//span[@data-content=\"Settings\"]");
    //private final By tabsList = By.xpath("//li[@class='d-flex']");
    private final By tabsList = By.xpath("//li[(@class='d-flex') and not(contains(@class,'Counter '))]");
    private final By repoLink = By.xpath("//a[@data-pjax='#js-repo-pjax-container']");


    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssuePage openProjectIssues() {
        try {
            driver.findElement(issuesTab).click();
        } catch (NoSuchElementException n) {
            Assert.fail(n.getMessage());
        }
        return new IssuePage(driver);
    }

    public SettingsPage openSettingsPage() {
        try {
            driver.findElement(settingsTab).click();
        } catch (NoSuchElementException n) {
            Assert.fail(n.getMessage());
        }
        return new SettingsPage(driver);
    }

    public ProjectPage validateRenaming(String expectedTitle){
        Assert.assertTrue(driver.findElement(repoLink).getText().endsWith(expectedTitle));
        return this;
    }

    //-----------------homework 14/11/2020--------------------------

    public ProjectPage printListOfTabs() {
        List<WebElement> tabs = driver.findElements(tabsList);
        log.info("Printing the list of tabs... =>");
        String myTabs = "";
        for (WebElement tab : tabs) {
            String nextTab = tab.getText();
            if (nextTab.contains("Issues")) {
                myTabs += "Issues ";
            } else {
                myTabs += nextTab + " ";
            }
        }
        printInPurple("The list of tabs is: " + myTabs, log);
        Assert.assertEquals(myTabs, "Code Issues Pull requests Actions Projects Wiki Security Insights Settings ");
        log.info("List of tabs was printed!");
        return this;
    }
}
