package com.hsf.javagather.number;

public class NumberTest {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2 == 0.3);
        System.out.println(0.1f + 0.2f == 0.3f);

        System.out.println(500000 + 0.05f);
        System.out.println(500000 + 0.05);

        int int1 = 335544300;
        long long1 = 3355443000000000000L;
        float float1 = 335544300000000000000000000000000000000f;

        int int2 = 2147483647;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
