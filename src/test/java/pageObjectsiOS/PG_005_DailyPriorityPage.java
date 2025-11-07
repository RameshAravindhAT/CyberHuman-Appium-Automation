package pageObjectsiOS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_005_DailyPriorityPage extends BaseClass {

    private WebDriverWait wait;

    public PG_005_DailyPriorityPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
    }

    // === Primary Locators (iOS) ===
    @iOSXCUITFindBy(accessibility = "DAILY PRIORITY")
    public WebElement dailyPriorityTitle;

    // Dynamic: Username (e.g., "RAMESH ARAVINDH")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] ' '")
    public WebElement txtUserName;

    // Date (e.g., "Monday, November 4")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS ','")
    public WebElement txtDate;

    // Time (e.g., "10:30 AM")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND (name CONTAINS 'AM' OR name CONTAINS 'PM')")
    public WebElement txtTime;

    // Session Priority (e.g., "Afternoon Priority")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Priority'")
    public WebElement txtSessionPriority;

    // Nutrition Topic (Image with content-desc)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name != ''`]")
    public WebElement txtNutrition;

    @iOSXCUITFindBy(accessibility = "Act")
    public WebElement txtActTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'For'")
    public WebElement txtActDescription;

    @iOSXCUITFindBy(accessibility = "PROCEED")
    public WebElement btnProceed;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@visible='true']")
    public WebElement btnChatIcon;

    // === Fallback Locators ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DAILY PRIORITY']")
    public WebElement dailyPriorityTitle_Xpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PROCEED']")
    public WebElement btnProceed_Xpath;

    // ===================================================================
    // 1. Verify Page Display
    // ===================================================================
    public PG_005_DailyPriorityPage Verify_Daily_Priority_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(1000);
            WebElement title = isDisplayedSafe(dailyPriorityTitle) ? dailyPriorityTitle : dailyPriorityTitle_Xpath;
            if (title.isDisplayed()) {
                ExtentReportManager.info(methodName + " - DAILY PRIORITY title is visible");
                TestContext.getLogger().info(methodName + " - DAILY PRIORITY title is visible");
            } else {
                throw new Exception("Title not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - DAILY PRIORITY title is NOT visible");
            TestContext.getLogger().error(methodName + " - DAILY PRIORITY title is NOT visible", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Verify Username
    // ===================================================================
    public PG_005_DailyPriorityPage Verify_User_Name(String expectedName) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(1000);
            WebElement userNameElement = getUserNameElement(expectedName);
            String actualName = userNameElement.getAttribute("name").trim();
            if (actualName.equals(expectedName)) {
                ExtentReportManager.info(methodName + " - Username matches: " + expectedName);
                TestContext.getLogger().info(methodName + " - Username matches: " + expectedName);
            } else {
                ExtentReportManager.fail(methodName + " - Username mismatch! Expected: " + expectedName + ", Found: " + actualName);
                TestContext.getLogger().error(methodName + " - Username mismatch! Expected: " + expectedName + ", Found: " + actualName);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to verify username");
            TestContext.getLogger().error(methodName + " - Username element not found", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Verify Current Date & Time
    // ===================================================================
    public PG_005_DailyPriorityPage Verify_Current_Date_Time() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            wait.until(ExpectedConditions.visibilityOf(txtDate));
            wait.until(ExpectedConditions.visibilityOf(txtTime));

            String uiDate = txtDate.getAttribute("name").trim();
            String uiTime = txtTime.getAttribute("name").trim();

            TestContext.getLogger().info("UI Date fetched: " + uiDate);
            TestContext.getLogger().info("UI Time fetched: " + uiTime);

            // Format expected date
            String expectedDate1 = new SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH).format(new Date());
            String expectedDate2 = new SimpleDateFormat("EEEE, MMMM dd", Locale.ENGLISH).format(new Date());
            String expectedTime = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date());

            // Validate Date
            if (uiDate.contains(expectedDate1) || uiDate.contains(expectedDate2)) {
                ExtentReportManager.info(methodName + " - Date matches: " + expectedDate1);
                TestContext.getLogger().info(methodName + " - Date matches: " + expectedDate1);
            } else {
                ExtentReportManager.fail(methodName + " - Date mismatch! Expected: " + expectedDate1 + " or " + expectedDate2 + ", Found: " + uiDate);
                TestContext.getLogger().error(methodName + " - Date mismatch! Found: " + uiDate);
            }

            // Validate Time (hour + AM/PM)
            String expectedHour = expectedTime.substring(0, 2);
            String expectedAmPm = expectedTime.substring(expectedTime.length() - 2);
            if (uiTime.startsWith(expectedHour) && uiTime.endsWith(expectedAmPm)) {
                ExtentReportManager.info(methodName + " - Time format is correct (Hour & AM/PM match)");
            } else {
                ExtentReportManager Kain(methodName + " - Time mismatch! Expected (approx.): " + expectedTime + ", Found: " + uiTime);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to verify date & time");
            TestContext.getLogger().error(methodName + " - Exception while verifying date & time", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Verify Session Based on Time
    // ===================================================================
    public PG_005_DailyPriorityPage Verify_Session_Based_On_Time() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(1000);
            String expectedSession = getExpectedSession();
            String actualSession = txtSessionPriority.getAttribute("name");
            if (actualSession.contains(expectedSession)) {
                ExtentReportManager.info(methodName + " - Session is correct: " + expectedSession);
                TestContext.getLogger().info(methodName + " - Session is correct: " + expectedSession);
            } else {
                ExtentReportManager.fail(methodName + " - Session mismatch! Expected: " + expectedSession + ", Found: " + actualSession);
                TestContext.getLogger().error(methodName + " - Session mismatch! Expected: " + expectedSession + ", Found: " + actualSession);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Session element not found");
            TestContext.getLogger().error(methodName + " - Session element not found", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // Helper: Determine expected session
    private String getExpectedSession() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour < 12) return "Morning Priority";
        if (hour >= 12 && hour < 17) return "Afternoon Priority";
        if (hour >= 17 && hour < 21) return "Evening Priority";
        return "Night Priority";
    }

    // ===================================================================
    // 5. Click Proceed
    // ===================================================================
    public PG_005_DailyPriorityPage Click_On_Proceed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(1000);
            WebElement proceedBtn = isDisplayedSafe(btnProceed) ? btnProceed : btnProceed_Xpath;
            proceedBtn.click();
            ExtentReportManager.info(methodName + " - Clicked on PROCEED");
            TestContext.getLogger().info(methodName + " - Clicked on PROCEED");
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click PROCEED");
            TestContext.getLogger().error(methodName + " - Failed to click PROCEED", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Click Chat Icon
    // ===================================================================
    public PG_005_DailyPriorityPage Click_On_Chat_Icon() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnChatIcon.click();
            ExtentReportManager.info(methodName + " - Clicked on Chat Icon");
            TestContext.getLogger().info(methodName + " - Clicked on Chat Icon");
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click Chat Icon");
            TestContext.getLogger().error(methodName + " - Failed to click Chat Icon", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Helper: Get Username Element Dynamically
    // ===================================================================
    public WebElement getUserNameElement(String userName) {
        return TestContext.getDriver().findElement(
                By.xpath("//XCUIElementTypeStaticText[@name='" + userName + "']"));
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
}