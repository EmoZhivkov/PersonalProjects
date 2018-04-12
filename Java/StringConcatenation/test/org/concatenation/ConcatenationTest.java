package org.concatenation;

import org.junit.Assert;
import org.junit.Test;

public class ConcatenationTest {
    @Test
    public void testConcatenate1() {
        String input = "2(AB)2A3(AA)";
        String expected = "ABABAAAAAAAA";
        String temp = new String();
        temp = Concatenation.concatenate(input, temp);
        Assert.assertEquals(expected,temp);
    }
    @Test
    public void testConcatenate2() {
        String input = "2(A3(BB))";
        String expected = "ABBBBBBABBBBBB";
        String temp = new String();
        temp = Concatenation.concatenate(input, temp);
        Assert.assertEquals(expected,temp);
    }
    @Test
    public void testConcatenate3() {
        String input = "2(C2(AB3(xx)AB)C)A2B2(ABA)";
        String expected = "CABxxxxxxABABxxxxxxABCCABxxxxxxABABxxxxxxABCABBABAABA";
        String temp = new String();
        temp = Concatenation.concatenate(input, temp);
        Assert.assertEquals(expected,temp);
    }
    @Test
    public void testConcatenate4() {
        String input = "2(AB)2(C2(AB3(xx)AB)C)";
        String expected = "ABABCABxxxxxxABABxxxxxxABCCABxxxxxxABABxxxxxxABC";
        String temp = new String();
        temp = Concatenation.concatenate(input, temp);
        Assert.assertEquals(expected,temp);
    }
    @Test
    public void testConcatenate() {
        String input = "2(2(AB)2(C2(AB3(xx)AB)C))";
        String expected = "ABABCABxxxxxxABABxxxxxxABCCABxxxxxxABABxxxxxxABCABABCABxxxxxxABABxxxxxxABCCABxxxxxxABABxxxxxxABC";
        String temp = new String();
        temp = Concatenation.concatenate(input, temp);
        Assert.assertEquals(expected,temp);
    }

}
