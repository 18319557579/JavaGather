package com.hsf.javagather.thread.six.functional_programming;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Test {
    static int[] arr = {1, 3, 4, 5, 7, 8, 9, 10};



    public static void main(String[] args) {
        /*Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });*/

//        Arrays.stream(arr).forEach(System.out::println);

        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.out::println;
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));

    }
}
