package testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.PathConfig;
import drivermanager.Driver;
import drivermanager.DriverBase;
import drivermanager.DriverLogger;
import drivermanager.DriverManager;
import logsetup.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageobjects.*;
import utilities.PropertyFileReader;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    Driver driver;
    WebDriver webDriver;
    String url = PropertyFileReader.readFile(PathConfig.CONFIG).get("url").toString();
    String eligibilityUrl = PropertyFileReader.readFile(PathConfig.CONFIG).get("eligibilityUrl").toString();
    String contactInfoUrl = PropertyFileReader.readFile(PathConfig.CONFIG).get("contactInfoUrl").toString();
    String projectUrl = PropertyFileReader.readFile(PathConfig.CONFIG).get("projectUrl").toString();
    String impactUrl = PropertyFileReader.readFile(PathConfig.CONFIG).get("impactUrl").toString();
    String costDetailsUrl = PropertyFileReader.readFile(PathConfig.CONFIG).get("costDetailsUrl").toString();
    String reviewUrl = PropertyFileReader.readFile(PathConfig.CONFIG).get("reviewUrl").toString();
    LoginPage loginPage;
    BGPLoginPage bgpLoginPage;
    CorpPassLoginPage corpPassLoginPage;
    DashboardPage dashboardPage;
    EligibilityPage eligibilityPage;
    FAQPage faqPage;
    ContactDetailsPage contactDetailsPage;
    ProposalPage proposalPage;
    BusinessImpactPage businessImpactPage;
    DetailsCostPage detailsCostPage;

    DeclareAndReviewPage declareAndReviewPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void testInit(String browser) throws Exception {
        driver = new DriverLogger(new DriverBase());
        DriverManager.setDriver(driver);
        Log.info("Driver set up successfully.");

        DriverManager.getDriver().start(browser);
        Log.info(browser + " browser started.");

        webDriver = DriverBase.getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        pageObjectSetup();
    }

    @AfterMethod
    public void testCleanup() {
        if (DriverManager.getDriver() != null) {
            DriverManager.removeDriver();
        }
        Log.info("Driver quit successfully.");
    }

    void pageObjectSetup() {
        loginPage = new LoginPage(webDriver);
        bgpLoginPage = new BGPLoginPage(webDriver);
        corpPassLoginPage = new CorpPassLoginPage(webDriver);
        dashboardPage = new DashboardPage(webDriver);
        eligibilityPage = new EligibilityPage(webDriver);
        faqPage = new FAQPage(webDriver);
        contactDetailsPage = new ContactDetailsPage(webDriver);
        proposalPage = new ProposalPage(webDriver);
        businessImpactPage = new BusinessImpactPage(webDriver);
        detailsCostPage = new DetailsCostPage(webDriver);
        declareAndReviewPage = new DeclareAndReviewPage(webDriver);
    }


    void loginConfig(String username, String password) throws InterruptedException {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        bgpLoginPage = loginPage.clickOnSignIn();
      //  bgpLoginPage.clickOnBurgerMenu();
        corpPassLoginPage = bgpLoginPage.clickOnLoginBtn();
        dashboardPage = corpPassLoginPage.clickOnBtnSelect();
        Thread.sleep(1000);
    }


    public String numberFormat(Object tobeFormatObject) {
        if (tobeFormatObject instanceof String) {
            BigDecimal result = new BigDecimal((String) tobeFormatObject);
            return String.format("%,.2f", result);
        }
        return String.format("%.2d", 0);

    }

}
