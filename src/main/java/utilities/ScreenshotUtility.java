package utilities;

import drivermanager.DriverManager;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

import java.io.File;

public final class ScreenshotUtility {
    public static File getScreenshot(){
        return DriverManager.getDriver().takeScreenshot();
    }
}
