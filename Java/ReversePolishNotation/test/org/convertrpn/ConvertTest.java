package org.convertrpn;

import org.junit.Assert;
import org.junit.Test;

public class ConvertTest {
    @Test
    public void testPostfixToInfix() {
        String input = "abcd^e-fgh*+^*g%+i-";
        String expected = "(a+((b*(((c^d)-e)^(f+(g*h))))%g))-i";
        Assert.assertEquals(expected, Convert.postfixToInfix(input));
    }
    @Test
    public void testPostfixToInfix1() {
        String input = "as^ab+/c-";
        String expected = "((a^s)/(a+b))-c";
        Assert.assertEquals(expected, Convert.postfixToInfix(input));
    }
    @Test
    public void testPostfixToInfix2() {
        String input = "abcd^e-fgh*+^*g%+i-";
        String expected = "(a+((b*(((c^d)-e)^(f+(g*h))))%g))-i";
        Assert.assertEquals(expected, Convert.postfixToInfix(input));
    }
    @Test
    public void testInfixToPostfix1() {
        String input = "(a+b)*c+d";
        String expected = "ab+c*d+";
        Assert.assertEquals(expected, Convert.infixToPostfix(input));
    }
    @Test
    public void testInfixToPostfix2() {
        String input = "(a^s)/(a+b)-c";
        String expected = "as^ab+/c-";
        Assert.assertEquals(expected, Convert.infixToPostfix(input));
    }
    @Test
    public void testInfixToPostfix() {
        String input = "a+b*(c^d-e)^(f+g*h)-i";
        String expected = "abcd^e-fgh*+^*+i-";
        Assert.assertEquals(expected, Convert.infixToPostfix(input));
    }
}
