package com.hsf.javagather.thread.five.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchDemo {
    static int[] arr = {7, 3, 6, 1, 9, 3};

    static ExecutorService pool = Executors.newCachedThreadPool();
    static final int Thread_Num = 2;
    static AtomicInteger result = new AtomicInteger(-1);

    public static int search(int searchValue, int beginPos, int endPos) {
        int i = 0;
        for (i = beginPos; i < endPos; i++) {
            if (result.get() >= 0) {
                return result.get();
            }
            if (arr[i] == searchValue) {
                if (! result.compareAndSet(-1, i)) {
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    public static class SearchTask implements Callable<Integer> {
        int begin, end, searchValue;

        public SearchTask(int begin, int end, int searchValue) {
            this.begin = begin;
            this.end = end;
            this.searchValue = searchValue;
        }

        @Override
        public Integer call() throws Exception {
            int re = search(searchValue, begin, end);
            return re;
        }
    }

    public static int pSearch(int searchValue) throws InterruptedException, ExecutionException {
        int subArrSize = arr.length / Thread_Num + 1;
        List<Future<Integer>> re = new ArrayList<>();
        for (int i = 0; i < arr.length; i += subArrSize) {
            int end = i + subArrSize;
            if (end >= arr.length) end = arr.length;
            re.add(pool.submit(new SearchTask(i, end, searchValue)));
        }
        for (Future<Integer> fu: re) {
            System.out.println("这里走过了");
            if (fu.get() >= 0) return fu.get();
        }
        return -1;
/*//        System.out.println("提前走了把");
//        return -1;
        return re.get(0).get();*/

        /*for (Future<Integer> fu: re) {
            int result = fu.get();
            if ()
            return result;
        }
        return -1;*/
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int index = pSearch(5);
        if (index == -1) {
            System.out.println("不存在该元素");
        }
        System.out.println("该元素的位置: " + index);

        pool.shutdown();
    }
}
