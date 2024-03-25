package com.hsf.javagather.thread.five.one.consumer_producer_disruptor;

public class PCData {
    private long value;
    public void set(long value) {
        this.value = value;
    }
    public long get() {
        return value;
    }
}
