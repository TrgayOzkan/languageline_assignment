package com.languageline.tests;

import com.languageline.pages.MainPage;
import com.languageline.pages.VOTCustomer;
import com.languageline.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory_01 extends TestBase {


   MainPage mainPage = new MainPage();
   VOTCustomer votCustomer = new VOTCustomer();

   @Test
   public void TC_01(){

       mainPage.navigateToModule("Client Resources", "Voice of the Customer");

       String expectedResult = "Voice of the Customer";
       String actualResult = votCustomer.vOtCustomer.getText();

       Assertions.assertEquals(expectedResult,actualResult);

   }


}
