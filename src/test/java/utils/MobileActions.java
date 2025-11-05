package utils;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.SupportsRotation;
import io.appium.java_client.AppiumBy;

/**
 * MobileActions - Utility class for mobile automation actions
 * Provides reusable methods for common mobile interactions
 */
public class MobileActions {

    private AppiumDriver driver;
    private WebDriverWait wait;

    // Constructor
    public MobileActions(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ========================================================================
    // BASIC ACTIONS
    // ========================================================================

    /**
     * Click on an element
     */
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Click on element by locator
     */
    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /**
     * Send keys to an element
     */
    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get text from an element
     */
    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * Check if element is displayed
     */
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if element is enabled
     */
    public boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get attribute value
     */
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * Clear an element
     */
    public void clear(WebElement element) {
        element.clear();
    }

    /**
     * Clear and send keys
     */
    public void clearAndSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    // ========================================================================
    // WAIT ACTIONS
    // ========================================================================

    /**
     * Wait for element visibility
     */
    public WebElement waitForVisibility(By locator, Duration timeout) {
        WebDriverWait customWait = new WebDriverWait(driver, timeout);
        return customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be clickable
     */
    public WebElement waitForClickable(By locator, Duration timeout) {
        WebDriverWait customWait = new WebDriverWait(driver, timeout);
        return customWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ========================================================================
    // SCROLL ACTIONS
    // ========================================================================

    /**
     * Scroll down by percentage
     */
    public void scrollDown(double percentage) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * (1 - percentage));

        swipe(startX, startY, startX, endY, Duration.ofMillis(800));
    }

    /**
     * Scroll up by percentage
     */
    public void scrollUp(double percentage) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * percentage);

