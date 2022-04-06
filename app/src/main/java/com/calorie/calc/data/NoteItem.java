package com.calorie.calc.data;

import java.util.Date;

public class NoteItem {
    String text;
    Date date;

    public NoteItem(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
