package ru.job4j.collection;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 0, -1, -4, 3, -2, 8, -7);
        List<Integer> stream = list.stream()
                .filter(in -> in >= 0)
                .collect(Collectors.toList());
        stream.forEach(System.out::println);
    }
}
