package pageObjectsiOS;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_000_DashboardModulePage extends BaseClass {

    public PG_000_DashboardModulePage(WebDriver webDriver) {
        TestContext.setDriver(webDriver);
        PageFactory.initElements(new AppiumFieldDecorator(webDriver), this);
    }

    // === Bottom Navigation Tabs (iOS) ===
    @iOSXCUITFindBy(accessibility = "HOME")
    public WebElement homeTab;

    @iOSXCUITFindBy(accessibility = "DAILY PRESCRIPTION")
    public WebElement dailyPrescriptionTab;

    @iOSXCUITFindBy(accessibility = "DATA BANK")
    public WebElement dataBankTab;

    @iOSXCUITFindBy(accessibility = "AB CHOPRA HOUSE")
    public WebElement abChopraHouseTab;

    @iOSXCUITFindBy(accessibility = "PROFILE")
    public WebElement profileTab;

    @iOSXCUITFindBy(accessibility = "WELLBEING \nDASHBOARD\nHOME")
    public WebElement wellbeingDashboardHomeTab;

    @iOSXCUITFindBy(accessibility = "WELLBEING \nDASHBOARD\nDAILY PRESCRIPTION")
    public WebElement wellbeingDashboardDailyPrescriptionTab;

    // === Fallback Locators for iOS ===
    // Using -ios class chain (faster than XPath)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'WELLBEING' AND label CONTAINS 'DASHBOARD' AND label CONTAINS 'HOME'`]")
    public WebElement wellbeingDashboardHomeTabClassChain;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'WELLBEING' AND label CONTAINS 'DASHBOARD' AND label CONTAINS 'HOME'")
    public WebElement wellbeingDashboardHomeTabPredicate;

    // Fallback using XPath (less preferred, but safe)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='HOME']")
    public WebElement homeTabXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='DAILY PRESCRIPTION']")
    public WebElement dailyPrescriptionTabXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='DATA BANK']")
    public WebElement dataBankTabXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='AB CHOPRA HOUSE']")
    public WebElement abChopraHouseTabXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='PROFILE']")
    public WebElement profileTabXpath;

    // ===================================================================
    // 1. Click HOME Tab
    // ===================================================================
    public PG_000_DashboardModulePage Click_On_Home_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(homeTab) ? homeTab : homeTabXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click HOME tab", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click DAILY PRESCRIPTION Tab
    // ===================================================================
    public PG_000_DashboardModulePage Click_On_Daily_Prescription_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(dailyPrescriptionTab) ? dailyPrescriptionTab : dailyPrescriptionTabXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click DAILY PRESCRIPTION tab", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click DATA BANK Tab
    // ===================================================================
    public PG_000_DashboardModulePage Click_On_Data_Bank_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(dataBankTab) ? dataBankTab : dataBankTabXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click DATA BANK tab", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click AB CHOPRA HOUSE Tab
    // ===================================================================
    public PG_000_DashboardModulePage Click_On_AB_Chopra_House_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(abChopraHouseTab) ? abChopraHouseTab : abChopraHouseTabXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click AB CHOPRA HOUSE tab", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click PROFILE Tab
    // ===================================================================
    public PG_000_DashboardModulePage Click_On_Profile_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(profileTab) ? profileTab : profileTabXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click PROFILE tab", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Swipe Up & Verify All Modules Are Displayed
    // ===================================================================
    public PG_000_DashboardModulePage Swipe_Up_And_Verify_All_Modules_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            List<WebElement> modules = Arrays.asList(
                homeTab, dailyPrescriptionTab, dataBankTab, abChopraHouseTab, profileTab
            );
            List<String> moduleNames = Arrays.asList(
                "HOME", "DAILY PRESCRIPTION", "DATA BANK", "AB CHOPRA HOUSE", "PROFILE"
            );

            int maxSwipes = 5;
            boolean allVisible = false;

            for (int swipe = 0; swipe < maxSwipes && !allVisible; swipe++) {
                allVisible = true;
                for (int i = 0; i < modules.size(); i++) {
                    if (!isDisplayedWithFallback(modules.get(i))) {
                        allVisible = false;
                        swipeUp();
                        Thread.sleep(800);
                        break;
                    }
                }
            }

            // Final verification
            for (int i = 0; i < modules.size(); i++) {
                if (!isDisplayedWithFallback(modules.get(i))) {
                    throw new Exception(moduleNames.get(i) + " is not displayed after swiping");
                }
            }

            ExtentReportManager.info(methodName + " - All 5 modules are displayed");
            TestContext.getLogger().info(methodName + " - All modules verified");
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Verification failed");
            TestContext.getLogger().error(methodName + " - One or more modules not visible", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Helper: Swipe Up (W3C - Cross-platform)
    // ===================================================================
    private void swipeUp() {
        Dimension size = TestContext.getDriver().manage().window().getSize();
        int width = size.width;
        int height = size.height;

        int startX = width / 2;
        int startY = (int) (height * 0.8);
        int endY = (int) (height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((RemoteWebDriver) TestContext.getDriver()).perform(Collections.singletonList(swipe));
    }

    // ===================================================================
    // Swipe Up from Wellbeing Dashboard Bottom Tab
    // ===================================================================
    public PG_000_DashboardModulePage swipe_Up_WellBeing_Dashboard() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement bottomNav = wellbeingDashboardDailyPrescriptionTab;

            // Wait for element
            new WebDriverWait(TestContext.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(bottomNav));

            Point loc = bottomNav.getLocation();
            Dimension sz = bottomNav.getSize();
            int startX = loc.getX() + sz.getWidth() / 2;
            int startY = loc.getY() + sz.getHeight() / 2;
            int endY = (int) (TestContext.getDriver().manage().window().getSize().getHeight() * 0.20);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((RemoteWebDriver) TestContext.getDriver()).perform(Collections.singletonList(swipe));
            Thread.sleep(3000);

            ExtentReportManager.info(methodName + " – Swipe Up from bottom navigation");
            TestContext.getLogger().info(methodName + " – Success");
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " – Failed");
            TestContext.getLogger().error(methodName + " – Error", e);
            throw new RuntimeException("Swipe-up gesture failed", e);
        }
        return this;
    }

    // ===================================================================
    // Helper: Safe Display Check
    // ===================================================================
    private boolean isDisplayedSafe(WebElement el) {
        try {
            return el != null && el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isDisplayedWithFallback(WebElement el) {
        return isDisplayedSafe(el);
    }
}