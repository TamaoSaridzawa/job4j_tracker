package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindAction implements UserAction {

    private final Output output;

    public FindAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return " Show all items ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item: items) {
                output.println(item);
            }
        } else {
           output.println("В хранилище еще нет заявок");
        }
        return true;
    }
}
