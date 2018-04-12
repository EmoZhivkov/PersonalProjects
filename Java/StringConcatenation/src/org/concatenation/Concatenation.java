package org.concatenation;

public class Concatenation {
    public static String concatenate(String input, String temp) {
        char current = '0';
        int mult = 0;
        String t = new String();
        for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i);
            if (!Character.isDigit(current)) {
                temp = temp + current;
            }else {
                mult = Character.getNumericValue(current);
                i++;
                current = input.charAt(i);
                if (current != '(') {
                    for (int j = 0; j < mult; j++) {
                        temp = temp + current;
                    }
                } else {
                    int cnt = 1;
                    while (cnt != 0) {
                        i++;
                        current = input.charAt(i);
                        if (current == '(') {
                            cnt++;
                            t = t + current;
                        } else if (current == ')') {
                            cnt--;
                            if (cnt != 0) {
                                t = t + current;
                            }
                        } else {
                            t = t + current;
                        }
                    }
                    for (int j = 0; j < mult; j++) {
                        temp = concatenate(t, temp);
                    }
                    t = new String();
                }
            }
        }
        return temp;
    }
}
