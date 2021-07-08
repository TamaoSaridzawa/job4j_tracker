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
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
      int index = indexOf(id);
      if (index != -1 ) {
          item.setId(id);
          items[index] = item;
          return true;
      }
      return false;
    }
}