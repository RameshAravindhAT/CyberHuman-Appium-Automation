package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_004_LinkDevicePage extends BaseClass {

    // ✅ Constructor
    public PG_004_LinkDevicePage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "LINK DEVICES")
    public WebElement lblLinkDevicesTitle;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Track your fitness')]")
    public WebElement txtTrackFitness;

    @AndroidFindBy(accessibility = "ULTRAHUMAN")
    public WebElement btnUltrahuman;

    @AndroidFindBy(accessibility = "CONTINUE")
    public WebElement btnContinue;

    // ✅ Verify Title is displayed
    public PG_004_LinkDevicePage Verify_LinkDevices_Title_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            if (lblLinkDevicesTitle.isDisplayed()) {
                ExtentReportManager.info(methodName + " - LINK DEVICES title is displayed");
                TestContext.getLogger().info(methodName);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - LINK DEVICES title NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Verify Description is displayed
    public PG_004_LinkDevicePage Verify_Description_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            if (txtTrackFitness.isDisplayed()) {
                ExtentReportManager.info(methodName + " - Description text is displayed");
                TestContext.getLogger().info(methodName);
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Description text NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Click on "Ultrahuman"
    public PG_004_LinkDevicePage Click_On_Ultrahuman() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnUltrahuman.click();
            ExtentReportManager.info(methodName + " - Clicked on ULTRAHUMAN");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click ULTRAHUMAN");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ✅ Click on CONTINUE button
    public PG_004_LinkDevicePage Click_On_Continue() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnContinue.click();
            ExtentReportManager.info(methodName + " - Clicked on CONTINUE");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click CONTINUE");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }
}
