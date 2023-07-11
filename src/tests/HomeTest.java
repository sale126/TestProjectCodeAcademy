package tests;

import org.junit.Test;

import pages.HomePage;

public class HomeTest extends BaseTest{


    @Test
    public void navigateToURL(){
        HomePage homePage = new HomePage(driver);
        homePage.goToBaseUrl();
        homePage.validateThatUserIsOnHomePage();
     }

     @Test
     public void validateNumOfProductHotSelersCat(){
        HomePage homePage = new HomePage(driver);
        homePage.goToBaseUrl();
        homePage.verifyNumberOfProducts();
     }
     
}
