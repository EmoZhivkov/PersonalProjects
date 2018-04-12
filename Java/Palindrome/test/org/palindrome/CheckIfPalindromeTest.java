package org.palindrome;

import org.junit.Assert;
import org.junit.Test;

public class CheckIfPalindromeTest {
    @Test
    public void testIsPalindrome1() {
        String input = "bgbobgb";
        Assert.assertTrue(CheckIfPalindrome.isPalindrome(input));
    }
    @Test
    public void testIsPalindrome2() {
        String input = "ggghjhggg";
        Assert.assertTrue(CheckIfPalindrome.isPalindrome(input));
    }
    @Test
    public void testIsPalindrome3() {
        String input = "goggooggog";
        Assert.assertTrue(CheckIfPalindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome4() {
        String input = "gogoggog";
        Assert.assertFalse(CheckIfPalindrome.isPalindrome(input));
    }
    @Test
    public void testIsPalindrome5() {
        String input = "gsedfg";
        Assert.assertFalse(CheckIfPalindrome.isPalindrome(input));
    }
    @Test
    public void testIsPalindrome6() {
        String input = "wwow";
        Assert.assertFalse(CheckIfPalindrome.isPalindrome(input));
    }

}
