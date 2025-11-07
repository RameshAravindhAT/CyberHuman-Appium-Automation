package pageObjectsAndroid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_002_SignInPage  extends BaseClass {

    public PG_002_SignInPage(WebDriver webDriver) {
    	TestContext.setDriver(webDriver);
        PageFactory.initElements(new AppiumFieldDecorator(webDriver), this);
    }

 // ✅ Locators using Accessibility ID
    @AndroidFindBy(accessibility = "SIGN IN")
    public WebElement SignInTitle;


 // ✅ Email input field (Hint = "Email" but no accessibility-id available → use xpath)
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Email']")
    public WebElement txtEmail;

    // ✅ Password input field (password='true' → no accessibility-id → use xpath)
    @AndroidFindBy(xpath = "//android.widget.EditText[@password='true']")
    public WebElement txtPassword;

    // ✅ Forgot Password button
    @AndroidFindBy(accessibility = "Forgot Password?")
    public WebElement btnForgotPassword;

    // ✅ Sign Up (Don't have an account? Sign up)
    @AndroidFindBy(accessibility = "Don't have an account? Sign up")
    public WebElement btnSignUp;

    // ✅ Continue button
    @AndroidFindBy(accessibility = "CONTINUE")
    public WebElement btnContinue;

    // ✅ Continue with Apple
    @AndroidFindBy(accessibility = "CONTINUE WITH APPLE")
    public WebElement btnContinueWithApple;

    // ✅ Continue with Google
    @AndroidFindBy(accessibility = "CONTINUE WITH GOOGLE")
    public WebElement btnContinueWithGoogle;


    public By toastOrErrorMessage = By.xpath("//android.view.View[contains(@content-desc,'')]");

    @AndroidFindBy(accessibility = "GET STARTED")
    public WebElement btnGetStarted;


 public PG_002_SignInPage Verify_Sign_In_Title_Displayed() {
     String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
     try {
         // Wait for visibility (optional but recommended)
         wait = new WebDriverWait(TestContext.getDriver(), Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(SignInTitle));

         if (SignInTitle.isDisplayed()) {
             String actualText = SignInTitle.getAttribute("content-desc");
             ExtentReportManager.info(methodName + " - Title: '" + actualText + "' is displayed");
             TestContext.getLogger().info(methodName + " - SIGN IN title is visible");
         } else {
             throw new Exception("SIGN IN title is not displayed");
         }
     } catch (Exception e) {
         ExtentReportManager.fail(methodName + " - SIGN IN title NOT visible");
         TestContext.getLogger().error(methodName + " - Failed to verify SIGN IN title", e);
         throw new RuntimeException("SIGN IN title assertion failed", e);
     }
     return this;
 }



    public PG_002_SignInPage Click_On_Get_Started_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	ExtentReportManager.info("Navigated to AB CHOPRA EPIGENETICS Start up Screen");
            Thread.sleep(3000);
            btnGetStarted.click();
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


    // ✅ Enter Email
    public PG_002_SignInPage Enter_the_Email(String email) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	txtEmail.click();
            txtEmail.clear();
            txtEmail.sendKeys(email);
            ExtentReportManager.info(methodName +" "+ email);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter email", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Enter Password
    public PG_002_SignInPage Enter_the_Password(String password) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	txtPassword.click();
            txtPassword.clear();
            txtPassword.sendKeys(password);
            mobileActions.hideKeyboard();
            ExtentReportManager.info(methodName  +" "+ password);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter password", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Click CONTINUE button
    public PG_002_SignInPage Click_On_Continue() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnContinue.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click CONTINUE", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Click Forgot Password
    public PG_002_SignInPage Click_On_Forgot_Password() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnForgotPassword.click();
            ExtentReportManager.info(methodName );
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click Forgot Password", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Click Sign Up
    public PG_002_SignInPage Click_On_SignUp() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnSignUp.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click Sign Up", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_003_TwoFactorAuthenticationPage Verify_The_Result(String Scenario, String expectedMessage) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
//            WebElement messageElement = TestContext.getDriver().findElement(
//                    By.xpath("//android.view.View[contains(@content-desc,'" + expectedMessage + "')]"));

            if (Scenario.equalsIgnoreCase("Positive") || expectedMessage.equalsIgnoreCase("Success")) {



                // ✅ Properly pass driver while creating TwoFA page object
                PG_003_TwoFactorAuthenticationPage twoFA = new PG_003_TwoFactorAuthenticationPage((AppiumDriver) TestContext.getDriver());

                // ✅ Assert Important Elements on Two-Factor Page
                twoFA.Verify_TwoFactor_Header_Displayed()
                     .Verify_MFA_Question_Displayed()
                     .Click_On_No(); // ✅ Click "No"

                PG_004_LinkDevicePage linkDevicePage = new PG_004_LinkDevicePage((AppiumDriver) TestContext.getDriver());

                // ✅ Assert Link Device Screen Elements & Continue
                linkDevicePage.Verify_LinkDevices_Title_Displayed()
                              .Verify_Description_Displayed()
                              .Click_On_Continue();

                PG_005_DailyPriorityPage dailyPage =
                        new PG_005_DailyPriorityPage((AppiumDriver) TestContext.getDriver());

                dailyPage.Verify_Daily_Priority_Page_Displayed()
                         .Verify_Current_Date_Time()
                         .Verify_Session_Based_On_Time()
                         .Verify_User_Name("RAMESH ARAVINDH")  // <-- you can pass dynamically if needed
                         .Click_On_Proceed();

                PG_000_DashboardModulePage dashboardModulePage = new PG_000_DashboardModulePage(
						(AppiumDriver) TestContext.getDriver());

                dashboardModulePage
						.swipe_Up_WellBeing_Dashboard().Click_On_Profile_Tab();


				PG_007_ProfilePage profilePage = new PG_007_ProfilePage((AppiumDriver) TestContext.getDriver());

				profilePage.Click_On_Log_Out();


				PG_008_LogOutPage logOutPage = new PG_008_LogOutPage((AppiumDriver) TestContext.getDriver());

				logOutPage.Click_On_Yes();

            }

            else if (Scenario.equalsIgnoreCase("NegativeEmail")) {
                WebElement errorMsg = TestContext.getDriver().findElement(
                        By.xpath("//android.view.View[@content-desc='Invalid email. Please check your credentials and try again.']"));

                if (errorMsg.isDisplayed()) {
                    ExtentReportManager.pass(methodName + expectedMessage);
                    TestContext.getLogger().info("Invalid Email validation passed");
                }
            }

            // ✅ Negative Password Validation
            else if (Scenario.equalsIgnoreCase("NegativePassword")) {
                WebElement errorMsg = TestContext.getDriver().findElement(
                        By.xpath("//android.view.View[@content-desc='Invalid email or password. Please check your credentials and try again.']"));

                if (errorMsg.isDisplayed()) {
                    ExtentReportManager.pass(methodName + expectedMessage);
                    TestContext.getLogger().info("Invalid Password validation passed");
                }
            }
        }
             catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Expected message NOT displayed: " + expectedMessage);
        }
        return new PG_003_TwoFactorAuthenticationPage((AppiumDriver) TestContext.getDriver());
    }


    // ✅ Click Continue with Apple
    public PG_002_SignInPage Click_On_Continue_With_Apple() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnContinueWithApple.click();
            ExtentReportManager.info(methodName + " - Clicked on Continue with Apple");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click Continue with Apple", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Click Continue with Google
    public PG_002_SignInPage Click_On_Continue_With_Google() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnContinueWithGoogle.click();
            ExtentReportManager.info(methodName + " - Clicked on Continue with Google");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click Continue with Google", e);
            throw new RuntimeException(e);
        }
        return this;
    }
}
