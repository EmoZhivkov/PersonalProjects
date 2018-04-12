package org.spiral;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

    public class isFibonacciTest {
    @Test
    public void testisFibonacci() {
        int[] array = {1, 2, 3, 5, 8, 13};
        long startTime = System.nanoTime();
        assertTrue(isFibonacci.isFibonacci(array));
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }
    @Test
    public void testisFibonacci1() {
        int[] array1 = {1, 2, 5, 8, 13};
        long startTime1 = System.nanoTime();
        assertTrue(isFibonacci.isFibonacci(array1));
        long stopTime1 = System.nanoTime();
        System.out.println(stopTime1 - startTime1);
    }
    @Test
    public void testisFibonacci2() {
        int[] array2 = {1, 2, 3, 5, 8, 13, 21, 34};
        long startTime2 = System.nanoTime();
        assertTrue(isFibonacci.isFibonacci(array2));
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);
    }
    @Test
    public void testisFibonacci3() {
        int[] array3 = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        long startTime3 = System.nanoTime();
        assertTrue(isFibonacci.isFibonacci(array3));
        long stopTime3 = System.nanoTime();
        System.out.println(stopTime3 - startTime3);
    }
}

