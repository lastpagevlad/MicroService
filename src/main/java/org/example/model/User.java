package org.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    private int id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 30, message = "The count of name symbols should be from 2 to 30")
    private String name;
    @Email(message = "email should be valid")
    private String email;

    private int bus_id;

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public User(){}

    public User(int id, String name, String email, int bus_id){
        this.id = id;
        this.name = name;
        this.email = email;
        this.bus_id = bus_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
