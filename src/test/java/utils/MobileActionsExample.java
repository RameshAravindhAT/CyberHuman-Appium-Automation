//package utils;
//
//import java.time.Duration;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.ScreenOrientation;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import projectSpecifications.BaseClass;
//
///**
// * Example class demonstrating all MobileActions methods
// * This class provides comprehensive examples of mobile automation actions
// * including basic interactions, scrolling, swiping, gestures, and advanced features
// */
//public class MobileActionsExample extends BaseClass {
//
//	private MobileActions actions;
//
//    // ========================================================================
//    // BASIC ACTIONS EXAMPLES
//    // ========================================================================
//
//    public void test_Basic_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Click examples
//        WebElement loginButton = driver.findElement(By.id("login_button"));
//        actions.click(loginButton);
//
//        // Click by locator
//        actions.click(By.id("submit_btn"));
//
//        // Send keys
//        WebElement emailField = driver.findElement(By.id("email"));
//        actions.sendKeys(emailField, "test@example.com");
//
//        // Get text
//        WebElement titleElement = driver.findElement(By.id("title"));
//        String title = actions.getText(titleElement);
//        System.out.println("Title: " + title);
//
//        // Check if displayed
//        boolean isDisplayed = actions.isDisplayed(loginButton);
//        System.out.println("Login button displayed: " + isDisplayed);
//
//        // Wait for visibility
//        WebElement element = actions.waitForVisibility(By.id("result"), Duration.ofSeconds(10));
//
//        // Wait for clickable
//        WebElement clickableElement = actions.waitForClickable(By.id("next_btn"), Duration.ofSeconds(5));
//    }
//
//    // ========================================================================
//    // INTERMEDIATE ACTIONS EXAMPLES
//    // ========================================================================
//
//    public void test_Scroll_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Scroll down 50%
//        actions.scrollDown(0.5);
//
//        // Scroll up 30%
//        actions.scrollUp(0.3);
//
//        // Scroll to element
//        actions.scrollToElement(By.id("footer_element"));
//
//        // Scroll to exact element by text
//        actions.scrollToExactElement("Terms and Conditions");
//
//        // Horizontal scroll
//        actions.horizontalScrollToElement("Last Item");
//
//        // Fling scroll (fast scroll)
//        actions.flingScroll("down");
//
//        // Scroll with retry
//        WebElement element = actions.scrollToElementWithRetry(By.id("hidden_element"), 5);
//
//        // Scroll to top/bottom of page
//        actions.scrollToBottom();
//        actions.scrollToTop();
//    }
//
//    public void test_Swipe_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Swipe left (e.g., carousel, image gallery)
//        actions.swipeLeft();
//
//        // Swipe right
//        actions.swipeRight();
//
//        // Swipe on specific element
//        WebElement carousel = driver.findElement(By.id("image_carousel"));
//        actions.swipeOnElement(carousel, "left");
//        actions.swipeOnElement(carousel, "right");
//        actions.swipeOnElement(carousel, "up");
//        actions.swipeOnElement(carousel, "down");
//    }
//
//    public void test_Tap_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Single tap
//        WebElement element = driver.findElement(By.id("tap_target"));
//        actions.tap(element);
//
//        // Tap at coordinates
//        actions.tapAtCoordinates(500, 1000);
//
//        // Long press
//        WebElement longPressElement = driver.findElement(By.id("long_press_item"));
//        actions.longPress(longPressElement, Duration.ofSeconds(2));
//
//        // Double tap
//        WebElement imageElement = driver.findElement(By.id("image"));
//        actions.doubleTap(imageElement);
//    }
//
//    public void test_Keyboard_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Check if keyboard is shown
//        boolean keyboardShown = actions.isKeyboardShown();
//        System.out.println("Keyboard shown: " + keyboardShown);
//
//        // Hide keyboard
//        if (keyboardShown) {
//            actions.hideKeyboard();
//        }
//
//        // Press Android keys
//        actions.pressBack();
//        actions.pressHome();
//        actions.pressEnter();
//        actions.pressAndroidKey(AndroidKey.DEL);
//        actions.pressAndroidKey(AndroidKey.SEARCH);
//    }
//
//    // ========================================================================
//    // ADVANCED ACTIONS EXAMPLES
//    // ========================================================================
//
//    public void test_Zoom_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Zoom in on map/image
//        WebElement mapElement = driver.findElement(By.id("map_view"));
//        actions.zoomIn(mapElement);
//
//        // Zoom out
//        actions.zoomOut(mapElement);
//    }
//
//    public void test_Drag_Drop() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Drag and drop
//        WebElement source = driver.findElement(By.id("drag_item"));
//        WebElement target = driver.findElement(By.id("drop_zone"));
//        actions.dragAndDrop(source, target);
//    }
//
//    public void test_MultiTouch() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // 3 finger tap (e.g., for special app features)
//        actions.multiTouchTap(500, 1000, 3);
//    }
//
//    public void test_Device_Rotation() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Get current orientation
//        ScreenOrientation currentOrientation = actions.getCurrentOrientation();
//        System.out.println("Current orientation: " + currentOrientation);
//
//        // Rotate to landscape
//        actions.rotateDevice(ScreenOrientation.LANDSCAPE);
//
//        // Rotate to portrait
//        actions.rotateDevice(ScreenOrientation.PORTRAIT);
//    }
//
//    public void test_App_Management() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Background app for 3 seconds
//        actions.backgroundApp(Duration.ofSeconds(3));
//
//        // Close and relaunch
//        ((Object) actions).closeAndRelaunchApp();
//
//        // Check if app installed
//        boolean installed = actions.isAppInstalled("com.example.app");
//        System.out.println("App installed: " + installed);
//
//        // Activate app
//        actions.activateApp("com.example.app");
//
//        // Get app state
//        String state = actions.getAppState("com.example.app");
//        System.out.println("App state: " + state);
//
//        // Terminate app
//        actions.terminateApp("com.example.app");
//
//        // Reset app
//        actions.resetApp();
//    }
//
//    public void test_Context_Switching() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Get all contexts (e.g. NATIVE_APP, WEBVIEW_com.example)
//        Set<String> contexts = actions.getAllContexts();
//        System.out.println("Available contexts: " + contexts);
//
//        // Get current context
//        String currentContext = actions.getCurrentContext();
//        System.out.println("Current context: " + currentContext);
//
//        // Switch to WebView (if available)
//        boolean webViewFound = false;
//        for (String context : contexts) {
//            if (context.toLowerCase().contains("webview")) {
//                actions.switchToContext(context);
//                System.out.println("Switched to WebView context: " + context);
//                webViewFound = true;
//                break;
//            }
//        }
//
//        if (!webViewFound) {
//            System.out.println("No WebView context found!");
//            return;
//        }
//
//        // Perform actions inside WebView
//        try {
//            // Example: Interact with a WebView element
//            WebDriver driver = TestContext.getMobileDriver();
//            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("testuser");
//            driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password123");
//            driver.findElement(By.cssSelector("button[type='submit']")).click();
//            System.out.println("WebView interaction done successfully!");
//        } catch (Exception e) {
//            System.out.println("Error interacting in WebView: " + e.getMessage());
//        }
//
//        // Switch back to Native context
//        actions.switchToContext("NATIVE_APP");
//        System.out.println("Switched back to Native context.");
//
//        // Validate a native element (example)
//        try {
//            WebDriver driver = TestContext.getMobileDriver();
//            MobileElement nativeElement = (MobileElement) driver.findElement(By.id("com.example:id/home"));
//            Assert.assertTrue(nativeElement.isDisplayed(), "Native element is not visible after switching back!");
//            System.out.println("Context switching validated successfully!");
//        } catch (Exception e) {
//            System.out.println("Error validating native context: " + e.getMessage());
//        }
//    }
//
//    public void test_Wait_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Wait for element to be visible
//        WebElement visibleElement = actions.waitForVisibility(By.id("result_text"), Duration.ofSeconds(10));
//        System.out.println("Element is now visible");
//
//        // Wait for element to be clickable
//        WebElement clickable = actions.waitForClickable(By.id("submit_button"), Duration.ofSeconds(5));
//        System.out.println("Element is now clickable");
//
//        // Check if element is enabled
//        boolean isEnabled = actions.isEnabled(clickable);
//        System.out.println("Element enabled: " + isEnabled);
//
//        // Get attribute value
//        String attributeValue = actions.getAttribute(clickable, "text");
//        System.out.println("Button text: " + attributeValue);
//    }
//
//    public void test_Clear_And_Type() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Clear field and enter new text
//        WebElement searchField = driver.findElement(By.id("search_input"));
//        actions.clearAndSendKeys(searchField, "New search query");
//
//        // Clear specific field
//        actions.clear(searchField);
//    }
//
//    public void test_Screenshots() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Take screenshot (if method exists in MobileActions)
//        try {
//            actions.takeScreenshot("test_screenshot");
//            System.out.println("Screenshot captured successfully");
//        } catch (Exception e) {
//            System.out.println("Screenshot method might not be implemented");
//        }
//    }
//
//    public void test_Network_Actions() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Toggle airplane mode (if supported)
//        try {
//            actions.toggleAirplaneMode();
//            Thread.sleep(2000);
//            actions.toggleAirplaneMode();
//            System.out.println("Airplane mode toggled successfully");
//        } catch (Exception e) {
//            System.out.println("Network toggle might not be supported: " + e.getMessage());
//        }
//    }
//
//    public void test_Pull_To_Refresh() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Perform pull to refresh gesture
//        actions.pullToRefresh();
//        System.out.println("Pull to refresh executed");
//    }
//
//    public void test_Complete_Login_Flow() {
//        actions = new MobileActions(TestContext.getMobileDriver());
//
//        // Wait for app to load
//        actions.waitForVisibility(By.id("splash_screen"), Duration.ofSeconds(5));
//
//        // Navigate to login
//        actions.click(By.id("login_link"));
//
//        // Enter credentials
//        WebElement emailField = actions.waitForVisibility(By.id("email_input"), Duration.ofSeconds(5));
//        actions.sendKeys(emailField, "user@example.com");
//
//        WebElement passwordField = driver.findElement(By.id("password_input"));
//        actions.sendKeys(passwordField, "SecurePass123");
//
//        // Hide keyboard
//        if (actions.isKeyboardShown()) {
//            actions.hideKeyboard();
//        }
//
//        // Click login button
//        actions.click(By.id("login_button"));
//
//        // Verify login success
//        WebElement welcomeText = actions.waitForVisibility(By.id("welcome_message"), Duration.ofSeconds(10));
//        String welcomeMessage = actions.getText(welcomeText);
//        Assert.assertTrue(welcomeMessage.contains("Welcome"), "Login failed - welcome message not found");
//
//        System.out.println("Login flow completed successfully!");
//    }
//}