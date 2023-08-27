package org.example.model;

public class Bus {
    private int bus_id;
    private int users_id;
    private int mailing_id;

    public Bus(){}

    public Bus(int bus_id, int users_id, int mailing_id) {
        this.bus_id = bus_id;
        this.users_id = users_id;
        this.mailing_id = mailing_id;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getMailing_id() {
        return mailing_id;
    }

    public void setMailing_id(int mailing_id) {
        this.mailing_id = mailing_id;
    }
}
