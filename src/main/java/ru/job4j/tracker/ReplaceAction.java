package ru.job4j.tracker;

public class ReplaceAction implements UserAction{

    @Override
    public String name() {
        return " replace item " ;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id");
        System.out.print("Enter name: ");
        String name = input.askStr("Введите имя");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
