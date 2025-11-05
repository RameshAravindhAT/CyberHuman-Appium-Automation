package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)
public class TC_002_SignIn extends BaseClass {

    @BeforeClass
    public void testDetails() {
        TestContext.setSheetName("SignIn"); // Excel Sheet Name holding test data
    }

    @Test(dataProvider = "sendData")
    public void Validate_Login_Scenarios(String testNameDetails,
                              String email, String password, String Scenario, String expectedMessage) throws InterruptedException {

        // Initialize test in Extent Reports
        ExtentReportManager.setTest(extent.createTest(testNameDetails));
        ExtentReportManager.getTest().assignAuthor("Ramesh Aravindh");
        ExtentReportManager.getTest().assignCategory("Regression");

        // Perform login action using chaining methods
        TestContext.getStartedPage()
            .Enter_the_Email(email)               // Step 1: Enter Email
            .Enter_the_Password(password)         // Step 2: Enter Password
            .Click_On_Continue()          // Step 3: Click Submit / Login
            .Verify_The_Result(Scenario, expectedMessage);
    }
}
