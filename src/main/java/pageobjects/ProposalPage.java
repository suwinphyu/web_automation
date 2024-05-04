package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProposalPage {

    WebDriver driver;

    public final By txtProjectTitle = By.id("react-project-title");
    public final By txtProjectDesc = By.id("react-project-description");
    public final By txtTargetMarket = By.xpath("/html//div[@id='js-app']//div[@class='layoutStyles-layout-container--AWuW']/div[@class='layoutStyles-children-wrapper-qwLqJ']/div[@class='layoutStyles-children-1VWtq']/div//div[@class='bgp-dropdown-wrapper']/span//span[@role='combobox']/ul[@class='select2-selection__rendered']//input[@role='textbox']");
    public final By txtRemark = By.id("react-project-remarks");
    public final By btnPrevious = By.id("back-btn");
    public final By btnSave = By.id("save-btn");
    public final By btnNext = By.id("next-btn");
    public final By linkHere = By.linkText("here");
    public final By dropdownActivity = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[9]/div/div/div[2]/div/div/span[3]");
    public final By dropdownMarket = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[11]/div/div[2]/div/div/span[3]/span");
    public final By dragDropDocument = By.xpath("/html//div[@id='js-app']//div[@class='layoutStyles-layout-container--AWuW']/div[@class='layoutStyles-children-wrapper-qwLqJ']/div[@class='layoutStyles-children-1VWtq']/div//div[@class='bgp-attachment-dropzone']/div");
    public final By startDatePicker = By.id("react-project-start_date");
    public final By endDatePicker = By.id("react-project-end_date");
    public final By selectStartDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[5]/div/div[2]/div/div/div/div/div/table/tbody/tr[6]/td[1]");
    public final By selectEndDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[6]/div/div[2]/div/div/div/div/div/table/tbody/tr[6]/td[2]");
    public final By lblTitle = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2");

    public final By selectDropdownOption = By.id("react-select-project-activity--value-item");

    public ProposalPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getSelectDropdownOption() {
        return selectDropdownOption;
    }

    public By getTxtProjectTitle() {
        return txtProjectTitle;
    }

    public By getTxtProjectDesc() {
        return txtProjectDesc;
    }

    public By getTxtTargetMarket() {
        return txtTargetMarket;
    }

    public By getTxtRemark() {
        return txtRemark;
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

    public By getLinkHere() {
        return linkHere;
    }

    public By getDropdownActivity() {
        return dropdownActivity;
    }

    public By getDropdownMarket() {
        return dropdownMarket;
    }

    public By getDragDropDocument() {
        return dragDropDocument;
    }


    public By getStartDatePicker() {
        return startDatePicker;
    }

    public By getEndDatePicker() {
        return endDatePicker;
    }

    public By getSelectStartDate() {
        return selectStartDate;
    }

    public By getSelectEndDate() {
        return selectEndDate;
    }

    public By getLblTitle() {
        return lblTitle;
    }

    public String getPageTitle() {
        Log.info("Getting page title in ContactDetails page.");
        return driver.getTitle();
    }

    public void enterProjectTitle(String data) {
        WebElement element = driver.findElement(getTxtProjectTitle());
        element.clear();
        element.sendKeys(data);
    }

    public void enterProjectDesc(String data) {
        WebElement element = driver.findElement(getTxtProjectDesc());
        element.clear();
        element.sendKeys(data);
    }

    public void enterTargetMarket(String data) {
        WebElement element = driver.findElement(getTxtTargetMarket());
        element.clear();
        element.sendKeys(data);
    }

    public void enterRemark(String data) {
        WebElement element = driver.findElement(getTxtRemark());
        element.clear();
        element.sendKeys(data);
    }

    public void clickHere(String data) {
        driver.findElement(getLinkHere()).click();
    }

    public ContactDetailsPage clickOnBtnPrevious() {
        driver.findElement(getBtnPrevious()).click();
        Log.info("Clicked on Previous btn");
        return new ContactDetailsPage(driver);
    }

    public ProposalPage clickOnBtnSave() {
        driver.findElement(getBtnSave()).click();
        Log.info("Clicked on Save btn");
        return this;
    }

    public BusinessImpactPage clickOnBtnNext() {
        driver.findElement(getBtnNext()).click();
        Log.info("Clicked on Next btn");
        return new BusinessImpactPage(driver);
    }

    public Select selectMarketDropdown() {
        return new Select(driver.findElement(getDropdownMarket()));
    }

    public Select selectActivityDropdown() {
        return new Select(driver.findElement(getDropdownActivity()));
    }

    public void clickActivityDropdown() {
        driver.findElement(getDropdownActivity()).click();
    }

    public void selectActivityDropdownOption() {
        driver.findElement(getSelectDropdownOption()).click();
    }

    public void selectStartDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getStartDatePicker())));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");
        driver.findElement(getStartDatePicker()).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectStartDate())));
        driver.findElement(getSelectStartDate()).click();
    }

    public void selectEndDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getEndDatePicker())));
        driver.findElement(getEndDatePicker()).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectEndDate())));
        driver.findElement(getSelectEndDate()).click();
    }

    public String getFormTitle() {
        Log.info("Getting page title in Proposal page.");
        return driver.findElement(getLblTitle()).getText();
    }

    public String fetchSaveData(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }


}
