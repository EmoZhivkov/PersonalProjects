package org.textlines;

import org.textlines.Types.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> lineNumberContent = new HashMap<>();
        Map<Integer, TypeOfLine> lineNumberType = new HashMap<>();

        LineContainer lineContainer = new LineContainer(lineNumberContent, lineNumberType);

        //The index represents the hierarchy of types because a palindrome is also text for example
        ArrayList<TypeOfLine> arrayList = new ArrayList<>();
        arrayList.add(0, new TextType());
        arrayList.add(1, new NumberType());
        arrayList.add(2, new PalindromeType());
        arrayList.add(3, new EmptyType());
    
        String fileName = "file.txt";

    }
}
