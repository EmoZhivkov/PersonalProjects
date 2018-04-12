package org.concatenation;

public class Main {
    public static void main(String[] args) {
        //String input = ReadString.readLine();
        String input = "2(AB)2(C2(AB3(xx)AB)C)";
        String temp = new String();
        temp = Concatenation.concatenate(input, temp);
        for (int i = 0; i < temp.length(); i++) {
            System.out.print(temp.charAt(i));
        }
    }
}
