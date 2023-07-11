package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPage extends BasePage{
    public ForgotPassPage(WebDriver driver){
        super(driver);
    }
        
        By pageTitleBy = By.xpath("//h1[@class='page-title']/span");
        String pageTitle = "Forgot Your Password?";
        

    public ForgotPassPage checkIfUserOnForgotPage(){
        String foundTitle = readText(pageTitleBy);
        checkIfTextsIsTheSame(pageTitle, foundTitle);
        return this;
    }
}

    

