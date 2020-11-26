package pages;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;

public class MainPage extends BasePage {

    private final static String TITLE = "Main Page";

    private final By searchField = By.xpath("//input[@name='q']");
    private final By searchResultList = By.xpath("//ul[@id='jump-to-results']/li[contains(@class, " +
            "'d-flex flex-justify-start flex-items-center p-0 f5 navigation-item js-navigation-item js-jump-to-suggestion')]");

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public MainPage isAuthSuccessful(String name) {
        printColorMessage("Check successful authorization...", log, Level.INFO);
        Assert.assertEquals(name, driver.findElement(searchField).getAttribute("placeholder"));
        printColorMessage("Check is finished!", log, Level.INFO);
        return this;
    }

    public MainPage enterRepositoryNameForSearch(String repository) throws InterruptedException {
        printColorMessage("Start searching for the repository....", log, Level.INFO);
        driver.findElement(searchField).sendKeys(repository);
        Thread.sleep(1000);
        printColorMessage("Searching is finished!", log, Level.INFO);
        return this;
    }

    public RepositoryPage goToFoundRepository() {
        printColorMessage("Go to repository...", log, Level.INFO);
        List<WebElement> list = driver.findElements(searchResultList);

        if (list.isEmpty())
            Assert.fail("Search result is empty!!!");
        else {
            for (WebElement l:list) {
                if (l.getText().contains("BeregCristina")){
                    printColorMessage("Opening the reporitory:" + l.getText(), log, Level.DEBUG);
                    l.click();
                    break;
                }
            }
        }
        //Assert.assertNotNull("Search result is empty!!!",list);
        printColorMessage("Repository is opened!", log, Level.INFO);
        return new RepositoryPage(driver);
    }

    public void checkDropdown(String text) {
        List<WebElement> list = driver.findElements(searchResultList);

        System.out.println(list.size());

        for (WebElement w : list) {
            System.out.println(w.getText());
        }

        for (WebElement w : list) {
            Assert.assertTrue("There is at least 1 element which is not fit search criteria!!!", w.getText().contains(text));
        }
    }

    public ProjectPage openOurProject(){
        driver.get("https://github.com/BeregCristina/G46Automation");
        return new ProjectPage(driver);
    }
}
