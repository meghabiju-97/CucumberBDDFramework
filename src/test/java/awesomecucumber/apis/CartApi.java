package awesomecucumber.apis;

import awesomecucumber.constants.EndPoint;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

public class CartApi {
    public CartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    private Cookies cookies;

    public Response addToCart(int productId, int quantity){
        Header header=new Header("content-type","application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        HashMap<String,Object> formParams=new HashMap<>();
        formParams.put("product_sku","");
        formParams.put("product_id",productId);
        formParams.put("quantity",quantity);

        Response response=ApiRequest.post(EndPoint.ADD_TO_CART.value, headers,formParams,cookies);

        if(response.getStatusCode()!=200) {
            throw new RuntimeException("Failed to add product" + productId + "to the cart" +
                    ",HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies=response.getDetailedCookies();
        return response;
        }

    }

