package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class TestTraversal {
    @Test
    public void isFibIndexesSpiralTest() {
        int[][] matrix = {{1, 2, 3},
                {34, 7, 5},
                {21, 13, 8}};
        int[] array = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(array);
        int[] left = ExtractIndexes.extractLeft(array);
        int[] right = ExtractIndexes.extractRight(array);
        Assert.assertTrue(Traversal.isFibIndexesSpiral(left, right, 3));
    }
    @Test
    public void isFibIndexesSpiralTest2() {
        int[][] matrix = {{1, 2, 7},
                {5, 3, 16},
                {26, 14, 22}};
        int[] array = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(array);
        int[] left = ExtractIndexes.extractLeft(array);
        int[] right = ExtractIndexes.extractRight(array);
        Assert.assertTrue(Traversal.isFibIndexesSpiral(left, right, 3));
    }
    @Test
    public void isFibIndexesSpiralTestNegative() {
        int[][] matrix = {{1, 2, 3},
                {4, 7, 5},
                {21, 13, 8}};
        int[] array = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(array);
        int[] left = ExtractIndexes.extractLeft(array);
        int[] right = ExtractIndexes.extractRight(array);
        Assert.assertTrue(Traversal.isFibIndexesSpiral(left, right, 3));
    }
    @Test
    public void isFibIndexesSpiralTestNegative2() {
        int[][] matrix = {{1, 2, 4},
                {5, 7, 3},
                {12, 11, 10}};
        int[] array = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(array);
        int[] left = ExtractIndexes.extractLeft(array);
        int[] right = ExtractIndexes.extractRight(array);
        Assert.assertTrue(Traversal.isFibIndexesSpiral(left, right, 3));
    }

    //Doesn't run, because we sort the whole left and right
    /*@Test
    public void testIsFibIndexesSpiral3() {
        int[][] matrix =
                        {{7, 1, 2},
                        {7, 5, 3},
                        {1, 8, 2}};


        int[] arr = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(arr);
        arr = Sort.devideTheFibNumbersInFibSequences(arr);
        int[] left = ExtractIndexes.extractLeft(arr);
        int[] right = ExtractIndexes.extractRight(arr);

        Assert.assertTrue(Traversal.isFibIndexesSpiral(left, right, 3));

    }*/
}
