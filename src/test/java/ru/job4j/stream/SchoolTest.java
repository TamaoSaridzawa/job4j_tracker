package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenCollectClassA() {
        List<Student1> students = List.of(
                new Student1(10, "Surname1"),
                new Student1(40, "Surname4"),
                new Student1(50, "Surname5"),
                new Student1(70, "Surname7"),
                new Student1(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student1> pr = (n) -> n.getScore() >= 70 && n.getScore() <= 100;
        List<Student1> rsl = sc.collect(students, pr);
        List<Student1> expected = new ArrayList<>();
        expected.add(new Student1(70, "Surname7"));
        expected.add(new Student1(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student1> students = List.of(
                new Student1(20, "Surname2"),
                new Student1(30, "Surname3"),
                new Student1(50, "Surname5"),
                new Student1(60, "Surname6"),
                new Student1(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student1> pr = (n) -> n.getScore() >= 50 && n.getScore() < 70;
        List<Student1> rsl = sc.collect(students, pr);
        List<Student1> expected = new ArrayList<>();
        expected.add(new Student1(50, "Surname5"));
        expected.add(new Student1(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student1> students = List.of(
                new Student1(10, "Surname1"),
                new Student1(30, "Surname3"),
                new Student1(40, "Surname4"),
                new Student1(60, "Surname6"),
                new Student1(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student1> pr = (n) -> n.getScore() > 0 && n.getScore() < 50;
        List<Student1> rsl = sc.collect(students, pr);
        List<Student1> expected = new ArrayList<>();
        expected.add(new Student1(10, "Surname1"));
        expected.add(new Student1(30, "Surname3"));
        expected.add(new Student1(40, "Surname4"));
        assertThat(rsl, is(expected));
    }
}