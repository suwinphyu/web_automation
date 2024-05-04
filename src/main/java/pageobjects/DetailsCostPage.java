package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.sql.rowset.WebRowSet;
import java.text.DecimalFormat;

public class DetailsCostPage {
    WebDriver driver;

    public final By lblTitle = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2");

    public final By btnPrevious = By.id("back-btn");
    public final By btnSave = By.id("save-btn");
    public final By btnNext = By.id("next-btn");

    public By getLblTitle() {
        return lblTitle;
    }

    public DetailsCostPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFormTitle() {
        Log.info("Getting page title in Eligibility page.");
        return driver.findElement(getLblTitle()).getText();
    }

    public BusinessImpactPage clickOnBtnPrevious() {
        driver.findElement(getBtnPrevious()).click();
        Log.info("Clicked on Previous btn");
        return new BusinessImpactPage(driver);
    }

    public DetailsCostPage clickOnBtnSave() {
        driver.findElement(getBtnSave()).click();
        Log.info("Clicked on Save btn");
        return this;
    }

    public DeclareAndReviewPage clickOnBtnNext() {
        driver.findElement(getBtnNext()).click();
        Log.info("Clicked on Next btn");
        return new DeclareAndReviewPage(driver);
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
}
