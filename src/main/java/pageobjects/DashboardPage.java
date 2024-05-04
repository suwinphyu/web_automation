package pageobjects;

import logsetup.Log;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        Log.info("Getting page title in home page.");
        return driver.getTitle();
    }
}
