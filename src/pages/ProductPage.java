package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver){
        super(driver);
    }
    By sizeOptionBy = By.id("option-label-size-143-item-175");
    By colorOption = By.id("option-label-color-93-item-50");
    By addToCartButtonBy = By.xpath("//button[@id='product-addtocart-button']");

public ProductPage addProductToCart(){
    click(sizeOptionBy);
    click(colorOption);
    click(addToCartButtonBy);
    return this;
}    
}
