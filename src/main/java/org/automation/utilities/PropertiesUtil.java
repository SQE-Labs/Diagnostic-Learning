package org.automation.utilities;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {


    static Properties prop = new Properties();

    public static String getPropertyValue(String key) {
        //1. load data from properties file
        String propFilePath = System.getProperty("user.dir") + "/src/main/java/org/automation/config/config.properties";
        FileInputStream fis;
        try {
            fis = new FileInputStream(propFilePath);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //2. read data
        String value = prop.get(key).toString();

        if (StringUtils.isEmpty(value)) {
            try {
                throw new Exception("Value is not specified for key: " + key + " in properties file.");
            } catch (Exception e) {
            }
        }

        return value;
    }

    public static void setpropertyValue(String key, String value) throws IOException {
        try {
            String propFilePath = System.getProperty("user.dir") + "/src/main/java/org/automation/config/config.properties";
            FileInputStream inputStream = new FileInputStream(propFilePath);
            Properties confprop = new Properties();
            confprop.load(inputStream);
            inputStream.close();

            // Update value of property
            confprop.setProperty(key, value);

            // Write updated properties back to config file
            FileOutputStream outputStream = new FileOutputStream(propFilePath);
            confprop.store(outputStream, null);
            outputStream.close();

    } catch(
    IOException e)
    {
        e.printStackTrace();
    }

}

}

