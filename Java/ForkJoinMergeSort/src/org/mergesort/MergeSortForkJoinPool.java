package org.mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortForkJoinPool extends RecursiveAction {

    private final int[] array;
    private final int low;
    private final int high;

    MergeSortForkJoinPool(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public void compute() {
        int size = high - low;
        if (size <= 8) {
            Arrays.sort(array, low, high);
        } else {
            int middle = low + (size >> 1);
            invokeAll(new MergeSortForkJoinPool(array, low, middle), new MergeSortForkJoinPool(array, middle, high));
            merge(middle);
        }
    }

    private void merge(int middle) {
        if (array[middle - 1] < array[middle]) {
            return;
        }
        int copySize = high - low;
        int copyMiddle = middle - low;
        int[] copy = new int[copySize];
        System.arraycopy(array, low, copy, 0, copy.length);
        int p = 0;
        int q = copyMiddle;
        for (int i = low; i < high; ++i) {
            if (q >= copySize || (p < copyMiddle && copy[p] < copy[q])) {
                array[i] = copy[p++];
            } else {
                array[i] = copy[q++];
            }
        }
    }

    public int[] getSortedArray() {
        return array;
    }
}
