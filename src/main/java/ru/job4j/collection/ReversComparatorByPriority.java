package ru.job4j.collection;

import java.util.Comparator;

public class ReversComparatorByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getPriority() - o1.getPriority();
    }
}