package testcase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utilities.JsonFileReader;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EligibilityTest extends BaseTest {

    String actualPageTitle;
    String expectedPageTitle;


    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }


    @Test(dataProvider = "credentials", priority = 5)
    public void fieldValidationForEligibilityYes(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(eligibilityUrl);
        ExtentReport.pass("Select YES option for all fields");
        if (!eligibilityPage.isSelectedSgRegisterYes()) {
            eligibilityPage.selectSgRegisterOptionYes();
        }
        if (!eligibilityPage.isSelectedTurnoverYes()) {
            eligibilityPage.selectTurnoverOptionYes();
        }
        if (!eligibilityPage.isSelectedLocalEquityYes()) {
            eligibilityPage.selectLocalEquityOptionYes();
        }
        if (!eligibilityPage.isSelectedStartedProjectYes()) {
            eligibilityPage.selectStartedProjectOptionYes();
        }
        eligibilityPage.clickOnBtnSave();
        Thread.sleep(2000);
        ExtentReport.pass("Click on SAVE");
        Assert.assertTrue(eligibilityPage.isSelectedSgRegisterYes());
        Assert.assertTrue(eligibilityPage.isSelectedTurnoverYes());
        Assert.assertTrue(eligibilityPage.isSelectedLocalEquityYes());
        Assert.assertTrue(eligibilityPage.isSelectedStartedProjectYes());
        ExtentReport.pass("Check the save data is correct");
    }


    @Test(dataProvider = "credentials", priority = 6)
    public void fieldValidationForEligibilityNo(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());
        ExtentReport.pass("Check Error message when user click on NO option");
        String expectedErrorMesg = "The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants.";
        webDriver.get(eligibilityUrl);

        if (eligibilityPage.isSelectedSgRegisterYes()) {
            eligibilityPage.selectSgRegisterOptionNo();
            Assert.assertEquals(eligibilityPage.getSgRegisterError(), expectedErrorMesg);
        }
        if (eligibilityPage.isSelectedTurnoverYes()) {
            Thread.sleep(1000);
            Duration duration = Duration.ofSeconds(60);
            WebDriverWait wait = new WebDriverWait(webDriver, duration);

            wait.until(ExpectedConditions.visibilityOfElementLocated(eligibilityPage.getRdoTurnoverOptionNo()));
            eligibilityPage.selectTurnoverOptionNo();
            Assert.assertEquals(eligibilityPage.getTurnoverError(), expectedErrorMesg);
        }

        if (eligibilityPage.isSelectedLocalEquityYes()) {
            Thread.sleep(1000);
            eligibilityPage.selectLocalEquityOptionNo();
            Assert.assertEquals(eligibilityPage.getLocalEquityError(), expectedErrorMesg);
        }
        if (eligibilityPage.isSelectedStartedProjectYes()) {
            Thread.sleep(1000);
            eligibilityPage.selectStartedProjectOptionNo();
            Assert.assertEquals(eligibilityPage.getStartedProjectError(), expectedErrorMesg);
            ExtentReport.pass("Expected result: " + expectedErrorMesg);
        }
        eligibilityPage.clickOnBtnSave();
        Thread.sleep(2000);
        ExtentReport.pass("Click on SAVE");

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        Assert.assertFalse(eligibilityPage.isSelectedSgRegisterYes());
        Assert.assertFalse(eligibilityPage.isSelectedTurnoverYes());
        Assert.assertFalse(eligibilityPage.isSelectedLocalEquityYes());
        Assert.assertFalse(eligibilityPage.isSelectedStartedProjectYes());
        ExtentReport.pass("Check the save data is correct");
    }

    @Test(dataProvider = "credentials", priority = 7)
    public void navigateToFAQ(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(eligibilityUrl);
        eligibilityPage.selectSgRegisterOptionNo();
        eligibilityPage.clickFQAlink();
        ExtentReport.pass("Click on FAQ Link");

        List<String> browserTabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(browserTabs.get(1));
        Thread.sleep(2000);
        expectedPageTitle = "About";
        actualPageTitle = faqPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        ExtentReport.pass("Navigate to FQA Tab");

        webDriver.close();
        webDriver.switchTo().window(browserTabs.get(0));
    }

    @Test(dataProvider = "credentials", priority = 8)
    public void navigateToContactDetails(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(eligibilityUrl);
        contactDetailsPage = eligibilityPage.clickOnBtnNext();
        Thread.sleep(2000);
        ExtentReport.pass("Navigate to Contact Details");

        expectedPageTitle = "Provide Your Contact Details";
        actualPageTitle = contactDetailsPage.getContactDetailTitle();
        Assert.assertEquals(expectedPageTitle.toUpperCase(), actualPageTitle.toUpperCase());
        ExtentReport.pass("Redirect page title -  " + actualPageTitle);
    }

}
