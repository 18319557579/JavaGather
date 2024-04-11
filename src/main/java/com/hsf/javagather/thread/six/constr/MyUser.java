package com.hsf.javagather.thread.six.constr;

public class MyUser {
    private int id;
    private String name;

    public MyUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyUser(int id) {
        this.id = id;
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
}
