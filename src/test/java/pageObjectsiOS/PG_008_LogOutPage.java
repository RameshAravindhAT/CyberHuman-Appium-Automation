package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.ExtentReportManager;
import utils.TestContext;

public class PG_008_LogOutPage {

    // Constructor
    public PG_008_LogOutPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === Primary Locators (iOS) ===
    @iOSXCUITFindBy(accessibility = "YES")
    public WebElement yesButton;

    @iOSXCUITFindBy(accessibility = "NO")
    public WebElement noButton;

    // === Fallback Locators (iOS) ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='YES']")
    public WebElement yesButtonXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NO']")
    public WebElement noButtonXpath;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'YES'`]")
    public WebElement yesButtonClassChain;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NO'`]")
    public WebElement noButtonClassChain;

    // ===================================================================
    // 1. Click YES (Confirm Logout)
    // ===================================================================
    public PG_008_LogOutPage Click_On_Yes() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(yesButton) ? yesButton :
                               isDisplayedSafe(yesButtonXpath) ? yesButtonXpath :
                               yesButtonClassChain;

            target.click();
            ExtentReportManager.info(methodName + " - Confirmed logout by clicking YES");
            TestContext.getLogger().info(methodName + " - YES clicked");

            // Navigate to Sign In Page and verify
            PG_002_SignInPage signInPage = new PG_002_SignInPage(TestContext.getDriver());
            signInPage.Verify_Sign_In_Title_Displayed();

        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click YES");
            TestContext.getLogger().error(methodName + " - Failed to click YES", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click NO (Cancel Logout)
    // ===================================================================
    public PG_008_LogOutPage Click_On_No() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(noButton) ? noButton :
                               isDisplayedSafe(noButtonXpath) ? noButtonXpath :
                               noButtonClassChain;

            target.click();
            ExtentReportManager.info(methodName + " - Cancelled logout by clicking NO");
            TestContext.getLogger().info(methodName + " - NO clicked");
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click NO");
            TestContext.getLogger().error(methodName + " - Failed to click NO", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Verify Confirmation Dialog is Displayed
    // ===================================================================
    public PG_008_LogOutPage Verify_Logout_Confirmation_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement yesBtn = isDisplayedSafe(yesButton) ? yesButton :
                               isDisplayedSafe(yesButtonXpath) ? yesButtonXpath :
                               yesButtonClassChain;

            WebElement noBtn = isDisplayedSafe(noButton) ? noButton :
                              isDisplayedSafe(noButtonXpath) ? noButtonXpath :
                              noButtonClassChain;

            if (yesBtn.isDisplayed() && noBtn.isDisplayed()) {
                ExtentReportManager.info(methodName + " - YES and NO buttons are visible");
                TestContext.getLogger().info(methodName + " - Logout confirmation dialog displayed");
            } else {
                throw new Exception("YES or NO button not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Logout confirmation NOT displayed");
            TestContext.getLogger().error(methodName + " - Failed to verify dialog", e);
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