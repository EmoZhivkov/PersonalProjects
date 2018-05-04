package org.interpreter.commands;

import java.io.Serializable;
import java.util.Stack;

public class ReverseWordsCommand implements Command, Serializable {
    public String execute(String input) {
        String output = "";
        String currentWord = "";
        Stack<String> temp = new Stack<>();
        int wordCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == ' ') {
                temp.push(currentWord);
                currentWord = "";
                wordCounter++;
                continue;
            }
            currentWord = currentWord + current;
            if (i == input.length() - 1) {
                temp.push(currentWord);
                wordCounter++;
            }
        }
        for (int i = 0; i < wordCounter; i++) {
            if (i == 0) {
                output += temp.pop();
            } else {
                output += " " + temp.pop();
            }
        }
        return output;
    }
}
