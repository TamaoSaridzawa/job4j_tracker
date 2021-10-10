package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Этот классы описывает работу банковских операций
 */
public class BankService {
    /**
     * Здесь осуществляется хранение всех пользователей в системе с их счетами
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод реалзизующий довабление нового пользователя,
     * если такой пользователь уже существует, то добавление не произойдет
     * @param user - пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод реализует поиск пользователя по паспорту
     * если такой пользователь существует
     * добавляет новый счет, при условии, что такого счета еще нет
     * @param passport - паспорт пользователя
     * @param account - аккаунт (реквизиты, счет)
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод реализует поиск пользователя по паспорту
     * @param passport - паспорт пользователя
     * @return возвращает найденного пользователя, либо null
     */
    public Optional<User> findByPassport(String passport) {
        Optional<String> user = Optional.ofNullable(passport);
        if (user.isPresent()) {
            return users.keySet()
                    .stream()
                    .filter(p -> p.getPassport().equals(passport))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод реализует поиск пользователя по паспорту
     * если такой пользователь существует
     * ищет счет пользователя по реквизитам
     * @param passport - паспорт
     * @param requisite - реквизиты
     * @return возвращает счет пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user).stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод реализует перевод денег с одного счета на другой
     * если не хватает денег на счете-отправителе, возвращает false
     * @param srcPassport - паспорт пользователя-отправителя
     * @param srcRequisite - реквизиты счета - отправителя
     * @param destPassport паспорт пользователя-получателя
     * @param destRequisite реквизиты счета - получателя
     * @param amount - сумма перевода
     * @return возвращает true или false, в зависимости от успеха операции
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent()
                && accountDest.isPresent()
                && accountSrc.get().getBalance() >= amount) {
             accountSrc.stream().findFirst().map(sr -> sr.getBalance() - amount);
             accountDest.stream().findFirst().map(ds -> ds.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
