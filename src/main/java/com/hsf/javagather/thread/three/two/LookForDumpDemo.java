package com.hsf.javagather.thread.three.two;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class LookForDumpDemo {
    public static class DivTask implements Runnable {
        int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a / b;
            System.out.println(re);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
        for (int i=0; i < 5; i++) {
//            Future re = pools.submit(new DivTask(100, i));
//            re.get();

            pools.execute(new DivTask(100, i));
        }
    }

    public static class TraceThreadPoolExecutor extends ThreadPoolExecutor {

        public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        public void execute(@NotNull Runnable command) {
            super.execute(wrap(command, clientTrance(), Thread.currentThread().getName()));
        }

        @NotNull
        @Override
        public Future<?> submit(@NotNull Runnable task) {
            return super.submit(wrap(task, clientTrance(), Thread.currentThread().getName()));
        }

        private Exception clientTrance() {
            return new Exception("Client stack trace");
        }

        private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
            return () -> {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            };
        }
    }
}
