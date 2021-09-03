package ru.job4j.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        Set<Account> rsl = new HashSet<>();
        for (Account acount : accounts) {
           rsl.add(acount);
        }
        return rsl;
    }
}

