package ru.job4j.pojo;

import java.util.Calendar;
import java.util.Date;

public class Student {
    private String family;
    private String name;
    private String surname;
    private String group;
    private Date entrance;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getEntrance() {
        return entrance;
    }

    public void setEntrance(Date entrance) {
        this.entrance = entrance;
    }
}
