package org.brackets;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String input = ScanInput.readLine();
        System.out.println(CheckIfExpressionIsTrue.isCorrect(input));
    }
}
