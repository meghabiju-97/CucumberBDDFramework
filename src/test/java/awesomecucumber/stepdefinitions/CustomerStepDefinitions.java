package awesomecucumber.stepdefinitions;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.BillingDetails;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {

    private final WebDriver driver;
    private final TestContext context;
    private StorePage storePage;

    public CustomerStepDefinitions(TestContext context) {
        driver=context.driver;
        this.context = context;
        storePage= PageFactoryManager.getStorePage(driver);
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {

        storePage.load(MyConstants.STORE);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {

        context.billingDetails=billingDetails;
    }


}
