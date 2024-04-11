package com.hsf.javagather.thread.six;

import com.hsf.javagather.thread.six.default_function.MyFunction;
import com.hsf.javagather.thread.two.StopThreadUnsafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Java8Test {
    public static void imperative() {
        int[] iArr = {1, 3, 4, 5, 9, 8, 7, 4, 2};
        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }
    }

    public static void declarative() {
        int[] iArr = {1, 3, 4, 5, 9, 8, 7, 4, 2};
        Arrays.stream(iArr).forEach(System.out::println);
    }

    private static void addOne() {
        int[] arr = {1, 3, 4, 5, 9, 8, 7, 4, 2};
        Arrays.stream(arr).map((x) -> x + 1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void oddNumberAddOne() {
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i]++;
            }
            System.out.println(arr[i]);
        }
    }

    private static void oddNumberAddOne2() {
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).map(x -> (x % 2 == 0 ? x : x + 1)).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        imperative();
//        declarative();
//        addOne();
//        oddNumberAddOne();
        oddNumberAddOne2();

        Comparator<String> cmp = Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach((Integer value) -> System.out.println(value));


        MyFunction.IN.ttt();

        List<StopThreadUnsafe.User> users = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            StopThreadUnsafe.User user = new StopThreadUnsafe.User();
            user.setName("name" + i);
            users.add(user);
        }
        users.stream().map(StopThreadUnsafe.User::getName).forEach(System.out::println);


        List<Double> numbers2 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers2.add(Double.valueOf(i));
        }
//        numbers2.stream().map(Double::toString).forEach(System.out::println);
    }
}
