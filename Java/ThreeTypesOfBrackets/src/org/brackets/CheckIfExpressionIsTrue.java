package org.brackets;

import java.util.Stack;

public class CheckIfExpressionIsTrue {
    public static boolean isCorrect(String input) {
        Stack<Character> output = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                output.push(current);
            } else if (current == ')' ) {
                if (output.isEmpty())
                    return false;
                if (output.peek() == '(') {
                    output.pop();
                }
                else return false;
            } else if (current == ']') {
                if (output.isEmpty())
                    return false;
                if (output.peek() == '[') {
                    output.pop();
                }
                else return false;
            } else if (current == '}') {
                if (output.isEmpty())
                    return false;
                if (output.peek() == '{') {
                    output.pop();
                }
                else return false;
            }
        }
        if (output.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
