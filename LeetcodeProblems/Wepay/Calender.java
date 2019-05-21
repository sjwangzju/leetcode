package Wepay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Calender {

    public int date(int year) {

        // get the date of Oct 1st
        LocalDate tmp = LocalDate.of(year, 10,1);

        // if it's Tuesday, add one week
        if (tmp.getDayOfWeek() == DayOfWeek.TUESDAY) {
            return tmp.plusWeeks(1).getDayOfMonth();
        }

        // find the first Tuesday, then add one week
        return tmp.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).plusWeeks(1).getDayOfMonth();
    }

    public static void main(String[] args) {
        System.out.println(new Calender().date(2018));
    }
}
