package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {

    private final WebDriver driver;
    private CartPage cart;

    public CartStepDefinitions(TestContext context) {

        driver=context.driver;
        cart= PageFactoryManager.getCartPage(driver);

    }




    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int expectedQuantity, Product product) {

        Assert.assertEquals(cart.getProductName(),product.getName());
        Assert.assertEquals(cart.getProductQuantity(),expectedQuantity);
    }



}
