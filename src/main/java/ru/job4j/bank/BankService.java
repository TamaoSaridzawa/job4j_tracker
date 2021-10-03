package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
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
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод реализует поиск пользователя по паспорту
     * если такой пользователь существует
     * ищет счет пользователя по реквизитам
     * @param passport - паспорт
     * @param requisite - реквизиты
     * @return возвращает счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null &&  accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
