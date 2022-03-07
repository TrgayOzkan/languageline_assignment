package com.languageline.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver obj;

    private Driver(){}

    public static WebDriver getDriver(){

        String browserName = ConfigReader.read("browser");

        if(obj == null){

            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    obj = new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    obj = new OperaDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    obj = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    obj = new SafariDriver();
                    break;
                default:
                    obj = null;
                    System.out.println("UNKNOWN BROWSER TYPE!" + browserName);
            }
            return obj;

        }else{
            return obj;
        }

    }

    public static void closeBrowser(){

        if(obj != null){
            obj.quit();
            obj = null;
        }
    }

}
