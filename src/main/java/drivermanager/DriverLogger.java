package drivermanager;

import logsetup.Log;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

public class DriverLogger extends DriverDecorator{
    public DriverLogger(Driver driver ) {
        super(driver);
    }

    @Override
    public void start(String browser) {
        driver.start(browser);
        Log.info(String.format("Started browser: %s", browser));
    }

    @Override
    public void quit() {
        driver.quit();
        Log.info("Closed browser");
    }

    @Override
    public void getToUrl(String url) {
        driver.getToUrl(url);
        Log.info(String.format("Navigated to url: %s", url));
    }

    @Override
    public Element findElement(By locator) {
        Element element = driver.findElement(locator);
        Log.info("Located element by locator "+locator);

        return element;
    }

    @Override
    public List<Element> findElements(By locator) {
        return driver.findElements(locator);
    }

    @Override
    public File takeScreenshot() {
        Log.info("Screenshot taken.");
        return driver.takeScreenshot();
    }
}
