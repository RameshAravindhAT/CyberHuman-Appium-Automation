package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import projectSpecifications.BaseClass;

public class ExtentReportManager{

    private static final Logger logger = Logger.getLogger(ExtentReportManager.class);

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static String reportFilePath;

    // Thread-safe test and name storage
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final ThreadLocal<String> currentTestName = new ThreadLocal<>();

    // ======================================================
    // INITIALIZE EXTENT REPORTS
    // ======================================================
    public static ExtentReports startReports(String reportName) {
        try {

        	 String reportDir = Paths.get("ExtentReports").toAbsolutePath().toString();
             Files.createDirectories(Paths.get(reportDir));

             // ✅ Use custom report name if provided, else default
             if (reportName == null || reportName.trim().isEmpty()) {
                 reportName = "MobileTestReport";
             }

             // ✅ Timestamp for unique report
             String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
             reportFilePath = reportDir + File.separator + reportName + "_" + timeStamp + ".html";

             // ✅ Initialize Spark Reporter
             sparkReporter = new ExtentSparkReporter(reportFilePath);
             configureSparkReporter();  // Your existing method for UI setup

             // ✅ Attach to ExtentReports
             extentReports = new ExtentReports();
             extentReports.attachReporter(sparkReporter);

             setSystemInfo();  // System/config values for report footer

             logger.info("ExtentReports initialized: " + reportFilePath);
             return extentReports;

        } catch (Exception e) {
            logger.error("Failed to initialize ExtentReports", e);
            throw new RuntimeException("ExtentReports initialization failed", e);
        }
    }

    public static void openExtentReport() {
        try {
            if (reportFilePath == null || reportFilePath.isEmpty()) {
                logger.error("❌ Report file path is null or empty. Cannot open report.");
                return;
            }

            File reportFile = new File(reportFilePath);

            if (reportFile.exists()) {
                // ✅ Open in default browser (Chrome if default)
                new ProcessBuilder("cmd", "/c", "start", "\"\"", reportFile.getAbsolutePath()).start();
                logger.info("✅ Extent Report opened automatically: " + reportFilePath);
            } else {
                logger.error("❌ Report file not found at: " + reportFilePath);
            }
        } catch (Exception e) {
            logger.error("⚠️ Failed to open ExtentReport automatically.", e);
        }
    }

    // ======================================================
    // TEST CREATION
     //======================================================

    public static ExtentTest createTest(String testName) {
        ensureReportsInitialized();
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
       currentTestName.set(testName);
       logger.info("Test created: " + testName);
        return test;
    }

    public static ExtentTest createTest(String testName, String description) {
        ensureReportsInitialized();
      ExtentTest test = extentReports.createTest(testName, description);
        extentTest.set(test);
        currentTestName.set(testName);
        logger.info("Test created: " + testName + " | " + description);
        return test;
    }

    // Auto-create test if not exists
    private static ExtentTest getOrCreateTest() {
        ExtentTest test = extentTest.get();
        if (test == null) {
           // String autoName = "Test_" + Thread.currentThread().getId() + "_" + System.currentTimeMillis();
           // test = createTest(autoName);
            logger.info("Auto-created test: " );
        }
        return test;
    }

    // ======================================================
    // CHILD NODES
    // ======================================================
    public static ExtentTest createNode(String nodeName) {
        ExtentTest node = getOrCreateTest().createNode(nodeName);
        logger.info("Node created: " + nodeName);
        return node;
    }

    public static ExtentTest createNode(String nodeName, String description) {
        ExtentTest node = getOrCreateTest().createNode(nodeName, description);
        logger.info("Node created: " + nodeName);
        return node;
    }

    // ======================================================
    // REPORT STEP (String status)
    // ======================================================
    public static void reportStep(String message, String status) {
        ExtentTest test = getOrCreateTest();

        try {
            switch (status.toLowerCase()) {
                case "pass":
                    test.pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
                    break;
                case "fail":
                    test.fail(MarkupHelper.createLabel(message, ExtentColor.RED));
                    break;
                case "skip":
                    test.skip(MarkupHelper.createLabel(message, ExtentColor.ORANGE));
                    break;
                case "info":
                    test.info(message);
                    break;
                case "warning":
                    test.warning(MarkupHelper.createLabel(message, ExtentColor.YELLOW));
                    break;
                default:
                    test.info(message);
                    logger.warn("Unknown status '" + status + "', defaulting to INFO");
            }
        } catch (Exception e) {
            logger.error("Failed to log step: " + message, e);
        }
    }

