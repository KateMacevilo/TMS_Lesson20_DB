package com.teachMeSkills.Lesson20.task1.service;

import com.teachMeSkills.Lesson20.task1.model.IModel;
import com.teachMeSkills.Lesson20.task1.model.Student;

import java.sql.*;

public class CRUD_Service_Student implements IService {


    private static Connection connection = DBConnection.getConnectionToDB();
    private static String GET_STUDENTS_INFO = "SELECT si.idStudent, si.name, si.lastName, c.name as city, si.course FROM students.students_info si LEFT JOIN students.city c on c.idcity = si.idcity where si.course = 'Java'";
    private static String DELETE_STUDENT = "DELETE FROM students_info WHERE idStudent = ?";
    private static String ADD_STUDENT = "INSERT INTO students_info (name, lastname, idcity, course) values (?, ?, ?, ?)";


    @Override
    public void getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_STUDENTS_INFO)) {

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

    @Override
    public boolean deleteInfoByID(int ID) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT)) {
            statement.setInt(FIRST_STATEMENT_PARAM, ID);
            statement.executeUpdate();
            System.out.println("Student was deleted");
            return true;
        } catch (SQLException e) {
            System.out.println("Error in the deleteStudent method " + e.getMessage());
            return false;
        }

    }

    @Override
    public boolean addInfo(IModel model) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_STUDENT)) {
            statement.setString(FIRST_STATEMENT_PARAM, ((Student) model).getName());
            statement.setString(SECOND_STATEMENT_PARAM, ((Student) model).getLastName());
            statement.setInt(THIRD_STATEMENT_PARAM, ((Student) model).getIdCity());
            statement.setString(FORTH_STATEMENT_PARAM, ((Student) model).getCourse());
            statement.executeUpdate();

            System.out.println("Student was added ");

            return true;

        } catch (SQLException e) {
            System.out.println("Error in the addStudent method " + e.getMessage());
            return false;
        }

    }

}
