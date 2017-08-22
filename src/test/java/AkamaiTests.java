import Pages.MainPage;
import Pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverHelper;


public class AkamaiTests {

    private static WebDriver driver;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;

    @BeforeMethod
    public void preparation() {
        driver = new FirefoxDriver();
        driver.get("https://akamaijobs.referrals.selectminds.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    @Test
    public void PositiveSearchForAJobTest() {
        mainPage.searchForJob("Test", "Krakow, Poland");
        Assert.assertTrue(searchResultPage.getSearchResults().size() > 0,
                "No jobs were found");
    }

    @Test
    public void NegativeSearchForAJobTest() {
        String jobTitle = "XXX";
        mainPage.searchForJob(jobTitle);
        Assert.assertEquals(searchResultPage.getSearchResults(),null,
                "Expected no search results, but them are presented");
        Assert.assertEquals(searchResultPage.getErrorSearchingJobMessage(),
                String.format("Your search matching keyword(s) %s did not return any job results.", jobTitle),
                "Search error message is not correct");
    }

    @AfterMethod
    public void cleanUP() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
