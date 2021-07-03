package ru.job4j.prof;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public String getName(String name){
      return this.name = name;
    }

    public String getSurname(String surname){
        return this.surname = surname;
    }

    public String getEducation(String education){
        return this.education = education;
    }

    public int getBirthday(int birthday){
        return this.birthday = birthday;
    }
}
