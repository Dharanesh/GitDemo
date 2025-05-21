package action;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtils extends BaseTest {

    protected void sleep(long delay) {
        try {
            Thread.sleep(delay);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void log(String message, boolean systemPrint) {

        if (systemPrint) {
            System.out.println(message);
        }

        logger.info(message);
        test.info(message);
    }


    /** Waits for Ajax requests to be completed, prevents certain exceptions, to be used all the time */
    protected void waitForAjax() {
        waitForJSandJQueryToLoad();
        waitForInvisibilityOfElement(By.xpath("//*[@class='ajaxLoading']"));
    }

    /** Waits for JS and jQuery scripts to load, is the main part of the @waitForAjax method */
    private boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    protected WebElement find(By locator) {
        waitForAjax();
        return driver.findElement(locator);
    }

    protected Boolean findVisibleBool(By locator) {
        waitForAjax();
        return waitForVisibilityOfElement(locator) != null;
    }

    protected WebElement findVisible(By locator) {
        waitForAjax();
        return waitForVisibilityOfElement(locator);
    }

    protected WebElement findPresence(By locator) {
        waitForAjax();
        return waitForPresenceOfElement(locator);
    }

    protected List<WebElement> findAllPresence(By locator) {
        waitForAjax();
        return waitForPresenceOfElements(locator);
    }

    protected List<WebElement> findAll(By locator) {
        waitForAjax();
        return driver.findElements(locator);
    }

    protected List<WebElement> findAllVisible(By locator) {
        waitForAjax();
        return waitForVisibilityOfElements(locator);
    }

    protected void dragAndDropNew(By from, By to) {
        WebElement fromVisible = waitForVisibilityOfElement(from);
        WebElement toVisible = waitForVisibilityOfElement(to);
        waitForAjax();
        builder.dragAndDrop(fromVisible, toVisible).perform();
    }

    /** Click on element with given locator when it's visible */
    protected void click(By locator) {

//        new WebDriverWait(driver, 30)
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver d) -> {
//                    waitForVisibilityOfElement(locator, 5).click();
//                    return true;
//                });

        int attempts = 0;

        while (attempts < 2) {

            try {
                WebElement toBeClicked = waitForVisibilityOfElement(locator);
                waitForAjax();
                toBeClicked.click();
                break;
            }
            catch(StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }
    }

    /** Click on element with given locator when it's visible */
    protected void click(String locator) {

//        new WebDriverWait(driver, 30)
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver d) -> {
//                    waitForVisibilityOfElement(By.xpath(locator), 5).click();
//                    return true;
//                });
        int attempts = 0;

        while (attempts < 2) {

            try {
                WebElement toBeClicked = waitForVisibilityOfElement(By.xpath(locator));
                waitForAjax();
                toBeClicked.click();
                break;
            }
            catch(StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }
    }

    /** Click on element with given locator when it's visible */
    protected void clickP(By locator) {

//        new WebDriverWait(driver, 30)
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver d) -> {
//                    waitForVisibilityOfElement(By.xpath(locator), 5).click();
//                    return true;
//                });

        int attempts = 0;

        while (attempts < 2) {

            try {
                WebElement toBeClicked = waitForPresenceOfElement(locator);
                waitForAjax();
                toBeClicked.click();
                break;
            }
            catch(StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }
    }

    /** Click on a clickable element with given locator when it's visible */
    protected void clickableClick(By locator) {
        int attempts = 0;

        while (attempts < 2) {

            try {
                WebElement toBeClicked = waitForClickableElement(locator);
                waitForAjax();
                toBeClicked.click();
                break;
            }
            catch(StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }
    }

    /** Type given text into element with given locator */
    protected void type(String text, By locator) {
        waitForAjax();
        waitForVisibilityOfElement(locator, 5).sendKeys(text);
    }

    protected Boolean isSelectedBool(By locator) {
        waitForAjax();
        return waitForSelectedOfElement(locator) != null;
    }

    /** Wait for a specific text to be present in the element */
    protected void waitForTextInElement(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /** Wait for a specific text to be present in the element */
    protected void waitForTextInElement(WebElement locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private void waitFor(ExpectedCondition<?> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

//    /**
//     * Wait for specific ExpectedCondition for the given amount of time in seconds
//     */
//    private void waitFor(ExpectedCondition<Boolean> condition, Integer timeOutInSeconds) {
//        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
//        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//
//    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds, for the given locator
     */
    protected void waitForCondition(By locator, ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected WebElement waitForVisibilityOfElement(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }

        return find(locator);
    }

    protected WebElement waitForPresenceOfElement(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.presenceOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }

        return find(locator);
    }

    protected List<WebElement> waitForPresenceOfElements(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }

        return findAll(locator);
    }

    /**
     * Wait for given number of seconds for elements with given locator to be visible
     * on the page
     */
    protected List<WebElement> waitForVisibilityOfElements(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }

        return findAll(locator);
    }

    /**
     * Wait for given number of seconds for element with given locator to be clickable
     * on the page
     */
    protected WebElement waitForClickableElement(By locator, Integer... timeOutInSeconds) {

        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.elementToBeClickable(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }

        return find(locator);
    }

    /**
     * Wait for given number of seconds for element with given locator to be invisible
     * on the page
     */
    protected void waitForInvisibilityOfElement(By locator, Integer... timeOutInSeconds) {

        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.invisibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }
    }

    /**
     * Wait for given number of seconds for element with given locator to be non-clickable
     * on the page
     */
    protected List<WebElement> waitForSelectedOfElement(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor(ExpectedConditions.elementToBeSelected(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30));
                break;
            }
            catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }

            attempts++;
        }

        return findAll(locator);
    }

    /** Waits for the radio element to become unselected */
    protected void waitForElementNotSelected(WebElement locator) {

        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor((ExpectedCondition<Boolean>) x -> !locator.isSelected(), 30);
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e + " : Timed out waiting for element");
            }

            attempts++;
        }
    }

    /** Waits for the radio element to become selected */
    protected WebElement waitForElementSelected(WebElement locator) {

        int attempts = 0;

        while (attempts < 2) {

            try {
                waitFor((ExpectedCondition<Boolean>) x -> locator.isSelected(), 30);
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e + " : Timed out waiting for element");
            }

            attempts++;
        }

        return locator;
    }

    protected void implicitWaitSeconds(long delay) {
        driver.manage().timeouts().implicitlyWait(delay, TimeUnit.SECONDS);
    }

    protected void pageLoadWaitSeconds(long delay) {
        driver.manage().timeouts().pageLoadTimeout(delay, TimeUnit.SECONDS);
    }

    // TODO: refactor the method to adapt for all possible test case outcomes so that it ends session after any scenario
    @Override
    public void logout() {
        clickableClick(By.xpath("//span[@id='hamburger_btn']"));
        test.info("Settings menu opened.");
        System.out.println("Settings menu opened.");

        Assert.assertEquals(findVisible(By.xpath("//div[normalize-space()='Log Off']")).getText(), "Log Off");
        clickableClick(By.xpath("//div[normalize-space()='Log Off']"));
        test.info("Log Off button clicked.");
        System.out.println("Log Off button clicked.");

        Assert.assertEquals(findVisible(By.xpath("//span[text()='You have logged off']")).getText(), "You have logged off");
        test.info("Session has been ended.");
        System.out.println("Session has been ended.");

        clickableClick(By.xpath("//input[@id='okbutton']"));
    }
}
