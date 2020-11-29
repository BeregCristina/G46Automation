package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseAuthorizedPage {

    private final static String TITLE = "Home Unauthorized Page";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    //TODO There are duplicated Bys. Refactoring is needed
    private final By titleMessage = By.xpath("//h1[@class='h000-mktg text-white lh-condensed-ultra mb-3']");

    public void validateLogOut(){
        Assert.assertTrue(driver.findElement(titleMessage).isDisplayed());
        Assert.assertEquals("Built for developers",driver.findElement(titleMessage).getText());
    }


}
