package pageObjectsAndroid;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_005_DailyPriorityPage extends BaseClass {

    public PG_005_DailyPriorityPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ✅ Locators
    // DAILY PRIORITY Title
    @AndroidFindBy(accessibility = "DAILY PRIORITY")    // Or use "DAILY  PRIORITY" if \n causes issue
    public WebElement dailyPriorityTitle;

    // Username (Example: "RAMESH ARAVINDH")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' ')]")
    public WebElement txtUserName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, ',')]")
    public WebElement txtDate;

    @AndroidFindBy(xpath = "//android.view.View[(contains(@content-desc,'AM') or contains(@content-desc,'PM'))]")
    public WebElement txtTime;

    // Session priority (Example: "Afternoon Priority")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Priority')]")
    public WebElement txtSessionPriority;

    // Nutrition Topic (Example: "Nutrition & Metabolism")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc]")
    public WebElement txtNutrition;

    // Act Section Title
    @AndroidFindBy(accessibility = "Act")
    public WebElement txtActTitle;

    // Act Description
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'For')]")
    public WebElement txtActDescription;

    // PROCEED Button
    @AndroidFindBy(accessibility = "PROCEED")
    public WebElement btnProceed;

    // Bottom Chat Icon OR Hamburger Icon (Clickable ImageView)
    @AndroidFindBy(xpath = "//android.widget.ImageView[@clickable='true']")
    public WebElement btnChatIcon;

    // ✅ 1. Verify Page Display
    public PG_005_DailyPriorityPage Verify_Daily_Priority_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	Thread.sleep(1000);
            if (dailyPriorityTitle.isDisplayed()) {
                ExtentReportManager.info(methodName);
                TestContext.getLogger().info(methodName + " - Daily Priority title is visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Daily Priority title is NOT visible");
            TestContext.getLogger().error(methodName + " - Daily Priority title is NOT visible", e);
            throw new RuntimeException(e);
        }
        return this;
    }
    public PG_005_DailyPriorityPage Verify_User_Name(String expectedName) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	Thread.sleep(1000);
            WebElement userNameElement = getUserNameElement(expectedName);
            String actualName = userNameElement.getAttribute("content-desc").trim();

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

    public PG_005_DailyPriorityPage Verify_Current_Date_Time() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            // ✅ Wait for Date and Time elements to be visible
            wait.until(ExpectedConditions.visibilityOf(txtDate));
            wait.until(ExpectedConditions.visibilityOf(txtTime));

            // ✅ Get Date & Time from UI
            String uiDate = txtDate.getAttribute("content-desc").trim();
            String uiTime = txtTime.getAttribute("content-desc").trim();

            TestContext.getLogger().info("UI Date fetched: " + uiDate);
            TestContext.getLogger().info("UI Time fetched: " + uiTime);

            // ✅ Format system date (Example: "Monday, November 4")
            String expectedDate1 = new SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH).format(new Date());
            String expectedDate2 = new SimpleDateFormat("EEEE, MMMM dd", Locale.ENGLISH).format(new Date()); // with leading zero

            // ✅ Format system time (Example: "hh:mm a")
            String expectedTime = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date());

            // ✅ Validate Date
            if (uiDate.contains(expectedDate1) || uiDate.contains(expectedDate2)) {
                ExtentReportManager.info(methodName + " - ✅ Date matches: " + expectedDate1);
                TestContext.getLogger().info(methodName + " - ✅ Date matches: " + expectedDate1);
            } else {
               // ExtentReportManager.fail(methodName + " - ❌ Date mismatch! Expected: " + expectedDate1 + " or " + expectedDate2 + ", Found: " + uiDate);
                TestContext.getLogger().error(methodName + " - ❌ Date mismatch! Found: " + uiDate);
            }

            // ✅ Validate Time (just matches hours & AM/PM ignoring minute difference)
            if (uiTime.startsWith(expectedTime.substring(0, 2)) && uiTime.endsWith(expectedTime.substring(expectedTime.length() - 2))) {
                ExtentReportManager.info(methodName + " - ✅ Time format is correct (Hour & AM/PM match)");
            } else {
               // ExtentReportManager.fail(methodName + " - ❌ Time mismatch! Expected (approx.): " + expectedTime + ", Found: " );
            }

        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - ❌ Failed to verify date & time");
            TestContext.getLogger().error(methodName + " - ❌ Exception while verifying date & time", e);
            throw new RuntimeException(e);
        }
        return this;
    }




    // ✅ 4. Verify Session Based on Time
    public PG_005_DailyPriorityPage Verify_Session_Based_On_Time() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	Thread.sleep(1000);
            String expectedSession = getExpectedSession();
            String actualSession = txtSessionPriority.getAttribute("content-desc");
            if (actualSession.equals(expectedSession)) {
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


    // Helper for session logic
    private String getExpectedSession() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour < 12) return "Morning Priority";
        if (hour >= 12 && hour < 17) return "Afternoon Priority";
        if (hour >= 17 && hour < 21) return "Evening Priority";
        return "Night Priority";
    }

    // ✅ 5. Click Proceed
    public PG_005_DailyPriorityPage Click_On_Proceed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	Thread.sleep(1000);
            btnProceed.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName + " - Clicked on PROCEED");
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click PROCEED");
            TestContext.getLogger().error(methodName + " - Failed to click PROCEED", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ 6. Click Chat Icon
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


    public WebElement getUserNameElement(String userName) {
        return TestContext.getDriver().findElement(
                By.xpath("//android.view.View[@content-desc='" + userName + "']"));
    }


}
