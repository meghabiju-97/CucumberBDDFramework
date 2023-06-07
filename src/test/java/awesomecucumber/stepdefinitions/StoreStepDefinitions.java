package awesomecucumber.stepdefinitions;

import awesomecucumber.apis.CartApi;
import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.Product;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {


    private final WebDriver driver;
    private StorePage storePage;

    private TestContext context;
    public StoreStepDefinitions(TestContext context) {
        driver=context.driver;
        this.context = context;
        storePage= PageFactoryManager.getStorePage(driver);
    }

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() throws InterruptedException {

       storePage.load(EndPoint.STORE.value);
    }
    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) throws InterruptedException {
        storePage.addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
      // storePage.addToCart("Blue Shoes");
        CartApi cartApi=new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215,1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

}
