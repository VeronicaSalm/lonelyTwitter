package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood<T> {

    private Date date;

    Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    Mood(Date d) {
        this.set_Date(date);
    }

    public Date get_Date() {
        return this.date;
    };
    public void set_Date(Date date) {
        this.date = date;
    };

    public abstract String format();

}
