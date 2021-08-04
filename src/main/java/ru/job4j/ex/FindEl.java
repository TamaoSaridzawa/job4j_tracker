package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            for (int i = 0; i < value.length; i++) {
                if (key.equals(String.valueOf(i))) {
                    return i;
                }
            }
            throw new ElementNotFoundException("Ошибка ввода данных");
    }

    public static void main(String[] args) throws ElementNotFoundException{
        String[] array = {"Alex", "Garik", "Rex", "Gav", "Tyapa"};
        try {
            System.out.println("Элемент с индексом №3 существует в массиве, его имя - " + array[FindEl.indexOf(array, "3")] );
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
