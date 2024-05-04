package pageobjects;

import logsetup.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EligibilityPage {

    WebDriver driver;

    private final By rdoSgRegisterOptionYes = By.id("react-eligibility-sg_registered_check-true");

    private final By rdoSgRegisterOptionNo = By.id("react-eligibility-sg_registered_check-false");

    private final By rdoTurnoverOptionYes = By.id("react-eligibility-turnover_check-true");

    private final By rdoTurnoverOptionNo = By.id("react-eligibility-turnover_check-false");

    //   private final By rdoTurnoverOptionNo = By.cssSelector("#js-app > div > div > div.layoutStyles-children-wrapper-qwLqJ > div.layoutStyles-children-1VWtq > div > div > div:nth-child(1) > div:nth-child(6) > div > div.controls.bgp-radio-text-format > label:nth-child(2) > span.radiobutton");

    private final By rdoLocalEquityOptionYes = By.id("react-eligibility-global_hq_check-true");

    private final By rdoLocalEquityOptionNo = By.id("react-eligibility-global_hq_check-false");

    private final By rdoStartedProjectOptionYes = By.id("react-eligibility-started_project_check-true");

    private final By rdoStartedProjectOptionNo = By.id("react-eligibility-started_project_check-false");

    private final By lblSgRegisterError = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[5]/div/span");

    private final By lblTurnoverError = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[7]/div/span");

    private final By lblLocalEquityError = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[9]/div/span");

    private final By lblStartedProjectError = By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[11]/div/span");
    private final By btnSave = By.id("save-btn");
    private final By btnNext = By.id("next-btn");
    private final By linkFQA = By.linkText("FAQ");
    private final By lblTitle = By.xpath("/html//div[@id='js-app']//div[@class='layoutStyles-layout-container--AWuW']/div[@class='layoutStyles-children-wrapper-qwLqJ']/div[@class='layoutStyles-children-1VWtq']/div//h2[.='Check Your Eligibility']");

    public EligibilityPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getRdoSgRegisterOptionYes() {
        return rdoSgRegisterOptionYes;
    }

    public By getRdoSgRegisterOptionNo() {
        return rdoSgRegisterOptionNo;
    }

    public By getRdoTurnoverOptionYes() {
        return rdoTurnoverOptionYes;
    }

    public By getRdoTurnoverOptionNo() {
        return rdoTurnoverOptionNo;
    }

    public By getRdoLocalEquityOptionYes() {
        return rdoLocalEquityOptionYes;
    }

    public By getRdoLocalEquityOptionNo() {
        return rdoLocalEquityOptionNo;
    }

    public By getRdoStartedProjectOptionYes() {
        return rdoStartedProjectOptionYes;
    }

    public By getRdoStartedProjectOptionNo() {
        return rdoStartedProjectOptionNo;
    }

    public By getLblSgRegisterError() {
        return lblSgRegisterError;
    }

    public By getLblTurnoverError() {
        return lblTurnoverError;
    }

    public By getLblLocalEquityError() {
        return lblLocalEquityError;
    }

    public By getLblStartedProjectError() {
        return lblStartedProjectError;
    }

    public By getBtnSave() {
        return btnSave;
    }

    public By getBtnNext() {
        return btnNext;
    }

    public By getLinkFQA() {
        return linkFQA;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Eligibility page.");
        return driver.getTitle();
    }

    public By getLblTitle() {
        return lblTitle;
    }


    public String getFormTitle() {
        Log.info("Getting page title in Eligibility page.");
        return driver.findElement(getLblTitle()).getText();
    }

    public void selectSgRegisterOptionYes() {
        driver.findElement(rdoSgRegisterOptionYes).click();
    }

    public void selectSgRegisterOptionNo() {
        driver.findElement(rdoSgRegisterOptionNo).click();
    }

    public void selectTurnoverOptionYes() {
        driver.findElement(rdoTurnoverOptionYes).click();
    }

    public void selectTurnoverOptionNo() {
//        Duration duration = Duration.ofSeconds(60);
//        WebDriverWait wait = new WebDriverWait(driver, duration);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(rdoTurnoverOptionNo));
        driver.findElement(rdoTurnoverOptionNo).click();
    }

    public WebElement getTurnoverOptionNo() {
        return driver.findElement(rdoTurnoverOptionNo);
    }

    public void selectStartedProjectOptionYes() {
        driver.findElement(rdoStartedProjectOptionYes).click();
    }

    public void selectStartedProjectOptionNo() {
        driver.findElement(rdoStartedProjectOptionNo).click();
    }

    public void selectLocalEquityOptionYes() {
        driver.findElement(rdoLocalEquityOptionYes).click();
    }

    public void selectLocalEquityOptionNo() {
        driver.findElement(rdoLocalEquityOptionNo).click();
    }

    public String getSgRegisterError() {
        return driver.findElement(lblSgRegisterError).getText();
    }

    public String getTurnoverError() {
        return driver.findElement(lblTurnoverError).getText();
    }

    public String getLocalEquityError() {
        return driver.findElement(lblLocalEquityError).getText();
    }

    public String getStartedProjectError() {
        return driver.findElement(lblStartedProjectError).getText();
    }

    public EligibilityPage clickOnBtnSave() {
        driver.findElement(getBtnSave()).click();
        Log.info("Clicked on Save btn");
        return this;
    }

    public Boolean isSelectedSgRegisterYes() {
        return driver.findElement(getRdoSgRegisterOptionYes()).isSelected();
    }

//    public Boolean isSelectedSgRegisterNo() {
//        return driver.findElement(getRdoSgRegisterOptionNo()).isSelected();
//    }

    public Boolean isSelectedTurnoverYes() {
        return driver.findElement(getRdoTurnoverOptionYes()).isSelected();
    }

    public Boolean isSelectedLocalEquityYes() {
        return driver.findElement(getRdoLocalEquityOptionYes()).isSelected();
    }

    public Boolean isSelectedStartedProjectYes() {
        return driver.findElement(getRdoStartedProjectOptionYes()).isSelected();
    }

//    public Boolean isSelectedTurnoverNo() {
//        return driver.findElement(getRdoTurnoverOptionNo()).isSelected();
//    }
//
//    public Boolean isSelectedLocalEquityNo() {
//        return driver.findElement(getRdoLocalEquityOptionNo()).isSelected();
//    }
//
//    public Boolean isSelectedStartedProjectNo() {
//        return driver.findElement(getRdoStartedProjectOptionNo()).isSelected();
//    }

    public void clickFQAlink() {
        driver.findElement(linkFQA).click();
    }

    public ContactDetailsPage clickOnBtnNext() {
        driver.findElement(getBtnNext()).click();
        Log.info("Clicked on Next btn");
        return new ContactDetailsPage(driver);
    }
}
