package com.hsf.javagather.thread.six.default_function;

public interface IDonkey {
    void eat();
    default void run() {
        System.out.println("Donkey run");
    }
}
