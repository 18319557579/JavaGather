package com.hsf.javagather.thread.six.default_function;

public interface IHorse {
    void eat();
    default void run() {
        System.out.println("horse run");
    }
    default void go() {
        System.out.println("horse go");
    }
}
