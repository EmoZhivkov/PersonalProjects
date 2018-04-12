package org.convertrpn;

public class Main {
    public static void main(String[] args) {
        String input = "(a+b)*c+d"  ;
        System.out.println(Convert.infixToPostfix(input));
       // System.out.println(input);
        //System.out.println(Convert.postfixToInfix(Convert.infixToPostfix(input)));
    }
}
