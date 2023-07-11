package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhatsNewPage extends BasePage{
    public WhatsNewPage(WebDriver driver){
        super(driver);
    }

    By shortsMenBy = By.xpath("//div[@class='categories-menu']/ul[2]/li[6]/a");


    public WhatsNewPage navigateToShortsBottomsMen(){
        click(shortsMenBy);
        return this;
    }

}
