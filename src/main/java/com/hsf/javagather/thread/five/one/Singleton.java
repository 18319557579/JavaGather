package com.hsf.javagather.thread.five.one;

public class Singleton {
    public static int STATUS = 1;
    private Singleton() {
        System.out.println("Singleton is created");
    }
    private static final Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
