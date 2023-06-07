package awesomecucumber.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {

    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies=cookies.asList();
        List<Cookie> seleniuCookies=new ArrayList<>();
        for(io.restassured.http.Cookie cookie:restAssuredCookies){
            seleniuCookies.add(new Cookie(cookie.getName(),cookie.getValue(),cookie.getDomain(),
                    cookie.getPath(),cookie.getExpiryDate(),cookie.isSecured(),cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }
        return seleniuCookies;

    }


}