        swipe(startX, startY, startX, endY, Duration.ofMillis(800));
    }

    /**
     * Scroll to element by locator
     */
    public void scrollToElement(By locator) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceId(\"" + locator.toString() + "\"))"
        ));
    }

    /**
     * Scroll to exact element by text
     */
    public void scrollToExactElement(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }

    /**
     * Horizontal scroll to element
     */
    public void horizontalScrollToElement(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".setAsHorizontalList()" +
            ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }

    /**
     * Fling scroll
     */
    public void flingScroll(String direction) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
        ));
    }

    /**
     * Scroll to element with retry
     */
    public WebElement scrollToElementWithRetry(By locator, int maxRetries) {
        for (int i = 0; i < maxRetries; i++) {
            try {
                return driver.findElement(locator);
            } catch (Exception e) {
                scrollDown(0.5);
            }
        }
        throw new RuntimeException("Element not found after " + maxRetries + " scrolls");
    }

    /**
     * Scroll to bottom
     */
    public void scrollToBottom() {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"
        ));
    }

    /**
     * Scroll to top
     */
    public void scrollToTop() {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10)"
        ));
    }

    // ========================================================================
    // SWIPE ACTIONS
    // ========================================================================

    /**
     * Generic swipe method
     */
    private void swipe(int startX, int startY, int endX, int endY, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Swipe left
     */
    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int y = size.height / 2;

        swipe(startX, y, endX, y, Duration.ofMillis(800));
    }

    /**
     * Swipe right
     */
    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        int endX = (int) (size.width * 0.8);
        int y = size.height / 2;

        swipe(startX, y, endX, y, Duration.ofMillis(800));
    }

    /**
     * Swipe on specific element
     */
    public void swipeOnElement(WebElement element, String direction) {
        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;

        switch (direction.toLowerCase()) {
            case "left":
                swipe(startX, startY, startX - 200, startY, Duration.ofMillis(500));
                break;
            case "right":
                swipe(startX, startY, startX + 200, startY, Duration.ofMillis(500));
                break;
            case "up":
                swipe(startX, startY, startX, startY - 200, Duration.ofMillis(500));
                break;
            case "down":
                swipe(startX, startY, startX, startY + 200, Duration.ofMillis(500));
                break;
        }
    }

    // ========================================================================
    // TAP ACTIONS
    // ========================================================================

    /**
     * Single tap on element
     */
    public void tap(WebElement element) {
        element.click();
    }

    /**
     * Tap at coordinates
     */
    public void tapAtCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));
    }

    /**
     * Long press on element
     */
    public void longPress(WebElement element, Duration duration) {
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);

        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), x, y));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(longPress));
    }

    /**
     * Double tap
     */
    public void doubleTap(WebElement element) {
        element.click();
        element.click();
    }

    // ========================================================================
    // KEYBOARD ACTIONS
    // ========================================================================

    /**
     * Check if keyboard is shown
     */
    public boolean isKeyboardShown() {
        return ((AndroidDriver) driver).isKeyboardShown();
    }

    /**
     * Hide keyboard
     */
    public void hideKeyboard() {
        if (isKeyboardShown()) {
            ((HidesKeyboard) driver).hideKeyboard();
        }
    }

    /**
     * Press back button
     */
    public void pressBack() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    /**
     * Press home button
     */
    public void pressHome() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    /**
     * Press enter
     */
    public void pressEnter() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    /**
     * Press any Android key
     */
    public void pressAndroidKey(AndroidKey key) {
        ((AndroidDriver) driver).pressKey(new KeyEvent(key));
    }

    // ========================================================================
    // ADVANCED ACTIONS
    // ========================================================================

    /**
     * Zoom in
     */
    public void zoomIn(WebElement element) {
        // Implementation for pinch zoom in
        System.out.println("Zoom in action - implement based on your needs");
    }

    /**
     * Zoom out
     */
    public void zoomOut(WebElement element) {
        // Implementation for pinch zoom out
        System.out.println("Zoom out action - implement based on your needs");
    }

    /**
     * Drag and drop
     */
    public void dragAndDrop(WebElement source, WebElement target) {
        int startX = source.getLocation().getX() + source.getSize().getWidth() / 2;
        int startY = source.getLocation().getY() + source.getSize().getHeight() / 2;
        int endX = target.getLocation().getX() + target.getSize().getWidth() / 2;
        int endY = target.getLocation().getY() + target.getSize().getHeight() / 2;

        swipe(startX, startY, endX, endY, Duration.ofMillis(1000));
    }

    /**
     * Multi-touch tap
     */
    public void multiTouchTap(int x, int y, int fingers) {
        System.out.println("Multi-touch tap with " + fingers + " fingers");
    }

    /**
     * Get current orientation
     */
    public ScreenOrientation getCurrentOrientation() {
        return ((SupportsRotation) driver).getOrientation();
    }

    /**
     * Rotate device
     */
    public void rotateDevice(ScreenOrientation orientation) {
        ((SupportsRotation) driver).rotate(orientation);
    }

    /**
     * Background app
     */
    public void backgroundApp(Duration duration) {
        ((InteractsWithApps) driver).runAppInBackground(duration);
    }

    /**
     * Close and relaunch app
     */
//    public void closeAndRelaunchApp() {
//        driver.closeApp();
//        driver.launchApp();
//    }

    /**
     * Check if app is installed
     */
    public boolean isAppInstalled(String bundleId) {
        return ((InteractsWithApps) driver).isAppInstalled(bundleId);
    }

    /**
     * Activate app
     */
    public void activateApp(String bundleId) {
        ((InteractsWithApps) driver).activateApp(bundleId);
    }

    /**
     * Get app state
     */
    public String getAppState(String bundleId) {
        return ((InteractsWithApps) driver).queryAppState(bundleId).toString();
    }

    /**
     * Terminate app
     */
    public void terminateApp(String bundleId) {
        ((InteractsWithApps) driver).terminateApp(bundleId);
    }

    /**
     * Reset app
     */
