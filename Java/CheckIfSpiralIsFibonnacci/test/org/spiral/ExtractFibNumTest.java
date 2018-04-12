package org.spiral;

import org.junit.Assert;
import org.junit.Test;


public class ExtractFibNumTest {
    @Test
    public void testExtractIndexes() {
        int[][] matrix = {{1, 2, 3},
                {34, 7, 5},
                {21, 13, 8}};
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 34, 1, 0, 5, 1, 2, 21, 2, 0, 13, 2, 1, 8, 2, 2};
        Assert.assertArrayEquals(expected, ExtractFibNum.fibonacciNumbers(matrix, 3));
    }

    @Test
    public void testExtractIndexes1() {
        int[][] matrix = {{1, 2, 7},
                {5, 3, 5},
                {21, 13, 8}};
        int[] expected = {1, 0, 0, 2, 0, 1, 5, 1, 0, 3, 1, 1, 5, 1, 2, 21, 2, 0, 13, 2, 1, 8, 2, 2};
        Assert.assertArrayEquals(expected, ExtractFibNum.fibonacciNumbers(matrix, 3));
    }

    @Test
    public void testExtractIndexes2() {
        int[][] matrix = {{1, 2},
                {34, 3}};
        int[] expected = {1, 0, 0, 2, 0, 1, 34, 1, 0, 3, 1, 1};
        Assert.assertArrayEquals(expected, ExtractFibNum.fibonacciNumbers(matrix, 2));
    }

    @Test
    public void testExtractIndexesNegative() {
        int[][] matrix = {{1, 2, 3},
                {34, 7, 5},
                {21, 13, 8}};
        int[] expected = {1, 0, 0, 2, 0, 1, 3, 0, 2, 34, 1, 0, 5, 1, 2, 21, 2, 0, 13, 2, 1, 8, 2, 2};
        Assert.assertArrayEquals(expected, ExtractFibNum.fibonacciNumbers(matrix, 3));
    }
}
