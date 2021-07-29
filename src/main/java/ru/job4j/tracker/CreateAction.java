package ru.job4j.tracker;

public class CreateAction implements UserAction{

    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return " add new Item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create a new Item ====");
        String name = input.askStr("Введите имя");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавленная заявка: " + item);
        return true;
    }
}
