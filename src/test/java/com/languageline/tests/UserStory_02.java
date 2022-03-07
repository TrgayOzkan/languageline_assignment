package com.languageline.tests;

import com.languageline.pages.MainPage;
import com.languageline.pages.VOTCustomer;
import com.languageline.utility.BrowserUtil;
import com.languageline.utility.Driver;
import com.languageline.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory_02 extends TestBase {

    MainPage mainPage = new MainPage();
    VOTCustomer votCustomer = new VOTCustomer();

    @Test
    public void TC_01() {

        mainPage.navigateToModule("Client Resources", "Voice of the Customer");

        votCustomer.fillVOTCForm();

        Assertions.assertFalse(votCustomer.popUpMsg.isDisplayed());

    }

    @Test
    public void TC_02(){

        List<String> actualMsgList = new ArrayList<>();
        Actions action = new Actions(driver);

        mainPage.navigateToForm();


        for (int i = 1, j=1; i<16; i++,j++){
            WebElement element = driver.findElement(By.xpath("(//div[@class='mouseOverInfoOuter'])["+i+"]"));

            WebElement iconTxt = driver.findElement(By.xpath("(//div[@class='body'])["+j+"]"));
            if (i <= 7) {

                BrowserUtil.waitElementToBeClickable(element,2);

                action.moveToElement(element).perform();

                BrowserUtil.waitForVisibility(iconTxt,3);

                if(element.isDisplayed()){
                    //System.out.println("iconTxt("+i+") = " + iconTxt.getText());
                    actualMsgList.add(iconTxt.getText());
                }
            }else if(i==8){

                votCustomer.clickProduct();
                action.moveToElement(element).perform();
                BrowserUtil.waitForVisibility(iconTxt,2);

                if(element.isDisplayed()){
                   // System.out.println("iconTxt("+i+") = " + iconTxt.getText());
                    actualMsgList.add(iconTxt.getText());
                }

            } else if (i==9) {

                votCustomer.clickCategory();
                action.moveToElement(element).perform();
                BrowserUtil.waitForVisibility(iconTxt, 2);

                if (element.isDisplayed()) {
                  //  System.out.println("iconTxt(" + i + ") = " + iconTxt.getText());
                    actualMsgList.add(iconTxt.getText());
                }
            }else if(i == 10 || i ==11) {

                BrowserUtil.waitElementToBeClickable(element, 2);
                action.moveToElement(element).perform();

                if (element.isDisplayed()) {
                   // System.out.println("iconTxt(" + i + ") = " + iconTxt.getText());
                    actualMsgList.add(iconTxt.getText());
                }
            }else if (i == 12){
                BrowserUtil.waitElementToBeClickable(element, 2);

                action.moveToElement(element).click().perform();

                BrowserUtil.waitForVisibility(votCustomer.eventTimePicker,1);
                votCustomer.eventTimePicker.click();

                WebElement timeEvent = driver.findElement(By.xpath("//a[@class='reset_time']/../../../../..//div[@class='mouseOverInfo']"));
                BrowserUtil.mouseHoverJScript(iconTxt);

                BrowserUtil.waitElementToBeClickable(timeEvent, 2);

               // System.out.println("iconTxt(12) = " + timeEvent.getText());
                actualMsgList.add(iconTxt.getText());

            } else {

                BrowserUtil.mouseHoverJScript(iconTxt);

                BrowserUtil.waitForVisibility(iconTxt, 2);
                if (element.isDisplayed()) {
                   //     System.out.println("iconTxt(" + i + ") = " + iconTxt.getText());
                    actualMsgList.add(iconTxt.getText());
                }
            }

        }
        String[] infoMsgArr = {
                "First name of feedback/contact recipient",
                "Last name of feedback/contact recipient",
                "Please provide a feedback/contact recipient email address.",
                "Please provide your Client ID or Access Code. Feedback is not available if not provided.",
                "Please provide a feedback/contact recipient phone number. Numeric digits only.",
                "Please provide your company name",
                "Product utilized related to VOC",
                "Category specified for the VOC",
                "Sub-Category specified for the VOC",
                "Time Zone of event",
                "Date of event",
                "Time of event",
                "Please provide the number dialed. Numeric digits only.",
                "Please provide the Language associated to the event.",
                "Interpreter ID's are 6 digits"
        };
        List<String> expectedMsgList = new ArrayList<>(Arrays.asList(infoMsgArr));

       Assertions.assertArrayEquals(expectedMsgList.toArray(),actualMsgList.toArray());

    }

    @Test
    public void TC_03(){
        mainPage.navigateToForm();

        votCustomer.submitButton.click();

        BrowserUtil.waitForVisibility(votCustomer.popUpMsg,3);
        System.out.println("votCustomer.popUpMsg.getText() = " + votCustomer.popUpMsg.getText());

        String expectedResult ="If a Client Id or Dialed Number is not provided along with an email, " +
                "we will review your feedback but you will not be eligible to receive a follow-up response";

        String actualResult = votCustomer.popUpMsg.getText().trim();

        Assertions.assertEquals(expectedResult,actualResult);


    }
    @Test
    public void TC_04(){
        mainPage.navigateToForm();

        List<String> actualErrMsgList = new ArrayList<>();

        votCustomer.submitButton.click();
        votCustomer.popUpOKBtn.click();

        System.out.println("votCustomer.errMsg = " + votCustomer.errMsg);

        for(WebElement each : votCustomer.errMsg){
            actualErrMsgList.add(each.getText());
        }

        String[] errMsgArray = {"Please verify the captcha to submit this form.",
                                "A Product, Category and Sub-Category must be selected.",
                                "An Event Date is Required.",
                                "An Event Time is Required.",
                                "A description must be provided."};
        List<String> expectedErrMsgList = new ArrayList<>(Arrays.asList(errMsgArray));

        Assertions.assertArrayEquals(expectedErrMsgList.toArray(),actualErrMsgList.toArray());

    }
    @Test
    public void TC_05(){
        mainPage.navigateToForm();

        List<String> actualErrMsgList = new ArrayList<>();

        votCustomer.clickReCaptcha();
        driver.switchTo().parentFrame();

        votCustomer.submitButton.click();
        votCustomer.popUpOKBtn.click();


        for(WebElement each : votCustomer.errMsg){
            actualErrMsgList.add(each.getText());
        }
        String[] errMsgArray = {
                "A Product, Category and Sub-Category must be selected.",
                "An Event Date is Required.",
                "An Event Time is Required.",
                "A description must be provided."};
        List<String> expectedErrMsgList = new ArrayList<>(Arrays.asList(errMsgArray));

        Assertions.assertArrayEquals(expectedErrMsgList.toArray(),actualErrMsgList.toArray());

    }
    @Test
    public void TC_06(){
        mainPage.navigateToForm();

        List<String> actualErrMsgList = new ArrayList<>();

        votCustomer.fillFeedbackInfo(1,3,2);

        votCustomer.clickReCaptcha();
        driver.switchTo().parentFrame();

        votCustomer.submitButton.click();
        votCustomer.popUpOKBtn.click();


        for(WebElement each : votCustomer.errMsg){
            actualErrMsgList.add(each.getText());
        }
        String[] errMsgArray = {
                "An Event Date is Required.",
                "An Event Time is Required.",
                "A description must be provided."};
        List<String> expectedErrMsgList = new ArrayList<>(Arrays.asList(errMsgArray));

        Assertions.assertArrayEquals(expectedErrMsgList.toArray(),actualErrMsgList.toArray());

    }
    @Test
    public void TC_07(){
        mainPage.navigateToForm();

        List<String> actualErrMsgList = new ArrayList<>();

        votCustomer.fillFeedbackInfo(1,3,2);
        votCustomer.eventDate.click();
        BrowserUtil.waitForVisibility(votCustomer.eventDateToday,1);
        votCustomer.eventDateToday.click();

        votCustomer.clickReCaptcha();
        driver.switchTo().parentFrame();

        votCustomer.submitButton.click();
        //BrowserUtil.waitForVisibility(votCustomer.popUpOKBtn,2);
        votCustomer.popUpCancelBtn.click();


        for(WebElement each : votCustomer.errMsg){
            actualErrMsgList.add(each.getText());
        }

        String[] errMsgArray = {
                "An Event Time is Required.",
                "A description must be provided."};
        List<String> expectedErrMsgList = new ArrayList<>(Arrays.asList(errMsgArray));

        Assertions.assertArrayEquals(expectedErrMsgList.toArray(),actualErrMsgList.toArray());

    }
    @Test
    public void TC_08(){

        mainPage.navigateToForm();

        List<String> actualErrMsgList = new ArrayList<>();

        votCustomer.fillFeedbackInfo(1,3,2);
        //BrowserUtil.waitFor(3);
        votCustomer.fillTime();
        //BrowserUtil.waitFor(3);

        votCustomer.clickReCaptcha();
        driver.switchTo().parentFrame();

        votCustomer.submitButton.click();
        //BrowserUtil.waitFor(3);
        votCustomer.popUpOKBtn.click();


        for(WebElement each : votCustomer.errMsg){
            actualErrMsgList.add(each.getText());
        }
        String[] errMsgArray = {
                //"An Event Date is Required.",
                //"An Event Time is Required.",
                "A description must be provided."};
        List<String> expectedErrMsgList = new ArrayList<>(Arrays.asList(errMsgArray));

        Assertions.assertArrayEquals(expectedErrMsgList.toArray(),actualErrMsgList.toArray());

    }
    @Test
    public void TC_09(){

        mainPage.navigateToForm();

        votCustomer.fillFeedbackInfo(1,2,1);

        BrowserUtil.scrollToElement(votCustomer.minutesWaiting);

        Assertions.assertTrue(votCustomer.minutesWaiting.isDisplayed());

    }
}
