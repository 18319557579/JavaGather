package com.hsf.javagather.thread.five.one.consumer_producer_disruptor;

import com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId() + " :Event: --" + event.get() * event.get() + " -- ");
    }
}
