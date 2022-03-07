package com.languageline.utility;

import com.languageline.pages.MainPage;
import com.languageline.pages.VOTCustomer;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForVisibility(WebElement locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static WebElement waitElementToBeClickable(WebElement locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitPresenceOfElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void mouseHoverJScript(WebElement HoverElement) {
        try {
            if (isElementPresent(HoverElement)) {

                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');" +
                        "evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} " +
                        "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) Driver.getDriver()).executeScript(mouseOverScript,
                    HoverElement);

        } else {
            System.out.println("Element was not visible to hover " + "\n");

        }
    } catch (StaleElementReferenceException e) {
        System.out.println("Element with " + HoverElement
                + "is not attached to the page document"
                + e.getStackTrace());
    } catch (NoSuchElementException e) {
        System.out.println("Element " + HoverElement + " was not found in DOM"
                + e.getStackTrace());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error occurred while hovering"
                + e.getStackTrace());
    }
}

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }

}
