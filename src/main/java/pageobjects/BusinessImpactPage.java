package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.CompletionService;

public class BusinessImpactPage {

    WebDriver driver;

    public final By fyEndDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/table/tbody/tr[1]/td[2]/div/div/div/div/span");
    public final By selectEndDate = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/table/tbody/tr[1]/td[2]/div/div/div/div/div/div/div/table/tbody/tr[5]/td[7]");
    public final By txtOverseaSale = By.id("react-project_impact-overseas_sales_0");
    public final By txtInvestment = By.id("react-project_impact-overseas_investments_0");
    public final By txtProjection = By.id("react-project_impact-rationale_remarks");
    public final By txtBenefit = By.id("react-project_impact-benefits_remarks");

    public final By lblTitle = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2");
    public final By btnPrevious = By.id("back-btn");

    public final By btnSave = By.id("save-btn");

    public final By btnNext = By.id("next-btn");

    public BusinessImpactPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getFyEndDate() {
        return fyEndDate;
    }

    public By getSelectEndDate() {
        return selectEndDate;
    }

    public By getTxtOverseaSale() {
        return txtOverseaSale;
    }

    public By getTxtInvestment() {
        return txtInvestment;
    }

    public By getTxtProjection() {
        return txtProjection;
    }

    public By getTxtBenefit() {
        return txtBenefit;
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

    public By getBtnNext() {
        return btnNext;
    }

    public ProposalPage clickOnBtnPrevious() {
        driver.findElement(getBtnPrevious()).click();
        Log.info("Clicked on Previous btn");
        return new ProposalPage(driver);
    }

    public BusinessImpactPage clickOnBtnSave() {
        driver.findElement(getBtnSave()).click();
        Log.info("Clicked on Save btn");
        return this;
    }

    public DetailsCostPage clickOnBtnNext() {
        driver.findElement(getBtnNext()).click();
        Log.info("Clicked on Next btn");
        return new DetailsCostPage(driver);
    }

    public void enterOverseaSale(String data) {
        WebElement element = driver.findElement(getTxtOverseaSale());
        element.clear();
        element.sendKeys(data);
    }

    public void enterBenefit(String data) {
        WebElement element = driver.findElement(getTxtBenefit());
        element.clear();
        element.sendKeys(data);
    }

    public void enterInvestment(String data) {
        WebElement element = driver.findElement(getTxtInvestment());
        element.clear();
        element.sendKeys(data);
    }

    public void enterProjection(String data) {
        WebElement element = driver.findElement(getTxtProjection());
        element.clear();
        element.sendKeys(data);
    }

    public void selectFYEndDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getFyEndDate())));
        driver.findElement(getFyEndDate()).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getSelectEndDate())));
        driver.findElement(getSelectEndDate()).click();
    }

    public String getFormTitle() {
        Log.info("Getting page title in Eligibility page.");
        return driver.findElement(getLblTitle()).getText();
    }

    public String fetchSaveData(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }
}
