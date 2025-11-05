package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_006_DailyPrescriptionsPage extends BaseClass {

	// ✅ Constructor
	public PG_006_DailyPrescriptionsPage(AppiumDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'improve your nutrition & metabolism')]")
    public WebElement nutritionRecommendationText;

    // 2. "SCHEDULE TIME" Button
    @AndroidFindBy(accessibility = "SCHEDULE TIME")  // Preferred: Fast & reliable
    public WebElement scheduleTimeButton;

    // Fallback XPath for the same button (use if accessibility fails in some contexts)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SCHEDULE TIME']")
    public WebElement scheduleTimeButtonXpath;

    // 3. Cream vs Lotion Article - Click on the IMAGE only (not the text)
    // The image is a child <android.view.View> with content-desc="AB SCIENCE"
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'What’s the Difference Between a Cream and a Lotion?')]" +
                          "//android.view.View[@content-desc='AB SCIENCE']")
    public WebElement creamLotionArticleImage;

    // 4. Bottom Navigation: WELLBEING DASHBOARD DAILY PRESCRIPTION
    @AndroidFindBy(accessibility = "WELLBEING \nDASHBOARD\nDAILY PRESCRIPTION")
    public WebElement wellbeingDashboardTab;

    // Fallback XPath if line breaks cause issues in accessibility ID
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'WELLBEING') and contains(@content-desc, 'DASHBOARD')]")
    public WebElement wellbeingDashboardTabXpath;

 // ===================================================================
    // 1. Verify & Log Nutrition Recommendation Text
    // ===================================================================
    public PG_006_DailyPrescriptionsPage Verify_Nutrition_Recommendation_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(2000); // Optional: wait for animation
            if (nutritionRecommendationText.isDisplayed()) {
                String actualText = nutritionRecommendationText.getAttribute("content-desc");
                ExtentReportManager.info(methodName + " - Text: " + actualText);
                TestContext.getLogger().info(methodName + " - Nutrition recommendation is visible: " + actualText);
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
            if (scheduleTimeButton.isDisplayed()) {
                scheduleTimeButton.click();
                ExtentReportManager.info(methodName + " - SCHEDULE TIME button clicked successfully");
                TestContext.getLogger().info(methodName + " - SCHEDULE TIME button clicked");
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
            // First, try to scroll into view using Appium's scrollTo (if supported)
            WebElement target = wellbeingDashboardTab.isDisplayed() ? wellbeingDashboardTab : wellbeingDashboardTabXpath;

            if (!target.isDisplayed()) {
                ExtentReportManager.info("Wellbeing tab not visible. Swiping up...");
                mobileActions.SwipeUpToGetDashboardModule();
                Thread.sleep(1000);
            }

            if (target.isDisplayed()) {
                target.click();
                mobileActions.SwipeUpToGetDashboardModule();
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

}

