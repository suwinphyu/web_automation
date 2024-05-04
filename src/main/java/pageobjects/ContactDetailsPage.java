package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetailsPage {

    WebDriver driver;

    private final By lblTitle = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2");

    private final By txtName = By.id("react-contact_info-name");
    private final By txtJobTitle = By.id("react-contact_info-designation");
    private final By txtContactNo = By.id("react-contact_info-phone");
    private final By txtEmail = By.id("react-contact_info-primary_email");
    private final By txtPersonalEmail = By.id("react-contact_info-secondary_email");
    private final By chkMailingAddress = By.id("react-contact_info-correspondence_address-copied");
    private final By txtBuildingNo = By.id("react-contact_info-correspondence_address-building_name");
    private final By txtBlockNo = By.id("react-contact_info-correspondence_address-block");
    private final By txtStreet = By.id("react-contact_info-correspondence_address-street");
    private final By txtAddressLevel = By.id("react-contact_info-correspondence_address-level");
    private final By txtUnit = By.id("react-contact_info-correspondence_address-unit");
    private final By txtPostalCode = By.id("react-contact_info-correspondence_address-postal");
    private final By chkSameContact = By.id("react-contact_info-copied");
    private final By txtOfferName = By.id("react-contact_info-offeree_name");
    private final By txtOfferJob = By.id("react-contact_info-offeree_designation");
    private final By txtOfferEmail = By.id("react-contact_info-offeree_email");
    private final By btnPrevious = By.id("back-btn");
    private final By btnSave = By.id("save-btn");
    private final By btnNext = By.id("next-btn");
    private final By lblPostalCodeErr = By.xpath("/html//p[@id='react-contact_info-correspondence_address-postal-alert']");
    private final By lblOfferNameErr = By.xpath("/html//p[@id='react-contact_info-offeree_name-alert']");
    private final By lblOfferJobErr = By.xpath("/html//p[@id='react-contact_info-offeree_designation-alert']");
    private final By lblOfferEmailErr = By.xpath("/html//p[@id='react-contact_info-offeree_email-alert']");
    private final By lblContactDetail = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2");
    private final By lblPrimaryEmailErr = By.id("react-contact_info-primary_email-alert");
    private final By lblSecondaryEmailErr = By.id("react-contact_info-secondary_email-alert");
    private final By lblNameErr = By.xpath("/html//p[@id='react-contact_info-name-alert']");
    private final By lblJobErr = By.xpath("/html//p[@id='react-contact_info-designation-alert']");
    private final By lblContactErr = By.xpath("/html//p[@id='react-contact_info-phone-alert']");
    private final By lblEmailErr = By.xpath("/html//p[@id='react-contact_info-primary_email-alert']");

    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        Log.info("Getting page title in ContactDetails page.");
        return driver.getTitle();
    }

    public void enterName(String userName) {
        WebElement element = driver.findElement(getTxtName());
        element.clear();
        element.sendKeys(userName);
    }

    public void enterJobTitle(String jobTitle) {
        WebElement element = driver.findElement(getTxtJobTitle());
        element.clear();
        element.sendKeys(jobTitle);
    }

    public void enterContactNo(String contactNo) {
        WebElement element = driver.findElement(getTxtContactNo());
        element.clear();
        element.sendKeys(contactNo);
    }

    public void enterEmail(String email) {
        WebElement element = driver.findElement(getTxtEmail());
        element.clear();
        element.sendKeys(email);
    }

    public void enterPersonalEmail(String personalEmail) {
        WebElement element = driver.findElement(getTxtPersonalEmail());
        element.clear();
        element.sendKeys(personalEmail);
    }

    public void enterBuildingNo(String buildingNo) {
        WebElement element = driver.findElement(getTxtBuildingNo());
        element.clear();
        element.sendKeys(buildingNo);
    }

    public void enterBlockNo(String blockNo) {
        WebElement element = driver.findElement(getTxtBlockNo());
        element.clear();
        element.sendKeys(blockNo);
    }

    public void enterStreet(String street) {
        WebElement element = driver.findElement(getTxtStreet());
        element.clear();
        element.sendKeys(street);
    }

    public void enterAddressLevel(String addressLevel) {
        WebElement element = driver.findElement(getTxtAddressLevel());
        element.clear();
        element.sendKeys(addressLevel);
    }

    public void enterUnit(String unit) {
        WebElement element = driver.findElement(getTxtUnit());
        element.clear();
        element.sendKeys(unit);
    }

    public void enterPostalCode(String postalCode) {
        WebElement element = driver.findElement(getTxtPostalCode());
        element.clear();
        element.sendKeys(postalCode);
    }

    public void enterOfferName(String offerName) {
        WebElement element = driver.findElement(getTxtOfferName());
        element.clear();
        element.sendKeys(offerName);
    }

    public void enterOfferJob(String offerJob) {
        WebElement element = driver.findElement(getTxtOfferJob());
        element.clear();
        element.sendKeys(offerJob);
    }

    public void enterOfferEmail(String offerEmail) {
        WebElement element = driver.findElement(getTxtOfferEmail());
        element.clear();
        element.sendKeys(offerEmail);
    }

    public void clickSameContactCheckBox() {
        driver.findElement(getChkSameContact()).click();
    }

    public void clickMailingAddressCheckBox() {
        driver.findElement(getChkMailingAddress()).click();
    }

    public boolean isSelectedAddressCheckBox() {
        return driver.findElement(getChkMailingAddress()).isSelected();
    }

    public boolean isSelectedSameContactCheckBox() {
        return driver.findElement(getChkSameContact()).isSelected();
    }


    public Boolean readonlyBuildingNo() {
        WebElement readOnly = driver.findElement(getTxtBuildingNo());
        return readOnly.getAttribute("disabled") != null;
    }

    public Boolean readonlyBlockNo() {
        WebElement readOnly = driver.findElement(getTxtBlockNo());
        //  return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }

    public Boolean readonlyStreet() {
        WebElement readOnly = driver.findElement(getTxtStreet());
        // return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }

    public Boolean readonlyAddressLevel() {
        WebElement readOnly = driver.findElement(getTxtAddressLevel());
        // return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }

    public Boolean readonlyUnit() {
        WebElement readOnly = driver.findElement(getTxtUnit());
        //    return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }

    public Boolean readonlyPostalCode() {
        WebElement readOnly = driver.findElement(getTxtPostalCode());
        //  return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }


    public Boolean readonlyOfferName() {
        WebElement readOnly = driver.findElement(getTxtOfferName());
        // return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }


    public Boolean readonlyOfferJob() {
        WebElement readOnly = driver.findElement(getTxtOfferJob());
        // return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }


    public Boolean readonlyOfferEmail() {
        WebElement readOnly = driver.findElement(getTxtOfferEmail());
        // return readOnly.getCssValue("disabled").equals("");
        return readOnly.getAttribute("disabled") != null;
    }

    public String getPostalCodeError() {
        return driver.findElement(getLblPostalCodeErr()).getText();
    }

    public String getOfferNameError() {
        return driver.findElement(getLblOfferNameErr()).getText();
    }

    public String getOfferJobError() {
        return driver.findElement(getLblOfferJobErr()).getText();
    }

    public String getOfferEmailError() {
        return driver.findElement(getLblOfferEmailErr()).getText();
    }

    public String getContactDetailTitle() {
        return driver.findElement(getLblContactDetail()).getText();
    }

    public String getPrimaryEmailFormatError() {
        return driver.findElement(getLblPrimaryEmailErr()).getText();
    }

    public String getSecondaryEmailFormatError() {
        return driver.findElement(getLblSecondaryEmailErr()).getText();
    }

    public String getNameError() {
        return driver.findElement(getLblNameErr()).getText();
    }

    public String getJobError() {
        return driver.findElement(getLblJobErr()).getText();
    }

    public String getContactError() {
        return driver.findElement(getLblContactErr()).getText();
    }

    public String getEmailError() {
        return driver.findElement(getLblEmailErr()).getText();
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public EligibilityPage clickOnBtnPrevious() {
        driver.findElement(getBtnPrevious()).click();
        Log.info("Clicked on Previous btn");
        return new EligibilityPage(driver);
    }

    public ContactDetailsPage clickOnBtnSave() {
        driver.findElement(getBtnSave()).click();
        Log.info("Clicked on Save btn");
        return this;
    }


    public ProposalPage clickOnBtnNext() {
        driver.findElement(getBtnNext()).click();
        Log.info("Clicked on Next btn");
        return new ProposalPage(driver);
    }

    public String getFormTitle() {
        Log.info("Getting page title in Eligibility page.");
        return driver.findElement(getLblTitle()).getText();
    }

    public void clearInputFieldName() {
        driver.findElement(getTxtName()).clear();
    }

    public void clearInputFieldJobTitle() {
        driver.findElement(getTxtJobTitle()).clear();
    }

    public void clearInputFieldContactNo() {
        driver.findElement(getTxtContactNo()).clear();
    }

    public void clearInputFieldEmail() {
        driver.findElement(getTxtEmail()).clear();
    }

    public void clearInputFieldPostalCode() {
        driver.findElement(getTxtPostalCode()).clear();
    }

    public void clearInputFieldOfferName() {
        driver.findElement(getTxtOfferName()).clear();
    }

    public void clearInputFieldOfferJob() {
        driver.findElement(getTxtOfferJob()).clear();
    }

    public void clearInputFieldOfferEmail() {
        driver.findElement(getTxtOfferEmail()).clear();
    }

    public void clearInputFieldBlockNo() {
        driver.findElement(getTxtBlockNo()).clear();
    }

    public void clearInputFieldStreet() {
        driver.findElement(getTxtStreet()).clear();
    }

    public void clearInputFieldLevel() {
        driver.findElement(getTxtAddressLevel()).clear();
    }

    public By getTxtName() {
        return txtName;
    }

    public By getTxtJobTitle() {
        return txtJobTitle;
    }

    public By getTxtContactNo() {
        return txtContactNo;
    }

    public By getTxtEmail() {
        return txtEmail;
    }

    public By getTxtPersonalEmail() {
        return txtPersonalEmail;
    }

    public By getChkMailingAddress() {
        return chkMailingAddress;
    }

    public By getTxtBuildingNo() {
        return txtBuildingNo;
    }

    public By getTxtBlockNo() {
        return txtBlockNo;
    }

    public By getTxtStreet() {
        return txtStreet;
    }

    public By getTxtAddressLevel() {
        return txtAddressLevel;
    }

    public By getTxtUnit() {
        return txtUnit;
    }

    public By getTxtPostalCode() {
        return txtPostalCode;
    }

    public By getChkSameContact() {
        return chkSameContact;
    }

    public By getTxtOfferName() {
        return txtOfferName;
    }

    public By getTxtOfferJob() {
        return txtOfferJob;
    }

    public By getTxtOfferEmail() {
        return txtOfferEmail;
    }

    public By getBtnPrevious() {
        return btnPrevious;
    }

    public By getBtnSave() {
        return btnSave;
    }

    public By getBtnNext() {
        return btnNext;
    }

    public By getLblPostalCodeErr() {
        return lblPostalCodeErr;
    }

    public By getLblOfferNameErr() {
        return lblOfferNameErr;
    }

    public By getLblOfferJobErr() {
        return lblOfferJobErr;
    }

    public By getLblOfferEmailErr() {
        return lblOfferEmailErr;
    }

    public By getLblContactDetail() {
        return lblContactDetail;
    }

    public By getLblPrimaryEmailErr() {
        return lblPrimaryEmailErr;
    }

    public By getLblSecondaryEmailErr() {
        return lblSecondaryEmailErr;
    }

    public By getLblNameErr() {
        return lblNameErr;
    }

    public By getLblJobErr() {
        return lblJobErr;
    }

    public By getLblContactErr() {
        return lblContactErr;
    }

    public By getLblEmailErr() {
        return lblEmailErr;
    }

    public By getLblTitle() {
        return lblTitle;
    }

    public void tapOnEnterKey(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public String fetchSaveData(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getBuildingName() {
        return driver.findElement(getTxtBuildingNo()).getText();
    }

    public String getBlockNo() {
        return driver.findElement(getTxtBlockNo()).getText();
    }

    public String getStreet() {
        return driver.findElement(getTxtStreet()).getText();
    }

    public String getLevel() {
        return driver.findElement(getTxtAddressLevel()).getText();
    }

    public String getUnit() {
        return driver.findElement(getTxtUnit()).getText();
    }

    public String getPostalCode() {
        return driver.findElement(getTxtPostalCode()).getText();
    }

    public String getOfferName() {
        return driver.findElement(getTxtAddressLevel()).getText();
    }

    public String getOfferJob() {
        return driver.findElement(getTxtUnit()).getText();
    }

    public String getOfferEmail() {
        return driver.findElement(getTxtPostalCode()).getText();
    }

    public String getName() {
        return driver.findElement(getTxtName()).getText();
    }

    public String getJob() {
        return driver.findElement(getTxtJobTitle()).getText();
    }

    public String getEmail() {
        return driver.findElement(getTxtEmail()).getText();
    }
}
