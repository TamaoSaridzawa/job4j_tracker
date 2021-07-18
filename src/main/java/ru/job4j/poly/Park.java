package ru.job4j.poly;

public class Park {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus2 = new Bus2();
        Vehicle airPlane = new Airplane();
        Vehicle[] array = new Vehicle[] {train, bus2, airPlane};
        for (Vehicle tp : array) {
            tp.move();
            System.out.println("За 5 часов преодолевает " + tp.speed(5) + " километров");
        }
    }
}
