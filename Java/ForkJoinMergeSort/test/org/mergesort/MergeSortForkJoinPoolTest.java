package org.mergesort;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class MergeSortForkJoinPoolTest {
    @Test
    public void testMergeSortEven() {
        int[] array = {2, 3, 5, 2, 1, 325, 7, 4, 31, 1, 234, 23, 345, 5};

        ForkJoinPool pool = new ForkJoinPool();
        MergeSortForkJoinPool mergeSortForkJoinPool = new MergeSortForkJoinPool(array, 0, array.length);
        pool.submit(mergeSortForkJoinPool).join();

        int[] expected = {1, 1, 2, 2, 3, 4, 5, 5, 7, 23, 31, 234, 325, 345};
        Assert.assertArrayEquals(expected, mergeSortForkJoinPool.getSortedArray());
    }
    @Test
    public void testMergeSortUneven() {
        int[] array = {2, 3, 5, 2, 1, 325, 7, 4, 31, 1, 234, 23, 345, 5, 1000};

        ForkJoinPool pool = new ForkJoinPool();
        MergeSortForkJoinPool mergeSortForkJoinPool = new MergeSortForkJoinPool(array, 0, array.length);
        pool.submit(mergeSortForkJoinPool).join();

        int[] expected = {1, 1, 2, 2, 3, 4, 5, 5, 7, 23, 31, 234, 325, 345, 1000};
        Assert.assertArrayEquals(expected, mergeSortForkJoinPool.getSortedArray());
    }
}
