package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    By viewCarrtBy = By.xpath("//*[@class='action viewcart']/span");
    By productQtyBy = By.xpath("//*[@data-cart-item-id='MSH10-32-Blue']");

    By subtotalBy = By.xpath("//td[@data-th='Subtotal']/span/span/span");
    By shippingBy = By.xpath("//span[@data-th='Shipping']");
    By orderTotalBy = By.xpath("//td[@data-th='Order Total']/strong/span");


    
public CartPage verifyProductIsAddINCart(){
    click(viewCarrtBy);
    checkIfElementIsVisible(productQtyBy);
    return this;
}
public CartPage verifyPrice(){
    String subtotalText = readText(subtotalBy);
    String shippingText = readText(shippingBy);
    String orederTotalText = readText(orderTotalBy);

    double priceSubtotal = parseStringToDouble(subtotalText.substring(1));
    //pretvara string u broj(double) od drugog znaka, znaci bez dolara
    double shipping = parseStringToDouble(shippingText.substring(1));
    double orderTotalPrice = parseStringToDouble(orederTotalText.substring(1));
    checkIfNumberIsTheSame(shipping+priceSubtotal, orderTotalPrice);

    return this;

}

}

