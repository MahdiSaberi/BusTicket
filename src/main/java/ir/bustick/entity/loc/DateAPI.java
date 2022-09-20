package ir.bustick.entity.loc;

import jakarta.persistence.Embeddable;

@Embeddable
public class DateAPI {
    private String day;

    private String month;

    private String year;

    public DateAPI() {
    }

    public DateAPI(String year, String month, String day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
