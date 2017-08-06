package Pages;

import org.openqa.selenium.support.PageFactory;
import utils.WebDriverHelper;

/**
 * Created by anetsman on 2017-06-06.
 */

public class BasePage {

    public BasePage(WebDriverHelper webDriverHelper){
        PageFactory.initElements(webDriverHelper.getDriver(), this);
    }
}
