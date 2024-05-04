package pageobjects;

import logsetup.Log;
import org.openqa.selenium.WebDriver;

public class FAQPage {

    WebDriver driver;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        Log.info("Getting page title in FAQ page.");
        return driver.getTitle();
    }
}
