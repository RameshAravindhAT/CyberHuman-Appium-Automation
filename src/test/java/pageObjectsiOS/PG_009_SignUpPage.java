package pageObjectsiOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_009_SignUpPage extends BaseClass {

    public PG_009_SignUpPage(WebDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === Primary Locators (iOS) ===
    @iOSXCUITFindBy(accessibility = "SIGN UP")
    public WebElement lblSignUpHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`placeholderValue == 'Name'`]")
    public WebElement txtName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`placeholderValue == 'Email'`]")
    public WebElement txtEmail;

    @iOSXCUITFindBy(accessibility = "Country")
    public WebElement btnCountry;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`placeholderValue == 'Password'`]")
    public WebElement txtPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`placeholderValue == 'Confirm Password'`]")
    public WebElement txtConfirmPassword;

    @iOSXCUITFindBy(accessibility = "Already have an account? Sign in")
    public WebElement linkSignIn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch")
    public WebElement chkPrivacy;

    @iOSXCUITFindBy(accessibility = "CONTINUE")
    public WebElement btnContinue;

    // === Fallback Locators (iOS) ===
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SIGN UP']")
    public WebElement lblSignUpHeaderXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Name' or @placeholder='Name']")
    public WebElement txtNameXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Email' or @placeholder='Email']")
    public WebElement txtEmailXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Country']")
    public WebElement btnCountryXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
    public WebElement txtPasswordXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
    public WebElement txtConfirmPasswordXpath;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUE']")
    public WebElement btnContinueXpath;

    // ===================================================================
    // 1. Verify Sign Up Header
    // ===================================================================
    public PG_009_SignUpPage Verify_Sign_Up_Header_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            Thread.sleep(2000);
            WebElement header = isDisplayedSafe(lblSignUpHeader) ? lblSignUpHeader : lblSignUpHeaderXpath;
            if (header.isDisplayed()) {
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

    // ===================================================================
    // 2. Enter Name
    // ===================================================================
    public PG_009_SignUpPage Enter_Name(String name) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement field = isDisplayedSafe(txtName) ? txtName : txtNameXpath;
            field.click();
            field.clear();
            field.sendKeys(name);
            mobileActions.hideKeyboard();
            ExtentReportManager.info(methodName + " - Entered name: " + name);
            TestContext.getLogger().info(methodName + " - Name: " + name);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter name", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Enter Email
    // ===================================================================
    public PG_009_SignUpPage Enter_Email(String email) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement field = isDisplayedSafe(txtEmail) ? txtEmail : txtEmailXpath;
            field.click();
            field.clear();
            field.sendKeys(email);
            mobileActions.hideKeyboard();
            ExtentReportManager.info(methodName + " - Entered email: " + email);
            TestContext.getLogger().info(methodName + " - Email: " + email);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter email", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click & Select Country (iOS Picker Wheel)
    // ===================================================================
    public PG_009_SignUpPage Click_and_Select_the_Country(String country) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement countryBtn = isDisplayedSafe(btnCountry) ? btnCountry : btnCountryXpath;
            countryBtn.click();
            ExtentReportManager.info(methodName + " - Opened country picker");

            // iOS uses XCUIElementTypePickerWheel
            By countryLocator = By.xpath("//XCUIElementTypePickerWheel[@name='" + country + "']");
            WebElement picker = TestContext.getDriver().findElement(countryLocator);

            // Tap and select via picker wheel
            picker.sendKeys(country);
            mobileActions.hideKeyboard();

            ExtentReportManager.pass(methodName + " - Selected: " + country);
            TestContext.getLogger().info(methodName + " - Country selected: " + country);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to select country: " + country);
            TestContext.getLogger().error(methodName + " - Failed", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Enter Password
    // ===================================================================
    public PG_009_SignUpPage Enter_Password(String password) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement field = isDisplayedSafe(txtPassword) ? txtPassword : txtPasswordXpath;
            field.click();
            field.clear();
            field.sendKeys(password);
            mobileActions.hideKeyboard();
            ExtentReportManager.info(methodName + " - Password entered");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter password", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Enter Confirm Password
    // ===================================================================
    public PG_009_SignUpPage Enter_Confirm_Password(String confirmPassword) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement field = isDisplayedSafe(txtConfirmPassword) ? txtConfirmPassword : txtConfirmPasswordXpath;
            field.click();
            field.clear();
            field.sendKeys(confirmPassword);
            mobileActions.hideKeyboard();
            ExtentReportManager.info(methodName + " - Confirm password entered");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to enter confirm password", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 7. Click Sign In Link
    // ===================================================================
    public PG_009_SignUpPage Click_On_Sign_In_Link() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            linkSignIn.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click Sign In link", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 8. Click Privacy Checkbox (iOS uses Switch)
    // ===================================================================
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

    // ===================================================================
    // 9. Click Continue Button
    // ===================================================================
    public PG_009_SignUpPage Click_On_Continue_Button() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement continueBtn = isDisplayedSafe(btnContinue) ? btnContinue : btnContinueXpath;
            continueBtn.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click CONTINUE", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // Bonus: Full Sign-Up Flow
    // ===================================================================
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