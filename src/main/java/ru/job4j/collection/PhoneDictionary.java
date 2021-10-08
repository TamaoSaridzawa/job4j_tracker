package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = (n) -> n.getName().contains(key);
        Predicate<Person> surName = (n) -> n.getSurname().contains(key);
        Predicate<Person> phone = (n) -> n.getPhone().contains(key);
        Predicate<Person> address = (n) -> n.getAddress().contains(key);
        Predicate<Person> combine = name.or(surName).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
