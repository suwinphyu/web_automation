package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CorpPassLoginPage {

    WebDriver driver;

    private final By txtEntityId = By.xpath("/html//input[@id='entityId']");

    private final By txtUserId = By.xpath("/html//input[@id='userId']");

    private final By txtUserRole = By.xpath("/html//input[@id='userRole']");

    private final By txtUserFullName = By.xpath("/html//input[@id='userFullName']");

    private final By btnLogin = By.xpath("/html//div[@class='row']/div[2]/form[@role='form']/button[@type='submit']");

    private final By btnSelect = By.id("btn001");

    public CorpPassLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public By getTxtEntityId() {
        return txtEntityId;
    }

    public By getTxtUserId() {
        return txtUserId;
    }

    public By getTxtUserRole() {
        return txtUserRole;
    }

    public By getTxtUserFullName() {
        return txtUserFullName;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public void enterEntityId(String entityId) {
        driver.findElement(getTxtEntityId()).sendKeys(entityId);
    }

    public void enterUserId(String userId) {
        driver.findElement(getTxtUserId()).sendKeys(userId);
    }

    public void enterUserRole(String userRole) {
        driver.findElement(getTxtUserRole()).sendKeys(userRole);
    }

    public void enterUserFullName(String userFullName) {
        driver.findElement(getTxtUserFullName()).sendKeys(userFullName);
    }

    public DashboardPage clickOnLoginBtn() {
        driver.findElement(getBtnLogin()).click();
        Log.info("Clicked on Login btn");
        return new DashboardPage(driver);
    }

    public String getPageTitle() {
        Log.info("Getting page title in home page.");
        return driver.getTitle();
    }

    public By getBtnSelect() {
        return btnSelect;
    }

    public DashboardPage clickOnBtnSelect() {
        driver.findElement(getBtnSelect()).click();
        Log.info("Clicked on Login btn");
        return new DashboardPage(driver);
    }

}
