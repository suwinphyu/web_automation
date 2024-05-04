package testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utilities.JsonFileReader;

import java.time.Duration;
import java.util.Map;

public class DeclareAndReviewTest extends BaseTest {


    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }


    @Test(dataProvider = "credentials", priority = 29)
    public void navigateToNextFromCostPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(projectUrl);
        declareAndReviewPage = detailsCostPage.clickOnBtnNext();
        ExtentReport.pass("Navigate to Declare and Review");
        Thread.sleep(1000);

        String expectedTitle = "Explain The Business Impact";
        Assert.assertEquals(expectedTitle.toUpperCase(), declareAndReviewPage.getFormTitle());
        ExtentReport.pass("Expected result: " + expectedTitle);
    }

    @Test(dataProvider = "credentials", priority = 30)
    public void saveDeclareAndReviewForm_With_No(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(reviewUrl);
        ExtentReport.pass("Select NO options in Declare and Review ");

        declareAndReviewPage.selectLiabilityRemarksNo();
        declareAndReviewPage.selectCivilRemarksNo();
        declareAndReviewPage.selectInsolvencyRemarksNo();
        declareAndReviewPage.selectIncentiveNameNo();
        declareAndReviewPage.selectOtherIncentiveNo();
        declareAndReviewPage.selectCommenceRemarksNo();
        declareAndReviewPage.selectPartyRemarksNo();
        declareAndReviewPage.selectDebarmentRemarksNo();

        if (!declareAndReviewPage.isSelected(declareAndReviewPage.getChkAcknowledgement())) {
            declareAndReviewPage.clickAcknowledgementCheckbox();
            ExtentReport.pass("Check ON AcknowledgementCheckbox");
        }
        declareAndReviewPage.clickOnBtnSave();
        ExtentReport.pass("Check on SAVE");
        Thread.sleep(2000);

        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoLiabilityRemarksNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoCivilRemarksNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoInsolvencyRemarksNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoIncentiveNameNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoOtherIncentiveNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoCommenceRemarksNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoDebarmentRemarksNo()));
        Assert.assertFalse(declareAndReviewPage.isSelected(declareAndReviewPage.getRdoPartyRemarksNo()));
        Assert.assertTrue(declareAndReviewPage.isSelected(declareAndReviewPage.getChkAcknowledgement()));
        ExtentReport.pass("Check the save data is correct");

    }

    @Test(dataProvider = "credentials", priority = 31)
    public void checkErrorForMandatoryFields(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        String expectedErr = "We need a response for this field";
        webDriver.get(reviewUrl);


        webDriver.get(reviewUrl);
        declareAndReviewPage.selectLiabilityRemarksYes();
        ExtentReport.pass("Select YES option for LiabilityRemarks");
        declareAndReviewPage.enterLiabilityRemarks(map.get("liabilityRemarks").toString());
        webDriver.findElement(declareAndReviewPage.getTxtLiabilityRemarks()).clear();
        Thread.sleep(2000);
        Assert.assertEquals(expectedErr, declareAndReviewPage.getLiabilityRemarkErr());
        ExtentReport.pass("Check error message for LiabilityRemarks");

        declareAndReviewPage.selectCivilRemarksYes();
        ExtentReport.pass("Select YES option for CivilRemarks");
        declareAndReviewPage.enterCivilRemarks(map.get("civilRemarks").toString());
        webDriver.findElement(declareAndReviewPage.getTxtCivilRemarks()).clear();
        Thread.sleep(3000);
        Assert.assertEquals(expectedErr, declareAndReviewPage.getCivilRemarkErr());
        ExtentReport.pass("Check error message for CivilRemarks");

        declareAndReviewPage.selectCommenceRemarksYes();
        ExtentReport.pass("Select YES option for CommenceRemarks");
        declareAndReviewPage.enterCommenceRemarks(map.get("commenceRemarks").toString());
        webDriver.findElement(declareAndReviewPage.getTxtCommenceRemarks()).clear();
        Thread.sleep(5000);
        Assert.assertEquals(expectedErr, declareAndReviewPage.getCommenceRemarkErr());
        ExtentReport.pass("Check error message for CommenceRemarks");

        declareAndReviewPage.selectPartyRemarksYes();
        ExtentReport.pass("Select YES option for PartyRemarks");
        declareAndReviewPage.enterPartyRemarks(map.get("partyRemarks").toString());
        webDriver.findElement(declareAndReviewPage.getTxtPartyRemarks()).clear();
        Thread.sleep(5000);
        Assert.assertEquals(expectedErr, declareAndReviewPage.getPartyRemarkErr());
        ExtentReport.pass("Check error message for PartyRemarks");

        declareAndReviewPage.selectDebarmentRemarksYes();
        ExtentReport.pass("Select YES option for DebarmentRemarks");
        declareAndReviewPage.enterDebarmentRemarks(map.get("debarmentRemarks").toString());
        webDriver.findElement(declareAndReviewPage.getTxtDebarmentRemarks()).clear();
        Thread.sleep(5000);
        Assert.assertEquals(expectedErr, declareAndReviewPage.getDebarmentRemarkErr());
        ExtentReport.pass("Check error message for DebarmentRemarks");


    }

    @Test(dataProvider = "credentials", priority = 32)
    public void saveDeclareAndReviewForm_With_Yes(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(reviewUrl);
        declareAndReviewPage.selectLiabilityRemarksYes();
        ExtentReport.pass("Select YES option for LiabilityRemarks");
        declareAndReviewPage.enterLiabilityRemarks(map.get("liabilityRemarks").toString());
        ExtentReport.pass("Enter remark for LiabilityRemarks");

        declareAndReviewPage.selectCivilRemarksYes();
        ExtentReport.pass("Select YES option for CivilRemarks");
        declareAndReviewPage.enterCivilRemarks(map.get("civilRemarks").toString());
        ExtentReport.pass("Enter remark for CivilRemarks");

        declareAndReviewPage.selectInsolvencyRemarksYes();
        ExtentReport.pass("Select YES option for InsolvencyRemarks");
        declareAndReviewPage.enterInsolvencyRemarks(map.get("insolvencyRemarks").toString());
        ExtentReport.pass("Enter remark for InsolvencyRemarks");

        declareAndReviewPage.selectCommenceRemarksYes();
        ExtentReport.pass("Select YES option for CommenceRemarks");
        declareAndReviewPage.enterCommenceRemarks(map.get("commenceRemarks").toString());
        ExtentReport.pass("Enter remark for CommenceRemarks");

        declareAndReviewPage.selectPartyRemarksYes();
        ExtentReport.pass("Select YES option for PartyRemarks");
        declareAndReviewPage.enterPartyRemarks(map.get("partyRemarks").toString());
        ExtentReport.pass("Enter remark for PartyRemarks");

        declareAndReviewPage.selectDebarmentRemarksYes();
        ExtentReport.pass("Select YES option for DebarmentRemarks");
        declareAndReviewPage.enterDebarmentRemarks(map.get("debarmentRemarks").toString());
        ExtentReport.pass("Enter remark for DebarmentRemarks");

        if (!declareAndReviewPage.isSelected(declareAndReviewPage.getChkAcknowledgement())) {
            declareAndReviewPage.clickAcknowledgementCheckbox();
        }
        declareAndReviewPage.clickOnBtnSave();
        ExtentReport.pass("Check on SAVE");
        Thread.sleep(2000);

        Assert.assertEquals(map.get("liabilityRemarks").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtLiabilityRemarks()));
        Assert.assertEquals(map.get("civilRemarks").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtCivilRemarks()));
        Assert.assertEquals(map.get("insolvencyRemarks").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtInsolvencyRemarks()));
        Assert.assertEquals(map.get("commenceRemarks").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtCommenceRemarks()));
        Assert.assertEquals(map.get("partyRemarks").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtPartyRemarks()));
        Assert.assertEquals(map.get("debarmentRemarks").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtDebarmentRemarks()));
        ExtentReport.pass("Check the save data is correct");

    }

    @Test(dataProvider = "credentials", priority = 33)
    public void addIncentiveField(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(reviewUrl);

        declareAndReviewPage.selectIncentiveNameYes();
        ExtentReport.pass("Select YES option ");

        declareAndReviewPage.enterIncentiveName(map.get("incentiveName").toString());
        ExtentReport.pass("Enter IncentiveName");

        declareAndReviewPage.clearIncentiveStartDate();
        declareAndReviewPage.sendKeyForStartDate(map.get("incentiveStartDate").toString());

        ExtentReport.pass("Select Start Date");
        declareAndReviewPage.clearIncentiveEndDate();
        declareAndReviewPage.sendKeyForEndDate(map.get("incentiveEndDate").toString());
        ExtentReport.pass("Select End Date");
        Thread.sleep(2000);

        if (!declareAndReviewPage.isSelected(declareAndReviewPage.getChkAcknowledgement())) {
            declareAndReviewPage.clickAcknowledgementCheckbox();
        }
        declareAndReviewPage.clickOnBtnSave();
        ExtentReport.pass("Check on SAVE");
        Thread.sleep(1000);

        Assert.assertEquals(map.get("incentiveName").toString(), declareAndReviewPage.fetchSaveData(declareAndReviewPage.getTxtIncentiveName()));
        Assert.assertEquals(declareAndReviewPage.readIncentiveStartDate(), map.get("incentiveStartDate").toString());
        Assert.assertEquals(declareAndReviewPage.readIncentiveEndDate(), map.get("incentiveEndDate").toString());
        ExtentReport.pass("Check the Start date and End date are saved draft correctly");
    }


    @Test(dataProvider = "credentials", priority = 35)
    public void checkErrorForAcknowledgeCheckbox(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());
        webDriver.get(reviewUrl);
        ExtentReport.pass("Select NO options in Declare and Review ");

        declareAndReviewPage.selectLiabilityRemarksNo();
        declareAndReviewPage.selectCivilRemarksNo();
        declareAndReviewPage.selectInsolvencyRemarksNo();
        declareAndReviewPage.selectIncentiveNameNo();
        declareAndReviewPage.selectOtherIncentiveNo();
        declareAndReviewPage.selectCommenceRemarksNo();
        declareAndReviewPage.selectPartyRemarksNo();
        declareAndReviewPage.selectDebarmentRemarksNo();

        if (!declareAndReviewPage.isSelected(declareAndReviewPage.getChkAcknowledgement())) {
            declareAndReviewPage.clickAcknowledgementCheckbox();
            ExtentReport.pass("Check ON AcknowledgementCheckbox");
        }

        declareAndReviewPage.clickAcknowledgementCheckbox();
        ExtentReport.pass("Check OFF AcknowledgementCheckbox");
        Thread.sleep(5000);

        String expectedErr = "Acknowledge and consent to the terms to proceed";
        ExtentReport.pass("Check error message for acknowledge checkbox is correct");
        Assert.assertEquals(expectedErr, declareAndReviewPage.getAcknowledgeError());

    }

    @Test(dataProvider = "credentials", priority = 36)
    public void navigateToPreviousPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(reviewUrl);
        detailsCostPage = declareAndReviewPage.clickOnBtnPrevious();
        ExtentReport.pass("Navigate to Detail Cost");
        Thread.sleep(2000);
        String expectedTitle = "PROVIDE DETAILS OF COSTS";
        Assert.assertEquals(detailsCostPage.getFormTitle(), expectedTitle.toUpperCase());
        ExtentReport.pass("Expected result: " + expectedTitle);
    }

    @Test(dataProvider = "credentials", priority = 37)
    public void navigateToReview(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());
        ExtentReport.pass("Click on REVIEW");

        webDriver.get(reviewUrl);
        eligibilityPage = declareAndReviewPage.clickOnBtnReview();
        Thread.sleep(1000);
        String expectedTitle = "CHECK YOUR ELIGIBILITY";
        Assert.assertEquals(expectedTitle.toUpperCase(), declareAndReviewPage.getFormTitle());
    }
}
