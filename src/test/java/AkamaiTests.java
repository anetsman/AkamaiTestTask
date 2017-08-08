import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverHelper;


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
        Assert.assertEquals(mainPage.getErrorSearchingJobMessage(),
                "Your search matching keyword(s) XXX did not return any job results.");
    }

    @AfterMethod
    public void cleanUP() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
