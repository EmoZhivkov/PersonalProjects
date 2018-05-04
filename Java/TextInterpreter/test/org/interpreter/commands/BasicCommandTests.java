package org.interpreter.commands;

import org.interpreter.commands.ReverseCommand;
import org.interpreter.commands.ReverseWordsCommand;
import org.interpreter.commands.WordCountCommand;
import org.junit.Assert;
import org.junit.Test;

public class BasicCommandTests {
    @Test
    public void testFirstWord() {
        String input = "aaabbb cccddd";
        String expected = "aaabbb";
        //Assert.assertEquals(expected, Interpreter.firstWord(input));
    }
    @Test
    public void testReverse() {
        ReverseCommand commandReverse = new ReverseCommand();
        String input = "aaabbb cccddd";
        String expected = "dddccc bbbaaa";
        Assert.assertEquals(expected, commandReverse.execute(input));
    }
    @Test
    public void testWordCount() {
        WordCountCommand commandWordCount = new WordCountCommand();
        String input = "aaabbb cccddd sdg dgss";
        Integer expected = 4;
        Assert.assertEquals(expected, commandWordCount.execute(input));
    }
    @Test
    public void testReverseWords() {
        ReverseWordsCommand commandReverseWords = new ReverseWordsCommand();
        String input = "aaabbb cccddd safsd aaa";
        String expected = "aaa safsd cccddd aaabbb";
        Assert.assertEquals(expected,commandReverseWords.execute(input));
    }

}
