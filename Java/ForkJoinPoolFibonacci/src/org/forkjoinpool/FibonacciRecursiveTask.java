package org.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FibonacciRecursiveTask extends RecursiveTask<Integer> implements Callable<Integer> {
    private int fibIndex;

    FibonacciRecursiveTask(int fibIndex) {
        this.fibIndex = fibIndex;
    }

    @Override
    public Integer call() {
        int result = 0;

        if (fibIndex <= 1) {
            return 1;
        }
        List<RecursiveTask> tasks = new ArrayList<>();
        tasks.add(new FibonacciRecursiveTask(fibIndex - 1));
        tasks.add(new FibonacciRecursiveTask(fibIndex - 2));

        for (RecursiveTask task :
                tasks) {
            task.fork();
        }

        for (RecursiveTask task :
                tasks) {
            result = result + (int) task.join();
        }
        return result;
    }

    @Override
    protected Integer compute() {
        //System.out.println(Thread.currentThread().getName());
        int result = 0;

        if (fibIndex <= 1) {
            return 1;
        }
        List<RecursiveTask> tasks = new ArrayList<>();
        tasks.add(new FibonacciRecursiveTask(fibIndex - 1));
        tasks.add(new FibonacciRecursiveTask(fibIndex - 2));

        for (RecursiveTask task :
                tasks) {
            task.fork();
        }

        for (RecursiveTask task :
                tasks) {
            result = result + (int) task.join();
        }
        return result;
    }
}
