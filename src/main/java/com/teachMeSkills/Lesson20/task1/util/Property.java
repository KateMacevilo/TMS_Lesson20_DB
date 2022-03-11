package com.teachMeSkills.Lesson20.task1.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    public static String getProperties(String filePath, String key){

        try (InputStream input = new FileInputStream(filePath)) {

            Properties properties = new Properties();
            properties.load(input);

            String value = properties.getProperty(key);
            return value;

        } catch (IOException io) {
            io.printStackTrace();
            return null;
        }

    }

}
