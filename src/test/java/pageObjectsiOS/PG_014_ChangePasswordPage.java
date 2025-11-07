package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_014_ChangePasswordPage extends BaseClass {

    public PG_014_ChangePasswordPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ==================== MAIN FIELDS ====================

    // 1. Current Password
    @iOSXCUITFindBy(accessibility = "current_password_field")
    public WebElement txtCurrentPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
    public WebElement txtCurrentPassword_XPath;

    @iOSXCUITFindBy(accessibility = "show_current_password")
    public WebElement iconEyeCurrent;

    // 2. New Password
    @iOSXCUITFindBy(accessibility = "new_password_field")
    public WebElement txtNewPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
    public WebElement txtNewPassword_XPath;

    @iOSXCUITFindBy(accessibility = "show_new_password")
    public WebElement iconEyeNew;

    // 3. Confirm Password
    @iOSXCUITFindBy(accessibility = "confirm_password_field")
    public WebElement txtConfirmPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[3]")
    public WebElement txtConfirmPassword_XPath;

    @iOSXCUITFindBy(accessibility = "show_confirm_password")
    public WebElement iconEyeConfirm;

    // 4. Validation Message (Dynamic)
    @iOSXCUITFindBy(accessibility = "validation_message")
    public WebElement lblValidationError;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Passwords do not match')]")
    public WebElement lblValidationError_XPath;

    // 5. Change Password Button
    @iOSXCUITFindBy(accessibility = "CHANGE PASSWORD")
    public WebElement btnChangePassword;

    // ==================== PAGE ACTIONS (Same logic as Android) ====================

    public PG_014_ChangePasswordPage Verify_Change_Password_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            if (txtCurrentPassword.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - Change Password page is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Current password field not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Enter_Current_Password(String password) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(txtCurrentPassword) ? txtCurrentPassword : txtCurrentPassword_XPath;
            el.clear();
            el.sendKeys(password);
            ExtentReportManager.pass(methodName + " - Entered Current Password");
            TestContext.getLogger().info(methodName + ": " + maskPassword(password));
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Enter_New_Password(String password) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(txtNewPassword) ? txtNewPassword : txtNewPassword_XPath;
            el.clear();
            el.sendKeys(password);
            ExtentReportManager.pass(methodName + " - Entered New Password");
            TestContext.getLogger().info(methodName + ": " + maskPassword(password));
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Enter_Confirm_Password(String password) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(txtConfirmPassword) ? txtConfirmPassword : txtConfirmPassword_XPath;
            el.clear();
            el.sendKeys(password);
            ExtentReportManager.pass(methodName + " - Entered Confirm Password");
            TestContext.getLogger().info(methodName + ": " + maskPassword(password));
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Click_Eye_Icon_Current() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconEyeCurrent.click();
            ExtentReportManager.pass(methodName + " - Toggled Current Password visibility");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Click_Eye_Icon_New() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconEyeNew.click();
            ExtentReportManager.pass(methodName + " - Toggled New Password visibility");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Click_Eye_Icon_Confirm() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconEyeConfirm.click();
            ExtentReportManager.pass(methodName + " - Toggled Confirm Password visibility");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Verify_Validation_Message(String expectedMessage) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(lblValidationError) ? lblValidationError : lblValidationError_XPath;
            String actual = el.getAttribute("name");
            if (actual.contains(expectedMessage)) {
                ExtentReportManager.pass(methodName + " - Validation: '" + actual + "'");
                TestContext.getLogger().info(methodName + ": " + actual);
            } else {
                throw new Exception("Expected: " + expectedMessage + ", Found: " + actual);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Validation failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Verify_Dynamic_Validation_Message(String messageContains) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement msg = driver.findElementByXPath(
                String.format("//XCUIElementTypeStaticText[contains(@name, '%s')]", messageContains)
            );
            if (msg.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - Found: " + msg.getAttribute("name"));
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Message not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Not found");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_014_ChangePasswordPage Click_Change_Password_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnChangePassword.click();
            ExtentReportManager.pass(methodName + " - Clicked Change Password");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    private String maskPassword(String pwd) {
        return pwd == null || pwd.isEmpty() ? "" : "******";
    }

    private boolean isDisplayedSafe(WebElement el) {
        try {
            return el != null && el.isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }
}