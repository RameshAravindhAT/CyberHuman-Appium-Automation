package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_012_ProfilePage extends BaseClass {

    public PG_012_ProfilePage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === PROFILE HEADER ===
    @iOSXCUITFindBy(accessibility = "PROFILE")
    public WebElement lblProfileHeader;

    @iOSXCUITFindBy(accessibility = "RAMESH ARAVINDH")
    public WebElement lblUserName;

    // === MENU OPTIONS ===
    @iOSXCUITFindBy(accessibility = "ACCOUNT")
    public WebElement btnAccount;

    @iOSXCUITFindBy(accessibility = "MY ORDERS")
    public WebElement btnMyOrders;

    @iOSXCUITFindBy(accessibility = "HELP & SUPPORT")
    public WebElement btnHelpSupport;

    @iOSXCUITFindBy(accessibility = "LEGAL INFORMATION")
    public WebElement btnLegalInfo;

    @iOSXCUITFindBy(accessibility = "LOG OUT")
    public WebElement btnLogOut;

    // === MY ORDERS SUB-OPTIONS ===
    @iOSXCUITFindBy(accessibility = "TRACK ORDER")
    public WebElement btnTrackOrder;

    @iOSXCUITFindBy(accessibility = "SEND SAMPLE")
    public WebElement btnSendSample;

    // === LEGAL SUB-OPTIONS ===
    @iOSXCUITFindBy(accessibility = "TERMS & CONDITIONS")
    public WebElement btnTermsConditions;

    @iOSXCUITFindBy(accessibility = "PRIVACY POLICY")
    public WebElement btnPrivacyPolicy;

    // === BOTTOM NAV ===
    @iOSXCUITFindBy(accessibility = "WELLBEING \nDASHBOARD\nPROFILE")
    public WebElement bottomNavProfile;

    // === PROFILE ICON ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='profile_icon']")
    public WebElement iconProfile;

    // === FALLBACKS ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PROFILE']")
    public WebElement lblProfileHeader_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='RAMESH ARAVINDH']")
    public WebElement lblUserName_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ACCOUNT']")
    public WebElement btnAccount_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MY ORDERS']")
    public WebElement btnMyOrders_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='HELP & SUPPORT']")
    public WebElement btnHelpSupport_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LEGAL INFORMATION']")
    public WebElement btnLegalInfo_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOG OUT']")
    public WebElement btnLogOut_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRACK ORDER']")
    public WebElement btnTrackOrder_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEND SAMPLE']")
    public WebElement btnSendSample_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TERMS & CONDITIONS']")
    public WebElement btnTermsConditions_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PRIVACY POLICY']")
    public WebElement btnPrivacyPolicy_XPath;

    // ===================================================================
    // 1. Verify Profile Page is Displayed
    // ===================================================================
    public PG_012_ProfilePage Verify_Profile_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement header = isDisplayedSafe(lblProfileHeader) ? lblProfileHeader : lblProfileHeader_XPath;
            if (header.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - PROFILE page is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("PROFILE not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // [All Click Methods Same as Android – Just using iOS locators]
    // Reusing same logic with fallbacks

    public PG_012_ProfilePage Click_On_Account() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnAccount) ? btnAccount : btnAccount_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked ACCOUNT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_My_Orders() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnMyOrders) ? btnMyOrders : btnMyOrders_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked MY ORDERS");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Track_Order() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnTrackOrder) ? btnTrackOrder : btnTrackOrder_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked TRACK ORDER");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Send_Sample() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnSendSample) ? btnSendSample : btnSendSample_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked SEND SAMPLE");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Help_Support() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnHelpSupport) ? btnHelpSupport : btnHelpSupport_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked HELP & SUPPORT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Legal_Information() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnLegalInfo) ? btnLegalInfo : btnLegalInfo_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked LEGAL INFORMATION");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Terms_Conditions() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnTermsConditions) ? btnTermsConditions : btnTermsConditions_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked TERMS & CONDITIONS");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Privacy_Policy() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnPrivacyPolicy) ? btnPrivacyPolicy : btnPrivacyPolicy_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked PRIVACY POLICY");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Log_Out() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnLogOut) ? btnLogOut : btnLogOut_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked LOG OUT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_012_ProfilePage Click_On_Profile_Icon() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconProfile.click();
            ExtentReportManager.info(methodName + " - Clicked PROFILE ICON");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    private boolean isDisplayedSafe(WebElement el) {
        try {
            return el != null && el.isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }
}