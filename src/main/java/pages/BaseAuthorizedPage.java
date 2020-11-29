package pages;

import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.code.ProjectPage;

import static helpers.ColorPrinter.printColorMessage;

public abstract class BaseAuthorizedPage extends BasePage {
    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }

    //TODO There are duplicated Bys. Refactoring is needed
    private final By searchField = By.xpath("//input[@name='q']");
    private final By searchResults = By.xpath("//li[contains(@id, 'jump-to-suggestion-')]");

    private final By userProfileButton = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//form[@class='logout-form']/button");

    public ProjectPage searchProject(String projectName){
        printColorMessage("Start searching for the SPECIFIC repository....", log, Level.INFO);
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(projectName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e);
        }
        driver.findElements(searchResults).get(1).click();
        printColorMessage("Searching is finished!", log, Level.INFO);
        return new ProjectPage(driver);
    }

    public HomePage logOut2(){
        driver.findElement(userProfileButton).click();
        driver.findElement(signOut).click();
        return new HomePage(driver);
    }


}
