package com.hsf.javagather.thread.six.constr;

import java.util.ArrayList;
import java.util.List;

public class ConstrMethodRef {
    @FunctionalInterface
    interface UserFactory<U extends MyUser> {
        U create(int id, String name);
    }

    static UserFactory<MyUser> uf = MyUser::new;

    public static void main(String[] args) {
        List<MyUser> users = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            users.add(uf.create(i, "billy" + Integer.toString(i)));
        }

        users.stream().map(MyUser::getName).forEach(System.out::println);
    }
}
