package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.PathConfig;
import logsetup.Log;
import utilities.PropertyFileReader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public final class ExtentReport {
    enum ConfigParameters {
        THEME,
        REPORT_NAME,
        DOCUMENT_TITLE,
        TIMESTAMP_FORMAT
    }

    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public static String extentReportPrefix;
    public ExtentReport() {
    }

    public synchronized static ExtentReports initReport() {
        Properties extentReportConfig = PropertyFileReader.readFile(PathConfig.EXTENTREPORT_CONFIG);
        String theme = extentReportConfig.get(ConfigParameters.THEME.name()).toString();
        String reportName = extentReportConfig.get(ConfigParameters.REPORT_NAME.name()).toString();
        String documentTitle = extentReportConfig.get(ConfigParameters.DOCUMENT_TITLE.name()).toString();
        String timeStampFormat = extentReportConfig.get(ConfigParameters.TIMESTAMP_FORMAT.name()).toString();

        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
                    new File(PathConfig.EXTENTREPORT_HTML+extentReportsPrefix_Name("testresult") + ".html"));
            extentReports.attachReporter(extentSparkReporter);

            //report configuration
            switch (theme.toLowerCase()) {
                case "standard":
                    extentSparkReporter.config().setTheme(Theme.STANDARD);
                    break;
                case "dark":
                    extentSparkReporter.config().setTheme(Theme.DARK);
                    break;
                default:
                    Log.info("Invalid theme " + theme + " configured in " + PathConfig.EXTENTREPORT_CONFIG + " file. Please enter 'standard' or 'dark' for 'Theme'.");
                    break;
            }

            extentSparkReporter.config().setReportName(reportName);
            extentSparkReporter.config().setDocumentTitle(documentTitle);
            extentSparkReporter.config().setTimeStampFormat(timeStampFormat);

            // setting test and system info from test/resources/Config.properties file
            extentReports.setSystemInfo("Application URL", PropertyFileReader.readFile(PathConfig.CONFIG).get("url").toString());
            extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
            extentReports.setSystemInfo("User name ", System.getProperty("user.name"));
            extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
            extentReports.setSystemInfo("Applicant", "Su Win Phyu");
        }

        return extentReports;
    }

    public static void flushReport() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
    }

    public synchronized static ExtentTest createTest(String name, String description) {
        ExtentTest test = extentReports.createTest(name, description);
        extentTest.set(test);
        return getTest();
    }

    public synchronized static ExtentTest getTest() {
        return extentTest.get();
    }

    public synchronized static void attachImage(String path) {
        getTest().addScreenCaptureFromPath(path);
    }

    public static String extentReportsPrefix_Name (String testName) {
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        extentReportPrefix = testName + "_" + date;
        return extentReportPrefix;
    }

    public synchronized static void pass(String message) {
        getTest().pass(message);
    }

}
