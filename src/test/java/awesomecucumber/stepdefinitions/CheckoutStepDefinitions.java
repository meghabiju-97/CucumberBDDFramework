package awesomecucumber.stepdefinitions;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.BillingDetails;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDefinitions {

    private final WebDriver driver;
    private final BillingDetails billingDetails;
    private CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext context) {
        driver=context.driver;
        billingDetails=context.billingDetails;
        checkoutPage= PageFactoryManager.getCheckoutPage(driver);


    }







    @When("I provide billing details")
    public void iProvideBillingDetails() {

        checkoutPage.setBillingDetails(billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        checkoutPage.placeOrder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {

        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {

       checkoutPage.load(EndPoint.CHECKOUT.value);
    }

}
