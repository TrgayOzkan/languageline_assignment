package com.languageline.pages;

import com.languageline.utility.BrowserUtil;
import com.languageline.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[normalize-space()='Client Resources']")
    public WebElement clientResources;

    @FindBy(xpath = "//a[normalize-space()='Voice of the Customer']")
    public WebElement voiceOTCustomer;

    public void navigateToModule(String tab, String module) {

        //BrowserUtil.waitFor(2);
        String tabLocator = "//a[normalize-space()='"+tab+"']";
        String moduleLocator = "//a[normalize-space()='"+module+"']";

        WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
        new Actions(Driver.getDriver()).moveToElement(tabElement).pause(100).perform();

        BrowserUtil.waitForVisibility(By.xpath(moduleLocator), 10).click();

    }
    public void navigateToForm(){
        MainPage mainPage = new MainPage();
        VOTCustomer votCustomer = new VOTCustomer();

        mainPage.navigateToModule("Client Resources", "Voice of the Customer");
        Driver.getDriver().switchTo().frame(votCustomer.vocIframe);
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
    }

}
