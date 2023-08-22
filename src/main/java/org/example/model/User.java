package org.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    private int id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 30, message = "The count of name symbols should be from 2 to 30")
    private String name;
    private String typeMessage;
    @Email(message = "email should be valid")
    private String email;

    public User(){}

    public User(int id, String name, String typeMessage, String email){
        this.id = id;
        this.name = name;
        this.typeMessage = typeMessage;
        this.email = email;
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

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
