package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {

        switch(System.getProperty("browser", "chrome")) {
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "C:\\Users\\khber\\IdeaProjects\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\khber\\IdeaProjects\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "opera":
                //driver = new OperaDriver();
                break;
            case "ie":
                //driver = new InternetExplorerDriver();
                break;
            default:
                //System.setProperty("webdriver.gecko.driver", "C:\\Users\\khber\\IdeaProjects\\geckodriver.exe");
                driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://github.com/login");

        //open("https://github.com/login");
    }

    @After
    public void quite() {
        //closeWebDriver();
        driver.quit();
    }

}
