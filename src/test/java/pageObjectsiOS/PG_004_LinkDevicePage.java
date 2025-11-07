package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_004_LinkDevicePage extends BaseClass {

    // Constructor
    public PG_004_LinkDevicePage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === Primary Locators (iOS) ===
    @iOSXCUITFindBy(accessibility = "LINK DEVICES")
    public WebElement lblLinkDevicesTitle;

    @iOSXCUITFindBy(accessibility = "Track your fitness")
    public WebElement txtTrackFitness;

    @iOSXCUITFindBy(accessibility = "ULTRAHUMAN")
    public WebElement btnUltrahuman;

    @iOSXCUITFindBy(accessibility = "CONTINUE")
    public WebElement btnContinue;

    // === Fallback Locators (iOS) ===
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'LINK DEVICES'`]")
    public WebElement lblLinkDevicesTitle_ClassChain;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Track your fitness'")
    public WebElement txtTrackFitness_Predicate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ULTRAHUMAN']")
    public WebElement btnUltrahuman_Xpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUE']")
    public WebElement btnContinue_Xpath;

    // ===================================================================
    // Verify LINK DEVICES Title is Displayed
    // ===================================================================
    public PG_004_LinkDevicePage Verify_LinkDevices_Title_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement title = isDisplayedSafe(lblLinkDevicesTitle) ? lblLinkDevicesTitle : lblLinkDevicesTitle_ClassChain;
            if (title.isDisplayed()) {
                ExtentReportManager.info(methodName + " - LINK DEVICES title is displayed: '" + title.getAttribute("name") + "'");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("LINK DEVICES title not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - LINK DEVICES title NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Verify Description Text is Displayed
    // ===================================================================
    public PG_004_LinkDevicePage Verify_Description_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement description = isDisplayedSafe(txtTrackFitness) ? txtTrackFitness : txtTrackFitness_Predicate;
            if (description.isDisplayed()) {
                ExtentReportManager.info(methodName + " - Description text is displayed: '" + description.getAttribute("name") + "'");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Description text not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Description text NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Click on ULTRAHUMAN Button
    // ===================================================================
    public PG_004_LinkDevicePage Click_On_Ultrahuman() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement ultrahumanBtn = isDisplayedSafe(btnUltrahuman) ? btnUltrahuman : btnUltrahuman_Xpath;
            ultrahumanBtn.click();
            ExtentReportManager.info(methodName + " - Clicked on ULTRAHUMAN");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click ULTRAHUMAN");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Click on CONTINUE Button
    // ===================================================================
    public PG_004_LinkDevicePage Click_On_Continue() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement continueBtn = isDisplayedSafe(btnContinue) ? btnContinue : btnContinue_Xpath;
            continueBtn.click();
            ExtentReportManager.info(methodName + " - Clicked on CONTINUE");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click CONTINUE");
            TestContext.getLogger().error(methodName, e);
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