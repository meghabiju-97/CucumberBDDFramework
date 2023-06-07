package awesomecucumber.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");



    public final String value;


    EndPoint(String value) {
        this.value=value;
    }
}
