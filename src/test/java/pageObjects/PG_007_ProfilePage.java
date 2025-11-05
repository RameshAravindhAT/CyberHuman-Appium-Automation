package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_007_ProfilePage extends BaseClass {

    // Constructor
    public PG_007_ProfilePage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    // === Page Elements ===
    @AndroidFindBy(accessibility = "PROFILE")
    public WebElement profileTitle;

    @AndroidFindBy(accessibility = "RAMESH ARAVINDH")
    public WebElement userNameLabel;

    @AndroidFindBy(accessibility = "ACCOUNT")
    public WebElement accountButton;

    @AndroidFindBy(accessibility = "MY ORDERS")
    public WebElement myOrdersButton;

    @AndroidFindBy(accessibility = "HELP & SUPPORT")
    public WebElement helpSupportButton;

    @AndroidFindBy(accessibility = "LEGAL INFORMATION")
    public WebElement legalInfoButton;

    @AndroidFindBy(accessibility = "LOG OUT")
    public WebElement logOutButton;

    // Fallback XPaths (for stability)
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='PROFILE']")
    public WebElement profileTitleXpath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='RAMESH ARAVINDH']")
    public WebElement userNameLabelXpath;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ACCOUNT']")
    public WebElement accountButtonXpath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='MY ORDERS']")
    public WebElement myOrdersButtonXpath;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='HELP & SUPPORT']")
    public WebElement helpSupportButtonXpath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='LEGAL INFORMATION']")
    public WebElement legalInfoButtonXpath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='LOG OUT']")
    public WebElement logOutButtonXpath;

    // Bottom Tab (for navigation verification)
    @AndroidFindBy(accessibility = "WELLBEING \nDASHBOARD\nPROFILE")
    public WebElement bottomProfileTab;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'PROFILE')]")
    public WebElement bottomProfileTabXpath;

    // ===================================================================
    // 1. Click ACCOUNT
    // ===================================================================
    public PG_007_ProfilePage Click_On_Account() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = accountButton.isDisplayed() ? accountButton : accountButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click ACCOUNT", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click MY ORDERS
    // ===================================================================
    public PG_007_ProfilePage Click_On_My_Orders() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = myOrdersButton.isDisplayed() ? myOrdersButton : myOrdersButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click MY ORDERS", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click HELP & SUPPORT
    // ===================================================================
    public PG_007_ProfilePage Click_On_Help_And_Support() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = helpSupportButton.isDisplayed() ? helpSupportButton : helpSupportButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click HELP & SUPPORT", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click LEGAL INFORMATION
    // ===================================================================
    public PG_007_ProfilePage Click_On_Legal_Information() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = legalInfoButton.isDisplayed() ? legalInfoButton : legalInfoButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click LEGAL INFORMATION", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click LOG OUT
    // ===================================================================
    public PG_007_ProfilePage Click_On_Log_Out() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement target = logOutButton.isDisplayed() ? logOutButton : logOutButtonXpath;
            target.click();
            ExtentReportManager.info(methodName);
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName);
            TestContext.getLogger().error(methodName + " - Failed to click LOG OUT", e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Verify Profile Page is Displayed (Optional)
    // ===================================================================
    public PG_007_ProfilePage Verify_Profile_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement title = profileTitle.isDisplayed() ? profileTitle : profileTitleXpath;
            if (title.isDisplayed()) {
                ExtentReportManager.info(methodName + " - PROFILE title is visible");
                TestContext.getLogger().info(methodName + " - PROFILE page loaded");
            } else {
                throw new Exception("PROFILE title not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - PROFILE page NOT displayed");
            TestContext.getLogger().error(methodName + " - Failed", e);
            throw new RuntimeException(e);
        }
        return this;
    }
}