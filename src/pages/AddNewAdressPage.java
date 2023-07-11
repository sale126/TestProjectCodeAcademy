package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewAdressPage extends BasePage{
    public AddNewAdressPage(WebDriver driver){
        super(driver);
    }
    By phoneNumberBy = By.xpath("//input[@id='telephone']");
    By streetAdressBy = By.xpath("//input[@id='street_1']");
    By cityBy = By.xpath("//input[@id='city']");
    By zipBy = By.xpath("//input[@id='zip']");
    
    By countryBy = By.id("country");
    By serbiaBy = By.xpath("//option[@value='RS']");

    By saveAdressBy = By.xpath("//*[@title='Save Address']");

    By mesageAdressBy = By.xpath("//div[@class='message-success success message']/div");
    String expectedText = "You saved the address.";



    public AddNewAdressPage addAdressPhoneZipCountry(String phoneNumber, String streetAdress, String city,String zip){
        writeText(phoneNumberBy, phoneNumber);
        writeText(streetAdressBy, streetAdress);
        writeText(cityBy, city);
        writeText(zipBy, zip);
        click(countryBy);
        click(serbiaBy);
        click(saveAdressBy);
        return this;   
    }

    public AddNewAdressPage validateThatAdressIsSaved(){
        String foundText = readText(mesageAdressBy);
        checkIfTextsIsTheSame(expectedText, foundText);
        return this;
    }


}
