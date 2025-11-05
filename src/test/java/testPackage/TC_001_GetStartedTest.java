package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)  // Listener for reporting
public class TC_001_GetStartedTest extends BaseClass {

    @BeforeClass
    public void testDetails() {
        TestContext.setSheetName("GetStarted"); // Excel Sheet Name
    }

    @Test(dataProvider = "sendData")
    public void validateGetStartedButton(String testNameDetails, String authorName, String category) throws InterruptedException {

        // Initialize test in Extent Reports
    	ExtentReportManager.setTest(extent.createTest(testNameDetails));
    	ExtentReportManager.getTest().assignAuthor(authorName);
    	ExtentReportManager.getTest().assignCategory(category);

        // Perform action
        TestContext.getStartedPage()
                   .Click_On_Get_Started_Button();// Your single method

    }
}
