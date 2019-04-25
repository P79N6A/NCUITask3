package com.netcracker.shared.structures;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private int year;
    private int month;
    private int day;

    public Date() {

    }

    public Date(String fullDate) {
        this.day = Integer.parseInt(fullDate.substring(0, 2));
        this.month = Integer.parseInt(fullDate.substring(3, 5));
        this.year = Integer.parseInt(fullDate.substring(6, fullDate.length()));
    }

    public String toString() {
        String result = "";
        if (this.day < 10) result += "0" + this.day + ".";
        else result += this.day + ".";
        if (this.month < 10) result += "0" + this.month + ".";
        else result += this.month + ".";
        result+=this.year;
        return result;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return year == date.year &&
                month == date.month &&
                day == date.day;
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, month, day);
    }
}
