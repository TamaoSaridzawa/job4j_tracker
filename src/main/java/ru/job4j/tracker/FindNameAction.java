package ru.job4j.tracker;

import java.util.Optional;

public class FindNameAction implements UserAction{

    private final Output output;
    public FindNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return " Find items by name ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
