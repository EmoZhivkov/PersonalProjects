package org.brackets;

import org.junit.Assert;
import org.junit.Test;

public class CheckIfExpressionIsTrueTest {
    @Test
    public void testIsCorrect01() {
        String input = "{{]}";
        Assert.assertFalse(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect02() {
        String input = "{{}}}";
        Assert.assertFalse(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect03() {
        String input = "{{{}}";
        Assert.assertFalse(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect04() {
        String input = "{({])}";
        Assert.assertFalse(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect05() {
        String input = "[{{}}])";
        Assert.assertFalse(CheckIfExpressionIsTrue.isCorrect(input));
    }
    //test if true
    @Test
    public void testIsCorrect06() {
        String input = "{{}}";
        Assert.assertTrue(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect07() {
        String input = "({[]})";
        Assert.assertTrue(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect08() {
        String input = "({{{[]}}})";
        Assert.assertTrue(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect09() {
        String input = "{}";
        Assert.assertTrue(CheckIfExpressionIsTrue.isCorrect(input));
    }
    @Test
    public void testIsCorrect10() {
        String input = "[{(({[]}))}]";
        Assert.assertTrue(CheckIfExpressionIsTrue.isCorrect(input));
    }
}
