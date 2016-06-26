package com.mycompany.spring.cache;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = -838617363808894951L;
    private int               id;
    private String            firstName;
    private String            lastName;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public void setName(final String name) {
        this.firstName = name;
    }

    public String getDirectory() {
        return lastName;
    }

    public void setDirectory(final String directory) {
        this.lastName = directory;
    }

    public Customer(final int id, final String name, final String directory) {
        this.id = id;
        this.firstName = name;
        this.lastName = directory;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", name=" + firstName + ", directory=" + lastName + "]";
    }
}