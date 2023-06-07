package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final TestContext context;

    public MyHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void before(){
        driver= DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        context.driver=driver;
    }

    @After
    public void after(){
        driver.quit();
    }


}
