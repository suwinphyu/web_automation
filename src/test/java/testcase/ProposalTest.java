package testcase;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utilities.JsonFileReader;

import java.math.BigDecimal;
import java.util.Map;

public class ProposalTest extends BaseTest {

    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }


    @Test(dataProvider = "credentials", priority = 23)
    public void saveProjectForm(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());
        ExtentReport.pass("Fill valid data in Project Form");

        webDriver.get(projectUrl);
        proposalPage.enterProjectTitle(map.get("projTitle").toString());
        ExtentReport.pass("Enter project title");

        proposalPage.selectStartDate();
        ExtentReport.pass("Select Start Date");

        proposalPage.selectEndDate();
        ExtentReport.pass("Select End Date");

        proposalPage.enterProjectDesc(map.get("projectDesc").toString());
        ExtentReport.pass("Enter project Description ");
        Thread.sleep(2000);

        proposalPage.clickActivityDropdown();
        proposalPage.selectActivityDropdownOption();
        ExtentReport.pass("Select Activity Dropdown");

        proposalPage.enterRemark(map.get("remark").toString());
        ExtentReport.pass("Enter remark");

        proposalPage.clickOnBtnSave();
        Thread.sleep(1000);
        ExtentReport.pass("Click on SAVE");
        Assert.assertEquals(map.get("projTitle").toString(), proposalPage.fetchSaveData(proposalPage.getTxtProjectTitle()));
        Assert.assertEquals(map.get("projectDesc").toString(), proposalPage.fetchSaveData(proposalPage.getTxtProjectDesc()));
        Assert.assertEquals(map.get("remark").toString(), proposalPage.fetchSaveData(proposalPage.getTxtRemark()));
        ExtentReport.pass("Check the save data is correct");
    }

    @Test(dataProvider = "credentials", priority = 24)
    public void navigateToPreviousProposalPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(projectUrl);
        contactDetailsPage = proposalPage.clickOnBtnPrevious();
        ExtentReport.pass("Redirect to Contact Details");
        Thread.sleep(2000);

        String expectedTitle = "PROVIDE YOUR CONTACT DETAILS";
        Assert.assertEquals(contactDetailsPage.getFormTitle(),expectedTitle.toUpperCase());
        ExtentReport.pass("Expected result: " + expectedTitle);
    }

    @Test(dataProvider = "credentials", priority = 25)
    public void navigateToNextPageFromProposalPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(projectUrl);
        businessImpactPage = proposalPage.clickOnBtnNext();
        ExtentReport.pass("Navigate to Business Impact");
        Thread.sleep(2000);

        String expectedTitle = "Explain The Business Impact";
        Assert.assertEquals(businessImpactPage.getFormTitle(),expectedTitle.toUpperCase());
        ExtentReport.pass("Expected result: " + expectedTitle);
    }
}
