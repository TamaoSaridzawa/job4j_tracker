package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorByName() {
        Comparator<Job> comparatorByName = new ComparatorByName();
        List<Job> users = new ArrayList<>();
        users.add(new Job("Gleb", 21));
        users.add(new Job("Danila", 27));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Danila", 27));
        expected.add(new Job("Gleb", 21));
        Collections.sort(users, comparatorByName);
        Assert.assertEquals(users, expected);
    }

    @Test
    public void whenReversComparatorByName() {
        Comparator<Job> reversComparatorByName = new ReversComparatorByName();
        List<Job> users = new ArrayList<>();
        users.add(new Job("Danila", 21));
        users.add(new Job("Gleb", 27));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Gleb", 27));
        expected.add(new Job("Danila", 21));
        Collections.sort(users, reversComparatorByName);
        Assert.assertEquals(users, expected);
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> comparatorByPriority = new ComparatorByPriority();
        List<Job> users = new ArrayList(Arrays.asList(
                new Job("Danila", 26),
                new Job("Gleb", 21),
                new Job("Danila", 27)));
        List<Job> expected = new ArrayList(Arrays.asList(
                new Job("Gleb", 21),
                new Job("Danila", 26),
                new Job("Danila", 27)));
        Collections.sort(users, comparatorByPriority);
        Assert.assertEquals(users, expected);
    }

    @Test
    public void whenReversComparatorByPriority() {
        Comparator<Job> reversComparatorByPriority = new ReversComparatorByPriority();
        List<Job> users = new ArrayList(Arrays.asList(
                new Job("Danila", 26),
                new Job("Gleb", 21),
                new Job("Danila", 27)));
        List<Job> expected = new ArrayList(Arrays.asList(
                new Job("Danila", 27),
                new Job("Danila", 26),
                new Job("Gleb", 21)));
        Collections.sort(users, reversComparatorByPriority);
        Assert.assertEquals(users, expected);
    }

    @Test
    public void whenCmbComparatorByPriority() {
        Comparator<Job> cmbComparator = new ComparatorByName().
                thenComparing(new ComparatorByPriority());
      int rsl = cmbComparator.compare(new Job("Danila", 9),
              new Job("Danila", 12));
      assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCmbReversComparatorByName() {
        Comparator<Job> cmbComparator = new ReversComparatorByName().
                thenComparing(new ReversComparatorByPriority());
        int rsl = cmbComparator.compare(new Job("Danila", 9),
                new Job("Danila", 12));
        assertThat(rsl, lessThan(2));
    }
}