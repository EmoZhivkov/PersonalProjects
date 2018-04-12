package org.palindrome;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class CheckIfPalindrome {
    public static boolean isPalindrome(String input) {
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            temp.push(input.charAt(i));
        }

        ArrayDeque<Character> temp1 = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            temp1.add(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (temp.pop() != temp1.removeFirst()) {
                return false;
            }
        }
        return true;
    }
}
