package org.textlines.Types;

import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeType implements TypeOfLine{
    @Override
    public boolean isCurrentType(String string) {
        boolean b = true;

        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            temp.push(string.charAt(i));
        }

        ArrayDeque<Character> temp1 = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            temp1.add(string.charAt(i));
        }

        for (int i = 0; i < string.length(); i++) {
            if (temp.pop() != temp1.removeFirst()) {
                b = false;
                break;
            }
        }
        return b;
    }
    @Override
    public String toString() {
        return "PalindromeType";
    }
}
