package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;   // ✅ Using WebElement
import org.openqa.selenium.support.PageFactory;
import utils.ExtentReportManager;
import utils.TestContext;
import projectSpecifications.BaseClass;

public class PG_001_GetStartedPage extends BaseClass {

    public PG_001_GetStartedPage(AppiumDriver driver) {
    	 TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "GET STARTED")
    public WebElement btnGetStarted;

    public PG_001_GetStartedPage Click_On_Get_Started_Button() {
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
}
