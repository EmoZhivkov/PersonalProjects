package org.forkjoinpool;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException{

        ForkJoinPool pool = ForkJoinPool.commonPool();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Callable task = new FibonacciRecursiveTask(10);
        Future<Integer> answer = executor.submit(task);
        try {
            System.out.println(answer.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
