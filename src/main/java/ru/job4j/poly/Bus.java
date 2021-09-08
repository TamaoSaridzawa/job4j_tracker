package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Движение машины");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Сейчас в автобусе" + number + " пассажиров");
    }

    @Override
    public double fillUp(double quantity) {
        return quantity * 47.5;
    }
}
