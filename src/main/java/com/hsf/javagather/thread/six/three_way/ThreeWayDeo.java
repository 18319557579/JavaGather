package com.hsf.javagather.thread.six.three_way;

public class ThreeWayDeo {
    public static void main(String[] args) throws InterruptedException {
        LongAdderDemo longAdderDemo = new LongAdderDemo();
        longAdderDemo.testSync();
        longAdderDemo.testAtomic();
        longAdderDemo.testAtomicLong();
    }
}
