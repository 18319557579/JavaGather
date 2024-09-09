package com.hsf.javagather.bit_operation;

public class BitOperationUtil {
    public static void main(String[] args) {
        int num1 = 9;
        int num2 = 3;
        int result = num1 & num2;
        System.out.println("按位与: " + result);

        System.out.println("按位或：" + (-9|3));

        System.out.println("2^3: " + (2^3));
        System.out.println("-7^12: " + (-7 ^ 12));
        System.out.println("-5 ^ -6: " + (-5 ^ -6));

        System.out.println("~5: " + (~5));
        System.out.println("~-10: " + (~-10));

        System.out.println("1>>2: " + (1>>2));
        System.out.println("-9>>1: " + (-9>>1));
        System.out.println("-9>>2: " + (-9>>2));

        System.out.println(1f/2/2);

        System.out.println("1<<2: " + (1<<2));
        System.out.println("-11<<3: " + (-11<<3));

        System.out.println("-10>>>3: " + (-10>>>3));
    }
}
