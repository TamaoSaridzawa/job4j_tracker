package ru.job4j.stream;

public class Car {

    private String model;
    private String color;
    private int speed;
    private int weight;
    private boolean automatic;
    private int price;

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + ", speed=" + speed
                + ", weight=" + weight
                + ", automatic=" + automatic
                + ", price=" + price
                + '}';
    }

    static class Builder {

        private String model;
        private String color;
        private int speed;
        private int weight;
        private boolean automatic;
        private int price;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        Builder buildWeight(int weight) {
            this.weight = weight;
            return this;
        }

        Builder buildAutomatic(boolean automatic) {
            this.automatic = automatic;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.model = model;
            car.color = color;
            car.speed = speed;
            car.weight = weight;
            car.automatic = automatic;
            car.price = price;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildModel("BMW")
                .buildColor("Black")
                .buildSpeed(300)
                .buildWeight(1800)
                .buildAutomatic(true)
                .buildPrice(1200000)
                .build();
        System.out.println(car);
    }
}
