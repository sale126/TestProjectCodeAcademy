package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }
    String baseUrl = "https://magento.softwaretestingboard.com/";

    By hotSellersproductsBy = By.xpath("//li[@class='product-item']");//lokator za hotsellers proizvode
    int expectedNumbOfProduct = 6;//ocekivani broj hot sellers proizvoda

    By creatAccountLinkBy = By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']");
    By logoImageBy = By.xpath("//a[@href='https://magento.softwaretestingboard.com/']");
    By goToHomePageBy = By.xpath("//a[@title='Go to Home Page']");
    By sigInLinkBy = By.className("authorization-link");
    By logUotButonBy= By.xpath("//div[@aria-hidden='false']/ul/li[3]/a"); //Sign Out u padajucem meniju
    By dropCustomerMenu = By.xpath("//div[@class='panel header']/ul/li[2]/span/button"); //Padajuci meni u hederu strelica na dole
    
    By whatsNewLinkBy = By.id("ui-id-3");
    By cartPageSimbolBy = By.xpath("//*[@class='action showcart']"); //korpa(kolica) 
    By cartNumberInBy = By.xpath("//*[@class='counter-number']"); //brojac pored kolica


    //vrace trenutni kontekst HomePage strane(ovde ce otici na URL)
    public HomePage goToBaseUrl(){
        driver.get(baseUrl);
        return this;
    }
    public HomePage checkIfUserLogOut(){
        checkIfElementIsVisible(sigInLinkBy);
        return this;
    }

    //prebrojava proizvode po lokatoru koji je isti za te prouzvode i uporedjuje da li je isti broj koji trazimo
    public HomePage verifyNumberOfProducts(){
        int foundItems = countItems(hotSellersproductsBy);//broji kolko ima proizvoda u hot sellers
        checkIfNumberIsTheSame(expectedNumbOfProduct, foundItems);
        return this;

    }//proverava da li je na HomePage strani
    //prvo proverava da li vidi logo koji u hederu pa ga ima na svim stranama
    //potom proverava da li NEVIDI link na "Home" koga ima na svim ostalim stranama osim HomePage
    public HomePage validateThatUserIsOnHomePage(){
        checkIfElementIsVisible(logoImageBy);
        verifyElementNotDisplayed(goToHomePageBy);
        return this;                   
    }
    public HomePage navigateToCreateAccount(){
        click(creatAccountLinkBy);
        return this;
    }
    public HomePage navigateToLoginPage(){
        click(sigInLinkBy);
        return this;
    }
    public HomePage navigateToCartPage(){
        waitVisible(cartNumberInBy); 
        click(cartPageSimbolBy);
        return this;
    }
    //otvara padajuci meni strelica na dole pored welcome
    public HomePage expanddropCustomerMenu(){
        click(dropCustomerMenu);
        return this;
    }
    //klikne na Sign Out
    public HomePage clickLogOutLink(){
    click (logUotButonBy);
    return this;
    }
    public HomePage navigateToWhatsNew(){
        click(whatsNewLinkBy);
        return this;
    }


    
}
