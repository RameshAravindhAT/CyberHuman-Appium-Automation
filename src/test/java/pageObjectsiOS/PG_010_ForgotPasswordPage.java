package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

import java.util.List;

public class PG_010_ForgotPasswordPage extends BaseClass {

    public PG_010_ForgotPasswordPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === MAIN ELEMENTS ===
    @iOSXCUITFindBy(accessibility = "FORGOT PASSWORD")
    public WebElement lblForgotPasswordHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`placeholderValue == 'Email'`]")
    public WebElement txtEmail;

    @iOSXCUITFindBy(accessibility = "SEND MESSAGE")
    public WebElement btnSendMessage;

    // === INVALID EMAIL VALIDATION ===
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'We couldn’t find an account'")
    public WebElement lblInvalidEmailMessage;

    // === OTP INPUT BOXES (6 digits) ===
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    public List<WebElement> otpBoxes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
    public WebElement otpBox1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
    public WebElement otpBox2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[3]")
    public WebElement otpBox3;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[4]")
    public WebElement otpBox4;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[5]")
    public WebElement otpBox5;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[6]")
    public WebElement otpBox6;

    // === OTP ERROR DIALOG ===
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'Invalid or expired OTP'")
    public WebElement lblOtpErrorMessage;

    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement btnOkInOtpDialog;

    // === FALLBACKS ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='FORGOT PASSWORD']")
    public WebElement lblForgotPasswordHeader_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@placeholder='Email']")
    public WebElement txtEmail_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SEND MESSAGE']")
    public WebElement btnSendMessage_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    public WebElement btnOkInOtpDialog_XPath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Invalid or expired OTP')]")
    public WebElement lblOtpErrorMessage_XPath;

    // ===================================================================
    // 1. Verify Page is Displayed
    // ===================================================================
    public PG_010_ForgotPasswordPage Verify_Forgot_Password_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement header = isDisplayedSafe(lblForgotPasswordHeader) ? lblForgotPasswordHeader : lblForgotPasswordHeader_XPath;
            if (header.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - FORGOT PASSWORD page is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Header not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Enter Email
    // ===================================================================
    public PG_010_ForgotPasswordPage Enter_Email(String email) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement field = isDisplayedSafe(txtEmail) ? txtEmail : txtEmail_XPath;
            field.click();
            field.clear();
            field.sendKeys(email);
            mobileActions.hideKeyboard();
            ExtentReportManager.info(methodName + " - Entered email: " + email);
            TestContext.getLogger().info(methodName + " - Email: " + email);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to enter email");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click Send Message
    // ===================================================================
    public PG_010_ForgotPasswordPage Click_On_Send_Message() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement button = isDisplayedSafe(btnSendMessage) ? btnSendMessage : btnSendMessage_XPath;
            button.click();
            ExtentReportManager.info(methodName + " - Clicked SEND MESSAGE");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click SEND MESSAGE");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Verify Invalid Email Message
    // ===================================================================
    public PG_010_ForgotPasswordPage Verify_Invalid_Email_Message_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement msg = isDisplayedSafe(lblInvalidEmailMessage) ? lblInvalidEmailMessage : null;
            if (msg != null && msg.isDisplayed()) {
                String text = msg.getAttribute("name");
                ExtentReportManager.pass(methodName + " - Invalid email message: " + text);
                TestContext.getLogger().info(methodName + " - Invalid email message visible");
            } else {
                throw new Exception("Invalid email message not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Invalid email message NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Enter OTP (6 digits)
    // ===================================================================
    public PG_010_ForgotPasswordPage Enter_OTP(String otp) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            if (otp.length() != 6) throw new IllegalArgumentException("OTP must be 6 digits");

            for (int i = 0; i < 6; i++) {
                WebElement box = otpBoxes.get(i);
                box.click();
                box.clear();
                box.sendKeys(String.valueOf(otp.charAt(i)));
                TestContext.getLogger().info("Entered OTP digit: " + otp.charAt(i) + " in box " + (i + 1));
            }
            ExtentReportManager.pass(methodName + " - OTP entered: " + otp);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to enter OTP");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Verify OTP Error Dialog
    // ===================================================================
    public PG_010_ForgotPasswordPage Verify_Otp_Error_Dialog_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement msg = isDisplayedSafe(lblOtpErrorMessage) ? lblOtpErrorMessage : lblOtpErrorMessage_XPath;
            if (msg.isDisplayed()) {
                String text = msg.getAttribute("name");
                ExtentReportManager.pass(methodName + " - OTP Error: " + text);
                TestContext.getLogger().info(methodName + " - OTP error dialog visible");
            } else {
                throw new Exception("OTP error dialog not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - OTP error dialog NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 7. Click OK in OTP Error Dialog
    // ===================================================================
    public PG_010_ForgotPasswordPage Click_Ok_In_Otp_Error_Dialog() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement okBtn = isDisplayedSafe(btnOkInOtpDialog) ? btnOkInOtpDialog : btnOkInOtpDialog_XPath;
            okBtn.click();
            ExtentReportManager.info(methodName + " - Clicked OK in OTP error dialog");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click OK");
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