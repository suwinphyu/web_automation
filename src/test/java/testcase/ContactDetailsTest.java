package testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utilities.JsonFileReader;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ContactDetailsTest extends BaseTest {


    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }


    @Test(dataProvider = "credentials", priority = 9)
    public void checkMandatoryFields(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);

        String expectedFieldErr = "We need a response for this field";
        contactDetailsPage.enterName("TestName");
        contactDetailsPage.clearInputFieldName();
        Thread.sleep(2000);
       // webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ExtentReport.pass("Check required field error message for Name");
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getNameError());

        contactDetailsPage.enterJobTitle("testJob");
        contactDetailsPage.clearInputFieldJobTitle();
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getJobError());

        contactDetailsPage.enterContactNo("90010900");
        contactDetailsPage.clearInputFieldContactNo();
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getContactError());

        contactDetailsPage.enterEmail("test@email.com");
        contactDetailsPage.clearInputFieldEmail();
        Thread.sleep(1000);
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getEmailError());

        contactDetailsPage.enterBlockNo("Blk123");
        contactDetailsPage.clearInputFieldBlockNo();

        contactDetailsPage.enterStreet("Avenue3");
        contactDetailsPage.clearInputFieldStreet();

        contactDetailsPage.enterPostalCode("570173");
        contactDetailsPage.clearInputFieldPostalCode();
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getPostalCodeError());

        contactDetailsPage.enterOfferName("TestName");
        contactDetailsPage.clearInputFieldOfferName();

        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getOfferNameError());

        contactDetailsPage.enterOfferJob("TestJob");
        contactDetailsPage.clearInputFieldOfferJob();
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getOfferJobError());

        contactDetailsPage.enterOfferEmail("test@email.com");
        contactDetailsPage.clearInputFieldOfferEmail();
        Assert.assertEquals(expectedFieldErr, contactDetailsPage.getOfferEmailError());
    }

    @Test(dataProvider = "credentials", priority = 10)
    public void SaveContactDetailsForm(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Enter valid data in contact details form");
        contactDetailsPage.enterName(map.get("name").toString());
        contactDetailsPage.enterJobTitle(map.get("jobTitle").toString());
        contactDetailsPage.enterContactNo(map.get("contactNo").toString());
        contactDetailsPage.enterEmail(map.get("email").toString());
        contactDetailsPage.enterPersonalEmail(map.get("alternateEmail").toString());
        contactDetailsPage.enterBuildingNo(map.get("buildingName").toString());
        contactDetailsPage.enterBlockNo(map.get("blockNo").toString());
        contactDetailsPage.enterStreet(map.get("street").toString());
        contactDetailsPage.enterAddressLevel(map.get("level").toString());
        contactDetailsPage.enterUnit(map.get("unit").toString());
        contactDetailsPage.enterPostalCode(map.get("postalCode").toString());
        contactDetailsPage.enterOfferName(map.get("offerName").toString());
        contactDetailsPage.enterOfferJob(map.get("offerJob").toString());
        contactDetailsPage.enterOfferEmail(map.get("offerEmail").toString());
        contactDetailsPage.clickOnBtnSave();
        Thread.sleep(1000);
        ExtentReport.pass("Verify the saved data is correct");
        Assert.assertEquals(map.get("name").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtName()));
        Assert.assertEquals(map.get("jobTitle").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtJobTitle()));
        Assert.assertEquals(map.get("contactNo").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtContactNo()));
        Assert.assertEquals(map.get("email").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtEmail()));
        Assert.assertEquals(map.get("alternateEmail").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtPersonalEmail()));
        Assert.assertEquals(map.get("buildingName").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtBuildingNo()));
        Assert.assertEquals(map.get("blockNo").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtBlockNo()));
        Assert.assertEquals(map.get("street").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtStreet()));
        Assert.assertEquals(map.get("level").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtAddressLevel()));
        Assert.assertEquals(map.get("unit").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtUnit()));
        Assert.assertEquals(map.get("postalCode").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtPostalCode()));
        Assert.assertEquals(map.get("offerName").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtOfferName()));
        Assert.assertEquals(map.get("offerJob").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtOfferJob()));
        Assert.assertEquals(map.get("offerEmail").toString(), contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtOfferEmail()));
    }

    @Test(dataProvider = "credentials", priority = 11)
    public void validateErrorWithInvalidContactNo(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Enter invalid contact no");

        contactDetailsPage.enterContactNo(map.get("invalidContactNo").toString());
        ExtentReport.pass("Test Data = " + map.get("invalidContactNo").toString());
        contactDetailsPage.clickOnBtnSave();
        Thread.sleep(1000);

        String expectedError = "Oops, that’s not an 8-digit Singapore contact number";
        ExtentReport.pass("Expected result" + expectedError);
        Assert.assertEquals(expectedError, contactDetailsPage.getContactError());
    }


    @Test(dataProvider = "credentials", priority = 12)
    public void validateErrorWithInvalidPostalCode(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Enter invalid Postal code");
        contactDetailsPage.enterPostalCode(map.get("invalidPostalCode").toString());
        ExtentReport.pass("Test Data = " + map.get("invalidPostalCode").toString());

        contactDetailsPage.clickOnBtnSave();
        Thread.sleep(1000);

        String expectedError = "Oops, that’s not a 6-digit Singapore postal code";
        ExtentReport.pass("Expected result : " + expectedError);
        Assert.assertEquals(expectedError, contactDetailsPage.getPostalCodeError());
    }

    @Test(dataProvider = "credentials", priority = 13)
    public void checkCharLimitForBlockNo(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Verify char limit for Block No field");

        String inputString = map.get("maxBlockNo").toString();
        contactDetailsPage.enterBlockNo(map.get("maxBlockNo").toString());
        ExtentReport.pass("Test Data = " + inputString);
        Thread.sleep(1000);

        String expectedResult = inputString.substring(0, 10);
        ExtentReport.pass("Max char limit - 10");

        ExtentReport.pass("Expected result: " + expectedResult);
        Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtBlockNo()), expectedResult);
    }

    @Test(dataProvider = "credentials", priority = 14)
    public void checkCharLimitForUnit(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Verify char limit for Unit field");

        String inputString = map.get("maxUnit").toString();
        contactDetailsPage.enterUnit(map.get("maxUnit").toString());
        ExtentReport.pass("Test Data = " + inputString);
        Thread.sleep(1000);

        String expectedResult = inputString.substring(0, 5);
        ExtentReport.pass("Max char limit - 5");
        ExtentReport.pass("Expected result: " + expectedResult);
        Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtUnit()), expectedResult);
    }

    @Test(dataProvider = "credentials", priority = 15)
    public void checkCharLimitForLevel(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Verify char limit for Level field");

        String inputString = map.get("maxLevel").toString();
        contactDetailsPage.clearInputFieldLevel();
        contactDetailsPage.enterAddressLevel(map.get("maxLevel").toString());
        ExtentReport.pass("Test Data = " + inputString);
        Thread.sleep(1000);

        String expectedResult = inputString.substring(0, 3);
        ExtentReport.pass("Max char limit - 3");
        ExtentReport.pass("Expected result: " + expectedResult);
        Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtAddressLevel()), expectedResult);
    }

    @Test(dataProvider = "credentials", priority = 16)
    public void check_ON_SameMailingAddressBox(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        contactDetailsPage.clickMailingAddressCheckBox();
        ExtentReport.pass("Check ON \"Same as registered address in Company Profile\" checkbox");

        if (contactDetailsPage.isSelectedAddressCheckBox()) {
            ExtentReport.pass("Verify Mailing address fields are disabled");
            Assert.assertTrue(contactDetailsPage.readonlyBuildingNo());
            Assert.assertTrue(contactDetailsPage.readonlyBlockNo());
            Assert.assertTrue(contactDetailsPage.readonlyStreet());
            Assert.assertTrue(contactDetailsPage.readonlyUnit());
            Assert.assertTrue(contactDetailsPage.readonlyAddressLevel());
            Assert.assertTrue(contactDetailsPage.readonlyPostalCode());

            ExtentReport.pass("Verify that company mailing address data are shown correctly");
            Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtBuildingNo()), map.get("companyBuildingName").toString());
            Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtBlockNo()), map.get("companyBlockNo").toString());
            Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtStreet()), map.get("companyStreet").toString());
            Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtUnit()), map.get("companyUnit").toString());
            Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtAddressLevel()), map.get("companyLevel").toString());
            Assert.assertEquals(contactDetailsPage.fetchSaveData(contactDetailsPage.getTxtPostalCode()), map.get("companyPostalCode").toString());
        }
    }


    @Test(dataProvider = "credentials", priority = 17)
    public void check_OFF_SameMailingAddressBox(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Check OFF \"Same as registered address in Company Profile\" checkbox");
        if (contactDetailsPage.isSelectedAddressCheckBox()) {
            contactDetailsPage.clickMailingAddressCheckBox();
        }
        ExtentReport.pass("Verify Mailing address fields are enabled to input data");
        Assert.assertFalse(contactDetailsPage.readonlyBuildingNo());
        Assert.assertFalse(contactDetailsPage.readonlyBlockNo());
        Assert.assertFalse(contactDetailsPage.readonlyStreet());
        Assert.assertFalse(contactDetailsPage.readonlyUnit());
        Assert.assertFalse(contactDetailsPage.readonlyAddressLevel());
        Assert.assertFalse(contactDetailsPage.readonlyPostalCode());
    }

    @Test(dataProvider = "credentials", priority = 18)
    public void check_MailingAddressField_isBlank_After_OFF(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Check OFF \"Same as registered address in Company Profile\" checkbox");
        if (!contactDetailsPage.isSelectedAddressCheckBox()) {
            contactDetailsPage.clickMailingAddressCheckBox();
        }
        contactDetailsPage.clickMailingAddressCheckBox();
        ExtentReport.pass("Verify Mailing address fields are enabled to input data");
        Assert.assertEquals(contactDetailsPage.getBuildingName(), "");
        Assert.assertEquals(contactDetailsPage.getBlockNo(), "");
        Assert.assertEquals(contactDetailsPage.getStreet(), "");
        Assert.assertEquals(contactDetailsPage.getLevel(), "");
        Assert.assertEquals(contactDetailsPage.getUnit(), "");
        Assert.assertEquals(contactDetailsPage.getPostalCode(), "");
    }


    @Test(dataProvider = "credentials", priority = 19)
    public void check_ON_SameContactPersonBox(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        contactDetailsPage.clickSameContactCheckBox();
        ExtentReport.pass("Check ON \"Same as main contact person\" checkbox");

        if (contactDetailsPage.isSelectedAddressCheckBox()) {
            ExtentReport.pass("Verify contact person fields are disabled");
            Assert.assertTrue(contactDetailsPage.readonlyOfferName());
            Assert.assertTrue(contactDetailsPage.readonlyOfferJob());
            Assert.assertTrue(contactDetailsPage.readonlyOfferEmail());

            ExtentReport.pass("Verify that same contact information are auto populated");
            Assert.assertEquals(contactDetailsPage.getOfferName(), contactDetailsPage.getName());
            Assert.assertEquals(contactDetailsPage.getOfferJob(), contactDetailsPage.getJob());
            Assert.assertEquals(contactDetailsPage.getOfferEmail(), contactDetailsPage.getEmail());
        }
    }


    @Test(dataProvider = "credentials", priority = 20)
    public void check_OFF_SameContactPersonBox(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Check OFF \"Same as main contact person\" checkbox");

        if (!contactDetailsPage.isSelectedAddressCheckBox()) {
            contactDetailsPage.clickSameContactCheckBox();
        }
        contactDetailsPage.clickSameContactCheckBox();
        ExtentReport.pass("Verify contact person fields are enable after checking OFF");
        Assert.assertFalse(contactDetailsPage.readonlyOfferName());
        Assert.assertFalse(contactDetailsPage.readonlyOfferJob());
        Assert.assertFalse(contactDetailsPage.readonlyOfferEmail());

        ExtentReport.pass("Verify that same contact information are auto populated");
        Assert.assertEquals(contactDetailsPage.getOfferName(), "");
        Assert.assertEquals(contactDetailsPage.getOfferJob(), "");
        Assert.assertEquals(contactDetailsPage.getOfferEmail(), "");
    }




    @Test(dataProvider = "credentials", priority = 21)
    public void navigateToPreviousPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);
        ExtentReport.pass("Redirect to Eligibility");
        eligibilityPage = contactDetailsPage.clickOnBtnPrevious();
        String expectedTitle = "Check Your Eligibility";
        ExtentReport.pass("Expected result: " + expectedTitle);
        Assert.assertEquals(eligibilityPage.getFormTitle(), expectedTitle.toUpperCase());
    }

    @Test(dataProvider = "credentials", priority = 22)
    public void navigateToNextPage(Map<String, Object> map) throws InterruptedException {
        loginConfig(map.get("username").toString(), map.get("password").toString());

        webDriver.get(contactInfoUrl);

        proposalPage = contactDetailsPage.clickOnBtnNext();
        ExtentReport.pass("Navigate to Proposal");
        Thread.sleep(1000);

        String expectedTitle = "Submit Your Proposal";
        ExtentReport.pass("Expected result: " + expectedTitle);
        Assert.assertEquals(expectedTitle.toUpperCase(), proposalPage.getFormTitle());
    }
}
