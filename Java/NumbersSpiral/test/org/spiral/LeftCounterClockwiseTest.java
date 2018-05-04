package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class LeftCounterClockwiseTest {
    LeftCounterClockwise leftCounterClockwise = new LeftCounterClockwise();

    @Test
    public void testCheckDirectionSmallestFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{1,1,1,1},
                        {3,2,2,3},
                        {3,2,2,3},
                        {1,1,1,1}};
        Assert.assertTrue(leftCounterClockwise.checkDirection(matrix, 0, 3));
    }
    @Test
    public void testCheckDirectionMiddleFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{1,2,1,1},
                        {13,3,8,21},
                        {21,5,8,13},
                        {1,2,1,1}};
        Assert.assertTrue(leftCounterClockwise.checkDirection(matrix, 0, 3));
    }
    @Test
    public void testCheckDirectionLargestFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{3,2,1,1},
                        {5,2,3,144},
                        {8,8,5,89},
                        {13,21,34,55}};
        Assert.assertTrue(leftCounterClockwise.checkDirection(matrix, 0, 3));
    }
    @Test
    public void testCheckDirectionFromMiddleIndex() {
        int[][] matrix =
                        {{1,1,2,3},
                        {144,1,1,5},
                        {89,2,3,8},
                        {55,34,21,13}};
        Assert.assertTrue(leftCounterClockwise.checkDirection(matrix, 1, 2));
    }
    @Test
    public void testCheckDirectionFromLastIndex() {
        int[][] matrix =
                        {{1,1,3,2},
                        {2,3,1,1},
                        {1,1,1,1},
                        {2,3,3,2}};
        Assert.assertTrue(leftCounterClockwise.checkDirection(matrix, 2, 1));
    }
    @Test
    public void testCheckDirectionNegativeFirstIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(leftCounterClockwise.checkDirection(matrix, 0, 3));
    }
    @Test
    public void testCheckDirectionNegativeLastIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(leftCounterClockwise.checkDirection(matrix, 0, 0));
    }
}
