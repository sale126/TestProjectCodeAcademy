package tests;

import org.junit.Test;

import pages.AddNewAdressPage;
import pages.CreateAccountPage;
import pages.HomePage;

public class CreateAccountTest extends BaseTest{
    


//Prvo pravim acaunt a potom a potom popunjavam i adresu
//(adresa mi je potrebna kad ubacim u kurpu da mi uracuna tax u mom slucaju shipping posto sam izabrao Srbiju)
    
@Test
     public void createAnAccount() throws InterruptedException{
          
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        AddNewAdressPage addNewAdressPage = new AddNewAdressPage(driver);

        homePage.goToBaseUrl();
        homePage.navigateToCreateAccount();
        createAccountPage.fillOutInformaion(firstName, lastName, email, password, confirmpassword);
        Thread.sleep(1000);//saceksj 1 sekundu da se ucitaju podaci
        createAccountPage.clikCreateAccount();
        createAccountPage.validateThatAccountIsCreated();        
        createAccountPage.navigateToAddAdress();
        addNewAdressPage.addAdressPhoneZipCountry(phoneNumber,streetAdress,city,zip);
        addNewAdressPage.validateThatAdressIsSaved();
        
     }
    
}
