package pageObjectsAndroid;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

public class PG_015_ABCHOPRAHOUSEPage extends BaseClass {

    public PG_015_ABCHOPRAHOUSEPage(AppiumDriver driver) {
        TestContext.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ==================== TOP BRANDING ====================

    @AndroidFindBy(accessibility = "AB CHOPRA HOUSE")
    public WebElement lblBrandTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='AB CHOPRA HOUSE']")
    public WebElement lblBrandTitle_XPath;

    // ==================== TABS ====================

    @AndroidFindBy(accessibility = "DISCOVER")
    public WebElement tabDiscover;

    @AndroidFindBy(accessibility = "ARCHIVE")
    public WebElement tabArchive;

    // Back Arrow (Top Left)
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[8,76][104,172]']")
    public WebElement btnBackArrow;

    // ==================== DISCOVER TAB CONTENT ====================

    @AndroidFindBy(accessibility = "Your Friday Evening Recommendations")
    public WebElement lblRecommendationHeader;

    @AndroidFindBy(accessibility = "Picks")
    public WebElement lblPicks;

    // Blog Cards (Dynamic)
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'ab_blogs')]")
    public List<WebElement> listBlogCards;

    // Specific Blog Titles
    @AndroidFindBy(accessibility = "What’s the Difference Between a Cream and a Lotion?")
    public WebElement lblBlog1;

    @AndroidFindBy(accessibility = "Keeping Your Winter Hair Healthy")
    public WebElement lblBlog2;

    // Blog Image/Thumbnail (clickable)
    @AndroidFindBy(xpath = "//android.view.View[@bounds='[48,759][332,1043]']")
    public WebElement imgBlog1;

    @AndroidFindBy(xpath = "//android.view.View[@bounds='[48,1165][332,1449]']")
    public WebElement imgBlog2;

    // ==================== ARCHIVE TAB CONTENT ====================

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Modified on')]")
    public List<WebElement> listArchiveItems;

    @AndroidFindBy(accessibility = "Three\nModified on Oct 30")
    public WebElement itemArchiveThree;

    @AndroidFindBy(accessibility = "Two\nModified on Oct 30")
    public WebElement itemArchiveTwo;

    @AndroidFindBy(accessibility = "One\nModified on Oct 29")
    public WebElement itemArchiveOne;

    // ==================== BOTTOM NAVIGATION ====================

    @AndroidFindBy(accessibility = "WELLBEING \nDASHBOARD\nAB CHOPRA HOUSE")
    public WebElement btnBottomWellbeing;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[560,1305][678,1425]']")
    public WebElement iconProfile; // Top-right profile icon

    // ===================================================================
    // 1. Verify Page is Displayed
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Verify_ABCHOPRAHOUSE_Page_Displayed() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement title = isDisplayedSafe(lblBrandTitle) ? lblBrandTitle : lblBrandTitle_XPath;
            if (title.isDisplayed()) {
                ExtentReportManager.pass(methodName + " - AB CHOPRA HOUSE page is displayed");
                TestContext.getLogger().info(methodName);
            } else {
                throw new Exception("Brand title not visible");
            }
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Page NOT displayed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 2. Click Back Arrow
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Back_Arrow() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnBackArrow.click();
            ExtentReportManager.pass(methodName + " - Clicked Back Arrow");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 3. Click DISCOVER Tab
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Discover_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            tabDiscover.click();
            waitForElementVisible(lblRecommendationHeader, 10);
            ExtentReportManager.pass(methodName + " - DISCOVER tab opened");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 4. Click ARCHIVE Tab
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Archive_Tab() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            tabArchive.click();
            waitForElementVisible(itemArchiveThree, 10);
            ExtentReportManager.pass(methodName + " - ARCHIVE tab opened");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 5. Scroll & Click Blog in DISCOVER
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Blog_In_Discover(String blogTitleContains) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement blog = driver.findElementByXPath(
                String.format("//android.view.View[contains(@content-desc, '%s')]", blogTitleContains)
            );
            scrollToElement(blog);
            blog.click();
            ExtentReportManager.pass(methodName + " - Clicked Blog: " + blogTitleContains);
            TestContext.getLogger().info(methodName + ": " + blogTitleContains);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Blog not found");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 6. Click Archive Item
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Archive_Item(String itemName) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            WebElement item = null;
            switch (itemName.toLowerCase()) {
                case "three" -> item = itemArchiveThree;
                case "two" -> item = itemArchiveTwo;
                case "one" -> item = itemArchiveOne;
                default -> throw new IllegalArgumentException("Invalid item: " + itemName);
            }
            scrollToElement(item);
            item.click();
            ExtentReportManager.pass(methodName + " - Clicked Archive: " + itemName);
            TestContext.getLogger().info(methodName + ": " + itemName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 7. Click Profile Icon (Top Right)
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Profile_Icon() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            iconProfile.click();
            ExtentReportManager.pass(methodName + " - Clicked Profile Icon");
            TestContext.getLogger().info(methodName);
        } catch (Exception e) {
            ExtentReportManager.fail(methodName + " - Failed");
            TestContext.getLogger().error(methodName, e);
            throw new RuntimeException(e);
        }
        return this;
    }

    // ===================================================================
    // 8. Click Bottom Wellbeing Dashboard
    // ===================================================================
    public PG_015_ABCHOPRAHOUSEPage Click_Bottom_Wellbeing_Dashboard() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " ");
        try {
            btnBottomWellbeing.click();
            ExtentReportManager.pass(methodName + " - Navigated to Wellbeing Dashboard");
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