package com.hsf.javagather.thread.five.five_future;

public class FutureData implements Data{
    protected RealData realData = null;  //FutureData是RealData的包装
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (! isReady) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.result;
    }

}
