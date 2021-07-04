package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // # 1- creat property object
    private static Properties properties = new Properties();

    static {
        // #2- load the file in FileInputStream
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            //#3- load properties object with the file (configuration.properties)
            properties.load(file);

            // close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in Configuration properties");
        }
    }

    // USE THE ABOVE CREATED LOGIC TO CREAT A RE-USABLE STATIC METHOD
    public static String getProperty (String keyWord) {
        return properties.getProperty(keyWord);
    }


}
