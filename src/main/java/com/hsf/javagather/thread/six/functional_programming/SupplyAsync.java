package com.hsf.javagather.thread.six.functional_programming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SupplyAsync {
    public static Integer calc(Integer para) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        return para * para;
        return para / 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(() -> calc(50))
                        .exceptionally(ex -> {
                            System.out.println(ex.toString());
                            return 0;
                        })
                                .thenApply((i) -> Integer.toString(i))
                                        .thenApply(str -> "\"" + str + "\"")
                                                .thenAccept(System.out::println);
        System.out.println(future.get());
    }
}
