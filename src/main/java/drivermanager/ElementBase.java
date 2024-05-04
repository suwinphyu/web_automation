package drivermanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementBase implements Element{

    private final WebElement webElement;
    private final By by;

    public ElementBase(WebElement webElement, By by) {
        this.webElement = webElement;
        this.by = by;
    }

    @Override
    public By getBy() {
        return by;
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public Boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public void typeText(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Override
    public void click() {
        webElement.click();

    }

    @Override
    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }
}
