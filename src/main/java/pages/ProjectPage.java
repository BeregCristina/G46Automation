package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.issues.IssuePage;

import java.util.List;

import static helpers.ColorPrinter.printInPurple;

public class ProjectPage extends BasePage {

    private final static String TITLE = "Project Page";

    private final By issuesTab = By.xpath("//span[@data-content=\"Issues\"]");
    //private final By tabsList = By.xpath("//li[@class='d-flex']");
    private final By tabsList = By.xpath("//li[(@class='d-flex') and not(contains(@class,'Counter '))]");

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
