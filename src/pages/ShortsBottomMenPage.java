package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShortsBottomMenPage extends BasePage{
    public ShortsBottomMenPage(WebDriver driver){
        super(driver);
    }
    By productLinkBy = By.xpath("//ol[@class='products list items product-items']/li[3]");

    By sizeOptionBy = By.id("option-label-size-143-item-175");
    By colorOption = By.id("option-label-color-93-item-50");
    By addToCartButtonBy = By.xpath("//butonn[@class='action tocart primary']");


public ShortsBottomMenPage navigateToProductPage(){
    click(productLinkBy);
    return this;
}

}