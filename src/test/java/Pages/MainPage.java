package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverHelper;

import java.util.HashMap;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private WebDriverHelper webDriverHelper;

    private static final String Url = "https://akamaijobs.referrals.selectminds.com/";
    private static final By searchField = By.id("keyword");
    private static final By searchLocationField = By.id("jLocInputHldr");
//    private static final String locationSelector = ".//*[@id='location_facet']/option[contains(text(), '%s')]";
    private static final HashMap<String, By> dropdownLocations = new HashMap<>();
    static {
        dropdownLocations.put("Krakow, Poland", By.cssSelector("#location_facet_chzn_o_12"));
    }
    private static final By searchBtn = By.id("jSearchSubmit");
    private static final By spinner = By.className("spinner");
    private static final By jobList = By.xpath(".//*[@id='job_results_list_hldr']/div");

    public MainPage(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
        this.driver = webDriverHelper.getDriver();
    }

    public void get() {
        driver.get(Url);
//        webDriverHelper.checkPageIsReady();
    }

    public void searchForJob(String jobTitle, String location) {
        fillSearchField(jobTitle);
        fillLocationField(location);
        driver.findElement(searchBtn).click();
        webDriverHelper.waitForElementDisappeared(spinner, 10);
    }

    public void searchForJob(String jobTitle) {
        fillSearchField(jobTitle);
        driver.findElement(searchBtn).click();
        webDriverHelper.waitForElementDisappeared(spinner, 10);
    }

    public void fillSearchField(String text) {
        webDriverHelper.fillInField(driver.findElement(searchField), text);
    }

    public void fillLocationField(String location) {
        driver.findElement(searchLocationField).click();
        driver.findElement(dropdownLocations.get(location)).click();
    }

    public List<WebElement> getJobList() {
        return driver.findElements(jobList);
    }
}
