package awesomecucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {



    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch(browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.firefoxdriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser: "+browser);

        }

        driver.manage().window().maximize();

        return driver;
    }







}
