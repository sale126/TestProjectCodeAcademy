package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

        
    public BasePage(WebDriver driver){
        this.driver = driver; 
        // this.driver se odnosi na promenljivu kojoj dodeljujemo parametar driver 
        //koje nam proslede page klase (driver-browswer)
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // browser(driver) ceka 10s da se ispuni uslov
    }



//samo sacekaj da element bude vidljiv
public void waitVisible (By elementBy){
    wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
}

//samo sacekaj da element bude klikabilan
public void waitClickable(By elementBy){
    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
}

//sacekaj da element bude klikabilan, onda ga ocisti i unesi text u to polje
public void writeText(By elementBy, String text){
    waitClickable(elementBy);
    driver.findElement(elementBy).clear();
    driver.findElement(elementBy).sendKeys(text);
}

// prvo da sacekamo da element bude klikabilan, a onda klikni na njega
public void click(By elementBy){
    waitClickable(elementBy);
    driver.findElement(elementBy).click();
}

//sacekaJ da element bude vidljiv a onda iscitaj tekst sa njega
public String readText(By elementBy){
    waitVisible(elementBy);
    return driver.findElement(elementBy).getText();
    
}
//metoda koja poredi dva Stringa da li su jednaka
public void checkIfTextsIsTheSame(String expectedText, String foundText){
    Assert.assertEquals(expectedText, foundText);
}
//metoda koja proverava da li je element vidljiv
public void checkIfElementIsVisible(By elementBy){
    waitVisible(elementBy);
    boolean isVisible = driver.findElement(elementBy).isDisplayed();
    Assert.assertTrue(isVisible);
}
//metoda koja vraca broj elemenata
public int countItems(By elemenBy){
    waitVisible(elemenBy);
    return driver.findElements(elemenBy).size();
}
//metoda koja poredi dva intigera(broja) da li su jednaka
public void checkIfNumberIsTheSame(int expectedNum, int foundNum){
    Assert.assertEquals(expectedNum, foundNum);
}
//metoda koja proverava da li su dva broja ista tipa double
public void checkIfNumberIsTheSame(double expectedNum, double foundNum){
    Assert.assertEquals(expectedNum, foundNum, 0.1);
}


//metoda koja treba da iscita href parametar sa elementa
public String readHref(By elementBy){
    waitVisible(elementBy);
    return driver.findElement(elementBy).getAttribute("href");
}
//metoda koja ce odabrati vrednost iz padajuce liste po vrednosti
public void selectDropdownOptionByValue(By elementBy, String value){
waitVisible(elementBy);
Select select = new Select(driver.findElement(elementBy));
select.selectByValue(value);
}
//metoda koja ce string pokusati da pretvori u double
public double parseStringToDouble(String stringToParse){
return Double.parseDouble(stringToParse);
}
//metoda koja proverava da li element nije vidljiv
public void verifyElementNotDisplayed(By elementBy){
boolean isNotVisible;
try{
    waitVisible(elementBy);
    isNotVisible = !driver.findElement(elementBy).isDisplayed();
}
catch(Exception e){
    isNotVisible=true;
}
Assert.assertTrue(isNotVisible);
}
}
