package tests;

import org.junit.Test;

import pages.ForgotPassPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    String emptyEmailError = "This is a required field."; 
    //prazno email polje - poruka ispod polja
      
    String emptyPasswordError = "This is a required field."; 
    //prazno pasword polje - poruka ispod polja
    
    String invalidPasswordError ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."; 
    //Ovo izbacuje tri puta, nakon toga trazi da ukucamo i captcha
    
    String invalidEmailError = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    //Ovo izbacuje tri puta, nakon toga trazi da ukucamo i captcha

    

    @Test
    public void verifyIfUserCanLogin() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login(email, password);
        loginPage.chekIfUserIsLogin();   
    }

    @Test
    public void validateThatUserCanNotLogInWithoutEmail() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
    
        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login("", password);
        loginPage.checkLoginEmailErrorMesage(emptyEmailError);    
    }

    @Test
    public void validateThatUserCanNotLogInWithoutPassword() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login(email, "");
        loginPage.checkLoginPassErrorMesage(emptyPasswordError);    
    }
    @Test
    public void validateThatUserCanNotLogInWithoutEmailPassword() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login("", "");
        loginPage.checkLoginEmailErrorMesage(emptyEmailError);    
        loginPage.checkLoginPassErrorMesage(emptyPasswordError);    
    }
    @Test
    public void validateThatUserCanNotLogInWithtInvalidPassword() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login(email,"yiti");
        loginPage.checkLoginWrongPassMesage(invalidPasswordError);


 
}
    @Test
    public void validateThatUserCanNotLogInWithInvalidEmail() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login("asdiyas@sddsdf.com", password);
        loginPage.checkLoginInvalidEmailMesage(invalidEmailError);
    }
    @Test
    public void validateForgotPasswordNavigation(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPassPage forgotPage =new ForgotPassPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.navigateForgotPassPage();
        forgotPage.checkIfUserOnForgotPage();
    }
    @Test
    public void validateThatUserCanLogOut() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToLoginPage();
        loginPage.login(email, password);
        Thread.sleep(2000);//sacekaj 2 sekunde da se ucita u hederu pravi meni
        homePage.expanddropCustomerMenu();
        homePage.clickLogOutLink();
        homePage.checkIfUserLogOut();



    }
   



}
