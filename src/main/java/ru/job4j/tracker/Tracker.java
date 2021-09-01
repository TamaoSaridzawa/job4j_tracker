package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }


    public ArrayList<Item> findAll(){
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList <Item> findByName(String key) {
         ArrayList <Item> newItems = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Item temp = items.get(i);
            if (key.equals(temp.getName())) {
                newItems.add(temp);
            }
        }
        return newItems;
    }

    public boolean replace(int id, Item item) {
      int index = indexOf(id);
      boolean rsl = index != -1;
      if (rsl) {
          item.setId(id);
          items.add(index,item);
      }
      return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if ( rsl) {
            items.remove(index);
            size --;
        }
        return rsl;
    }
}