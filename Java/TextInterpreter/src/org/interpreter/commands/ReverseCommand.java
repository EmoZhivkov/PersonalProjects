package org.interpreter.commands;

import java.io.Serializable;
import java.util.Stack;

public class ReverseCommand implements Command, Serializable {
    public String execute(String input) {
        String output = "";
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            temp.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            output = output + temp.pop();
        }
        return output;
    }
}
