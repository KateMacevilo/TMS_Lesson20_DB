package com.teachMeSkills.Lesson20.task1.util;

import com.teachMeSkills.Lesson20.task1.model.City;
import com.teachMeSkills.Lesson20.task1.model.Student;
import com.teachMeSkills.Lesson20.task1.service.CRUD_Service_City;
import com.teachMeSkills.Lesson20.task1.service.CRUD_Service_Student;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static int menuItem;
    private static CRUD_Service_City crudServiceCity = new CRUD_Service_City();
    private static CRUD_Service_Student crudServiceStudent = new CRUD_Service_Student();
    private static Student student = new Student();
    private static City city = new City();

    public static void setMenu() {

        System.out.println("Выберите действие и введите чило: ");
        System.out.println("1 - просмотреть список студентов");
        System.out.println("2 - просмотреть список городов");
        System.out.println("3 - добавить информацию о новом студенте");
        System.out.println("4 - добавить информацию о новом гоороде");
        System.out.println("5 - удалить информацию о студенте");
        System.out.println("6 - удалить информацию о городе");
        System.out.println("7 - Выход и программы");

        menuItem = scanner.nextInt();

        getInfoFromMenu();
    }

    private static void getInfoFromMenu() {
        boolean result = false;
        while (!result) {
            switch (Menu.menuItem) {
                case 1:
                    crudServiceStudent.getAll();
                    break;

                case 2:
                    crudServiceCity.getAll();
                    break;

                case 3:

                    System.out.println("Введите имя ");
                    String name = scanner.next();
                    student.setName(name);

                    System.out.println("Введите фамилию ");
                    String lastName = scanner.next();
                    student.setLastName(lastName);

                    System.out.println("Введите ID города ");
                    int idCity = scanner.nextInt();
                    student.setIdCity(idCity);

                    System.out.println("Введите название курса ");
                    String course = scanner.next();
                    student.setCourse(course);

                    crudServiceStudent.addInfo(student);
                    break;

                case 4:
                    System.out.println("Введите название города ");
                    String cityName = scanner.next();
                    city.setNameCity(cityName);
                    crudServiceCity.addInfo(city);
                    break;

                case 5:
                    System.out.println("Введите ID студента, которого нужно удалить ");
                    int idStudent = scanner.nextInt();
                    crudServiceStudent.deleteInfoByID(idStudent);
                    break;

                case 6:
                    System.out.println("Введите ID города, которого нужно удалить ");
                    int idCity1 = scanner.nextInt();
                    crudServiceCity.deleteInfoByID(idCity1);
                    break;

                case 7:
                    System.exit(0);

            }
            setMenu();
        }
    }

}
