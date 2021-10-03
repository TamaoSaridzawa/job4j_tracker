package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student1> collect(List<Student1> students, Predicate<Student1> predict) {
       return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
