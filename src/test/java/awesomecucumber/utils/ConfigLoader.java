package awesomecucumber.utils;

import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader configLoader;
    private final Properties properties;

    private ConfigLoader(){
        properties=PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop= properties.getProperty("baseUrl");
        if(prop!=null)
            return prop;
        else throw new RuntimeException("property baseUrl not specified in the config.properties file");
    }



}