//    public void resetApp() {
//        ((InteractsWithApps) driver).resetApp();
//    }
//
//    /**
//     * Get all contexts
//     */
//    public Set<String> getAllContexts() {
//        return driver.getContextHandles();
//    }
//
//    /**
//     * Get current context
//     */
//    public String getCurrentContext() {
//        return driver.getContext();
//    }
//
//    /**
//     * Switch to context
//     */
//    public void switchToContext(String contextName) {
//        driver.context(contextName);
//    }

    /**
     * Take screenshot
     */
    public void takeScreenshot(String filename) {
        System.out.println("Screenshot: " + filename);
    }

    /**
     * Toggle airplane mode
     */
    public void toggleAirplaneMode() {
        ((AndroidDriver) driver).toggleAirplaneMode();
    }

    /**
     * Pull to refresh
     */
    public void pullToRefresh() {
        scrollDown(0.5);
    }

	public void SwipeUpToGetDashboardModule() {
		// TODO Auto-generated method stub

	}


	public boolean SwipeFromDropdown(String containerLocator, By targetBy, String direction) {
	    String methodName = "Swipe " + direction.toUpperCase() + " from Dropdown";

	    try {
	        // Parse container
	        String[] parts = containerLocator.split(":", 2);
	        if (parts.length != 2) {
	            ExtentReportManager.fail(methodName + " - Invalid format");
	            return false;
	        }

	        String locType = parts[0].trim().toLowerCase();
	        String locValue = parts[1].trim();

	        By containerBy = null;
	        if ("id".equals(locType)) containerBy = By.id(locValue);
	        else if ("xpath".equals(locType)) containerBy = By.xpath(locValue);
	        else if ("acc".equals(locType) || "accessibility".equals(locType))
	            containerBy = By.xpath("//*[@content-desc='" + locValue + "']");
	        else if ("class".equals(locType)) containerBy = By.className(locValue);
	        else {
	            ExtentReportManager.fail(methodName + " - Unsupported locator");
	            return false;
	        }

	        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerBy));

	        org.openqa.selenium.Point loc = container.getLocation();
	        Dimension size = container.getSize();
	        int top = loc.getY();
	        int bottom = top + size.getHeight();
	        int centerX = loc.getX() + size.getWidth() / 2;

	        int startY, endY;
	        if (direction.equalsIgnoreCase("up")) {
	            startY = (int) (bottom * 0.8);
	            endY = (int) (top + size.getHeight() * 0.2);
	        } else if (direction.equalsIgnoreCase("down")) {
	            startY = (int) (top + size.getHeight() * 0.2);
	            endY = (int) (bottom * 0.8);
	        } else {
	            ExtentReportManager.fail(methodName + " - Invalid direction");
	            return false;
	        }

	        Dimension screen = driver.manage().window().getSize();
	        startY = Math.max(startY, 100);
	        endY = Math.min(endY, screen.getHeight() - 100);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        int maxSwipes = 15;
	        int swipeDurationMs = 300; // Faster swipe

	        for (int i = 0; i < maxSwipes; i++) {
	            // Fast check: Is element visible?
	            try {
	                WebElement target = driver.findElement(targetBy);
	                if (target.isDisplayed()) {
	                    // Tap instantly
	                    int tx = target.getLocation().getX() + target.getSize().getWidth() / 2;
	                    int ty = target.getLocation().getY() + target.getSize().getHeight() / 2;

	                    Sequence tap = new Sequence(finger, 1)
	                        .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), tx, ty))
	                        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	                        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	                    driver.perform(Collections.singletonList(tap));

	                    ExtentReportManager.pass(methodName + " - Selected in " + (i + 1) + " swipe(s)");
	                    TestContext.getLogger().info(methodName + " - Success");
	                    return true;
	                }
	            } catch (Exception ignored) {
	                // Not found → continue
	            }

	            // Fast swipe (no Thread.sleep)
	            Sequence swipe = new Sequence(finger, 1)
	                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY))
	                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	                .addAction(finger.createPointerMove(Duration.ofMillis(swipeDurationMs), PointerInput.Origin.viewport(), centerX, endY))
	                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	            driver.perform(Collections.singletonList(swipe));

	            // Optional: tiny non-blocking pause (better than sleep)
	            try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	        }

	        ExtentReportManager.fail(methodName + " - Not found after " + maxSwipes + " swipes");
	        return false;

	    } catch (Exception e) {
	        ExtentReportManager.fail(methodName);
	        TestContext.getLogger().error(methodName + " - Exception", e);
	        return false;
	    }
	}

	public void scrollToText(String text) {
	    try {
	        String uiSelector = "new UiScrollable(new UiSelector().scrollable(true))"
	                + ".scrollIntoView(new UiSelector().text(\"" + text + "\"));";
	        driver.findElement(AppiumBy.androidUIAutomator(uiSelector)); // ✅ Updated
	    } catch (Exception e) {
	        System.out.println("Unable to scroll to: " + text);
	    }
	}
}