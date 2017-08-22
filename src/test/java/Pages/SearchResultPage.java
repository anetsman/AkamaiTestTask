package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anetsman on 2017-08-22.
 */
public class SearchResultPage {

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='job_results_list_hldr']/div[contains(@id, 'job_list')]")
    List<WebElement> jobList;

    @FindBy(id="job_no_results_list_hldr")
    WebElement noJobResultHeader;

    @FindBy(className = "search_result_sentence")
    WebElement noJobResultMsg;

    public List getSearchResults() {
        try {
            noJobResultHeader.isDisplayed();
            return null;
        } catch (NoSuchElementException e) {
            return jobList;
        }
    }

    public String getErrorSearchingJobMessage() {
        return noJobResultMsg.getText();
    }
}
