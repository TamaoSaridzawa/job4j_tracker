package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareTest() {
        ItemComparator itemComparator = new ItemComparator();
        List<Item> list = new ArrayList(Arrays.asList(
                new Item("Petr"),
                new Item("Lena"),
                new Item("Gleb"),
                new Item("Danil")
        ));
        List<Item> expected = List.of(
                new Item("Danil"),
                new Item("Gleb"),
                new Item("Lena"),
                new Item("Petr"));
        Collections.sort(list, itemComparator);
        assertEquals(list, expected);
    }

    @Test
    public void reReversCompareTest() {
        ItemReversComparator itemReversComparator = new ItemReversComparator();
        List<Item> list = new ArrayList(Arrays.asList(
                new Item("Petr"),
                new Item("Lena"),
                new Item("Gleb"),
                new Item("Danil")
        ));
        List<Item> expected = List.of(
                new Item("Petr"),
                new Item("Lena"),
                new Item("Gleb"),
                new Item("Danil"));
        Collections.sort(list, itemReversComparator);
        assertEquals(list, expected);
    }
}