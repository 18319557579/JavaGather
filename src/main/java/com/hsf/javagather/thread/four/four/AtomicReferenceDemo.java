package com.hsf.javagather.thread.four.four;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceDemo {
    static
    AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            final int timestamp = money.getStamp();
            threads[i] = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println("Interrupted");
                            break;
                        }

                        while (true) {
                            Integer m = money.getReference();

                             if (m < 20) {
                                 System.out.println("充值时的时间戳: " + timestamp);
                                 //这里配合final int timestamp，timestamp为什么在上面就赋值为final了，因为这里的条件要求是只赠予
                                 //一次，所以后面只要发生了赠予，那么时间戳一定不和初始的0相同了。那么就意味着只能发生一次赠予了
                                 if (money.compareAndSet(m, m + 20, timestamp, timestamp + 1)) {
                                     System.out.println("余额小于20元，充值成功，余额: " + money.getReference() + " 元");
                                     break;
                                 }
                             } else {
//                                 System.out.println("余额大于20元，无须充值");
                                 break;
                             }
                        }
                    }
                }
            };
//            threads[i].setDaemon(true);
            threads[i].start();
        }

        Thread consumingThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        int timestamp = money.getStamp();
                        System.out.println("消费时的时间戳: " + timestamp);
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10, timestamp, timestamp + 1)) {
                                System.out.println("成功消费10元，余额：" + money.getReference());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };
        consumingThread.start();

        Thread.sleep(20000);
        for (int i = 0; i < 3; i++) {
            threads[i].interrupt();
        }
        consumingThread.interrupt();

    }
}
