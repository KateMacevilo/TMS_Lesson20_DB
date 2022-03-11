package com.teachMeSkills.Lesson20.task1.service;

import com.teachMeSkills.Lesson20.task1.util.Property;

import java.sql.*;

public class DBConnection {

    private static Connection connection;
    private static final String PATH_DB_PROPERTIES = "D:\\все_файлы\\java\\projects\\JavaEE\\TMS_Lesson20(Maven, JDBC)\\TMS_Lesson20(2)\\src\\main\\resources\\database.properties";
    private static final String URL = Property.getProperties(PATH_DB_PROPERTIES,"url");
    private static final String USER = Property.getProperties(PATH_DB_PROPERTIES, "user");
    private static final String PASSWORD = Property.getProperties(PATH_DB_PROPERTIES,"password");

    private DBConnection() {
    }

    public static Connection getConnectionToDB() {

        if (connection == null) {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Connect");
                return connection;

            } catch (SQLException e) {
                System.out.println("Error of driver class " + e.getMessage());
                return null;
            }
        } else {
            return connection;
        }

    }

}
