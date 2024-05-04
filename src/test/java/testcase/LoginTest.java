package testcase;

import drivermanager.DriverBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utilities.JsonFileReader;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;


public class LoginTest extends BaseTest {
    String actualPageTitle;
    String expectedPageTitle;


    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }


    @Test(priority = 1)
    public void launchTestURL() {
        expectedPageTitle = "Signin";
        actualPageTitle = loginPage.getPageTitle();
        ExtentReport.pass("Launch Test URL");
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }


    @Test(dataProvider = "credentials", priority = 2)
    public void signIn_invalidCredentials(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "The username or password you entered is invalid";
        ExtentReport.pass("Sign in with invalid credentials");
        loginPage.enterUserName(map.get("invalidUsername").toString());
        loginPage.enterPassword(map.get("invalidPassword").toString());
        loginPage.clickOnSignIn();
        Thread.sleep(1000);
        actualPageTitle = loginPage.getErrorMessage();
        ExtentReport.pass(actualPageTitle);
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Test(dataProvider = "credentials", priority = 3)
    public void verifyManualLogin(Map<String, Object> map) throws InterruptedException {

        expectedPageTitle = "Business Grants Portal";

        ExtentReport.pass("Sign in with valid credentials");
        loginPage.enterUserName(map.get("username").toString());
        loginPage.enterPassword(map.get("password").toString());
        bgpLoginPage = loginPage.clickOnSignIn();
        Thread.sleep(1000);
        actualPageTitle = bgpLoginPage.getPageTitle();
        ExtentReport.pass("User is in BGP Login ");
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        // bgpLoginPage.clickOnBurgerMenu();
        expectedPageTitle = "CorpPass Login";
        corpPassLoginPage = bgpLoginPage.clickOnLoginBtn();
        Thread.sleep(1000);
        actualPageTitle = corpPassLoginPage.getPageTitle();
        ExtentReport.pass("User is in Corp Pass Login ");
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        expectedPageTitle = "Business Grants Portal";
        corpPassLoginPage.enterEntityId(map.get("entityId").toString());
        corpPassLoginPage.enterUserId(map.get("userId").toString());
        corpPassLoginPage.enterUserRole(map.get("userRole").toString());
        corpPassLoginPage.enterUserFullName(map.get("fullName").toString());
        dashboardPage = corpPassLoginPage.clickOnLoginBtn();
        Thread.sleep(1000);
        actualPageTitle = dashboardPage.getPageTitle();
        ExtentReport.pass("User is in Dashboard ");

    }


    @Test(dataProvider = "credentials", priority = 4)
    public void signIn_validCredentials(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "Business Grants Portal";

        ExtentReport.pass("Sign in with valid credentials");
        loginPage.enterUserName(map.get("username").toString());
        loginPage.enterPassword(map.get("password").toString());
        bgpLoginPage = loginPage.clickOnSignIn();
        Thread.sleep(1000);
        actualPageTitle = bgpLoginPage.getPageTitle();
        ExtentReport.pass("User is in BGP Login ");
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        // bgpLoginPage.clickOnBurgerMenu();
        expectedPageTitle = "CorpPass Login";
        corpPassLoginPage = bgpLoginPage.clickOnLoginBtn();
        Thread.sleep(1000);
        actualPageTitle = corpPassLoginPage.getPageTitle();
        ExtentReport.pass("User is in Corp Pass Login ");
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        expectedPageTitle = "Business Grants Portal";
        dashboardPage = corpPassLoginPage.clickOnBtnSelect();
        Thread.sleep(1000);
        actualPageTitle = dashboardPage.getPageTitle();
        ExtentReport.pass("User is in Dashboard ");
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }
}
