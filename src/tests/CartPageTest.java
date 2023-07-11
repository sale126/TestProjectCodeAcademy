package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShortsBottomMenPage;
import pages.WhatsNewPage;

public class CartPageTest extends BaseTest{



    @Test
    public void verifyTotalPrice() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
        ShortsBottomMenPage shortsMenPage = new ShortsBottomMenPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login(email, password);
        homePage.navigateToWhatsNew();
        whatsNewPage.navigateToShortsBottomsMen();
        shortsMenPage.navigateToProductPage();
        productPage.addProductToCart();
        Thread.sleep(2000);//sacekaj 2 sekunde da se product ucita u korpu
        homePage.navigateToCartPage();
        cartPage.verifyProductIsAddINCart();
        cartPage.verifyPrice();

    }

    
}
