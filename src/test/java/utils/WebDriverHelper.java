package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

    private final WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void fillInField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    public void waitForElementDisappeared(By element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

//    public void checkPageIsReady() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        //Initially bellow given if condition will check ready state of page.
//        if (js.executeScript("return document.readyState").toString().equals("complete")) {
//            System.out.println("Page Is loaded.");
//        }
//    }
}
