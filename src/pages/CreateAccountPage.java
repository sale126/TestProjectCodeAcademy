package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver driver){
        super(driver);
        
    }

    By firstNameBy = By.xpath("//input[@id='firstname']");
    By lastNameBy = By.xpath("//input[@id='lastname']");   
    By emailBy = By.xpath("//input[@id='email_address']");
    By passwordBy = By.xpath("//input[@id='password']");   
    By confirmpasswordBy = By.xpath("//input[@id='password-confirmation']");
   
    By createAccountButonBy = By.xpath("//button[@title='Create an Account']");

    By accConfirMesageFieldBy = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    String expectedText = "Thank you for registering with Main Website Store.";

    By manageAdressBy = By.linkText("Manage Addresses");


    public CreateAccountPage fillOutInformaion(String firstName, String lastName, String email,String password, String confirmpassword){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(emailBy, email);
        writeText(passwordBy, password);
        writeText(confirmpasswordBy, confirmpassword);
        return this;

    }
    public CreateAccountPage navigateToAddAdress(){
        click(manageAdressBy);
        return this;

       
    }
    public CreateAccountPage clikCreateAccount(){
        click(createAccountButonBy);
        return this;
    }

    public CreateAccountPage validateThatAccountIsCreated(){
        String foundText = readText(accConfirMesageFieldBy);
        checkIfTextsIsTheSame(expectedText, foundText);
        return this;
    }
}
