package com.hsf.javagather.thread.three;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(CyclicBarrier cyclic, String soldierName) {
            this.soldier = soldierName;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
//                Thread.sleep(5000);
                System.out.println("士兵 " + soldier + " 报道！");
                cyclic.await();
                doWork();
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000) + 5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(soldier + ": 任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令:[士兵 " + N + " 个，任务完成！]");
            } else {
                System.out.println("司令:[士兵 " + N + " 个，集合完毕！]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍！");
        for (int i = 0; i < N; ++i) {
//            System.out.println("士兵 " + i + " 报道！");
            allSoldier[i] = new Thread(new Soldier(cyclic, "士兵 " + i));
            allSoldier[i].start();

            if (i == 5) {
                allSoldier[0].interrupt();
            }

            Thread.sleep(3000);
        }
    }

}
