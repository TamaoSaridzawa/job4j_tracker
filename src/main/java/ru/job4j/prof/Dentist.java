package ru.job4j.prof;

public class Dentist extends Doctor {
    private String painkillers;

    public Dentist() {

    }

    public Dentist(String name, String surname, String education,
                   int birthday, String recipe, String painkillers) {
        super(name, surname, education, birthday, recipe);
        this.painkillers = painkillers;
    }

    public Diagnosis removeTooth(Pacient pacient) {
        return null;
    }

    public Diagnosis treatmentTooth(Pacient pacient) {
        return null;
    }
}