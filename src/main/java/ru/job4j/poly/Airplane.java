package ru.job4j.poly;

public class Airplane implements Vehicle{

    @Override
    public void move() {
        System.out.println("Самолет летит по воздуху");
    }

    @Override
    public double speed(double time) {
        return time * 800;
    }
}

