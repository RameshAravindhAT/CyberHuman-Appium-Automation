package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectsAndroid.PG_009_SignUpPage;
import projectSpecifications.BaseClass;
import utils.ExtentReportManager;
import utils.TestContext;

@Listeners(utils.CustomTestListener.class)
public class TC_004_NewUserSignUp extends BaseClass {

    @BeforeClass
    public void testDetails() {
        TestContext.setSheetName("SignUp"); // Excel Sheet Name holding test data
    }

    @Test(dataProvider = "sendData")
    public void Validate_SignUp_Scenarios(String testNameDetails,
                                          String name, String email, String countryAction, String password, String confirmpassword ) throws InterruptedException {

        // Initialize test in Extent Reports
        ExtentReportManager.setTest(extent.createTest(testNameDetails));
        ExtentReportManager.getTest().assignAuthor("Ramesh Aravindh");
        ExtentReportManager.getTest().assignCategory("Regression");

        // Your requested style: Direct object creation + single method call
        PG_009_SignUpPage signUp = new PG_009_SignUpPage(TestContext.getDriver());

        signUp.Fill_Sign_Up_Form(name, email, countryAction, confirmpassword, confirmpassword);
    }
}