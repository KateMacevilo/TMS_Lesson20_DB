package com.teachMeSkills.Lesson20.task1.model;

public class Student extends Model {

    private String name;
    private String lastName;
    private int idCity;
    private String course;

    public Student(String name, String lastName, int idCity, String course) {
        this.name = name;
        this.lastName = lastName;
        this.idCity = idCity;
        this.course = course;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCity=" + idCity +
                ", course='" + course + '\'' +
                '}';
    }
}
