package com.hsf.javagather.thread.five.one.consumer_producer_disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 产生PCData的工厂类，它会在Disruptor系统初始化时，构造所有的缓冲区中的对象实例
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
