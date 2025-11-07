package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_007_ProfilePage extends BaseClass {

    // Constructor
    public PG_007_ProfilePage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === Primary Locators (iOS) ===
    @iOSXCUITFindBy(accessibility = "PROFILE")
    public WebElement profileTitle;

    @iOSXCUITFindBy(accessibility = "RAMESH ARAVINDH")
    public WebElement userNameLabel;

    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    public WebElement accountButton;

    @iOSXCUITFindBy(accessibility = "MY ORDERS")
    public WebElement myOrdersButton;

    @iOSXCUITFindBy(accessibility = "HELP & SUPPORT")
    public WebElement helpSupportButton;

    @iOSXCUITFindBy(accessibility = "LEGAL INFORMATION")
    public WebElement legalInfoButton;

    @iOSXCUITFindBy(accessibility = "LOG OUT")
    public WebElement logOutButton;

    // Bottom Tab
    @iOSXCUITFindBy(accessibility = "WELLBEING \nDASHBOARD\nPROFILE")
    public WebElement bottomProfileTab;

    // === Fallback Locators (iOS) ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PROFILE']")
    public WebElement profileTitleXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='RAMESH ARAVINDH']")
    public WebElement userNameLabelXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ACCOUNT']")
    public WebElement accountButtonXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MY ORDERS']")
    public WebElement myOrdersButtonXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='HELP & SUPPORT']")
    public WebElement helpSupportButtonXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LEGAL INFORMATION']")
    public WebElement legalInfoButtonXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOG OUT']")
    public WebElement logOutButtonXpath;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'WELLBEING' AND label CONTAINS 'PROFILE'`]")
    public WebElement bottomProfileTabClassChain;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'PROFILE')]")
    public WebElement bottomProfileTabXpath;

    // ===================================================================
    // 1. Click ACCOUNT
    // ===================================================================
    public PG_007_ProfilePage Click_On_Account() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(accountButton) ? accountButton : accountButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click ACCOUNT", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click MY ORDERS
    // ===================================================================
    public PG_007_ProfilePage Click_On_My_Orders() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(myOrdersButton) ? myOrdersButton : myOrdersButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click MY ORDERS", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click HELP & SUPPORT
    // ===================================================================
    public PG_007_ProfilePage Click_On_Help_And_Support() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(helpSupportButton) ? helpSupportButton : helpSupportButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click HELP & SUPPORT", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click LEGAL INFORMATION
    // ===================================================================
    public PG_007_ProfilePage Click_On_Legal_Information() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(legalInfoButton) ? legalInfoButton : legalInfoButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click LEGAL INFORMATION", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click LOG OUT
    // ===================================================================
    public PG_007_ProfilePage Click_On_Log_Out() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = isDisplayedSafe(logOutButton) ? logOutButton : logOutButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click LOG OUT", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Verify Profile Page is Displayed
    // ===================================================================
    public PG_007_ProfilePage Verify_Profile_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement title = isDisplayedSafe(profileTitle) ? profileTitle : profileTitleXpath;
            if (title.isDisplayed()) {
                ExtentReportManager.info(methodName + " - PROFILE title is visible");
                TestContext.getLogger().info(methodName + " - PROFILE page loaded");
            } else {
                throw new Exception("PROFILE title not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - PROFILE page NOT displayed");
            TestContext.getLogger().error(methodName + " - Failed", e);
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