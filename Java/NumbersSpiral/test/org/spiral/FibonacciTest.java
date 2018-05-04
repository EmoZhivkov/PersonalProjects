package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();
    @Test
    public void testIsTypeNumberPositive() {

        Assert.assertTrue(fibonacci.isType(5));
    }
    @Test
    public void testIsTypeNumberNegative() {
        Assert.assertFalse(fibonacci.isType(7));
    }

    @Test
    public void testIsTypeArrayPositive() {
        int[] arr = {1,1,2,3,5};
        Assert.assertTrue(fibonacci.isType(arr));
    }
    @Test
    public void testIsTypeArrayNegative() {
        int[] arr = {1,2,2,3,5};
        Assert.assertFalse(fibonacci.isType(arr));
    }
}
