package org.example.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Message {
    @NotEmpty
    @Size(min = 2, max = 30, message = "The count of name symbols should be from 2 to 30")
    private int mailing_id;
    private String mailing_message;
    private int bus_id;
    public Message(){}

    public Message(int mailing_id, String mailing_message, int bus_id) {
        this.mailing_id = mailing_id;
        this.mailing_message = mailing_message;
        this.bus_id = bus_id;
    }

    public int getMailing_id() {
        return mailing_id;
    }

    public void setMailing_id(int mailing_id) {
        this.mailing_id = mailing_id;
    }

    public String getMailing_message() {
        return mailing_message;
    }

    public void setMailing_message(String mailing_message) {
        this.mailing_message = mailing_message;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }
}
