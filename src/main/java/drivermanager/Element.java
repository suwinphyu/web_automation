package drivermanager;

import org.openqa.selenium.By;

public interface Element {
    By getBy();

    String getText();

    Boolean isEnabled();

    Boolean isDisplayed();

    void typeText(String text);

    void click();

    String getAttribute(String attributeName);
}
