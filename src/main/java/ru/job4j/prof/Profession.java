package ru.job4j.prof;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Profession() {

    }

    public Profession(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName(String name) {
        return name;
    }

    public String getSurname(String surname) {
        return surname;
    }

    public String getEducation(String education) {
        return education;
    }

    public int getBirthday(int birthday) {
        return birthday;
    }
}
