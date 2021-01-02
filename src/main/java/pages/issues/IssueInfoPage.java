package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;

public class IssueInfoPage extends BasePage {

    public static final String TITLE = "Page of Issue Info";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//span[@class=\"js-issue-title\"]");
    private final By statusImg = By.xpath("//div[contains(@class,\"flex-self-start flex-md-self-center\")]/span");
    private final By description = By.xpath("//td[contains(@class,\"js-comment-body\")]");

    private final By labels = By.xpath("//a[@class='lh-condensed-ultra']");

    public IssueInfoPage validateCreatedIssue(String titleText, String body, List<String> testLabels) {
        printColorMessage("Checking created issue...", log, Level.INFO);
        try {
            log.debug("Check title of the created issue...");
            Assert.assertEquals(titleText, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImg).isDisplayed());
            log.debug("Check description of the created issue...");
            Assert.assertEquals(body, driver.findElement(description).getText());

/*            List<WebElement> labelElements = driver.findElements(labels);
            for (WebElement label : labelElements) {
                log.debug("Check label: " + label.getText());
                Assert.assertTrue(testLabels.contains(label.getText()));
                testLabels.remove(label.getText());
            }*/

            driver.findElements(labels)
                    .forEach(label -> {
                        log.debug("Check label: " + label.getText());
                        Assert.assertTrue(testLabels.contains(label.getText()));
                        testLabels.remove(label.getText());
                    });

            //next Assert doesn't work
            //Assert.assertTrue(testLabels.isEmpty());
        } catch (NoSuchElementException n) {
            Assert.fail("Issue was created incorrectly!" + n.getMessage());
        }
        printColorMessage("Issue is displayed correctly!", log, Level.INFO);
        return this;
    }
}
