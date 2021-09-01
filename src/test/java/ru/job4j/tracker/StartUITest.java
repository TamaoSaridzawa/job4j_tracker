package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        ArrayList <UserAction> actions = new ArrayList<>();
              actions.add(new CreateAction(output));
              actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName , "1"} // здесь должны быть входные данные
        );
        Output output = new ConsoleOutput();
        ArrayList <UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0" , String.valueOf(item.getId()), "1"}
        );
        Output output = new ConsoleOutput();
        ArrayList <UserAction> actions = new ArrayList<>();
               actions.add(new DeleteAction(output));
               actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        ArrayList <UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is( "Menu" + System.lineSeparator() +
                "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test item"));
        Input input = new StubInput(
                new String[] { "0" , String.valueOf(item.getId()), "1"}
        );
        ArrayList <UserAction> actions = new ArrayList<>();
        actions.add( new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu" + ln
                + "0.  Find item by id " + ln
                + "1. Exit" + ln
                + item + ln
                + "Menu" + ln
                + "0.  Find item by id " + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input input = new StubInput(new String[] { "0", item.getName(), "1"});
        ArrayList <UserAction> actions = new ArrayList<>();
        actions.add(new FindNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu" + ln
                + "0.  Find items by name " + ln
                + "1. Exit" + ln
                + item + ln
                + "Menu" + ln
                + "0.  Find items by name " + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] { "0", "1"});
        ArrayList <UserAction> actions = new ArrayList<>();
        actions.add( new FindAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input,tracker,actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu" + ln
                + "0.  Show all items " + ln
                + "1. Exit" + ln
                + "В хранилище еще нет заявок" + ln
                + "Menu" + ln
                + "0.  Show all items " + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList <UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu" + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu" + ln
                        + "0. Exit" + ln
                )
        );
    }
}