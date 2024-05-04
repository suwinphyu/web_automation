package testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utilities.JsonFileReader;

import java.math.BigDecimal;
import java.util.Map;

public class BusinessImpactTest extends BaseTest {

    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }

    @Test(dataProvider = "credentials", priority = 26)
    public void saveBusinessImpactForm(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());
        ExtentReport.pass("Enter valid data in Business Impact");

        webDriver.get(impactUrl);
        businessImpactPage.selectFYEndDate();
        ExtentReport.pass("Select FY End Date");
        Thread.sleep(3000);

        businessImpactPage.enterOverseaSale(map.get("overseaSale").toString());
        ExtentReport.pass("Enter valid data in oversea sale");

        businessImpactPage.enterInvestment(map.get("investment").toString());
        ExtentReport.pass("Enter valid data in investment");

        businessImpactPage.enterProjection(map.get("projection").toString());
        ExtentReport.pass("Enter valid data in projection");

        businessImpactPage.enterBenefit(map.get("benefit").toString());
        ExtentReport.pass("Enter valid data in benefit");

        businessImpactPage.clickOnBtnSave();
        ExtentReport.pass("Click on SAVE");
        Thread.sleep(3000);
        Assert.assertEquals(map.get("benefit").toString(), businessImpactPage.fetchSaveData(businessImpactPage.getTxtBenefit()));
        Assert.assertEquals(numberFormat(map.get("investment").toString()), businessImpactPage.fetchSaveData(businessImpactPage.getTxtInvestment()));
        Assert.assertEquals(map.get("projection").toString(), businessImpactPage.fetchSaveData(businessImpactPage.getTxtProjection()));
        Assert.assertEquals(numberFormat(map.get("overseaSale").toString()), businessImpactPage.fetchSaveData(businessImpactPage.getTxtOverseaSale()));
        ExtentReport.pass("Check the save data is correct");
    }

    @Test(dataProvider = "credentials", priority = 27)
    public void navigateToPreviousImpactPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(impactUrl);
        proposalPage = businessImpactPage.clickOnBtnPrevious();
        ExtentReport.pass("Navigate to Proposal section");
        Thread.sleep(2000);
        String expectedTitle = "Submit Your Proposal";
        Assert.assertEquals(proposalPage.getFormTitle(), expectedTitle.toUpperCase());
        ExtentReport.pass("Expected result: " + expectedTitle);
    }

    @Test(dataProvider = "credentials", priority = 28)
    public void navigateToNextPageFromImpactPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(impactUrl);
        detailsCostPage = businessImpactPage.clickOnBtnNext();
        ExtentReport.pass("Navigate to Cost section");
        Thread.sleep(2000);

        String expectedTitle = "PROVIDE DETAILS OF COSTS";
        Assert.assertEquals(expectedTitle.toUpperCase(), detailsCostPage.getFormTitle());
        ExtentReport.pass("Expected result: " + expectedTitle);
    }
}
