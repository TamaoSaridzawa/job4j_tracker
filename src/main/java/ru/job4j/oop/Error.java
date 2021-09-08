package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

   public Error() {

   }

   public Error(boolean active, int status, String message) {
       this.active = active;
       this.status = status;
       this.message = message;
   }

   public void printInfo() {
       System.out.println("Активный : " + active);
       System.out.println("Статус : " + status);
       System.out.println("Сообщение : " + message);
   }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 1, "Авторизация прошла успешно!");
        Error error3 = new Error(false, 2, "Ошибка авторизации");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
