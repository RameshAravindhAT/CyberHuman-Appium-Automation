package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectsAndroid.PG_000_DashboardModulePage;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)
public class TC_003_OnlySwipeUp extends BaseClass {

    @BeforeClass
    public void testDetails() {
        TestContext.setSheetName("SwipeUp"); // Excel Sheet Name holding test data
    }

    @Test(dataProvider = "sendData")
    public void Validate_Login_Scenarios(String testNameDetails
                              ) throws InterruptedException {

        // Initialize test in Extent Reports
        ExtentReportManager.setTest(extent.createTest(testNameDetails));
        ExtentReportManager.getTest().assignAuthor("Ramesh Aravindh");
        ExtentReportManager.getTest().assignCategory("Regression");

        // Perform login action using chaining methods
        PG_000_DashboardModulePage startedPage = new PG_000_DashboardModulePage(TestContext.getDriver());

        startedPage.swipe_Up_WellBeing_Dashboard();

    }
}
