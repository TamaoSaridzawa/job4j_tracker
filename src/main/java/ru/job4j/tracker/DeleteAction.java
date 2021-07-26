package ru.job4j.tracker;

public class DeleteAction implements UserAction{

    @Override
    public String name() {
        return " Delete Item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.printf("Ошибка удаления заявки.");
        }
        return true;
    }
}
