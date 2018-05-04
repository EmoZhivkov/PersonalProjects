package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class RightClockWiseTest {
    RightClockwise rightClockwise = new RightClockwise();

    @Test
    public void testCheckDirectionSmallestFibonacciFromFirstIndex() {
        int[][] matrix = {{1,1,1,1},
                          {3,2,3,3},
                         {5,8,13,5},
                         {2,3,4,5}};
        Assert.assertTrue(rightClockwise.checkDirection(matrix, 0, 0));
    }
    @Test
    public void testCheckDirectionMiddleFibonacciFromFirstIndex() {
        int[][] matrix =
                {{1,1,2,1},
                {21,2,3,2},
                {13,8,5,3},
                {12,34,56,7}};
        Assert.assertTrue(rightClockwise.checkDirection(matrix, 0, 0));
    }
    @Test
    public void testCheckDirectionLargestFibonacciFromFirstIndex() {
        int[][] matrix =
                        {{1,1,2,3},
                        {144,2,3,5},
                        {89,8,5,8},
                        {55,34,21,13}};
        Assert.assertTrue(rightClockwise.checkDirection(matrix, 0, 0));
    }
    @Test
    public void testCheckDirectionFromMiddleIndex() {
        int[][] matrix =
                       {{1,1,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertTrue(rightClockwise.checkDirection(matrix, 1, 1));
    }
    @Test
    public void testCheckDirectionFromLastIndex() {
        int[][] matrix =
                       {{1,1,2,3},
                        {144,1,1,5},
                        {89,3,1,1},
                        {55,34,3,2}};
        Assert.assertTrue(rightClockwise.checkDirection(matrix, 2, 2));
    }
    @Test
    public void testCheckDirectionNegativeFirstIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(rightClockwise.checkDirection(matrix, 0, 0));
    }
    @Test
    public void testCheckDirectionNegativeLastIndex() {
        int[][] matrix =
                        {{1,2,2,3},
                        {144,1,1,5},
                        {89,3,2,8},
                        {55,34,21,13}};
        Assert.assertFalse(rightClockwise.checkDirection(matrix, 3, 3));
    }
}
