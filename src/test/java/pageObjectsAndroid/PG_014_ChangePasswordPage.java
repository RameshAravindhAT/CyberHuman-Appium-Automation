package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='pAsswd']")
    public WebElement txtCurrentPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@bounds='[40,371][680,494]']")
    public WebElement txtCurrentPassword_XPath;

    // Eye icon for Current Password
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[616,407][680,447]']")
    public WebElement iconEyeCurrent;

    // 2. New Password
    @AndroidFindBy(xpath = "//android.widget.EditText[@password='true'][1]")
    public WebElement txtNewPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@bounds='[40,510][680,633]']")
    public WebElement txtNewPassword_XPath;

    // Eye icon for New Password
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[616,546][680,586]']")
    public WebElement iconEyeNew;

    // 3. Confirm Password
    @AndroidFindBy(xpath = "//android.widget.EditText[@password='true'][2]")
    public WebElement txtConfirmPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@bounds='[40,649][680,772]']")
    public WebElement txtConfirmPassword_XPath;

    // Eye icon for Confirm Password
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[616,685][680,725]']")
    public WebElement iconEyeConfirm;

    // 4. Validation Message (Dynamic)
    @AndroidFindBy(accessibility = "Passwords do not match")
    public WebElement lblValidationError;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc[contains(., 'Passwords do not match')]]")
    public WebElement lblValidationError_XPath;

    // 5. Change Password Button
    @AndroidFindBy(accessibility = "CHANGE PASSWORD")
    public WebElement btnChangePassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@bounds='[40,1412][680,1506]']")
    public WebElement btnChangePassword_XPath;

    // ==================== PAGE ACTIONS ====================

    // ===================================================================
    // 1. Verify Change Password Page is Displayed
    // ===================================================================
    public PG_014_ChangePasswordPage Verify_Change_Password_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement current = isDisplayedSafe(txtCurrentPassword) ? txtCurrentPassword : txtCurrentPassword_XPath;
            if (current.isDisplayed()) {
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

    // ===================================================================
    // 2. Enter Current Password
    // ===================================================================
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

    // ===================================================================
    // 3. Enter New Password
    // ===================================================================
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

    // ===================================================================
    // 4. Enter Confirm Password
    // ===================================================================
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

    // ===================================================================
    // 5. Toggle Password Visibility (Eye Icon)
    // ===================================================================
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

    // ===================================================================
    // 6. Verify Validation Message (Dynamic)
    // ===================================================================
    public PG_014_ChangePasswordPage Verify_Validation_Message(String expectedMessage) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(lblValidationError) ? lblValidationError : lblValidationError_XPath;
            String actual = el.getAttribute("content-desc");
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

    // Dynamic path for any validation message
    public PG_014_ChangePasswordPage Verify_Dynamic_Validation_Message(String messageContains) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement msg = driver.findElementByXPath(
                String.format("//android.view.View[@content-desc[contains(., '%s')]]", messageContains)
            );
            if (msg.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - Found: " + msg.getAttribute("content-desc"));
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

    // ===================================================================
    // 7. Click Change Password Button
    // ===================================================================
    public PG_014_ChangePasswordPage Click_Change_Password_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(btnChangePassword) ? btnChangePassword : btnChangePassword_XPath;
            el.click();
            ExtentReportManager.pass(methodName + " - Clicked Change Password");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Helper: Mask Password in Logs
    // ===================================================================
    private String maskPassword(String pwd) {
        return pwd == null || pwd.isEmpty() ? "" : "******";
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