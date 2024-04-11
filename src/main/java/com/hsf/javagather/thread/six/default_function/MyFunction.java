package com.hsf.javagather.thread.six.default_function;

import java.util.function.Function;

public enum MyFunction {
    IN;


    public void ttt() {
        int num = 8;
        Function<Integer, Integer> stringConverter = (from) -> {
            return from * num;
        };

        System.out.println(stringConverter.apply(3));

//        num += 10;
        System.out.println(num);
    }
}
