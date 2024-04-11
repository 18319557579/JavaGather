package com.hsf.javagather.thread.six.default_function;

public interface IAnimal {
    default void breath() {
        System.out.println("breath");
    }
}
