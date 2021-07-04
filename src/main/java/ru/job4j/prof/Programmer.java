package ru.job4j.prof;

public class Programmer extends Engineer{
    private String software;

    public Programmer() {

    }

    public Programmer(String name, String surname, String education, int birthday, String tool, String software) {
        super(name, surname, education, birthday, tool);
        this.software = software;
    }

    public Development programming (Project project) {
        return null;
    }

    public Development optimization (Project project) {
        return null;
    }
}