package com.hsf.javagather.thread.four.three;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static final ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>();
    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (t1.get() == null) {
                    t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }

                Date t = t1.get().parse("2015-03-29 19:29:" + i % 60);
                System.out.println(i + ":" + t);

                t1.remove();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }*/

        Object ttt = 2000;
        double revenue = (double) ttt;
        System.out.println("收益: " + revenue);
    }
}
