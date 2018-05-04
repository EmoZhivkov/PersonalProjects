package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class LeftClockwiseTest {
    LeftClockwise leftClockwise = new LeftClockwise();
    @Test
    public void testCheckDirectionSmallestFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{1,1,1,1},
                        {3,2,3,3},
                        {3,2,2,3},
                        {1,1,1,1}};
        Assert.assertTrue(leftClockwise.checkDirection(matrix, 3, 3));
    }
    @Test
    public void testCheckDirectionMiddleFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{1,1,2,1},
                        {13,5,8,13},
                        {21,3,3,21},
                        {1,2,1,1}};
        Assert.assertTrue(leftClockwise.checkDirection(matrix, 3, 3));
    }
    @Test
    public void testCheckDirectionLargestFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{13,21,34,55},
                        {8,2,3,89},
                        {5,8,5,144},
                        {3,2,1,1}};
        Assert.assertTrue(leftClockwise.checkDirection(matrix, 3, 3));
    }
    @Test
    public void testCheckDirectionFromMiddleIndex() {
        int[][] matrix =
                        {{1,1,2,3},
                        {144,2,3,5},
                        {89,1,1,8},
                        {55,34,21,13}};
        Assert.assertTrue(leftClockwise.checkDirection(matrix, 2, 2));
    }
    @Test
    public void testCheckDirectionFromLastIndex() {
        int[][] matrix =
                        {{1,1,3,2},
                        {2,3,1,1},
                        {1,1,1,1},
                        {55,34,3,2}};
        Assert.assertTrue(leftClockwise.checkDirection(matrix, 2, 1));
    }
    @Test
    public void testCheckDirectionNegativeFirstIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(leftClockwise.checkDirection(matrix, 3, 3));
    }
    @Test
    public void testCheckDirectionNegativeLastIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(leftClockwise.checkDirection(matrix, 0, 0));
    }
}
