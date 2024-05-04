package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import constants.PathConfig;
import logsetup.Log;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;
import reports.ExtentReport;
import utilities.ScreenshotUtility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener, ISuiteListener {
    ExtentReports extentReports;
    ExtentTest test;
    public static String screenShotDestinationPath;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    ExtentReports extentManager;
    @Override
    public  void onStart(ISuite iSuite) {
        extentReports = ExtentReport.initReport();
      Log.info(iSuite.getName() + " - test suite execution started.");
    }

    @Override
    public  void onFinish(ISuite iSuite) {
        extentReports.flush();
        Log.info(iSuite.getName() + " - test suite execution ended.");
    }

    @Override
    public  void onTestStart(ITestResult iTestResult) {
        String testDesc=iTestResult.getMethod().getDescription();
        test = ExtentReport.createTest(testDesc,testDesc);
    }

    @Override
    public  void onTestSuccess(ITestResult iTestResult) {
        String testDescription = iTestResult.getMethod().getDescription();
        ExtentReport.getTest().pass(testDescription);
        Log.info(testDescription + " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testDescription = iTestResult.getMethod().getDescription();
        ExtentReport.getTest().fail(iTestResult.getThrowable());
        try{
            String folderPath = PathConfig.SCREENSHOT_FOLDER + timestamp() +".png";
            screenShotDestinationPath = folderPath;
            FileHandler.copy(ScreenshotUtility.getScreenshot(),new File(folderPath));
            ExtentReport.attachImage(screenShotDestinationPath);
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.error(iTestResult.getName() + " - FAILED." , iTestResult.getThrowable());


    }
    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String testName = iTestResult.getTestName();
        Log.error(iTestResult.getName() + " - SKIPPED." , iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public  void onFinish(ITestContext iTestContext) {
    }
}
