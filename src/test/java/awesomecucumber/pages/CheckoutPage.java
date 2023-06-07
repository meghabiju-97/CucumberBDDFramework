package awesomecucumber.pages;

import awesomecucumber.domainObjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(css="input[name='billing_first_name']")
    private WebElement billingFirstnamefld;
    @FindBy(css="input[name='billing_last_name']")
    private WebElement billingLastNameFld;
    @FindBy(css="input[placeholder='House number and street name'][name='billing_address_1']")
    private WebElement billingAddressOneFld;
    @FindBy(css="input[name='billing_city']")
    private WebElement billingCityFld;
    @FindBy(css="select[name='billing_state']")
    private WebElement billingStateDropDown;
    @FindBy(css="input[name='billing_postcode']")
    private WebElement billingZipFld;
    @FindBy(css="input[name='billing_email']")
    private WebElement billingEmailFld;
    @FindBy(css="button[value='Place order']")
    private WebElement placeOrderBtn;
    @FindBy(css=".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")
    private WebElement noticeTxt;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails){
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingAddressLineOne(billingDetails.getBillingAddressOne()).
                enterBillingCity(billingDetails.getBillingCity()).
                enterBillingState(billingDetails.getBillingStateName()).
                enterBillingZip(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
          }

    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingFirstnamefld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName) {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressOne) {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage enterBillingState(String billingState) {
        Select select=new Select(billingStateDropDown);
        select.selectByVisibleText(billingState);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip) {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }

}

