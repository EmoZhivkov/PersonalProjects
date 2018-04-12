package org.minmissing;

import org.junit.Assert;
import org.junit.Test;

public class FindMinMissingTest {
    @Test
    public void testGetMinMissing() {
        int[] input = {1,2,3,5,6,8,11,100};
        int expected = 4;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing1() {
        int[] input = {1,2,3,4,5,8,11,100};
        int expected = 6;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing2() {
        int[] input = {1,2,3,4,6,8,11,100};
        int expected = 5;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing3() {
        int[] input = {2,3,5,6,8,11,100};
        int expected = 1;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing4() {
        int[] input = {1,2,3,4,6,7,8,100};
        int expected = 5;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing5() {
        int[] input = {1,2,3,4,5,6,7,100,110};
        int expected = 8;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
///////////
    @Test
    public void testGetMinMissing6() {
        int[] input = {1,2,3,5,6,7};
        int expected = 4;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing7() {
        int[] input = {1,2,3,4,6,7,8};
        int expected = 5;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing8() {
        int[] input = {1,2,3,4,5,6,7,8,110};
        int expected = 9;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing9() {
        int[] input = {1,3,4,5,6,9,10,100,110};
        int expected = 2;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }
    @Test
    public void testGetMinMissing10() {
        int[] input = {1,2,3,4,5,7,8,100,110};
        int expected = 6;

        Assert.assertEquals(expected, FindMinMissing.getMinMissing(input));
    }

}
