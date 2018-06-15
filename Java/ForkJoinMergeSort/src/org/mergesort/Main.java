package org.mergesort;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 2, 1, 325, 7, 4, 31, 1, 234, 23, 345, 5};

        ForkJoinPool pool = new ForkJoinPool();
        MergeSortForkJoinPool mergeSortForkJoinPool = new MergeSortForkJoinPool(array, 0, array.length);
        pool.submit(mergeSortForkJoinPool).join();

        int[] sorted = mergeSortForkJoinPool.getSortedArray();
        for (int a :
                sorted) {
            System.out.print(a + ",");
        }
        System.out.println();
    }
}
