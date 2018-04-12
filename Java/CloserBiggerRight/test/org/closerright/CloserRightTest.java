package org.closerright;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;

public class CloserRightTest {
    @Test
    public void testBiggerRight() {
        int[] input = {1, 0, 10, 8, 16};
        int[] expected = {10, 10, 16, 16, -1};

        Assert.assertArrayEquals(expected, CloserRight.biggerRight(input));
    }
    @Test
    public void testBiggerRight1() {
        int[] input = {1, 1, 1, 1, 1};
        int[] expected = {-1, -1, -1, -1, -1};

        Assert.assertArrayEquals(expected, CloserRight.biggerRight(input));
    }
    @Test
    public void testBiggerRight2() {
        int[] input = {10, 0, 1, 8, 16};
        int[] expected = {16, 1, 8, 16, -1};

        Assert.assertArrayEquals(expected, CloserRight.biggerRight(input));
    }
    @Test
    public void testBiggerRight3() {
        int[] input = {1, 0, 16, 8, 10};
            int[] expected = {16, 16, -1, 10, -1};

        Assert.assertArrayEquals(expected, CloserRight.biggerRight(input));
    }
}
