package pageObjectsAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_011_DataBankPage extends

 BaseClass {

    public PG_011_DataBankPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // === MAIN MENU ITEMS ===
    @AndroidFindBy(accessibility = "DATA BANK")
    public WebElement menuDataBank;

    @AndroidFindBy(accessibility = "PACKAGES & PRICING")
    public WebElement menuPackagesPricing;

    @AndroidFindBy(accessibility = "UPLOAD DATA")
    public WebElement menuUploadData;

    @AndroidFindBy(accessibility = "DEVICES")
    public WebElement menuDevices;

    @AndroidFindBy(accessibility = "REPORTS")
    public WebElement menuReports;

    // === REPORT OPTIONS ===
    @AndroidFindBy(accessibility = "BLOOD REPORT")
    public WebElement optionBloodReport;

    @AndroidFindBy(accessibility = "DNA REPORT")
    public WebElement optionDnaReport;

    // === BOTTOM NAV (WELLBEING DASHBOARD) ===
    @AndroidFindBy(accessibility = "WELLBEING \nDASHBOARD\nDATA BANK")
    public WebElement bottomNavWellbeing;

    // === PROFILE ICON (Top Right) ===
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[560,1311][678,1431]']")
    public WebElement iconProfile;

    // === FALLBACKS ===
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='DATA BANK']")
    public WebElement menuDataBank_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='PACKAGES & PRICING']")
    public WebElement menuPackagesPricing_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='UPLOAD DATA']")
    public WebElement menuUploadData_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='DEVICES']")
    public WebElement menuDevices_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='REPORTS']")
    public WebElement menuReports_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='BLOOD REPORT']")
    public WebElement optionBloodReport_XPath;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='DNA REPORT']")
    public WebElement optionDnaReport_XPath;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='WELLBEING \nDASHBOARD\nDATA BANK']")
    public WebElement bottomNavWellbeing_XPath;

    // ===================================================================
    // 1. Verify Reports Page is Displayed
    // ===================================================================
    public PG_011_DataBankPage Verify_Reports_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement reports = isDisplayedSafe(menuReports) ? menuReports : menuReports_XPath;
            if (reports.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - REPORTS page is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("REPORTS menu not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click on Blood Report
    // ===================================================================
    public PG_011_DataBankPage Click_On_Blood_Report() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement blood = isDisplayedSafe(optionBloodReport) ? optionBloodReport : optionBloodReport_XPath;
            blood.click();
            ExtentReportManager.pass(methodName + " - Clicked BLOOD REPORT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click BLOOD REPORT");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click on DNA Report
    // ===================================================================
    public PG_011_DataBankPage Click_On_DNA_Report() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement dna = isDisplayedSafe(optionDnaReport) ? optionDnaReport : optionDnaReport_XPath;
            dna.click();
            ExtentReportManager.pass(methodName + " - Clicked DNA REPORT");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click DNA REPORT");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click on Data Bank (Menu)
    // ===================================================================
    public PG_011_DataBankPage Click_On_Data_Bank_Menu() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement item = isDisplayedSafe(menuDataBank) ? menuDataBank : menuDataBank_XPath;
            item.click();
            ExtentReportManager.info(methodName + " - Clicked DATA BANK");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click DATA BANK");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Click on Packages & Pricing
    // ===================================================================
    public PG_011_DataBankPage Click_On_Packages_And_Pricing() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement item = isDisplayedSafe(menuPackagesPricing) ? menuPackagesPricing : menuPackagesPricing_XPath;
            item.click();
            ExtentReportManager.info(methodName + " - Clicked PACKAGES & PRICING");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click PACKAGES & PRICING");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Click on Upload Data
    // ===================================================================
    public PG_011_DataBankPage Click_On_Upload_Data() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement item = isDisplayedSafe(menuUploadData) ? menuUploadData : menuUploadData_XPath;
            item.click();
            ExtentReportManager.info(methodName + " - Clicked UPLOAD DATA");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click UPLOAD DATA");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 7. Click on Devices
    // ===================================================================
    public PG_011_DataBankPage Click_On_Devices() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement item = isDisplayedSafe(menuDevices) ? menuDevices : menuDevices_XPath;
            item.click();
            ExtentReportManager.info(methodName + " - Clicked DEVICES");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click DEVICES");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 8. Click on Profile Icon
    // ===================================================================
    public PG_011_DataBankPage Click_On_Profile_Icon() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconProfile.click();
            ExtentReportManager.info(methodName + " - Clicked PROFILE ICON");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed to click PROFILE ICON");
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