package com.languageline.tests;

import com.languageline.pages.MainPage;
import com.languageline.pages.VOTCustomer;
import com.languageline.utility.BrowserUtil;
import com.languageline.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory_03 extends TestBase {

    MainPage mainPage = new MainPage();
    VOTCustomer votCustomer = new VOTCustomer();

    @Test
    public void TC_01(){

        mainPage.navigateToForm();

        votCustomer.product.click();
        //BrowserUtil.waitFor(1);
        BrowserUtil.waitForVisibility(By.id("pg:frm:voc_product"),1);
        Select productObj = new Select(votCustomer.product);
        List<WebElement> list = productObj.getOptions();
        int expected = 6;
        int actual = list.size()-1;
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void TC_02(){

        mainPage.navigateToForm();

        Assertions.assertEquals(6,votCustomer.getCategorySize(1));

    }
    @Test
    public void TC_03(){

        mainPage.navigateToForm();

        Assertions.assertEquals(6,votCustomer.getCategorySize(2));

    }
    @Test
    public void TC_04(){

        mainPage.navigateToForm();

        Assertions.assertEquals(5,votCustomer.getCategorySize(3));

    }
    @Test
    public void TC_05(){

        mainPage.navigateToForm();

        Assertions.assertEquals(4,votCustomer.getCategorySize(4));

    }

    @Test
    public void TC_06(){

        mainPage.navigateToForm();

        Assertions.assertEquals(6,votCustomer.getCategorySize(5));

    }
    @Test
    public void TC_07(){

        mainPage.navigateToForm();

        Assertions.assertEquals(5,votCustomer.getCategorySize(6));

    }
    @Test
    public void TC_08(){

        mainPage.navigateToForm();

        Assertions.assertEquals(3,votCustomer.getSubCategorySize(1,1));

    }

    @Test
    public void TC_09(){

        mainPage.navigateToForm();

        Assertions.assertEquals(5,votCustomer.getSubCategorySize(1,2));

    }
    @Test
    public void TC_10(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(1,3));

    }
    @Test
    public void TC_11(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(1,4));

    }
    @Test
    public void TC_12(){

        mainPage.navigateToForm();

        Assertions.assertEquals(8,votCustomer.getSubCategorySize(1,5));

    }
    @Test
    public void TC_13(){

        mainPage.navigateToForm();

        Assertions.assertEquals(6,votCustomer.getSubCategorySize(1,6));

    }
    @Test
    public void TC_14(){

        mainPage.navigateToForm();

        Assertions.assertEquals(3,votCustomer.getSubCategorySize(2,1));

    }

    @Test
    public void TC_15(){

        mainPage.navigateToForm();

        Assertions.assertEquals(1,votCustomer.getSubCategorySize(2,2));

    }
    @Test
    public void TC_16(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(2,3));

    }
    @Test
    public void TC_17(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(2,4));

    }
    @Test
    public void TC_18(){

        mainPage.navigateToForm();

        Assertions.assertEquals(7,votCustomer.getSubCategorySize(2,5));

    }
    @Test
    public void TC_19(){

        mainPage.navigateToForm();

        Assertions.assertEquals(9,votCustomer.getSubCategorySize(2,6));

    }
    @Test
    public void TC_20(){

        mainPage.navigateToForm();

        Assertions.assertEquals(3,votCustomer.getSubCategorySize(3,1));

    }

    @Test
    public void TC_21(){

        mainPage.navigateToForm();

        Assertions.assertEquals(3,votCustomer.getSubCategorySize(3,2));

    }
    @Test
    public void TC_22(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(3,3));

    }
    @Test
    public void TC_23(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(3,4));

    }
    @Test
    public void TC_24(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(3,5));

    }

    @Test
    public void TC_25(){

        mainPage.navigateToForm();

        Assertions.assertEquals(3,votCustomer.getSubCategorySize(4,1));

    }

    @Test
    public void TC_26(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(4,2));

    }
    @Test
    public void TC_27(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(4,3));

    }
    @Test
    public void TC_28(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(4,4));

    }

    @Test
    public void TC_29(){

        mainPage.navigateToForm();

        Assertions.assertEquals(4,votCustomer.getSubCategorySize(5,1));

    }

    @Test
    public void TC_30(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(5,2));

    }
    @Test
    public void TC_31(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(5,3));

    }
    @Test
    public void TC_32(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(5,4));

    }
    @Test
    public void TC_33(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(5,5));

    }
    @Test
    public void TC_34(){

        mainPage.navigateToForm();

        Assertions.assertEquals(1,votCustomer.getSubCategorySize(5,6));

    }
    @Test
    public void TC_35(){

        mainPage.navigateToForm();

        Assertions.assertEquals(4,votCustomer.getSubCategorySize(6,1));

    }

    @Test
    public void TC_36(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(6,2));

    }
    @Test
    public void TC_37(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(6,3));

    }
    @Test
    public void TC_38(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(6,4));

    }
    @Test
    public void TC_39(){

        mainPage.navigateToForm();

        Assertions.assertEquals(2,votCustomer.getSubCategorySize(6,5));

    }
    @Test
    public void TC_40(){

        mainPage.navigateToForm();
        List<Integer> actualList = new ArrayList<>();
        for ( int i = 1; i < 7; i++) {
            if (i == 1 || i ==2 || i == 5) {
                for (int j = 1; j < 7; j++) {
                    actualList.add(votCustomer.getSubCategorySize(i, j));
                }
            }else if(i == 3 || i ==6){
                for (int j = 1; j < 6; j++) {
                    actualList.add(votCustomer.getSubCategorySize(i, j));
                }
            }else if(i == 4){
                for (int j = 1; j < 5; j++) {
                    actualList.add(votCustomer.getSubCategorySize(i, j));
                }
            }
        }
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(3, 5, 2, 2, 8, 6, 3, 1, 2, 2, 7, 9, 3, 3, 2, 2, 2, 3, 2, 2, 2, 4, 2, 2, 2, 2, 1, 4, 2, 2, 2, 2));
        System.out.println("actualList = " + actualList);
       System.out.println("expectedList = " + expectedList);
        Assertions.assertArrayEquals(expectedList.toArray(),actualList.toArray());
    }
    @Test
    public void TC_41(){

        mainPage.navigateToForm();
        List<Integer> actualList = new ArrayList<>();
        for ( int i = 1; i < 7; i++) {

                actualList.add(votCustomer.getCategorySize(i));

        }
         List<Integer> expectedList = new ArrayList<>(Arrays.asList(6, 6, 5, 4, 6, 5));
        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);
        Assertions.assertArrayEquals(expectedList.toArray(),actualList.toArray());
    }

}
// List<Integer> actualList = new ArrayList<>();
//