package pageObjectsiOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_001_GetStartedPage extends BaseClass {

    public PG_001_GetStartedPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === Primary Locator ===
    @iOSXCUITFindBy(accessibility = "GET STARTED")
    public WebElement btnGetStarted;

    // === Fallback Locators (Recommended for iOS) ===
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'GET STARTED'`]")
    public WebElement btnGetStartedClassChain;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'GET STARTED' AND type == 'XCUIElementTypeButton'")
    public WebElement btnGetStartedPredicate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='GET STARTED']")
    public WebElement btnGetStartedXpath;

    // ===================================================================
    // Click on "GET STARTED" Button
    // ===================================================================
    public PG_001_GetStartedPage Click_On_Get_Started_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            ExtentReportManager.info("Navigated to AB CHOPRA EPIGENETICS Start up Screen");
            Thread.sleep(3000);

            // Use primary or fallback safely
            WebElement target = isDisplayedSafe(btnGetStarted) ? btnGetStarted :
                               isDisplayedSafe(btnGetStartedClassChain) ? btnGetStartedClassChain :
                               isDisplayedSafe(btnGetStartedPredicate) ? btnGetStartedPredicate :
                               btnGetStartedXpath;

            target.click();

            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click on GET STARTED button", e);
            ExtentReportManager.logException(e);
            throw new RuntimeException(e);
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