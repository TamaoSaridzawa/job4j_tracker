package ru.job4j.poly;

public class Bus2 implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус едет по дороге");
    }

    @Override
    public double speed(double time) {
        return time * 100;
    }
}

