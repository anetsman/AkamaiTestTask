import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.WebDriverHelper;

import java.util.logging.Level;


public class AkamaiTests {

    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeMethod
    public void preparation() {
        driver = new FirefoxDriver();
        WebDriverHelper webDriverHelper = new WebDriverHelper(driver);
        mainPage = new MainPage(webDriverHelper);
    }

    @Test
    public void PositiveSearchForAJobTest() {
        mainPage.get();
        mainPage.searchForJob("Test", "Krakow, Poland");
        Assert.assertTrue(mainPage.getJobList().size() > 0);
    }

    @Test
    public void NegativeSearchForAJobTest() {
        mainPage.get();
        mainPage.searchForJob("XXX");
        Assert.assertTrue(mainPage.getJobList().size() > 0);
    }

    @AfterMethod
    public void cleanUP() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
