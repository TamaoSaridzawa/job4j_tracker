package ru.job4j.pojo;

import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        student.setFamily("Ryzhov ");
        student.setName("Danila ");
        student.setSurname("Yurievich ");
        student.setGroup("intern ");
        student.setEntrance(calendar.getTime());
        System.out.println(student.getFamily() + student.getName()
                + student.getSurname() + student.getGroup() + student.getEntrance());
    }
}
