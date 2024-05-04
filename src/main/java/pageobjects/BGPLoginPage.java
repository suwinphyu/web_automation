package pageobjects;

import drivermanager.DriverManager;
import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BGPLoginPage {

    WebDriver driver;

    public BGPLoginPage gotoUrl(String url) {
        driver.get(url);
        Log.info("Sign in with your username and password");
        return this;
    }

    private final By btnLogin = By.id("login-button");

    private final By burgerMenu = By.xpath("//*[@id=\"sgds-bgp-header-logo\"]/div");

    public BGPLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public CorpPassLoginPage clickOnLoginBtn() {
        driver.findElement(getBtnLogin()).click();
        Log.info("Clicked on Login btn");
        return new CorpPassLoginPage(driver);
    }

    public String getPageTitle() {
        Log.info("Getting page title in home page.");
        return DriverManager.getDriver().getPageTitle();
    }

    public By getBurgerMenu() {
        return burgerMenu;
    }

    public BGPLoginPage clickOnBurgerMenu() {
        driver.findElement(getBurgerMenu()).click();
        return this;
    }
}
