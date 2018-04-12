package org.files;

import org.junit.Assert;
import org.junit.Test;

public class FunctionsTest {
    @Test
    public void testExtractIntArrayFromFile() {
        int[] arrExp = {1,2,3,4,5,6,7,8,9,10,11,1,1,21,23,34,4};
        int[] arr = Functions.extractIntArrayFromFile("firstTest.txt", 100);
        Assert.assertArrayEquals(arrExp, arr);
    }
}
