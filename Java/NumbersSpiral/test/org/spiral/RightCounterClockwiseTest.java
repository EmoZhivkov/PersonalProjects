package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class RightCounterClockwiseTest {
    RightCounterClockwise rightCounterClockwise = new RightCounterClockwise();

    @Test
    public void testCheckDirectionSmallestFibonacciFromFirstIndex() {
        int[][] matrix =
               {{1,1,1,1},
                {3,2,3,3},
                {3,2,13,5},
                {1,1,4,5}};
        Assert.assertTrue(rightCounterClockwise.checkDirection(matrix, 3, 0));
    }
    @Test
    public void testCheckDirectionMiddleFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{1,1,2,1},
                        {13,8,5,2},
                        {21,8,3,3},
                        {1,1,2,7}};
        Assert.assertTrue(rightCounterClockwise.checkDirection(matrix, 3, 0));
    }
    @Test
    public void testCheckDirectionLargestFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{55,34,21,13},
                        {89,2,3,8},
                        {144,8,5,5},
                        {1,1,2,3}};
        Assert.assertTrue(rightCounterClockwise.checkDirection(matrix, 3, 0));
    }
    @Test
    public void testCheckDirectionFromMiddleIndex() {
        int[][] matrix =
                        {{1,1,2,3},
                        {144,3,2,5},
                        {89,1,1,8},
                        {55,34,21,13}};
        Assert.assertTrue(rightCounterClockwise.checkDirection(matrix, 2, 1));
    }
    @Test
    public void testCheckDirectionFromLastIndex() {
        int[][] matrix =
                        {{1,1,3,2},
                        {144,1,1,1},
                        {89,3,1,1},
                        {55,34,3,2}};
        Assert.assertTrue(rightCounterClockwise.checkDirection(matrix, 1, 2));
    }
    @Test
    public void testCheckDirectionNegativeFirstIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(rightCounterClockwise.checkDirection(matrix, 3, 0));
    }
    @Test
    public void testCheckDirectionNegativeLastIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(rightCounterClockwise.checkDirection(matrix, 0, 3));
    }

}
