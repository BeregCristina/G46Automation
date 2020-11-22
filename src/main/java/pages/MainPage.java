package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private final static String TITLE = "Main Page";

    private final By searchField = By.xpath("//input[@name='q']");
    private final By searchResultList = By.xpath("//ul[@id='jump-to-results']/li[contains(@class, " +
            "'d-flex flex-justify-start flex-items-center p-0 f5 navigation-item js-navigation-item js-jump-to-suggestion')]");

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public MainPage isAuthSuccessful(String name) {
        log.info("Check successful authorization...");
        Assert.assertEquals(name, driver.findElement(searchField).getAttribute("placeholder"));
        log.info("Check is finished!");
        return this;
    }

    public MainPage enterRepositoryNameForSearch(String repository) throws InterruptedException {
        log.info("Start searching for the repository....");
        driver.findElement(searchField).sendKeys(repository);
        Thread.sleep(1000);
        log.info("Searching is finished!");
        return this;
    }

    public RepositoryPage goToFoundRepository() {
        log.info("Go to repository...");
        List<WebElement> list = driver.findElements(searchResultList);

        if (list.isEmpty())
            Assert.fail("Search result is empty!!!");
        else {
            list.get(0).click();
        }
        //Assert.assertNotNull("Search result is empty!!!",list);
        log.info("Repository is opened!");
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
}
