package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class TaskIsThereAFibonacciSpiralTest {
    TaskIsThereAFibonacciSpiral taskIsThereAFibonacciSpiral = new TaskIsThereAFibonacciSpiral();

    @Test
    public void testIsThereAFibonacciSpiralSmallest() {
        int[][] matrix =
                        {{1,1,1},
                        {3,2,2},
                        {5,4,3}};
        Assert.assertTrue(taskIsThereAFibonacciSpiral.isThereAFibonacciSpiral(matrix));
    }
    @Test
    public void testIsThereAFibonacciSpiralBiggest() {
        int[][] matrix =
                        {{1,1,2},
                        {21,2,3},
                        {13,8,5}};
        Assert.assertTrue(taskIsThereAFibonacciSpiral.isThereAFibonacciSpiral(matrix));
    }
    @Test
    public void testIsThereAFibonacciSpiralRight() {
        int[][] matrix =
                        {{1,3,1},
                        {3,2,1},
                        {5,4,3}};
        Assert.assertTrue(taskIsThereAFibonacciSpiral.isThereAFibonacciSpiral(matrix));
    }@Test
    public void testIsThereAFibonacciSpiralMiddle() {
        int[][] matrix =
                        {{1,3,1},
                        {3,1,1},
                        {5,2,3}};
        Assert.assertTrue(taskIsThereAFibonacciSpiral.isThereAFibonacciSpiral(matrix));
    }
    @Test
    public void testIsThereAFibonacciSpiralNegative() {
        int[][] matrix =
                        {{1,3,1},
                        {1,1,1},
                        {1,1,1}};
        Assert.assertFalse(taskIsThereAFibonacciSpiral.isThereAFibonacciSpiral(matrix));
    }
}
