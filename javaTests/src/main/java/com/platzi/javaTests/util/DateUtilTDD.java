package com.platzi.javaTests.util;

public class DateUtilTDD {
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
