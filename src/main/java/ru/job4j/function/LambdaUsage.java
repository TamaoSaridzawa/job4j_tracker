package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {

        String[] arrays = {"Alex", "Agressor", "Sena", "Russia"};
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("CompareTo - " + left + " : " + right);
            return left.compareTo(right);
        };

        Arrays.sort(arrays, cmpText);
        for (String s: arrays) {
            System.out.println(s);
        }
    }
}
