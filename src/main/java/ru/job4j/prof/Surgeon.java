package ru.job4j.prof;

public class Surgeon extends Doctor{
    private int assistant;

    public Surgeon() {

    }

    public Surgeon(String name, String surname, String education, int birthday, String recipe, int assistant) {
        super(name, surname, education, birthday, recipe);
        this.assistant = assistant;
    }

    public Diagnosis operation(Pacient pacient) {
        return null;
    }

}