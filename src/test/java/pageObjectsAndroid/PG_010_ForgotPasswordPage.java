package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
    @AndroidFindBy(accessibility = "FORGOT PASSWORD")
    public WebElement lblForgotPasswordHeader;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Email']")
    public WebElement txtEmail;

    @AndroidFindBy(accessibility = "SEND MESSAGE")
    public WebElement btnSendMessage;

    // === INVALID EMAIL VALIDATION ===
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'We couldn’t find an account with that email')]")
    public WebElement lblInvalidEmailMessage;

    // === OTP INPUT BOXES (6 digits) ===
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public List<WebElement> otpBoxes;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement otpBox1;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public WebElement otpBox2;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    public WebElement otpBox3;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
    public WebElement otpBox4;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
    public WebElement otpBox5;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[6]")
    public WebElement otpBox6;

    // === OTP ERROR DIALOG ===
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Invalid or expired OTP')]")
    public WebElement lblOtpErrorMessage;

    @AndroidFindBy(accessibility = "OK")
    public WebElement btnOkInOtpDialog;

    // === FALLBACKS ===
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='FORGOT PASSWORD']")
    public WebElement lblForgotPasswordHeader_XPath;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SEND MESSAGE']")
    public WebElement btnSendMessage_XPath;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='OK']")
    public WebElement btnOkInOtpDialog_XPath;

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
            txtEmail.click();
            txtEmail.clear();
            txtEmail.sendKeys(email);
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
            if (lblInvalidEmailMessage.isDisplayed()) {
                String text = lblInvalidEmailMessage.getAttribute("content-desc");
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
            if (lblOtpErrorMessage.isDisplayed()) {
                String text = lblOtpErrorMessage.getAttribute("content-desc");
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