package com.hsf.javagather.thread.five.one.consumer_producer;

public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }
    public PCData(String d) {
        intData = Integer.parseInt(d);
    }
    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data: " + intData;
    }
}
