package ru.job4j.tracker;

public class DeleteAction implements UserAction{

    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return " Delete Item ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id");
        if (tracker.delete(id)) {
            output.println("Заявка удалена успешно.");
        } else {
            output.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
