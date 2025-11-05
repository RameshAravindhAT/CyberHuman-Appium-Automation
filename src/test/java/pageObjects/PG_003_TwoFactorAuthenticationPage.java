package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_003_TwoFactorAuthenticationPage extends BaseClass {

	public PG_003_TwoFactorAuthenticationPage(AppiumDriver driver) {
		TestContext.setDriver(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    @AndroidFindBy(accessibility = "TWO-FACTOR AUTHENTICATION SETUP")
	public WebElement lblHeader_TwoFactorSetup;

	// ✅ Description Text – MFA Question
	@AndroidFindBy(accessibility = "For extra account security, would you like to \nenable Multi-Factor Authentication (MFA) now?")
	public WebElement lblDescription_MFAQuestion;

	// ✅ YES Button
	@AndroidFindBy(accessibility = "YES")
	public WebElement btnYes;

	// ✅ NO Button
	@AndroidFindBy(accessibility = "NO")
	public WebElement btnNo;

// ✅ Verify header text is displayed
	public PG_003_TwoFactorAuthenticationPage Verify_TwoFactor_Header_Displayed() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			if (lblHeader_TwoFactorSetup.isDisplayed()) {
				ExtentReportManager.info(methodName + " - Header is displayed");
				TestContext.getLogger().info(methodName);
			}
		} catch (Exception e) {
			ExtentReportManager.fail(methodName + " - Header not displayed");
			TestContext.getLogger().error(methodName, e);
			throw new RuntimeException(e);
		}
		return this;
	}

// ✅ Verify MFA question text is displayed
	public PG_003_TwoFactorAuthenticationPage Verify_MFA_Question_Displayed() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			if (lblDescription_MFAQuestion.isDisplayed()) {
				ExtentReportManager.info(methodName + " - MFA question text is displayed");
				TestContext.getLogger().info(methodName);
			}
		} catch (Exception e) {
			ExtentReportManager.fail(methodName + " - MFA question text not displayed");
			TestContext.getLogger().error(methodName, e);
			throw new RuntimeException(e);
		}
		return this;
	}

// ✅ Click on YES button
	public PG_003_TwoFactorAuthenticationPage Click_On_Yes() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			btnYes.click();
			ExtentReportManager.info(methodName + " - Clicked on YES");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.fail(methodName + " - Failed to click YES");
			TestContext.getLogger().error(methodName, e);
			throw new RuntimeException(e);
		}
		return this;
	}

// ✅ Click on NO button
	public PG_004_LinkDevicePage Click_On_No() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
		try {
			btnNo.click();
			ExtentReportManager.info(methodName + " - Clicked on NO");
			TestContext.getLogger().info(methodName);
		} catch (Exception e) {
			ExtentReportManager.fail(methodName + " - Failed to click NO");
			TestContext.getLogger().error(methodName, e);
			throw new RuntimeException(e);
		}
		return new PG_004_LinkDevicePage((AppiumDriver) TestContext.getDriver());
	}

}
