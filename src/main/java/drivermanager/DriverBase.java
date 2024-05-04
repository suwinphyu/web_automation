package drivermanager;

import browserfactory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverBase implements Driver{

    private WebDriver driver;
    private WebDriverWait wait;
    Duration duration = Duration.ofSeconds(60);
    public static WebDriver webDriver;
    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void start(String browser) {
        driver = BrowserFactory.getDriverManager(browser).initDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,duration);
        webDriver = driver;
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void getToUrl(String url) {
        driver.get(url);

    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    @Override
    public Element findElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new ElementBase(webElement,locator);
        Element logElement = new ElementDecorator(element);
        return logElement;
    }

    @Override
    public List<Element> findElements(By locator) {
        List<WebElement> webDriverList= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        ArrayList<Element> elementArrayList = new ArrayList<>();
        for(WebElement webElement : webDriverList){
            Element element = new ElementBase(webElement,locator);
            Element logElement = new ElementDecorator(element);
            elementArrayList.add(logElement);
        }
        return elementArrayList;
    }

    @Override
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        wait.until(d -> (Boolean) javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));

    }

    @Override
    public void waitUntilPageLoads() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        wait.until(d-> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }

    @Override
    public File takeScreenshot() {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        return screenshot ;
    }

    @Override
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void setupWebDriverWait(By locator) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
