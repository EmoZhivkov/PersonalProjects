package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    @Test
    public void testSort() {
        int[][] matrix = {{1, 2, 3},
                {34, 7, 5},
                {21, 13, 8}};
        int[] array = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(array);
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 5, 1, 2, 8, 2, 2, 13, 2, 1, 21, 2, 0, 34, 1, 0};
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void testSortNegative() {
        int[][] matrix = {{1, 2, 3},
                {34, 7, 5},
                {21, 13, 8}};
        int[] array = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(array);
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 34, 1, 0, 5, 1, 2, 21, 2, 0, 13, 2, 1, 8, 2, 2};
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void testDevideTheFibNumbersInFibSequences1() {
        int[][] matrix =
                        {{1, 2, 3},
                        {2, 7, 5},
                        {1, 13, 8}};
        int[] arr = {1, 0, 0, 1, 2, 0, 2, 0, 1, 2, 1, 0, 3, 0, 2, 5, 1, 2, 8, 2, 2, 13, 2, 1};
        arr = Sort.devideTheFibNumbersInFibSequences(arr);
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 5, 1, 2, 8, 2, 2, 13, 2, 1, 1, 2, 0, 2, 1, 0} ;
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testDevideTheFibNumbersInFibSequences2() {
        int[][] matrix =
                        {{1, 2, 3},
                        {2, 7, 1},
                        {1, 13, 2}};


        int[] arr = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(arr);
        arr = Sort.devideTheFibNumbersInFibSequences(arr);
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 13, 2, 1, 1, 1, 2, 2, 1, 0, 1, 2, 0, 2, 2, 2} ;
        Assert.assertArrayEquals(expected, arr);
    }
    @Test
    public void testDevideTheFibNumbersInFibSequences3() {
        int[][] matrix =
                        {{1, 2, 3},
                        {1, 7, 1},
                        {1, 1, 2}};


        int[] arr = ExtractFibNum.fibonacciNumbers(matrix, 3);
        Sort.sort(arr);
        arr = Sort.devideTheFibNumbersInFibSequences(arr);
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 1, 1, 0, 2, 2, 2, 1, 2, 0, 1, 1, 2, 1, 2, 1} ;
        Assert.assertArrayEquals(expected, arr);
    }
}
