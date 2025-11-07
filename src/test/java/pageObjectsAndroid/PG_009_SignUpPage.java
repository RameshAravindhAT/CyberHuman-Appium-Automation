package pageObjectsAndroid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_009_SignUpPage extends BaseClass {

    public PG_009_SignUpPage(WebDriver driver) {
    	TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // 1️⃣ Sign Up Header (Accessibility ID = SIGN UP)
    @AndroidFindBy(accessibility = "SIGN UP")
    public WebElement lblSignUpHeader;

    // 2️⃣ Name Input Field
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Name']")
    public WebElement txtName;

    // 3️⃣ Email Input Field
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Email']")
    public WebElement txtEmail;

    // 4️⃣ Select Country
    @AndroidFindBy(accessibility = "Country")
    public WebElement btnCountry;

    // 5️⃣ Password Field
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Password']")
    public WebElement txtPassword;

    // 6️⃣ Confirm Password Field
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Confirm Password']")
    public WebElement txtConfirmPassword;

    // 7️⃣ Sign In Link (Already have an account)
    @AndroidFindBy(accessibility = "Already have an account? Sign in")
    public WebElement linkSignIn;

    // 8️⃣ Privacy / Terms Checkbox
    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement chkPrivacy;

    // 9️⃣ Continue Button
    @AndroidFindBy(accessibility = "CONTINUE")
    public WebElement btnContinue;

    // ===================================================================
    // METHODS FOLLOWING YOUR NAMING & LOGGING PATTERN
    // ===================================================================




    public PG_009_SignUpPage Verify_Sign_Up_Header_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {

        	PG_002_SignInPage signInPage = new PG_002_SignInPage(TestContext.getDriver());

        	signInPage.Click_On_SignUp();

        	Thread.sleep(2000);

            if (lblSignUpHeader.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - Sign Up header is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Sign Up header is not displayed");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed", e);
            throw new RuntimeException(e);
        }
        return this;
    }



    public PG_009_SignUpPage Enter_Name(String name) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	txtName.click();
            txtName.clear();
            txtName.sendKeys(name);
            ExtentReportManager.info(methodName + " - Entered name: " + name);
            TestContext.getLogger().info(methodName + " - Name: " + name);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter name", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_009_SignUpPage Enter_Email(String email) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	txtEmail.click();
            txtEmail.clear();
            txtEmail.sendKeys(email);
            ExtentReportManager.info(methodName + " - Entered email: " + email);
            TestContext.getLogger().info(methodName + " - Email: " + email);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter email", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_009_SignUpPage Click_and_Select_the_Country(String country) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnCountry.click();
            ExtentReportManager.info(methodName + " - Opened country picker");



            By countryLocator = By.xpath("//*[@content-desc='" + country + "']");

            mobileActions.scrollToText(country);

//            boolean selected = mobileActions.SwipeFromDropdown(
//                "xpath://android.view.View[@scrollable='true']",
//                countryLocator,
//                "up"
//            );
//
//            if (!selected) {
//                throw new RuntimeException("Failed to select: " + country);
//            }
//
//            ExtentReportManager.pass(methodName + " - Selected: " + country);
//            TestContext.getLogger().info(methodName + " - Success");

        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_009_SignUpPage Enter_Password(String password) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	txtPassword.click();
            txtPassword.clear();
            txtPassword.sendKeys(password);
            ExtentReportManager.info(methodName + " - Password entered");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter password", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_009_SignUpPage Enter_Confirm_Password(String confirmPassword) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
        	txtConfirmPassword.click();
            txtConfirmPassword.clear();
            txtConfirmPassword.sendKeys(confirmPassword);
            ExtentReportManager.info(methodName + " - Confirm password entered");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter confirm password", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_009_SignUpPage Click_On_Sign_In_Link() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            linkSignIn.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);

            // Optional: Return Sign In page if navigation happens
            return this;
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click Sign In link", e);
            throw new RuntimeException(e);
        }
    }

    public PG_009_SignUpPage Click_On_Privacy_Checkbox() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            if (!chkPrivacy.isSelected()) {
                chkPrivacy.click();
            }
            ExtentReportManager.info(methodName + " - Privacy checkbox checked");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to check privacy checkbox", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_009_SignUpPage Click_On_Continue_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnContinue.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);

            // Optionally return next page (e.g., OTP or Dashboard)
            // return new PG_XXX_NextPage(TestContext.getDriver());
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click CONTINUE", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // Bonus: Full Sign-Up Flow Method (Optional)
    public PG_009_SignUpPage Fill_Sign_Up_Form(String name, String email, String countryName, String password, String confirmPassword) {
        return this
            .Verify_Sign_Up_Header_Displayed()
            .Enter_Name(name)
            .Enter_Email(email)
            .Click_and_Select_the_Country(countryName)
            .Enter_Password(password)
            .Enter_Confirm_Password(confirmPassword)
            .Click_On_Privacy_Checkbox()
            .Click_On_Continue_Button();
    }
}