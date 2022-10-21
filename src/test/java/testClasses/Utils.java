package testClasses;

import javax.naming.ConfigurationException;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Utils {

    public static String setEnvVariable(String key, String value) throws ConfigurationException, org.apache.commons.configuration.ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/main/java/properties/config.properties");
        config.setProperty(key, value);
        config.save();
        return value;

    }
}