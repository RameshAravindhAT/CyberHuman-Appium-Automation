package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.appium.java_client.AppiumDriver;
import projectSpecifications.BaseClass;

public class CustomTestListener extends BaseClass implements ITestListener {

    // ThreadLocal to store the method name for each test
    private static ThreadLocal<String> currentMethodName = new ThreadLocal<>();

    // ThreadLocal to store test start time
    private static ThreadLocal<Long> testStartTime = new ThreadLocal<>();

    /**
     * Called when a test starts
     * Creates ExtentTest and initializes test context
     */
    @Override
    public void onTestStart(ITestResult result) {
        // Store method name
        String methodName = result.getMethod().getMethodName();
        currentMethodName.set(methodName);

        // Store start time
        testStartTime.set(System.currentTimeMillis());

        // Get test description if available
        String description = result.getMethod().getDescription();

        // Create ExtentTest
        if (description != null && !description.isEmpty()) {
         //   ExtentReportManager.createTest(methodName, description);  // Ensure the test is created
        } else {
          //  ExtentReportManager.createTest(methodName);  // Fallback if no description
        }

        // Add metadata
        ExtentReportManager.assignAuthor("QA Automation Team");

        // Add test groups/categories if any
        String[] groups = result.getMethod().getGroups();
        if (groups != null && groups.length > 0) {
            ExtentReportManager.assignCategory(groups);
        }

        // Get platform from TestNG XML
        ITestContext context = result.getTestContext();
        String platform = context.getCurrentXmlTest().getParameter("platformName");
        if (platform != null) {
            ExtentReportManager.assignDevice(platform);
        }
        logger.info("Test Started: " + methodName);
    }

    /**
     * Called when a test passes
     */
    @Override
    public void onTestSuccess(ITestResult result) {
    	 String methodName = result.getMethod().getMethodName().replace("_", " ");
        // Log success
        ExtentReportManager.pass("✓ Test Passed Successfully");
        logger.info("Test Passed: " + methodName);

        // Cleanup
        cleanup();
    }

    /**
     * Called when a test fails
     */
    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName().replace("_", " ");
        Throwable throwable = result.getThrowable();
        String errorMessage = throwable != null ? throwable.getMessage() : "Unknown error";
        long duration = calculateTestDuration();

        // Log failure details
        ExtentReportManager.fail("✗ Test Failed: " + methodName);
        ExtentReportManager.fail("Error Message: " + errorMessage);
        ExtentReportManager.info("Test Duration: " + duration + " ms");

        // Log exception with stack trace
        if (throwable != null) {
            ExtentReportManager.logException(throwable);
        }

        // Take screenshot
        String screenshotPath = takeScreenshot(methodName);

        if (screenshotPath != null && !screenshotPath.startsWith("Error")) {
            try {
                // Attach screenshot to ExtentReport
                ExtentReportManager.getTest().fail("Screenshot on Failure",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

                logger.info("Screenshot captured: " + screenshotPath);
            } catch (Exception e) {
                logger.error("Failed to attach screenshot to report", e);
                ExtentReportManager.fail("Failed to attach screenshot: " + e.getMessage());
            }
        } else {
            ExtentReportManager.fail("Screenshot capture failed: " + screenshotPath);
            logger.error("Screenshot capture failed: " + screenshotPath);
        }

        ExtentReportManager.info("========== Test Failed: " + methodName + " ==========");
        logger.error("Test Failed: " + result.getMethod().getMethodName() + " (Duration: " + duration + " ms)");

        // Cleanup
        cleanup();
    }

    /**
     * Called when a test is skipped
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String skipReason = result.getThrowable() != null ? result.getThrowable().getMessage() : "No reason provided";

        // Create test if not exists (in case of dependency skip)
        if (ExtentReportManager.getTest() == null) {
            ExtentReportManager.createTest(methodName);
        }

        // Log skip
        ExtentReportManager.skip("⊘ Test Skipped: " + methodName);
        ExtentReportManager.skip("Skip Reason: " + skipReason);
        ExtentReportManager.info("========== Test Skipped: " + methodName + " ==========");

        logger.warn("Test Skipped: " + methodName + " - Reason: " + skipReason);

        // Cleanup
        cleanup();
    }

    /**
     * Called when a test fails but is within success percentage
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String methodName = result.getMethod().getMethodName();

        ExtentReportManager.warning("⚠ Test Failed but within success percentage: " + methodName);
        logger.warn("Test Failed but within success percentage: " + methodName);

        // Cleanup
        cleanup();
    }

    /**
     * Get current test method name
     */
    public static String getCurrentTestMethodName() {
        return currentMethodName.get();
    }

    /**
     * Calculate test duration
     */
    private long calculateTestDuration() {
        Long startTime = testStartTime.get();
        if (startTime != null) {
            return System.currentTimeMillis() - startTime;
        }
        return 0;
    }

    /**
     * Cleanup ThreadLocal variables
     */
    private void cleanup() {
        currentMethodName.remove();
        testStartTime.remove();
        ExtentReportManager.removeTest();
    }

    /**
     * Take screenshot with descriptive name
     * @param testName Name of the test
     * @return Path to the screenshot file
     */
    public String takeScreenshot(String testName) {
        AppiumDriver driver = (AppiumDriver) TestContext.getDriver();

        if (driver == null) {
            logger.error("AppiumDriver is null, cannot take screenshot.");
            return "Error: AppiumDriver is null.";
        }

        try {
            // Create timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Clean test name for file system
            String cleanTestName = testName.replaceAll("[^a-zA-Z0-9_-]", "_");

            // Create unique screenshot file name
            String screenshotFileName = cleanTestName + "_" + timestamp + ".png";

            // Define the path where screenshots will be stored
            String screenshotDir = Paths.get("screenshots").toAbsolutePath().toString();
            String screenshotPath = Paths.get(screenshotDir, screenshotFileName).toString();

            // Ensure the "screenshots" directory exists
            File screenshotDirectory = new File(screenshotDir);
            if (!screenshotDirectory.exists()) {
                screenshotDirectory.mkdirs();
                logger.info("Created screenshots directory: " + screenshotDir);
            }

            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Copy the screenshot to the desired location
            FileUtils.copyFile(screenshot, new File(screenshotPath));

            logger.info("Screenshot saved successfully: " + screenshotPath);

            // Return relative path for ExtentReports
            return screenshotPath;

        } catch (IOException e) {
            logger.error("Error while taking screenshot", e);
            return "Error while saving screenshot: " + e.getMessage();
        } catch (Exception e) {
            logger.error("Unexpected error while taking screenshot", e);
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Take screenshot with default name
     */
    public String takeScreenshot() {
        String methodName = getCurrentTestMethodName();
        if (methodName == null) {
            methodName = "screenshot_" + System.currentTimeMillis();
        }
        return takeScreenshot(methodName);
    }
}