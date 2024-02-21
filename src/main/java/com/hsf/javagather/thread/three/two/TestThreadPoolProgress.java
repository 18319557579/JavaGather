package com.hsf.javagather.thread.three.two;

import com.hsf.javagather.utils.TimeLogUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试了一种情况，前提corePoolSize为1，maximumPoolSize为3，LinkedBlockingQueue容量为5。当前线程池中的线程数量已经达到3（也就是线程池中已经创建了多余corePoolSize的线程），那么此时同时进来3个任务，后面的2个任务是否还会先进入LinkedBlockingQueue呢？
 * 实测是的，任务会先进入LinkedBlockingQueue，但是立马就被执行了，因为此时是有足够的线程去执行这些行为的。
 */
public class TestThreadPoolProgress {
    static AtomicInteger atomicInteger = new AtomicInteger(1000);

    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            TimeLogUtil.out("正在执行 Thread 名称: " + Thread.currentThread().getName() + ", Task Name= " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(1, 3,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                r -> {
                    Thread t = new Thread(r, String.valueOf(atomicInteger.getAndIncrement()));
                    TimeLogUtil.out("我创建了一个线程: " + t.getName());
                    return t;
                },
                (r, executor) -> TimeLogUtil.out(((MyTask)r).name + " 被丢弃"))
        {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                TimeLogUtil.out("执行完成： " + ((MyTask)r).name);
            }
        };

        for (int i = 0; i < 13; i++) {
            if (i == 8) {
                Thread.sleep(10000);
            }

            System.out.println("当前线程池的数量 " + ((ThreadPoolExecutor)es).getPoolSize()
                    + ", 等待队列: " + ((ThreadPoolExecutor)es).getQueue().size());

            MyTask task = new MyTask("TASK-GEYM- " + i);
            TimeLogUtil.out("尝试执行任务: " + task.name);
            es.execute(task);
        }
    }
}
