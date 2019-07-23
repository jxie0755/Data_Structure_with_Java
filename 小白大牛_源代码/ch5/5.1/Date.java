package com.a51work6;

public class Date extends java.util.Date {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    public static Date valueOf(String s) {

        final int YEAR_LENGTH = 4;
        final int MONTH_LENGTH = 2;

        int firstDash;
        int secondDash;

		...
    }

    public String toString() {
        int year = super.getYear() + 1900;
        int month = super.getMonth() + 1;
        int day = super.getDate();
		...
    }
}
