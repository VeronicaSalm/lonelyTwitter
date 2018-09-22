package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.ArrayList;

public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;
    private ArrayList<Mood> moods;

    //Empty argument constructor with default values
    Tweet() {
        //Must use the 'this' keyword in order to specify the current object message = message does nothing!
        this.date = new Date();
        this.message = "I am default message schwa!";
        this.moods = new ArrayList<Mood>();
    }

    //Overloading: so that we can specify the tweet content
    Tweet(String message) {
        this.date = new Date();
        this.message = message;
        this.moods = new ArrayList<Mood>();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() { return this.date; }
    public void setMoods(ArrayList<Mood> m) { this.moods = m; }
    public void addNewMood(Mood m) { this.moods.add(m); }
    public void deleteMood(Mood m) { this.moods.remove(m); }
    public ArrayList<Mood> getMoods() { return this.moods; }

    public String getMoodString() {
        String s = "Moods: ";
        for (Mood m : this.moods) {
            s = s + m.format() + " ";
        }
        return s;
    }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();
}