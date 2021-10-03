package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void arrayToList() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] array = {
                {5, 3}, {8, 9}, {13, 19}
        };
        List<Integer> rsl = matrixToList.arrayToList(array);
        List<Integer> expected = List.of(5, 3, 8, 9, 13, 19);
        assertThat(rsl, is(expected));
    }
}