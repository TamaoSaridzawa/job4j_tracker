package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void students() {
        ListToMap listToMap = new ListToMap();
        List<Student1> list = List.of(
                new Student1(5, "Lenin"),
                new Student1(5, "Lenin"),
                new Student1(6, "Larin"),
                new Student1(1, "Kolganov"),
                new Student1(4, "Karpov"),
                new Student1(1, "Kolganov")
        );
        Map<String, Student1> expected = new HashMap<>();
        expected.put("Lenin", new Student1(5, "Lenin"));
        expected.put("Larin", new Student1(6, "Larin"));
        expected.put("Kolganov", new Student1(1, "Kolganov"));
        expected.put("Karpov", new Student1(4, "Karpov"));
        Map<String, Student1> rsl = listToMap.students(list);
        assertThat(expected, is(rsl));
    }
}