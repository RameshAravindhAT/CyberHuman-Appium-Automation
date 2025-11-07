package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_006_DailyPrescriptionsPage extends BaseClass {

    // Constructor
    public PG_006_DailyPrescriptionsPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === Primary Locators (iOS) ===
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'improve your nutrition & metabolism'")
    public WebElement nutritionRecommendationText;

    @iOSXCUITFindBy(accessibility = "SCHEDULE TIME")
    public WebElement scheduleTimeButton;

    // Fallback: Button with name
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SCHEDULE TIME']")
    public WebElement scheduleTimeButtonXpath;

    // Cream vs Lotion Article Image (child with AB SCIENCE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'What’s the Difference Between a Cream and a Lotion?')]" +
                          "/following-sibling::XCUIElementTypeImage[@name='AB SCIENCE']")
    public WebElement creamLotionArticleImage;

    @iOSXCUITFindBy(accessibility = "WELLBEING \nDASHBOARD\nDAILY PRESCRIPTION")
    public WebElement wellbeingDashboardTab;

    // Fallback: Using class chain or predicate for multi-line text
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'WELLBEING' AND label CONTAINS 'DASHBOARD'`]")
    public WebElement wellbeingDashboardTabClassChain;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'WELLBEING') and contains(@name, 'DASHBOARD')]")
    public WebElement wellbeingDashboardTabXpath;

    // ===================================================================
    // 1. Verify & Log Nutrition Recommendation Text
    // ===================================================================
    public PG_006_DailyPrescriptionsPage Verify_Nutrition_Recommendation_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(2000); // Wait for animation
            if (nutritionRecommendationText.isDisplayed()) {
                String actualText = nutritionRecommendationText.getAttribute("name");
                ExtentReportManager.info(methodName + " - Text: " + actualText);
                TestContext.getLogger().info(methodName + " - Nutrition recommendation is visible: " + actualText);
            } else {
                throw new Exception("Nutrition text not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Nutrition recommendation text is NOT visible");
            TestContext.getLogger().error(methodName + " - Nutrition recommendation text is NOT visible", e);
            throw new RuntimeException("Nutrition recommendation text not displayed", e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click SCHEDULE TIME Button
    // ===================================================================
    public PG_006_DailyPrescriptionsPage Click_Schedule_Time_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement button = isDisplayedSafe(scheduleTimeButton) ? scheduleTimeButton : scheduleTimeButtonXpath;
            if (button.isDisplayed()) {
                button.click();
                ExtentReportManager.info(methodName + " - SCHEDULE TIME button clicked successfully");
                TestContext.getLogger().info(methodName + " - SCHEDULE TIME button clicked");
            } else {
                throw new Exception("SCHEDULE TIME button not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click SCHEDULE TIME button");
            TestContext.getLogger().error(methodName + " - Failed to click SCHEDULE TIME button", e);
            throw new RuntimeException("Failed to click SCHEDULE TIME button", e);
        }
        return this;
    }

    // ===================================================================
    // 3. Swipe Up & Click Wellbeing Dashboard Tab
    // ===================================================================
    public PG_006_DailyPrescriptionsPage Swipe_Up_And_Click_Wellbeing_Dashboard_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(wellbeingDashboardTab) ? wellbeingDashboardTab :
                               isDisplayedSafe(wellbeingDashboardTabClassChain) ? wellbeingDashboardTabClassChain :
                               wellbeingDashboardTabXpath;

            if (!target.isDisplayed()) {
                ExtentReportManager.info("Wellbeing tab not visible. Swiping up...");
                mobileActions.SwipeUpToGetDashboardModule();
                Thread.sleep(1000);
            }

            if (target.isDisplayed()) {
                target.click();
                mobileActions.SwipeUpToGetDashboardModule(); // Optional: extra swipe if needed
                ExtentReportManager.info(methodName + " - Wellbeing Dashboard tab clicked after swipe");
                TestContext.getLogger().info(methodName + " - Wellbeing Dashboard tab clicked");
            } else {
                throw new Exception("Wellbeing tab still not visible after swipe");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to swipe and click Wellbeing Dashboard tab");
            TestContext.getLogger().error(methodName + " - Failed to swipe and click Wellbeing Dashboard tab", e);
            throw new RuntimeException("Failed to access Wellbeing Dashboard tab", e);
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
}