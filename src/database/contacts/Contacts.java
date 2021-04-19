package database.contacts;

import java.sql.*;

public class Contacts {
    private String name;
    private int number;

    public Contacts() {
        this.name = "none";
        this.name = "none";
    }

    public Contacts(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
