package com.hsf.javagather.thread.two;

public class ValueOverflow {


    public static void main(String[] args) {
        int v1 = 1073741827;
        int v2 = 1431655768;
        int ave = (v1 + v2) / 2;
        System.out.println("ave=" + ave);
    }
}
