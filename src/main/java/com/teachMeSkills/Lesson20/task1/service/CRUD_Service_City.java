package com.teachMeSkills.Lesson20.task1.service;

import com.teachMeSkills.Lesson20.task1.model.City;
import com.teachMeSkills.Lesson20.task1.model.IModel;
import com.teachMeSkills.Lesson20.task1.model.Model;
import com.teachMeSkills.Lesson20.task1.util.Property;

import java.sql.*;
import java.util.ArrayList;

public class CRUD_Service_City implements IService {

    private static Connection connection = DBConnection.getConnectionToDB();
    private static final String GET_CITY = "SELECT * FROM city";
    private static final String DELETE_CITY = "DELETE FROM city WHERE idcity = ?";
    private static final String ADD_CITY = "INSERT INTO city (name) values (?)";

    public CRUD_Service_City() {
    }

    @Override
    public void getAll() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_CITY)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idcity");
                String name = resultSet.getString("name");

                System.out.println("idCity " + id);
                System.out.println("name " + name);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error in the getAll City method " + e.getMessage());
        }
    }

    @Override
    public boolean deleteInfoByID(int ID) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_CITY)) {
            statement.setInt(1, ID);
            statement.executeUpdate();
            System.out.println("City was deleted ");
            return true;
        } catch (SQLException e) {
            System.out.println("Error in the deleteCity method " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addInfo(IModel model) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_CITY)) {
            statement.setString(1, ((City) model).getNameCity());
            statement.executeUpdate();
            System.out.println("City was added ");
            return true;

        } catch (SQLException e) {
            System.out.println("Error in the addCity method " + e.getMessage());
            return false;
        }
    }

}
