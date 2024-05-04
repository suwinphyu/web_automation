package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeclareAndReviewPage {

    WebDriver driver;

    public final By lblTitle = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2");
    public final By rdoLiabilityRemarksNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[1]/div/div[2]/label[1]/span[1]");
    public final By rdoLiabilityRemarksYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[1]/div/div[2]/label[2]/span[1]");
    public final By txtLiabilityRemarks = By.id("react-declaration-criminal_liability_remarks");
    public final By lblLiabilityRemarkErr = By.xpath("/html//p[@id='react-declaration-criminal_liability_remarks-alert']");
    public final By rdoCivilRemarksNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[2]/div/div[2]/label[1]/span[1]");
    public final By rdoCivilRemarksYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[2]/div/div[2]/label[2]/span[1]");
    public final By txtCivilRemarks = By.id("react-declaration-civil_proceeding_remarks");
    public final By lblCivilRemarkErr = By.xpath("/html//p[@id='react-declaration-civil_proceeding_remarks-alert']");
    public final By rdoInsolvencyRemarksNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[3]/div/div[2]/label[1]/span[1]");
    public final By rdoInsolvencyRemarksYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[3]/div/div[2]/label[2]/span[1]");
    public final By txtInsolvencyRemarks = By.id("react-declaration-insolvency_proceeding_remarks");

    public final By lblInsolvencyRemarkErr = By.xpath("/html//p[@id='react-declaration-insolvency_proceeding_remarks-alert']");
    public final By rdoIncentiveNameNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[4]/div/div[2]/label[1]/span[1]");
    public final By rdoIncentiveNameYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[4]/div/div[2]/label[2]/span[1]");
    public final By txtIncentiveName = By.id("react-declaration-project_incentives-0-name");
    //public final By incentiveStartDate= By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div[4]/div/table/tbody/tr/td[2]/div/div/div/div/span");

    public final By modelbody = By.xpath("//*[@id=\"modal-incentive-hJfpuRtwM9G8k8cFXgex8y8r\"]/div[2]");
    public final By incentiveStartDate = By.id("react-declaration-project_incentives-0-start_date");
    public final By incentiveEndDate = By.id("react-declaration-project_incentives-0-end_date");
    public final By selectEndDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div[4]/div/table/tbody/tr[1]/td[3]/div/div/div/div/div/div/div/table/tbody/tr[6]/td[3]");
    public final By selectStartDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div[4]/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div/table/tbody/tr[6]/td[1]");
    //public final By selectEndDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div[4]/div/table/tbody/tr/td[3]/div/div/div/div/span");
    public final By btnAddIncentive = By.cssSelector("#js-app > div > div > div.layoutStyles-children-wrapper-qwLqJ > div.layoutStyles-children-1VWtq > div > div > div:nth-child(1) > ol > div:nth-child(8) > div > button");
    public final By iconIncentiveDelete = By.xpath("/html//div[@id='js-app']//div[@class='layoutStyles-layout-container--AWuW']/div[@class='layoutStyles-children-wrapper-qwLqJ']/div[@class='layoutStyles-children-1VWtq']/div/div[@class='main']//ol[@class='bgp-list-group']/div[4]/div/table/tbody/tr[2]/td[4]/div/div/a[@class='delete-icon']");
    public final By rdoOtherIncentiveNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[5]/div/div[2]/label[1]/span[1]");
    public final By rdoOtherIncentiveYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[5]/div/div[2]/label[2]/span[1]");
    public final By txtOtherIncentive = By.id("react-declaration-other_incentives-0-name");
    public final By otherIncentiveStartDate = By.id("react-declaration-other_incentives-0-start_date");
    public final By otherIncentiveEndDate = By.id("react-declaration-other_incentives-0-end_date");
    public final By selectOtherIncentiveStartDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div[5]/div/table/tbody/tr/td[3]/div/div/div/div/div/div/div/table/tbody/tr[6]/td[3]");
    public final By selectOtherIncentiveEndDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div[5]/div/table/tbody/tr/td[3]/div/div/div/div/div/div/div/table/tbody/tr[5]/td[4]");
    public final By btnAddOtherIncentive = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/div/div/button");
    public final By iconDeleteOtherIncentive = By.cssSelector("#js-app > div > div > div.layoutStyles-children-wrapper-qwLqJ > div.layoutStyles-children-1VWtq > div > div > div:nth-child(1) > ol > div > div > table > tbody > tr:nth-child(1) > td:nth-child(4) > div > div > a");
    public final By modelDeleteAlert = By.id("modal-incentive-aTUkiD4z2AWWTWNzhTX4ACmj");
    public final By modelBtnDelete = By.xpath("//body/div[@role='dialog']//div[@class='bgp-modal-content']//button[@class='bgp-btn bgp-btn-modal-delete']");
    public final By modelHeader = By.xpath("//*[@id=\"modal-incentive-aTUkiD4z2AWWTWNzhTX4ACmj\"]/div[1]");
    public final By modelBtnCancel = By.xpath("//body/div[@role='dialog']//div[@class='bgp-modal-content']//button[@class='bgp-btn bgp-btn-modal-cancel']");
    public final By modalDeleteAlert = By.xpath("/html/body/div[4]/div/div");
    public final By btnCancel = By.xpath("//*[@id=\"modal-incentive-2QFpovrX9rxfLsaAsY9x6x7A\"]/div[3]/button[1]");
    public final By btnDelete = By.xpath("//*[@id=\"modal-incentive-2QFpovrX9rxfLsaAsY9x6x7A\"]/div[3]/button[2]");
    public final By rdoCommenceRemarksNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[6]/div/div[2]/label[1]/span[1]");
    public final By rdoCommenceRemarksYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[6]/div/div[2]/label[2]/span[1]");
    public final By txtCommenceRemarks = By.id("react-declaration-project_commence_remarks");
    public final By lblCommenceRemarkErr = By.xpath("/html//p[@id='react-declaration-project_commence_remarks-alert']");
    public final By rdoPartyRemarksNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[7]/div/div[2]/label[1]/span[1]");
    public final By rdoPartyRemarksYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[7]/div/div[2]/label[2]/span[1]");
    public final By txtPartyRemarks = By.id("react-declaration-related_party_remarks");
    public final By lblPartyRemarkErr = By.xpath("/html//p[@id='react-declaration-related_party_remarks-alert']");
    public final By rdoDebarmentRemarksNo = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[8]/div/div[2]/label[1]");
    public final By rdoDebarmentRemarksYes = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/ol/li[8]/div/div[2]/label[2]/span[1]");
    public final By txtDebarmentRemarks = By.id("react-declaration-debarment_remarks");
    public final By lblDebarmentRemarkErr = By.xpath("/html//p[@id='react-declaration-debarment_remarks-alert']");
    public final By chkAcknowledgement = By.id("react-declaration-consent_acknowledgement_check");
    public final By lblAcknowledgeErr = By.id("react-declaration-consent_acknowledgement_check-alert");
    public final By btnPrevious = By.id("back-btn");
    public final By btnSave = By.id("save-btn");
    public final By btnReview = By.id("review-btn");

    public By getLblAcknowledgeErr() {
        return lblAcknowledgeErr;
    }

    public By getModelDeleteAlert() {
        return modelDeleteAlert;
    }

    public By getModelBtnDelete() {
        return modelBtnDelete;
    }

    public By getModelHeader() {
        return modelHeader;
    }

    public By getModelBtnCancel() {
        return modelBtnCancel;
    }

    public void selectLiabilityRemarksNo() {
        driver.findElement(getRdoLiabilityRemarksNo()).click();
    }

    public void selectLiabilityRemarksYes() {
        driver.findElement(getRdoLiabilityRemarksYes()).click();
    }

    public void enterLiabilityRemarks(String data) {
        WebElement element = driver.findElement(getTxtLiabilityRemarks());
        element.clear();
        element.sendKeys(data);
    }

    public String getLiabilityRemarks() {
        return driver.findElement(getTxtLiabilityRemarks()).getText();
    }

    public String getCivilRemarks() {
        return driver.findElement(getTxtCivilRemarks()).getText();
    }

    public void enterCivilRemarks(String data) {
        WebElement element = driver.findElement(getTxtCivilRemarks());
        element.clear();
        element.sendKeys(data);
    }

    public void selectCivilRemarksNo() {
        driver.findElement(getRdoCivilRemarksNo()).click();
    }

    public void selectCivilRemarksYes() {
        driver.findElement(getRdoCivilRemarksYes()).click();
    }

    public void selectInsolvencyRemarksNo() {
        driver.findElement(getRdoInsolvencyRemarksNo()).click();
    }

    public void selectInsolvencyRemarksYes() {
        driver.findElement(getRdoInsolvencyRemarksYes()).click();
    }

    public String getInsolvencyRemarks() {
        return driver.findElement(getTxtInsolvencyRemarks()).getText();
    }

    public void enterInsolvencyRemarks(String data) {
        WebElement element = driver.findElement(getTxtInsolvencyRemarks());
        element.clear();
        element.sendKeys(data);
    }

    //IncentiveNameNo
    public void selectIncentiveNameNo() {
        driver.findElement(getRdoIncentiveNameNo()).click();
    }

    public void selectIncentiveNameYes() {
        driver.findElement(getRdoIncentiveNameYes()).click();
    }

    public String getIncentiveName() {
        return driver.findElement(getTxtIncentiveName()).getText();
    }

    public void enterIncentiveName(String data) {
        WebElement element = driver.findElement(getTxtIncentiveName());
        element.clear();
        element.sendKeys(data);
    }


    public String getAcknowledgeError() {
        return driver.findElement(getLblAcknowledgeErr()).getText();
    }

    public void selectStartDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getIncentiveStartDate())));
        driver.findElement(getIncentiveStartDate()).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectStartDate())));
        driver.findElement(getSelectStartDate()).click();
    }

    public void selectEndDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getIncentiveEndDate())));
        driver.findElement(getIncentiveEndDate()).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectEndDate())));
        driver.findElement(getSelectEndDate()).click();
    }

    public void sendKeyForStartDate(String date) {
        driver.findElement(getIncentiveStartDate()).sendKeys(date);
    }

    public void sendKeyForEndDate(String date) {
        driver.findElement(getIncentiveEndDate()).sendKeys(date);
    }

    public void deleteIncentive() {
        driver.findElement(getIconIncentiveDelete()).click();
    }

    public void addIncentive() {
        driver.findElement(getBtnAddIncentive()).click();
    }


    //rdoOtherIncentiveNo
    public void selectOtherIncentiveNo() {
        driver.findElement(getRdoOtherIncentiveNo()).click();
    }

    public void selectOtherIncentiveYes() {
        driver.findElement(getRdoOtherIncentiveYes()).click();
    }

    public String getOtherIncentive() {
        return driver.findElement(getTxtOtherIncentive()).getText();
    }

    public void enterOtherIncentive(String data) {
        WebElement element = driver.findElement(getTxtOtherIncentive());
        element.clear();
        element.sendKeys(data);
    }

    public void selectOtherIncentiveStartDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getOtherIncentiveStartDate())));
        driver.findElement(getOtherIncentiveStartDate()).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectOtherIncentiveStartDate())));
        driver.findElement(getSelectOtherIncentiveStartDate()).click();
    }

    public void selectOtherIncentiveEndDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getOtherIncentiveEndDate())));
        driver.findElement(getOtherIncentiveEndDate()).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectOtherIncentiveEndDate())));
        driver.findElement(getSelectOtherIncentiveEndDate()).click();
    }

    public void clickIncentiveDeleteIcon() {
        driver.findElement(getIconIncentiveDelete()).click();
    }

    public void deleteOtherIncentive() {
        driver.findElement(getIconDeleteOtherIncentive()).click();
    }

    public void addOtherIncentive() {
        driver.findElement(getBtnAddOtherIncentive()).click();
    }

    //rdoCommenceRemarksNo
    public void selectCommenceRemarksNo() {
        driver.findElement(getRdoCommenceRemarksNo()).click();
    }

    public void selectCommenceRemarksYes() {
        driver.findElement(getRdoCommenceRemarksYes()).click();
    }

    public String getCommenceRemarks() {
        return driver.findElement(getTxtCommenceRemarks()).getText();
    }

    public void enterCommenceRemarks(String data) {
        WebElement element = driver.findElement(getTxtCommenceRemarks());
        element.clear();
        element.sendKeys(data);
    }

    //rdoPartyRemarksNo
    public void selectPartyRemarksNo() {
        driver.findElement(getRdoPartyRemarksNo()).click();
    }

    public void selectPartyRemarksYes() {
        driver.findElement(getRdoPartyRemarksYes()).click();
    }

    public String getPartyRemarks() {
        return driver.findElement(getTxtPartyRemarks()).getText();
    }

    public void enterPartyRemarks(String data) {
        WebElement element = driver.findElement(getTxtPartyRemarks());
        element.clear();
        element.sendKeys(data);
    }

    //rdoDebarmentRemarksNo
    public void selectDebarmentRemarksNo() {
        driver.findElement(getRdoDebarmentRemarksNo()).click();
    }

    public void selectDebarmentRemarksYes() {
        driver.findElement(getRdoDebarmentRemarksYes()).click();
    }

    public String getDebarmentRemarks() {
        return driver.findElement(getTxtDebarmentRemarks()).getText();
    }

    public void enterDebarmentRemarks(String data) {
        WebElement element = driver.findElement(getTxtDebarmentRemarks());
        element.clear();
        element.sendKeys(data);
    }

    public void clickAcknowledgementCheckbox() {
        driver.findElement(getChkAcknowledgement()).click();
    }

    public String getFormTitle() {
        Log.info("Getting page title in Eligibility page.");
        return driver.findElement(getLblTitle()).getText();
    }

    public DeclareAndReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLblTitle() {
        return lblTitle;
    }

    public By getBtnPrevious() {
        return btnPrevious;
    }

    public By getBtnSave() {
        return btnSave;
    }

    public By getRdoLiabilityRemarksNo() {
        return rdoLiabilityRemarksNo;
    }

    public By getRdoLiabilityRemarksYes() {
        return rdoLiabilityRemarksYes;
    }

    public By getTxtLiabilityRemarks() {
        return txtLiabilityRemarks;
    }

    public By getRdoCivilRemarksNo() {
        return rdoCivilRemarksNo;
    }

    public By getRdoCivilRemarksYes() {
        return rdoCivilRemarksYes;
    }

    public By getTxtCivilRemarks() {
        return txtCivilRemarks;
    }

    public By getRdoInsolvencyRemarksNo() {
        return rdoInsolvencyRemarksNo;
    }

    public By getRdoInsolvencyRemarksYes() {
        return rdoInsolvencyRemarksYes;
    }

    public By getTxtInsolvencyRemarks() {
        return txtInsolvencyRemarks;
    }

    public By getRdoIncentiveNameNo() {
        return rdoIncentiveNameNo;
    }

    public By getRdoIncentiveNameYes() {
        return rdoIncentiveNameYes;
    }

    public By getTxtIncentiveName() {
        return txtIncentiveName;
    }

    public By getIncentiveStartDate() {
        return incentiveStartDate;
    }

    public By getIncentiveEndDate() {
        return incentiveEndDate;
    }

    public By getSelectStartDate() {
        return selectStartDate;
    }

    public String readIncentiveStartDate() {
        return driver.findElement(getIncentiveStartDate()).getAttribute("value");
    }

    public String readIncentiveEndDate() {
        return driver.findElement(getIncentiveEndDate()).getAttribute("value");
    }


    public void clearIncentiveStartDate() {
        driver.findElement(getIncentiveStartDate()).clear();
    }

    public void clearIncentiveEndDate() {
        driver.findElement(getIncentiveEndDate()).clear();
    }

    public By getSelectEndDate() {
        return selectEndDate;
    }

    public By getBtnAddIncentive() {
        return btnAddIncentive;
    }

    public By getIconIncentiveDelete() {
        return iconIncentiveDelete;
    }

    public By getRdoOtherIncentiveNo() {
        return rdoOtherIncentiveNo;
    }

    public By getRdoOtherIncentiveYes() {
        return rdoOtherIncentiveYes;
    }

    public By getTxtOtherIncentive() {
        return txtOtherIncentive;
    }

    public By getOtherIncentiveStartDate() {
        return otherIncentiveStartDate;
    }

    public By getOtherIncentiveEndDate() {
        return otherIncentiveEndDate;
    }

    public By getSelectOtherIncentiveStartDate() {
        return selectOtherIncentiveStartDate;
    }

    public By getSelectOtherIncentiveEndDate() {
        return selectOtherIncentiveEndDate;
    }

    public By getBtnAddOtherIncentive() {
        return btnAddOtherIncentive;
    }

    public By getIconDeleteOtherIncentive() {
        return iconDeleteOtherIncentive;
    }

    public By getModalDeleteAlert() {
        return modalDeleteAlert;
    }


    public By getModelbody() {
        return modelbody;
    }

    public By getBtnCancel() {
        return btnCancel;
    }

    public By getBtnDelete() {
        return btnDelete;
    }

    public By getRdoCommenceRemarksNo() {
        return rdoCommenceRemarksNo;
    }

    public By getRdoCommenceRemarksYes() {
        return rdoCommenceRemarksYes;
    }

    public By getTxtCommenceRemarks() {
        return txtCommenceRemarks;
    }

    public By getRdoPartyRemarksNo() {
        return rdoPartyRemarksNo;
    }

    public By getRdoPartyRemarksYes() {
        return rdoPartyRemarksYes;
    }

    public By getTxtPartyRemarks() {
        return txtPartyRemarks;
    }

    public By getRdoDebarmentRemarksNo() {
        return rdoDebarmentRemarksNo;
    }

    public By getRdoDebarmentRemarksYes() {
        return rdoDebarmentRemarksYes;
    }

    public By getTxtDebarmentRemarks() {
        return txtDebarmentRemarks;
    }

    public By getChkAcknowledgement() {
        return chkAcknowledgement;
    }

    public By getBtnReview() {
        return btnReview;
    }

    public DetailsCostPage clickOnBtnPrevious() {
        driver.findElement(getBtnPrevious()).click();
        Log.info("Clicked on Previous btn");
        return new DetailsCostPage(driver);
    }

    public DeclareAndReviewPage clickOnBtnSave() {
        driver.findElement(getBtnSave()).click();
        Log.info("Clicked on Save btn");
        return this;
    }

    public EligibilityPage clickOnBtnReview() {
        driver.findElement(getBtnReview()).click();
        Log.info("Clicked on Next btn");
        return new EligibilityPage(driver);
    }

    public Boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public String fetchSaveData(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }


    public By getLblLiabilityRemarkErr() {
        return lblLiabilityRemarkErr;
    }

    public String getLiabilityRemarkErr() {
        return driver.findElement(getLblLiabilityRemarkErr()).getText();
    }

    public By getLblCivilRemarkErr() {
        return lblCivilRemarkErr;
    }

    public String getCivilRemarkErr() {
        return driver.findElement(getLblCivilRemarkErr()).getText();
    }

    public By getLblInsolvencyRemarkErr() {
        return lblInsolvencyRemarkErr;
    }

    public String getInsolvencyRemarkErr() {
        return driver.findElement(getLblInsolvencyRemarkErr()).getText();
    }

    public By getLblCommenceRemarkErr() {
        return lblCommenceRemarkErr;
    }

    public String getCommenceRemarkErr() {
        return driver.findElement(getLblCommenceRemarkErr()).getText();
    }

    public By getLblPartyRemarkErr() {
        return lblPartyRemarkErr;
    }

    public String getPartyRemarkErr() {
        return driver.findElement(getLblPartyRemarkErr()).getText();
    }

    public By getLblDebarmentRemarkErr() {
        return lblDebarmentRemarkErr;
    }

    public String getDebarmentRemarkErr() {
        return driver.findElement(getLblDebarmentRemarkErr()).getText();
    }
}
