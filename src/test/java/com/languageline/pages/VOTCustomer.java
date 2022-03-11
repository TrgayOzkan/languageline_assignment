package com.languageline.pages;

import com.github.javafaker.Faker;
import com.languageline.utility.BrowserUtil;
import com.languageline.utility.Driver;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VOTCustomer {

    WebDriver driver = Driver.getDriver();
    public VOTCustomer(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//h1[text()='Voice of the Customer']")
    public WebElement vOtCustomer;

    @FindBy(id = "pg:frm:firstname" )
    public WebElement firstName;

    @FindBy(xpath = "//div[@class='mouseOverInfoOuter']")//span[@id='pg:frm:j_id36']/
    public WebElement firstNameIcon;

    @FindBy(id = "pg:frm:lastname" )
    public WebElement lastName;

    @FindBy(id = "pg:frm:email" )
    public WebElement email;

    @FindBy(xpath = "//span[@id='pg:frm:j_id50']/div[@class='mouseOverInfoOuter']")
    public WebElement emailIcon;

    @FindBy(id = "pg:frm:client_id" )
    public WebElement clientID;

    @FindBy(id = "pg:frm:phone" )
    public WebElement phoneNumber;

    @FindBy(id = "pg:frm:company" )
    public WebElement companyName;

    @FindBy(id = "pg:frm:voc_product" )
    public WebElement product;

    @FindBy(id = "pg:frm:category" )
    public WebElement category;

    @FindBy(xpath = "//select[@name='pg:frm:j_id105']" )
    public WebElement subCategory;

    @FindBy(id = "pg:frm:voc_timeZone" )
    public WebElement timeZone;

    @FindBy(id = "pg:frm:j_id124" )
    public WebElement eventDate;

    @FindBy(css = "a.calToday" )
    public WebElement eventDateToday;

    @FindBy(id = "pg:frm:timepicker" )
    public WebElement eventTime;

    @FindBy(css = "div.prev.action-next" )
    public WebElement eventTimePicker;

    @FindBy(id = "pg:frm:dialed_number" )
    public WebElement dialedNumber;

    @FindBy(id = "pg:frm:langPnl" )
    public WebElement language;

    @FindBy(name = "pg:frm:j_id169" )
    public WebElement selectLanguage;

    @FindBy(id = "pg:frm:interpreter_id_number" )
    public WebElement interpreterID;

    @FindBy(id = "pg:frm:description" )
    public WebElement description;

    @FindBy(xpath = "//span[@role='checkbox']" )
    public WebElement reCaptcha;

    @FindBy(id = "feedbackText" )
    public WebElement feedbackText;

    @FindBy(css = "input.submit-button" )
    public WebElement submitButton;

    @FindBy(css= "iframe#voc-submission")
    public WebElement vocIframe;

    @FindBy(xpath= "//iframe[@title='reCAPTCHA']")
    public WebElement recIframe;

    @FindBy(css="span.errorMsg")
    public List<WebElement> errMsg;

    @FindBy(css="div.mpopup-main")
    public WebElement popUpMsg;

    @FindBy(xpath= "//input[@id='pg:frm:j_id204']")
    public WebElement popUpOKBtn;

    @FindBy(xpath= "//input[@id='pg:frm:j_id202']")
    public WebElement popUpCancelBtn;

    @FindBy(css="span.rc-anchor-error-msg")
    public WebElement reCaptchaErrMsg;

    @FindBy(xpath="//input[@id='pg:frm:MinutesWaiting']")
    public WebElement minutesWaiting;


    public void fillPerInfo(){


        BrowserUtil.waitFor(3);
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        BrowserUtil.waitFor(1);
        lastName.sendKeys(faker.name().lastName());
        BrowserUtil.waitFor(1);
        email.sendKeys(faker.internet().emailAddress());
        BrowserUtil.waitFor(1);
        clientID.sendKeys(faker.number().digits(4));
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        companyName.sendKeys(faker.company().name());
        BrowserUtil.waitFor(3);
    }

    public void fillFeedbackInfo(int num1, int num2, int num3){

       // BrowserUtil.waitFor(3);
        product.click();
        //BrowserUtil.waitFor(1);
        BrowserUtil.waitForVisibility(By.id("pg:frm:voc_product"),1);
        Select productObj = new Select(product);
        productObj.selectByIndex(num1);
        category.click();
       // BrowserUtil.waitFor(1);
        BrowserUtil.waitForVisibility(category,2);
        Select categoryObj = new Select(category);
        categoryObj.selectByIndex(num2);
        subCategory.click();
      //  BrowserUtil.waitFor(1);
        BrowserUtil.waitElementToBeClickable(subCategory,2);
        Select subCategoryObj = new Select(subCategory);
        subCategoryObj.selectByIndex(num3);
      //  BrowserUtil.waitFor(2);

    }

        public void fillTime(){

            BrowserUtil.waitFor(1);
            timeZone.click();
            BrowserUtil.waitFor(1);
            BrowserUtil.waitForVisibility(timeZone,1);
            Select timeObj = new Select(timeZone);
            timeObj.selectByIndex(0);
            eventDate.click();
            BrowserUtil.waitFor(1);
            BrowserUtil.waitForVisibility(eventDateToday,1);
            eventDateToday.click();
            eventTime.click();
            BrowserUtil.waitForVisibility(eventTimePicker,1);
            eventTimePicker.click();
            BrowserUtil.waitFor(2);
        }
        public void fillOthers(){

            Faker faker = new Faker();
            dialedNumber.sendKeys(faker.phoneNumber().cellPhone());
            language.click();
            Select langObj = new Select(selectLanguage);
            langObj.selectByValue("a2XF0000000cDoSMAU");
            interpreterID.click();
            interpreterID.sendKeys(faker.number().digits(6));
            description.sendKeys("This is a Technology Quality Assurance Team test, please disregard");
            BrowserUtil.waitFor(2);
            driver.switchTo().frame(recIframe);
            //BrowserUtil.scrollToElement(reCaptcha);
            reCaptcha.click();
            driver.switchTo().parentFrame();
            feedbackText.click();
            submitButton.click();
        }

        public void clickReCaptcha(){

            BrowserUtil.waitFor(3);
            driver.switchTo().frame(recIframe);

            reCaptcha.click();
        }

        public void fillVOTCForm(){

            driver.switchTo().frame(vocIframe);
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Faker faker = new Faker();

            firstName.sendKeys(faker.name().firstName());
           // BrowserUtil.waitFor(2);
            lastName.sendKeys(faker.name().lastName());
            //BrowserUtil.waitFor(2);
            email.sendKeys(faker.internet().emailAddress());
            //BrowserUtil.waitFor(2);
            clientID.sendKeys(faker.number().digits(4));
            //BrowserUtil.waitFor(2);
            phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
            //BrowserUtil.waitFor(2);
            companyName.sendKeys(faker.company().name());
           // BrowserUtil.waitFor(2);
            product.click();
            BrowserUtil.waitForVisibility(By.id("pg:frm:voc_product"),1);
            Select productObj = new Select(product);
            productObj.selectByIndex(1);
            //BrowserUtil.waitFor(2);
            category.click();
            BrowserUtil.waitForVisibility(category,2);
            Select categoryObj = new Select(category);
            categoryObj.selectByIndex(3);
            //BrowserUtil.waitFor(2);
            subCategory.click();
            BrowserUtil.waitElementToBeClickable(subCategory,2);
            Select subCategoryObj = new Select(subCategory);
            subCategoryObj.selectByIndex(1);
            //BrowserUtil.waitFor(2);
            timeZone.click();
            BrowserUtil.waitForVisibility(timeZone,1);
            Select timeObj = new Select(timeZone);
            timeObj.selectByIndex(0);
            //BrowserUtil.waitFor(2);
            eventDate.click();
            BrowserUtil.waitForVisibility(eventDateToday,1);
            eventDateToday.click();
            //BrowserUtil.waitFor(2);
            eventTime.click();
            BrowserUtil.waitForVisibility(eventTimePicker,1);
            eventTimePicker.click();
            //BrowserUtil.waitFor(1);
            dialedNumber.sendKeys(faker.phoneNumber().cellPhone());
            //BrowserUtil.waitFor(2);
            language.click();
            Select langObj = new Select(selectLanguage);
            langObj.selectByValue("a2XF0000000cDoSMAU");
            //BrowserUtil.waitFor(2);
            interpreterID.click();
            //BrowserUtil.waitFor(2);
            interpreterID.sendKeys(faker.number().digits(6));
            //BrowserUtil.waitFor(2);
            description.sendKeys("This is a Technology Quality Assurance Team test, please disregard");
            //BrowserUtil.waitFor(2);
            driver.switchTo().frame(recIframe);
            //BrowserUtil.waitFor(2);
            reCaptcha.click();

            driver.switchTo().parentFrame();

            feedbackText.click();

            submitButton.click();

        }
            public void fillVOTCForm2(){

                driver.switchTo().frame(vocIframe);
                Actions actions = new Actions(Driver.getDriver());
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                fillPerInfo();
                fillFeedbackInfo(1,1,1);
                fillTime();
                fillOthers();

            }
        public void clickProduct(){
            product.click();
            BrowserUtil.waitForVisibility(By.id("pg:frm:voc_product"),1);
            Select productObj = new Select(product);
            productObj.selectByIndex(1);
        }
        public void clickCategory(){
            category.click();
            BrowserUtil.waitForVisibility(category,2);
            Select categoryObj = new Select(category);
            categoryObj.selectByIndex(3);
    }

    public int getCategorySize(int num1){

        product.click();
        BrowserUtil.waitForVisibility(By.id("pg:frm:voc_product"),3);
        Select productObj = new Select(product);
        productObj.selectByIndex(num1);

        category.click();
        BrowserUtil.waitForVisibility(category,3);
        Select categoryObj = new Select(category);

        List<WebElement> list = categoryObj.getOptions();

       return list.size()-1;

    }
    public int getSubCategorySize(int num1, int num2){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        product.click();
        BrowserUtil.waitFor(1);
        BrowserUtil.waitForVisibility(subCategory,3);
        BrowserUtil.waitElementToBeClickable(product,3);
        Select productObj = new Select(product);
        productObj.selectByIndex(num1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        category.click();
        BrowserUtil.waitFor(1);
        BrowserUtil.waitForVisibility(subCategory,3);
        BrowserUtil.waitElementToBeClickable(category,3);
        Select categoryObj = new Select(category);
        categoryObj.selectByIndex(num2);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        subCategory.click();
        BrowserUtil.waitFor(1);
        BrowserUtil.waitForVisibility(subCategory,3);
        BrowserUtil.waitElementToBeClickable(subCategory,3);
        Select subCategoryObj = new Select(subCategory);

        List<WebElement> list = subCategoryObj.getOptions();

        return list.size()-1;

    }

}
