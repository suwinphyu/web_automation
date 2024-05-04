package drivermanager;

import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

public interface Driver {
    public String getPageTitle();
    public void start(String browser);
    public void quit();
    public void getToUrl(String url);
    public Element findElement(By locator);
    public List<Element> findElements(By locator);
    public void waitForAjax();
    public void waitUntilPageLoads();
    public File takeScreenshot();
    public void implicitlyWait();

    public void setupWebDriverWait(By locator);
}
