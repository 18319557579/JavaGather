package com.hsf.javagather.thread.five.five.future;

public class TheMain {
    public static void main(String[] args) {
        Client client = new Client();
        long startTime = System.currentTimeMillis();
        System.out.println("请求时间: " + startTime);

        Data data = client.request("name");
        System.out.println("请求完毕");


        System.out.println("数据 = " + data.getResult());
        System.out.println("花费时间: " + (System.currentTimeMillis() - startTime));

        try {
             Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        System.out.println("数据2 = " + data.getResult());
        System.out.println("花费时间2: " + (System.currentTimeMillis() - startTime));
    }
}
