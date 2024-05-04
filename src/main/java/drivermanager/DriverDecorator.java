package drivermanager;

import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

public class DriverDecorator implements Driver{

    Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String getPageTitle() {
        return driver.getPageTitle();
    }

    @Override
    public void start(String browser) {
        driver.start(browser);
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void getToUrl(String url) {
        driver.getToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        return driver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoads() {
        driver.waitUntilPageLoads();
    }

    @Override
    public File takeScreenshot() {
        return driver.takeScreenshot();
    }

    @Override
    public void implicitlyWait() {
        driver.implicitlyWait();
    }

    @Override
    public void setupWebDriverWait(By locator) {
        driver.setupWebDriverWait(locator);
    }
}
