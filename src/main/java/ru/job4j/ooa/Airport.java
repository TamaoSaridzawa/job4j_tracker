package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        Airbus airbus = new Airbus("A320");
        airbus.printModel();
        airbus.printCountEngine();
        airbus = new Airbus("A380");
        airbus.printModel();
        airbus.printCountEngine();

        Airbus airbus1 = new Airbus("A400");
        airbus1.printModel();
        airbus1.printCountEngine();
    }
}
