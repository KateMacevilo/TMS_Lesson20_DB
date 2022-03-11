package com.teachMeSkills.Lesson20.task1.model;

public class City extends Model {

    private String nameCity;

    public City() {
    }

    public City(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "nameCity='" + nameCity + '\'' +
                '}';
    }

}
