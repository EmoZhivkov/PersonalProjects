package org.convertrpn;

import java.util.Stack;

public class Convert {
    public static String postfixToInfix(String input) {
        String output = new String();
        Stack<String> temp = new Stack<>();
        int cntLetterOrDigit = 0;
        int cntOperator = 0;
        for (int i = 0; i < input.length(); i++) {
            String current = "" + input.charAt(i);
            if (Character.isLetterOrDigit(current.charAt(0))) {
                temp.push(current);
            } else {
                String b = temp.pop();
                String a = temp.pop();
                if (i == input.length() - 1) {
                    temp.push(a + current + b);
                } else {
                    temp.push("(" + a + current + b + ")");
                }
            }
        }
        return temp.pop();
    }

    public static String infixToPostfix(String input) {
        Stack<Character> temp = new Stack<>();
        String output = new String();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                output = output + current;
            } else if (current == '(') {
                temp.push(current);
            } else if (current == ')') {
                while (!temp.isEmpty() && temp.peek() != '(') {
                    output = output + temp.pop();
                }
                if (temp.peek() == '(') {
                    temp.pop();
                }
            } else  {
                while (!temp.isEmpty() && precedence(current) <= precedence(temp.peek())) {
                    output = output + temp.pop();
                }
                temp.push(current);
            }
        }
        while (!temp.isEmpty()) {
            output = output + temp.pop();
        }
        return output;
    }

    public static int precedence(char opperand) {
        switch (opperand) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
