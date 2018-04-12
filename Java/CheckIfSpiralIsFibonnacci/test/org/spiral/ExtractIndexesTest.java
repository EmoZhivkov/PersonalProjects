package org.spiral;

import org.junit.Assert;
import org.junit.Test;

public class ExtractIndexesTest {
    @Test
    public void testExtractIndexes() {
        int[] array = {1, 0, 0, 2, 0, 1, 3, 0, 2, 5, 1, 2};
        int[] expectedNumbers = {1, 2, 3, 5};
        int[] expectedLeft = {0, 0, 0, 1};
        int[] expectedRight = {0, 1, 2, 2};
        Assert.assertArrayEquals(expectedNumbers, ExtractIndexes.extractNumbers(array));
        Assert.assertArrayEquals(expectedLeft, ExtractIndexes.extractLeft(array));
        Assert.assertArrayEquals(expectedRight, ExtractIndexes.extractRight(array));
    }
    @Test
    public void testExtractIndexesNegative() {
        int[] array = {1, 0, 0, 2, 0, 1, 3, 0, 2, 5, 1, 2};
        int[] expectedNumbers = {1, 2, 3, 5};
        int[] expectedLeft = {0, 1, 2, 2};
        int[] expectedRight = {0, 0, 0, 1};
        Assert.assertArrayEquals(expectedNumbers, ExtractIndexes.extractNumbers(array));
        Assert.assertArrayEquals(expectedLeft, ExtractIndexes.extractLeft(array));
        Assert.assertArrayEquals(expectedRight, ExtractIndexes.extractRight(array));
    }
}
