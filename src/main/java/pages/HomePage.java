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
    private final By titleMessage = By.xpath("//h1[contains(@class,'h2-5-mktg-fluid h1-sm-mktg-fluid')]");

    public void validateLogOut(){
        Assert.assertTrue(driver.findElement(titleMessage).isDisplayed());
        Assert.assertEquals("Where the world\n" +
                "builds software",driver.findElement(titleMessage).getText());
    }


}
