package org.minmissing;

public class Main {
    public static void main(String[] args) {
        int[] input = {34,435,345,436,67,68,8,346,54,56,856,81,1,12,32,4,2,12,3};
        Sort.mergeSort(input, 0, input.length- 1);

        System.out.println(FindMinMissing.getMinMissing(input));
    }
}
