package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private final By txtPassword = By.xpath("/html/body/div[@class='container']/div[@class='modal-dialog']/div[2]//form[@name='cognitoSignInForm']//input[@id='signInFormPassword']");
    private final By txtUserName = By.xpath("/html/body/div[@class='container']/div[@class='modal-dialog']/div[2]//form[@name='cognitoSignInForm']//input[@id='signInFormUsername']");
    private final By btnSignIn = By.xpath("/html/body/div[@class='container']/div[@class='modal-dialog']/div[2]/div[@class='modal-body']/div[2]/div[2]/div[2]/div/form[@name='cognitoSignInForm']/input[@name='signInSubmitButton']");
    private final By lblFormDesc = By.cssSelector("[class='panel panel-left-border col-md-6 col-lg-6'] .textDescription-customizable");
    private final By lblErrorMesg = By.cssSelector(".background-customizable.modal-content.modal-content-desktop.visible-lg.visible-md form[name='cognitoSignInForm'] > p#loginErrorMessage");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLblFormDesc() {
        return lblFormDesc;
    }

    public By getTxtUserName() {
        return txtUserName;
    }

    public By getTxtPassword() {
        return txtPassword;
    }

    public By getBtnSignIn() {
        return btnSignIn;
    }

    public By getLblErrorMesg() {
        return lblErrorMesg;
    }

    public LoginPage gotoUrl(String url) {
        driver.get(url);
        Log.info("Sign in with your username and password");
        return this;
    }

    public String getPageTitle() {
        Log.info("Getting page title in home page.");
        return driver.getTitle();
    }

    public void enterUserName(String userName) {
        driver.findElement(getTxtUserName()).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(getTxtPassword()).sendKeys(password);
    }

    public BGPLoginPage clickOnSignIn() {
        driver.findElement(getBtnSignIn()).click();
        Log.info("Clicked on signIn btn");
        return new BGPLoginPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(getLblErrorMesg()).getText();
    }

}
