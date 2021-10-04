package ru.job4j.stream;

import ru.job4j.pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public Map<String, Student1> students(List<Student1> list) {
      return list.stream()
              .collect(Collectors.toMap(Student1::getSurname, value -> value,
               (surname, surname2) -> surname));
    }
}
