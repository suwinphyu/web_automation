package browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserManager{
    @Override
    public WebDriver initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("-headed");
     //   chromeOptions.addArguments("window-size=1200x600");

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