    // ======================================================
    // REPORT STEP (Status enum)
    // ======================================================
    public static void reportStep(String message, Status status) {
        getOrCreateTest().log(status, message);
    }

    // ======================================================
    // CONVENIENCE METHODS
    // ======================================================
    public static void pass(String message)    { reportStep(message, "pass"); }
    public static void fail(String message)    { reportStep(message, "fail"); }
    public static void info(String message)    { reportStep(message, "info"); }
    public static void skip(String message)    { reportStep(message, "skip"); }
    public static void warning(String message) { reportStep(message, "warning"); }

    // ======================================================
    // SCREENSHOTS
    // ======================================================
    public static void addScreenshotBase64(String base64, String title) {
        try {
            getOrCreateTest().addScreenCaptureFromBase64String(base64, title);
            logger.info("Screenshot attached (Base64): " + title);
        } catch (Exception e) {
            logger.error("Failed to attach Base64 screenshot", e);
        }
    }

    public static void addScreenshot(String filePath, String title) {
        try {
            getOrCreateTest().addScreenCaptureFromPath(filePath, title);
            logger.info("Screenshot attached: " + filePath);
        } catch (Exception e) {
            logger.error("Failed to attach screenshot: " + filePath, e);
        }
    }

    // ======================================================
    // EXCEPTION LOGGING
    // ======================================================
    public static void logException(Throwable t) {
        try {
            getOrCreateTest().fail(t);
            logger.error("Exception logged to report", t);
        } catch (Exception e) {
            logger.error("Failed to log exception", e);
        }
    }

    // ======================================================
    // TAGS & METADATA
    // ======================================================
    public static void assignCategory(String... categories) {
        try {
            getOrCreateTest().assignCategory(categories);
            logger.info("Categories: " + String.join(", ", categories));
        } catch (Exception e) {
            logger.error("Failed to assign category", e);
        }
    }

    public static void assignAuthor(String... authors) {
        try {
            getOrCreateTest().assignAuthor(authors);
            logger.info("Authors: " + String.join(", ", authors));
        } catch (Exception e) {
            logger.error("Failed to assign author", e);
        }
    }

    public static void assignDevice(String... devices) {
        try {
            getOrCreateTest().assignDevice(devices);
            logger.info("Devices: " + String.join(", ", devices));
        } catch (Exception e) {
            logger.error("Failed to assign device", e);
        }
    }

    // ======================================================
    // GETTERS & UTILITIES
    // ======================================================
    public static ExtentTest getTest() { return extentTest.get(); }
    public static String getCurrentTestName() { return currentTestName.get(); }
    public static boolean isTestInitialized() { return extentTest.get() != null; }
    public static ExtentReports getExtentReports() { return extentReports; }
    public static String getReportFilePath() { return reportFilePath; }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static void removeTest() {
        extentTest.remove();
        currentTestName.remove();
    }

    // ======================================================
    // FLUSH & CLEANUP
    // ======================================================
    public static void stopReports() {
        try {
            if (extentReports != null) {
                extentReports.flush();
                logger.info("Report generated: file://" + reportFilePath);
            }
        } catch (Exception e) {
            logger.error("Failed to flush reports", e);
        } finally {
            removeTest();
        }
    }

    // ======================================================
    // HELPER: Ensure reports are initialized
    // ======================================================
    private static void ensureReportsInitialized() {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports not initialized. Call startReports() in @BeforeSuite.");
        }
    }

    // ======================================================
    // HELPER METHODS - PLACED AT THE END AS REQUESTED
    // ======================================================

    private static void configureSparkReporter() {
        sparkReporter.config().setDocumentTitle("Cyber Human AB CHOPRA Mobile Application");
        sparkReporter.config().setReportName("Mobile Test Execution Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setCss(".badge { font-size: 95%; } .report-name { padding-top: 10px; }");
        sparkReporter.config().setJs("document.querySelector('.logo').innerHTML = '<b>AB CHOPRA APPLICATIONS</b> Mobile';");
    }

    private static void setSystemInfo() {
        extentReports.setSystemInfo("Application", "Cyber Human AB CHOPRA Mobile App");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("OS",BaseClass.properties.getProperty("OSType"));
        extentReports.setSystemInfo("OS Version",BaseClass.properties.getProperty("android.platformVersion"));
        extentReports.setSystemInfo("Framework", "TestNG + Appium");
        extentReports.setSystemInfo("Automation Tool", "Appium");
        extentReports.setSystemInfo("Executed By", "Ramesh Aravindh");
    }
}