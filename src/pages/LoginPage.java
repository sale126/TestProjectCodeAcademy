package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    By emailUserBy = By.id("email");
    By passwordBy = By.xpath("//input[@name='login[password]']");
    By customerLoginInButBy = By.xpath("//*[@class='action login primary']"); 
    //Sign in u strani

    By sigInLinkBy = By.className("authorization-link"); //Sign in link u hederu
    By logoImageBy = By.xpath("//a[@href='https://magento.softwaretestingboard.com/']");
    By goToHomePageBy = By.xpath("//a[@title='Go to Home Page']");


    By emailErrorBy = By.id("email-error"); //tekst ispod praznog email  
    By passwordErrorBy = By.id("pass-error"); //tekst ispod praznog passworda

    By invalidEmailBy = By.xpath("//div[@role='alert']/div/div");//crveno alert iskace kad je pogresan mejl   
    By invalidPasswordBy = By.xpath("//div[@role='alert']/div/div");// -II-

    By ForgotPassLinkBy = By.xpath("//a[@class='action remind']");


    By welcomeTitle = By.xpath("//span[text()='Welcome, SsSale SsMircetic!']");
    

    public LoginPage login(String email, String password) throws InterruptedException  {
        writeText(emailUserBy, email);
        writeText(passwordBy, password); 
        Thread.sleep(2000); 
        //ovde mu kazem da samo saceka jednu sekundu pre nego nastavi da klikne Sign In
        //ako mu to nekazem on ce kliknuti na neko skriveno dugme koje ima identican lokator koje se nalazi negde u hederu 
        //i prvo se pojavi u Doomu ali potom nestane tako da ce clik uspeti da ga vidi i da klikne na njega 
        //i odvesce nas na stranicu koju inace nevidimo kad se rucno loguje, 
        // test mora da malo uspori da se ucitaju svi elementi
        

        click(customerLoginInButBy);
        return this;
    }
    //metoda proverava da li je user ulogovan (prvo prvoreri da li vidi link na logo onda da NEVIDI "Sign in")
    
    public LoginPage chekIfUserIsLogin(){
        //checkIfElementIsVisible(logoImageBy);
        checkIfElementIsVisible(welcomeTitle);

       // verifyElementNotDisplayed(sigInLinkBy);
        return this;
    }
    public LoginPage checkLoginEmailErrorMesage(String expectedText){
    String foundError = readText(emailErrorBy);
    checkIfTextsIsTheSame(expectedText, foundError);
    return this;
    }
    public LoginPage checkLoginPassErrorMesage(String expectedText){
        String foundError = readText(passwordErrorBy);
        checkIfTextsIsTheSame(expectedText, foundError);
        return this;    
    }
    public LoginPage checkLoginWrongPassMesage(String expectedText){
        String foundError = readText(invalidPasswordBy);
        checkIfTextsIsTheSame(expectedText, foundError);
        return this;    
    }
    public LoginPage checkLoginInvalidEmailMesage(String expectedText){
        String foundError = readText(invalidEmailBy);
        checkIfTextsIsTheSame(expectedText, foundError);
        return this;    
    }
    public LoginPage navigateForgotPassPage(){
        click(ForgotPassLinkBy);
        return this;
    }
    


}
