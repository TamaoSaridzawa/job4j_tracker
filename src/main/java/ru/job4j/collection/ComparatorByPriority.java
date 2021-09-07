package ru.job4j.collection;

import java.util.Comparator;

public class ComparatorByPriority implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o1.getPriority() - o2.getPriority();
    }
}
