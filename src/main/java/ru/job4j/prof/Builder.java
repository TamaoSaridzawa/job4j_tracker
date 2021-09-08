package ru.job4j.prof;

public class Builder extends Engineer {
    private String drawing;

    public Builder() {

    }

    public Builder(String name, String surname, String education,
                   int birthday, String tool, String drawing) {
        super(name, surname, education, birthday, tool);
        this.drawing = drawing;
    }

    public Development construction(Project project) {
        return null;
    }

    public Development reconstruction(Project project) {
        return null;
    }
}
