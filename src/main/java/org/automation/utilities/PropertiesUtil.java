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

    public static void setPropertyValue(String key, String value) {
        //1. load data from properties file
        String propFilePath = System.getProperty("user.dir") + "/src/main/java/org/automation/config/config.properties";
        Properties confprop = new Properties();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(propFilePath);
            confprop.setProperty(key, value);
            prop.store(fos, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key, String configFile) {
        //1. load data from properties file
        String propFilePath = System.getProperty("user.dir") + "/src/main/java/org/automation/config/" + configFile;
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
}

