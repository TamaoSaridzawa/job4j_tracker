package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int keyInt = Integer.parseInt(key);
        if (keyInt >= value.length || keyInt < 0) {
            throw  new ElementNotFoundException();
        } else {
            for (int i = 0; i < value.length; i++) {
                if (keyInt == i) {
                    return i;
                }
            }
        }
        return -1;
    }
}
