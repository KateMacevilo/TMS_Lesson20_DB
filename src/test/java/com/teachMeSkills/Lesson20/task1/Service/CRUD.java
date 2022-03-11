package com.teachMeSkills.Lesson20.task1.Service;

import java.sql.*;

public class CRUD {

    public static void getStudentsInfo(Connection connection) {

        String SQL = "SELECT si.idStudent, si.name, si.lastName, c.name as city, si.course FROM students.students_info si\n" +
                "LEFT JOIN students.city c on c.idcity = si.idcity where si.course = 'Java'";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String city = resultSet.getString("city");
                String course = resultSet.getString("course");

                System.out.println("idStudent " + id);
                System.out.println("name " + name);
                System.out.println("lastName " + lastName);
                System.out.println("city " + city);
                System.out.println("course " + course);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error in the getStudentsCity method " + e.getMessage());
        }
    }

    public static void getCity(Connection connection){
        String SQL = "SELECT * FROM city";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idcity");
                String name = resultSet.getString("name");

                System.out.println("idCity " + id);
                System.out.println("name " + name);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error in the getCity method " + e.getMessage());
        }
    }


    public static boolean deleteStudent(Connection connection, int id) {

        String SQL = "DELETE FROM students_info WHERE idStudent = '" + id + "' ";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
            System.out.println("Student was deleted");
            return true;
        } catch (SQLException e) {
            System.out.println("Error in the deleteStudent method " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteCity(Connection connection, int id) {
        String SQL = "DELETE FROM city WHERE idcity = '" + id + "' ";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
            System.out.println("City was deleted ");
            return true;
        } catch (SQLException e) {
            System.out.println("Error in the deleteCity method " + e.getMessage());
            return false;
        }
    }

    public static boolean addStudent(Connection connection, String name, String lastName, int idCity, String course) {
        String SQL = "INSERT INTO students_info (name, lastname, idcity, course) "
                + " values (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, idCity);
            statement.setString(4, course);
            statement.executeUpdate();

            System.out.println("Student was added ");

            return true;

        } catch (SQLException e) {
            System.out.println("Error in the addStudent method " + e.getMessage());
            return false;
        }

    }

    public static boolean addCity(Connection connection, String cityName) {
        String SQL = "INSERT INTO city (name) "
                + " values (?)";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, cityName);
            statement.executeUpdate();
            System.out.println("City was added ");
            return true;

        } catch (SQLException e) {
            System.out.println("Error in the addCity method " + e.getMessage());
            return false;
        }

    }

}
