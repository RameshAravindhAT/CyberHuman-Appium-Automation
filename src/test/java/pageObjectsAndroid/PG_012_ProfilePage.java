package pageObjectsAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
    @AndroidFindBy(accessibility = "PROFILE")
    public WebElement lblProfileHeader;

    @AndroidFindBy(accessibility = "RAMESH ARAVINDH")
    public WebElement lblUserName;

    // === MENU OPTIONS ===
    @AndroidFindBy(accessibility = "ACCOUNT")
    public WebElement btnAccount;

    @AndroidFindBy(accessibility = "MY ORDERS")
    public WebElement btnMyOrders;

    @AndroidFindBy(accessibility = "HELP & SUPPORT")
    public WebElement btnHelpSupport;

    @AndroidFindBy(accessibility = "LEGAL INFORMATION")
    public WebElement btnLegalInfo;

    @AndroidFindBy(accessibility = "LOG OUT")
    public WebElement btnLogOut;

    // === MY ORDERS SUB-OPTIONS ===
    @AndroidFindBy(accessibility = "TRACK ORDER")
    public WebElement btnTrackOrder;

    @AndroidFindBy(accessibility = "SEND SAMPLE")
    public WebElement btnSendSample;

    // === LEGAL SUB-OPTIONS ===
    @AndroidFindBy(accessibility = "TERMS & CONDITIONS")
    public WebElement btnTermsConditions;

    @AndroidFindBy(accessibility = "PRIVACY POLICY")
    public WebElement btnPrivacyPolicy;

    // === BOTTOM NAV ===
    @AndroidFindBy(accessibility = "WELLBEING \nDASHBOARD\nPROFILE")
    public WebElement bottomNavProfile;

    // === PROFILE ICON (Top Right) ===
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[560,1311][678,1431]']")
    public WebElement iconProfile;

    // === FALLBACKS ===
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='PROFILE']")
    public WebElement lblProfileHeader_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='RAMESH ARAVINDH']")
    public WebElement lblUserName_XPath;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ACCOUNT']")
    public WebElement btnAccount_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='MY ORDERS']")
    public WebElement btnMyOrders_XPath;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='HELP & SUPPORT']")
    public WebElement btnHelpSupport_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='LEGAL INFORMATION']")
    public WebElement btnLegalInfo_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='LOG OUT']")
    public WebElement btnLogOut_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='TRACK ORDER']")
    public WebElement btnTrackOrder_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='SEND SAMPLE']")
    public WebElement btnSendSample_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='TERMS & CONDITIONS']")
    public WebElement btnTermsConditions_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='PRIVACY POLICY']")
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
                throw new Exception("PROFILE header not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click Account
    // ===================================================================
    public PG_012_ProfilePage Click_On_Account() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnAccount) ? btnAccount : btnAccount_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked ACCOUNT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click ACCOUNT");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click My Orders
    // ===================================================================
    public PG_012_ProfilePage Click_On_My_Orders() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnMyOrders) ? btnMyOrders : btnMyOrders_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked MY ORDERS");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click MY ORDERS");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click Track Order
    // ===================================================================
    public PG_012_ProfilePage Click_On_Track_Order() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnTrackOrder) ? btnTrackOrder : btnTrackOrder_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked TRACK ORDER");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click TRACK ORDER");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click Send Sample
    // ===================================================================
    public PG_012_ProfilePage Click_On_Send_Sample() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnSendSample) ? btnSendSample : btnSendSample_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked SEND SAMPLE");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click SEND SAMPLE");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Click Help & Support
    // ===================================================================
    public PG_012_ProfilePage Click_On_Help_Support() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnHelpSupport) ? btnHelpSupport : btnHelpSupport_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked HELP & SUPPORT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click HELP & SUPPORT");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 7. Click Legal Information
    // ===================================================================
    public PG_012_ProfilePage Click_On_Legal_Information() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnLegalInfo) ? btnLegalInfo : btnLegalInfo_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked LEGAL INFORMATION");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click LEGAL INFORMATION");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 8. Click Terms & Conditions
    // ===================================================================
    public PG_012_ProfilePage Click_On_Terms_Conditions() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnTermsConditions) ? btnTermsConditions : btnTermsConditions_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked TERMS & CONDITIONS");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click TERMS & CONDITIONS");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 9. Click Privacy Policy
    // ===================================================================
    public PG_012_ProfilePage Click_On_Privacy_Policy() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnPrivacyPolicy) ? btnPrivacyPolicy : btnPrivacyPolicy_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked PRIVACY POLICY");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click PRIVACY POLICY");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 10. Click Log Out
    // ===================================================================
    public PG_012_ProfilePage Click_On_Log_Out() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement btn = isDisplayedSafe(btnLogOut) ? btnLogOut : btnLogOut_XPath;
            btn.click();
            ExtentReportManager.pass(methodName + " - Clicked LOG OUT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click LOG OUT");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 11. Click Profile Icon (Top Right)
    // ===================================================================
    public PG_012_ProfilePage Click_On_Profile_Icon() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconProfile.click();
            ExtentReportManager.info(methodName + " - Clicked PROFILE ICON");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click PROFILE ICON");
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
        } catch (Exception ignored) {
            return false;
        }
    }
}