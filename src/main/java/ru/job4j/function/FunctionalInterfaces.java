package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = (s, s1) -> map.put(s, s1);
        int temp = 1;
        for (String s1: list ) {
            biCon.accept(temp++, s1);
        }
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            Integer key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }

        BiPredicate<Integer, String> biPred = (in, s) -> in % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            System.out.println(biPred.test(i, map.get(i)));
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = (s) -> System.out.println(s);

        Function<String, String> func = s -> s.toUpperCase();
        for (String st : sup.get()) {
            con.accept(st);
            System.out.println(func.apply(st));
        }
    }
}