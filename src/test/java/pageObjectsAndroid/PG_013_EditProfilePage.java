package pageObjectsAndroid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_013_EditProfilePage extends BaseClass {

    public PG_013_EditProfilePage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ==================== MAIN PROFILE FIELDS ====================

    // 1. Profile Pic Pencil Icon
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[8,69][104,165]']")
    public WebElement iconProfilePencil;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@bounds, '8,69') and contains(@bounds, '104,165')]")
    public WebElement iconProfilePencil_XPath;

    // 2. Name Field
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Ramesh Aravindh']")
    public WebElement txtName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@bounds='[46,468][674,598]']")
    public WebElement txtName_XPath;

    // 3. Email Field
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='ramesh@navadhiti.com']")
    public WebElement txtEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@bounds='[46,606][674,736]']")
    public WebElement txtEmail_XPath;

    // 4. Date of Birth Field (Trigger)
    @AndroidFindBy(xpath = "//android.view.View[@bounds='[46,744][674,874]']")
    public WebElement fieldDOB;

    @AndroidFindBy(accessibility = "SELECT DATE OF BIRTH")
    public WebElement lblSelectDOB;

    // 5. Gender Field (Trigger)
    @AndroidFindBy(accessibility = "Gender")
    public WebElement btnGender;

    @AndroidFindBy(xpath = "//android.widget.Button[@bounds='[46,881][674,1011]']")
    public WebElement btnGender_XPath;

    // 6. Country Code + Phone
    @AndroidFindBy(xpath = "//android.view.View[@content-desc[contains(., '+')]]")
    public WebElement btnCountryCode;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Phone Number']")
    public WebElement txtPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@bounds='[64,1037][656,1131]']")
    public WebElement txtPhoneNumber_XPath;

    // 7. Change Password
    @AndroidFindBy(accessibility = "CHANGE PASSWORD")
    public WebElement btnChangePassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@bounds='[46,1342][674,1436]']")
    public WebElement btnChangePassword_XPath;

    // 8. Save Changes
    @AndroidFindBy(accessibility = "SAVE CHANGES")
    public WebElement btnSaveChanges;

    @AndroidFindBy(xpath = "//android.widget.Button[@bounds='[46,1452][674,1546]']")
    public WebElement btnSaveChanges_XPath;

    // ==================== DOB POPUP (SEEK BARS) ====================

    @AndroidFindBy(accessibility = "07")
    public WebElement seekBarDay;

    @AndroidFindBy(accessibility = "11")
    public WebElement seekBarMonth;

    @AndroidFindBy(accessibility = "2025")
    public WebElement seekBarYear;

    // Separate XPaths for SeekBars
    @AndroidFindBy(xpath = "//android.widget.SeekBar[@bounds='[122,699][262,947]']")
    public WebElement seekBarDay_XPath;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@bounds='[290,699][430,947]']")
    public WebElement seekBarMonth_XPath;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@bounds='[458,699][598,947]']")
    public WebElement seekBarYear_XPath;

    @AndroidFindBy(accessibility = "CONFIRM")
    public WebElement btnDOBConfirm;

    @AndroidFindBy(accessibility = "CANCEL")
    public WebElement btnDOBCancel;

    // ==================== GENDER POPUP ====================

    @AndroidFindBy(accessibility = "Male")
    public WebElement optGenderMale;

    @AndroidFindBy(accessibility = "Female")
    public WebElement optGenderFemale;

    @AndroidFindBy(accessibility = "Other")
    public WebElement optGenderOther;

    // ==================== COUNTRY PICKER (DYNAMIC) ====================

    // Dynamic: Select any country by visible text
    public WebElement getCountryOption(String countryName) {
        return TestContext.getDriver().findElement(By.xpath(
            String.format("//android.widget.Button[@content-desc[contains(., '%s')]]", countryName)
        );
    }

    // Example: India
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc[contains(., 'India') and contains(., '+91')]]")
    public WebElement optCountryIndia;

    // ==================== DISMISS OVERLAY (Popup Background) ====================

    @AndroidFindBy(contentDescription = "Dismiss")
    public WebElement overlayDismiss;

    // ===================================================================
    // 1. Verify Edit Profile Page is Displayed
    // ===================================================================
    public PG_013_EditProfilePage Verify_Edit_Profile_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement name = isDisplayedSafe(txtName) ? txtName : txtName_XPath;
            if (name.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - Edit Profile page is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Name field not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click Profile Pencil Icon
    // ===================================================================
    public PG_013_EditProfilePage Click_Profile_Pencil_Icon() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(iconProfilePencil) ? iconProfilePencil : iconProfilePencil_XPath;
            el.click();
            ExtentReportManager.pass(methodName + " - Clicked Profile Pencil");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Enter Name
    // ===================================================================
    public PG_013_EditProfilePage Enter_Name(String name) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(txtName) ? txtName : txtName_XPath;
            el.clear();
            el.sendKeys(name);
            ExtentReportManager.pass(methodName + " - Entered Name: " + name);
            TestContext.getLogger().info(methodName + ": " + name);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Enter Email
    // ===================================================================
    public PG_013_EditProfilePage Enter_Email(String email) {
        String method19 = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(txtEmail) ? txtEmail : txtEmail_XPath;
            el.clear();
            el.sendKeys(email);
            ExtentReportManager.pass(method19 + " - Entered Email: " + email);
            TestContext.getLogger().info(method19 + ": " + email);
        } catch (Exception e) {
            ExtentReportManager.fail(method19 + " - Failed");
            TestContext.getLogger().error(method19, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click DOB Field → Opens Popup
    // ===================================================================
    public PG_013_EditProfilePage Click_Date_Of_Birth_Field() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            fieldDOB.click();
            waitForElementVisible(btnDOBConfirm, 10);
            ExtentReportManager.pass(methodName + " - DOB popup opened");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to open DOB");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Set DOB: Day, Month, Year via SeekBars
    // ===================================================================
    public PG_013_EditProfilePage Set_DOB_Using_SeekBars(int day, int month, int year) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            // SeekBar doesn't support sendKeys → Use Touch Actions
            swipeSeekBar(seekBarDay_XPath, day, 1, 31);
            swipeSeekBar(seekBarMonth_XPath, month, 1, 12);
            swipeSeekBar(seekBarYear_XPath, year, 1900, 2025);

            ExtentReportManager.pass(methodName + " - Set DOB: " + day + "/" + month + "/" + year);
            TestContext.getLogger().info(methodName + ": " + day + "/" + month + "/" + year);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to set DOB");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 7. Confirm DOB
    // ===================================================================
    public PG_013_EditProfilePage Click_DOB_Confirm() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnDOBConfirm.click();
            ExtentReportManager.pass(methodName + " - DOB Confirmed");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    public PG_013_EditProfilePage Click_DOB_Cancel() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnDOBCancel.click();
            ExtentReportManager.pass(methodName + " - DOB Cancelled");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 8. Click Gender → Opens Popup
    // ===================================================================
    public PG_013_EditProfilePage Click_Gender_Field() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(btnGender) ? btnGender : btnGender_XPath;
            el.click();
            waitForElementVisible(optGenderMale, 10);
            ExtentReportManager.pass(methodName + " - Gender popup opened");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 9. Select Gender
    // ===================================================================
    public PG_013_EditProfilePage Select_Gender(String gender) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement option = null;
            switch (gender.toLowerCase()) {
                case "male": option = optGenderMale; break;
                case "female": option = optGenderFemale; break;
                case "other": option = optGenderOther; break;
            }
            if (option != null && option.isDisplayed()) {
                option.click();
                ExtentReportManager.pass(methodName + " - Selected Gender: " + gender);
                TestContext.getLogger().info(methodName + ": " + gender);
            } else {
                throw new Exception("Gender option not found: " + gender);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 10. Click Country Code → Opens List
    // ===================================================================
    public PG_013_EditProfilePage Click_Country_Code() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnCountryCode.click();
            waitForElementVisible(optCountryIndia, 10);
            ExtentReportManager.pass(methodName + " - Country list opened");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 11. Select Country (Dynamic)
    // ===================================================================
    public PG_013_EditProfilePage Select_Country(String countryName) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement country = getCountryOption(countryName);
            scrollToElement(country);
            country.click();
            ExtentReportManager.pass(methodName + " - Selected Country: " + countryName);
            TestContext.getLogger().info(methodName + ": " + countryName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 12. Enter Phone Number
    // ===================================================================
    public PG_013_EditProfilePage Enter_Phone_Number(String phone) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(txtPhoneNumber) ? txtPhoneNumber : txtPhoneNumber_XPath;
            el.clear();
            el.sendKeys(phone);
            ExtentReportManager.pass(methodName + " - Entered Phone: " + phone);
            TestContext.getLogger().info(methodName + ": " + phone);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 13. Click Change Password
    // ===================================================================
    public PG_013_EditProfilePage Click_Change_Password() {
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
    // 14. Click Save Changes
    // ===================================================================
    public PG_013_EditProfilePage Click_Save_Changes() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement el = isDisplayedSafe(btnSaveChanges) ? btnSaveChanges : btnSaveChanges_XPath;
            el.click();
            ExtentReportManager.pass(methodName + " - Clicked Save Changes");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
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

    // ===================================================================
    // Helper: Swipe SeekBar (Day/Month/Year)
    // ===================================================================
    private void swipeSeekBar(WebElement seekBar, int targetValue, int min, int max) {
        int width = seekBar.getSize().getWidth();
        int height = seekBar.getLocation().getY();
        int xStart = seekBar.getLocation().getX();
        int xEnd = xStart + width;

        int progress = (int) (((double)(targetValue - min) / (max - min)) * 100);
        int targetX = xStart + (int)(width * progress / 100.0);

        touchAction.press(xStart + width / 2, height + 50)
                    .waitAction(waitOptions().withDuration(ofMillis(600)))
                    .moveTo(targetX, height + 50)
                    .release().perform();
    }
}