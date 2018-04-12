package org.brackets;

import java.util.Scanner;

public class ScanInput {
    public static String readLine() {
        Scanner t = new Scanner(System.in);
        String input = t.nextLine();
        return input;
    }
}
