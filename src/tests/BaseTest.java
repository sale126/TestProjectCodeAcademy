package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Capabilities;


public class BaseTest {
    public WebDriver driver;
    public ChromeOptions options;


    String firstName = "SsSale";
    String lastName = "SsMircetic";
    String email = "Sssalemircetic@gmail.com";
    String password = "SssaleMsale23454";
    String confirmpassword = "SssaleMsale23454";


    String phoneNumber = "3334444";
    String city = "Beograd";
    String zip = "11072";
    String streetAdress = "Omladinskih brigada 1255";

    





    @Before //Anotacija koja ce ovu metodu pokretati pre svakok testa
    public void setUp(){

      // options = new ChromeOptions();
      // options.addArguments("--ignore-certificate-errors");
      // options.addArguments("--start-maximized");
      // options.addArguments("--allow-running-insecure-content");
     //  options.addArguments("--disable-web-security");
     //  options.addArguments("--allow-insecure-localhost");


       //rasiri browser po celom ekranu(ovaj arguments radi samo u Chromu)
      
     // options.setAcceptInsecureCerts(true);
      //DesiredCapabilities desiredCap= new DesiredCapabilities();
     // desiredCap.setCapability(ChromeOptions.CAPABILITY, options);
      //desiredCap.acceptInsecureCerts();
      //options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
      //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
      //options.merge(desiredCap);

            
      // driver = new ChromeDriver(options);

        
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        
    }
   @After  //Metoda se pokrece nakon svakog testa(ugasi browser)
    public void tearDown(){
        driver.quit();
    }

    
}
