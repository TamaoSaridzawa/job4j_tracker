package ru.job4j.ex;

public class ElementNotFoundException extends Exception{
    public static void main(String[] args) {
        String[] array = {"Alex", "Garik", "Rex", "Gav", "Tyapa"};
        try {
            System.out.println("Элемент с индексом №2 существует в массиве, его имя - " +array[FindEl.indexOf(array, "3")] );
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
