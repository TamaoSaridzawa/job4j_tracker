package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] itemsNotNull = new Item[size];
        for (int i = 0; i < size; i++) {
            Item temp = items[i];
            if (temp != null) {
                itemsNotNull[count] = temp;
                count++;
            }
        }
        return Arrays.copyOf(itemsNotNull, count);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] newItems = new Item[size];
        for (int i = 0; i < size; i++) {
            Item temp = items[i];
            if (key.equals(temp.getName())) {
                newItems[count] = temp;
                count++;
            }
        }
        return Arrays.copyOf(newItems, count);
    }
}