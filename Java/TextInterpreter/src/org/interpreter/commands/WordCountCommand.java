package org.interpreter.commands;

import java.io.Serializable;

public class WordCountCommand implements Command, Serializable {
    public Integer execute(String input) {
        int counter = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                counter++;
            }
        }
        return counter;
    }
}
