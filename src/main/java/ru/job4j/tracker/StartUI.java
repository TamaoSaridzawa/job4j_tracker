package ru.job4j.tracker;


public class StartUI {

    public static void createdItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("Введите имя");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void findItem(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item [] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item: items) {
                System.out.println(item);
            }
        } else {
            System.out.println("В хранилище еще нет заявок");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Введите id");
        System.out.print("Enter name: ");
        String name = input.askStr("Введите имя");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Введите id");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.printf("Ошибка удаления заявки.");
        }
    }

    public static void findByItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Введите id");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
    }

    public static void findNameItem(Input input, Tracker tracker){
        System.out.println("=== Find items by name ====");
        System.out.print("Enter name: ");
        String name = input.askStr("Введите имя");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = input.askInt("Выберите пункт меню");
            if (select == 0) {
                StartUI.createdItem(input, tracker);
            }
            else if (select == 1){
               StartUI.findItem(tracker);
            }
            else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            }
            else if (select == 3) {
               StartUI.deleteItem(input, tracker);
            }
            else if (select == 4) {
                StartUI.findByItem(input, tracker);
            }
            else if (select == 5) {
                StartUI.findNameItem(input, tracker);
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {"Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
