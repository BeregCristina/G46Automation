package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "commit")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void checkAuthField() {
        Assert.assertTrue("There is no login field", loginField.isDisplayed());
        Assert.assertTrue("There is no password field", passwordField.isDisplayed());
        Assert.assertTrue("There IS no Sign In button field", signInButton.isDisplayed());
    }
}
