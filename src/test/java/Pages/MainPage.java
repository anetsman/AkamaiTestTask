package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverHelper;

import java.util.HashMap;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private WebDriverHelper webDriverHelper;

    private static final String Url = "https://akamaijobs.referrals.selectminds.com/";

    @FindBy(id = "keyword")
    WebElement searchField;

    @FindBy(id = "jLocInputHldr")
    WebElement searchLocationField;

    @FindBy(id = "jSearchSubmit")
    WebElement searchBtn;

    @FindBy(className = "spinner")
    WebElement spinner;

    private static final HashMap<String, By> dropdownLocations = new HashMap<>();
    static {
        dropdownLocations.put("Krakow, Poland", By.cssSelector("#location_facet_chzn_o_12"));
    }


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverHelper = new WebDriverHelper(driver);
    }

    public void get() {
        driver.get(Url);
    }

    public void searchForJob(String jobTitle, String location) {
        fillSearchField(jobTitle);
        fillLocationField(location);
        searchBtn.click();
        webDriverHelper.waitForElementDisappeared(spinner, 10);
    }

    public void searchForJob(String jobTitle) {
        fillSearchField(jobTitle);
        searchBtn.click();
        webDriverHelper.waitForElementDisappeared(spinner, 10);
    }

    public void fillSearchField(String text) {
        webDriverHelper.fillInField(searchField, text);
    }

    public void fillLocationField(String location) {
        searchLocationField.click();
        driver.findElement(dropdownLocations.get(location)).click();
    }
}
