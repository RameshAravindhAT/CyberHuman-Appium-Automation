package pageObjectsiOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
    @iOSXCUITFindBy(accessibility = "edit_profile_icon")
    public WebElement iconProfilePencil;

    // 2. Name Field
    @iOSXCUITFindBy(accessibility = "name_field")
    public WebElement txtName;

    // 3. Email Field
    @iOSXCUITFindBy(accessibility = "email_field")
    public WebElement txtEmail;

    // 4. Date of Birth Field (Trigger)
    @iOSXCUITFindBy(accessibility = "dob_field")
    public WebElement fieldDOB;

    @iOSXCUITFindBy(accessibility = "SELECT DATE OF BIRTH")
    public WebElement lblSelectDOB;

    // 5. Gender Field (Trigger)
    @iOSXCUITFindBy(accessibility = "Gender")
    public WebElement btnGender;

    // 6. Country Code + Phone
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, '+')]")
    public WebElement btnCountryCode;

    @iOSXCUITFindBy(accessibility = "Phone Number")
    public WebElement txtPhoneNumber;

    // 7. Change Password
    @iOSXCUITFindBy(accessibility = "CHANGE PASSWORD")
    public WebElement btnChangePassword;

    // 8. Save Changes
    @iOSXCUITFindBy(accessibility = "SAVE CHANGES")
    public WebElement btnSaveChanges;

    // ==================== DOB POPUP (PICKER WHEELS) ====================

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]") // Day
    public WebElement pickerDay;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]") // Month
    public WebElement pickerMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[3]") // Year
    public WebElement pickerYear;

    @iOSXCUITFindBy(accessibility = "CONFIRM")
    public WebElement btnDOBConfirm;

    @iOSXCUITFindBy(accessibility = "CANCEL")
    public WebElement btnDOBCancel;

    // ==================== GENDER POPUP ====================

    @iOSXCUITFindBy(accessibility = "Male")
    public WebElement optGenderMale;

    @iOSXCUITFindBy(accessibility = "Female")
    public WebElement optGenderFemale;

    @iOSXCUITFindBy(accessibility = "Other")
    public WebElement optGenderOther;

    // ==================== COUNTRY PICKER (DYNAMIC) ====================

    public WebElement getCountryOption(String countryName) {
        return TestContext.getDriver().findElement(
            String.format("//XCUIElementTypeButton[@name[contains(., '%s')]]", countryName)
        );
    }

    // Example: India
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name[contains(., 'India') and contains(., '+91')]]")
    public WebElement optCountryIndia;

    // ==================== DISMISS OVERLAY ====================

    @iOSXCUITFindBy(accessibility = "Dismiss")
    public WebElement overlayDismiss;

    // ===================================================================
    // 1. Verify Edit Profile Page is Displayed
    // ===================================================================
    public PG_013_EditProfilePage Verify_Edit_Profile_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            if (txtName.isDisplayed()) {
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
            iconProfilePencil.click();
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
            txtName.clear();
            txtName.sendKeys(name);
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
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            txtEmail.clear();
            txtEmail.sendKeys(email);
            ExtentReportManager.pass(methodName + " - Entered Email: " + email);
            TestContext.getLogger().info(methodName + ": " + email);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click DOB Field → Opens Picker
    // ===================================================================
    public PG_013_EditProfilePage Click_Date_Of_Birth_Field() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            fieldDOB.click();
            waitForElementVisible(btnDOBConfirm, 10);
            ExtentReportManager.pass(methodName + " - DOB picker opened");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to open DOB");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Set DOB Using Picker Wheels (iOS Native)
    // ===================================================================
    public PG_013_EditProfilePage Set_DOB_Using_Picker(int day, int month, int year) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            // iOS PickerWheel: sendKeys scrolls to value
            pickerDay.sendKeys(String.valueOf(day));
            pickerMonth.sendKeys(String.valueOf(month));
            pickerYear.sendKeys(String.valueOf(year));

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
            btnGender.click();
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
            WebElement option = nullSwitch(gender.toLowerCase()) {
                case "male" -> optGenderMale;
                case "female" -> optGenderFemale;
                case "other" -> optGenderOther;
                default -> throw new IllegalArgumentException("Invalid gender: " + gender);
            };
            option.click();
            ExtentReportManager.pass(methodName + " - Selected Gender: " + gender);
            TestContext.getLogger().info(methodName + ": " + gender);
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
            txtPhoneNumber.clear();
            txtPhoneNumber.sendKeys(phone);
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

    // ===================================================================
    // 14. Click Save Changes
    // ===================================================================
    public PG_013_EditProfilePage Click_Save_Changes() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnSaveChanges.click();
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
}