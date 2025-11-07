package projectSpecifications;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import pageObjectsAndroid.PG_002_SignInPage;
import utils.ExcelReader;
import utils.ExtentReportManager;
import utils.MobileActions;
import utils.TestContext;

public class BaseClass {

    // ======================================================
    // LOGGING & CONFIG
    // ======================================================
    public static Logger logger = Logger.getLogger(BaseClass.class);
    public static String logfile = Paths.get("src", "test", "java", "utils", "Log4j.properties")
            .toAbsolutePath().toString();

    public static String excelfilename = Paths.get("TestData", "CHAutomationTestCase.xlsx")
            .toAbsolutePath().toString();
    public static String configFilePath = Paths.get("Properties", "Config.properties")
            .toAbsolutePath().toString();

    public static Properties properties;
    public static FileInputStream file;

    protected static ExtentReports extent;

    public static MobileActions mobileActions;  // Global Access

    public static WebDriverWait wait;

    // ======================================================
    // SUITE SETUP
    // ======================================================
    @BeforeSuite(alwaysRun = true)
    @Parameters({"reportname"})
    public void startReports(String reportName) throws IOException {

    	if (reportName == null || reportName.trim().isEmpty()) {
            reportName = "Default_MobileTestReport";  // fallback if not provided
        }

        // Configure Log4j
        PropertyConfigurator.configure(logfile);
        logger.info("Log4j configured from: " + logfile);

        // Load Config.properties
        properties = new Properties();
        file = new FileInputStream(configFilePath);
        properties.load(file);
        logger.info("Config.properties loaded from: " + configFilePath);

        // Initialize ExtentReports
        extent = ExtentReportManager.startReports(reportName);
        logger.info("ExtentReports initialized successfully");

    }

    // ======================================================
    // TEST SETUP - Initialize Driver
    // ======================================================
    @BeforeMethod(alwaysRun = true)
    @Parameters({"platformName"})
    public void setUp(String platformName) throws MalformedURLException {
        AppiumDriver driver = initializeDriver(platformName);

        // Set in TestContext (ThreadLocal)
        TestContext.setDriver(driver);
        TestContext.setJsExecutor((JavascriptExecutor) driver);

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Explicit Window
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Initialize Login Page
        TestContext.setSignInPage(new PG_002_SignInPage(driver));

        logger.info("Appium session started on: " + platformName);
        ExtentReportManager.info("Application Launched Successfully !");

        mobileActions = new MobileActions(driver);

    }

    // ======================================================
    // DRIVER INITIALIZATION (Android + iOS)
    // ======================================================
    private AppiumDriver initializeDriver(String platformName) throws MalformedURLException {
        URL serverURL = new URL(properties.getProperty("appiumServerURL", "http://127.0.0.1:4723"));

        if (platformName.equalsIgnoreCase("android")) {
            logger.info("Initializing AndroidDriver...");

            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(properties.getProperty("android.deviceName"))
                    .setPlatformVersion(properties.getProperty("android.platformVersion"))
                    .setAutomationName("UiAutomator2")
                    .setNoReset(Boolean.parseBoolean(properties.getProperty("android.noReset", "true")));

            options.setCapability("ignoreHiddenApiPolicyError", true);
            options.setCapability("adbExecTimeout", 60000);

            ExtentReportManager.info("Application Launched Successfully ");


            boolean useInstalledApp = Boolean.parseBoolean(properties.getProperty("android.useInstalledApp", "false"));
            if (useInstalledApp) {
                options.setAppPackage(properties.getProperty("android.appPackage"));
                options.setAppActivity(properties.getProperty("android.appActivity"));
            } else {
                String appPath = Paths.get(properties.getProperty("android.appPath")).toAbsolutePath().toString();
                options.setApp(appPath);
            }

            return new AndroidDriver(serverURL, options);


        } else if (platformName.equalsIgnoreCase("ios")) {
            logger.info("Initializing IOSDriver...");

            XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName(properties.getProperty("ios.deviceName"))
                    .setPlatformVersion(properties.getProperty("ios.platformVersion"))
                    .setAutomationName("XCUITest")
                    .setNoReset(Boolean.parseBoolean(properties.getProperty("ios.noReset", "true")));

            boolean useInstalledApp = Boolean.parseBoolean(properties.getProperty("ios.useInstalledApp", "false"));
            if (useInstalledApp) {
                options.setBundleId(properties.getProperty("ios.bundleId"));
            } else {
                String appPath = Paths.get(properties.getProperty("ios.appPath")).toAbsolutePath().toString();
                options.setApp(appPath);
            }

            return new IOSDriver(serverURL, options);

        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platformName + ". Use 'android' or 'ios'.");
        }
    }

    // ======================================================
    // REPORT STEP
    // ======================================================
    public void reportStep(String message, String status) {
        if (ExtentReportManager.getTest() == null) {
            logger.warn("ExtentTest not initialized. Logging only: " + message);
            return;
        }
        ExtentReportManager.reportStep(message, status);
    }

    // ======================================================
    // DATA PROVIDER
    // ======================================================
    @DataProvider(name = "sendData", parallel = false, indices = {0})
    public String[][] fetchData() throws IOException {
        String sheetName = TestContext.getSheetName();
        if (sheetName == null || sheetName.isEmpty()) {
            throw new IllegalStateException("Sheet name is not set in TestContext.");
        }
        logger.info("Reading data from Excel: " + excelfilename + " | Sheet: " + sheetName);
        return ExcelReader.readexcelData(excelfilename, sheetName);
    }

    // ======================================================
    // TEST TEARDOWN
    // ======================================================
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            WebDriver driver = TestContext.getDriver();
            if (driver != null) {
            	((InteractsWithApps) driver).terminateApp("com.houseofepigenetics.abchopra");
//                driver.quit();
            	((AndroidDriver) driver).executeScript("mobile: shell",
                        Map.of("command", "am", "args", List.of("force-stop", "com.houseofepigenetics.abchopra"))
                    );
                logger.info("Appium driver quit successfully.");
            }
        } catch (Exception e) {
            logger.error("Error quitting driver: ", e);
        } finally {
            // Clean ThreadLocal
           // TestContext.clear();
            //ExtentReportManager.removeTest();

            reportStep("Mobile App Session Ended", "pass");
            logger.info("Mobile App Closed");
            logger.info("=============================================================");
        }
    }

    // ======================================================
    // SUITE TEARDOWN
    // ======================================================
    @AfterSuite(alwaysRun = true)
    public void stopReports() {
        ExtentReportManager.stopReports();
        logger.info("ExtentReports flushed.");
        try {
            if (file != null) file.close();
            ExtentReportManager.openExtentReport();
        }

        catch (IOException e) {
            logger.error("Error closing config file: ", e);
        }

    }
}