package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book varyag = new Book("Varyag ", 215);
        Book viking = new Book("Viking ", 179);
        Book strategy = new Book("strategy ", 164);
        Book cleanCode = new Book("Чистый код ", 315);
        Book[] book = new Book[4];
        book[0] = varyag;
        book[1] = viking;
        book[2] = strategy;
        book[3] = cleanCode;

        for (int i = 0; i < book.length; i++) {
            Book pr = book[i];
            System.out.println(pr.getName() + pr.getQuantity());
        }

        System.out.println("");
        Book temp;
        temp = book[0];
        book[0] = book[3];
        book[3] = temp;

        for (int i = 0; i < book.length; i++) {
            Book pr = book[i];
            System.out.println(pr.getName() + pr.getQuantity());
        }

        for (Book pr : book) {
            if ("Чистый код ".equals(pr.getName())) {
                System.out.println("Найдена книга : " + pr.getName());
            }
        }
    }
}
