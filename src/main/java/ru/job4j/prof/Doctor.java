package ru.job4j.prof;

public class Doctor extends Profession {
    private String recipe;

    public Doctor() {

    }

    public Doctor(String name, String surname, String education, int birthday, String recipe) {
        super(name, surname, education, birthday);
        this.recipe = recipe;
    }

    public Diagnosis heal(Pacient pacient) {
        return null;
    }
}
