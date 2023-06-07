package awesomecucumber.apis;

import io.cucumber.java.hu.Ha;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static awesomecucumber.apis.SpecBuilder.getRequestSpec;
import static awesomecucumber.apis.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class ApiRequest {

    public static Response post(String endPoint, Headers headers,
                                HashMap<String,Object> formParams, Cookies cookies){

        return given(getRequestSpec()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
        when().
                post(endPoint).
        then().spec(getResponseSpec()).
                extract().
                response();

    }

    public static Response get(String endPoint, Cookies cookies){

        return given(getRequestSpec()).
                cookies(cookies).
                when().
                post(endPoint).
                then().spec(getResponseSpec()).
                extract().
                response();

    }




}
