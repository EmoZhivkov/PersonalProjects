package org.spiral;

public class Fibonacci implements NumbersType{
    public boolean isType(int num) {
        int fib1 = 0;
        int fib2 = 1;
        do {
            int saveFib1 = fib1;
            fib1 = fib2;
            fib2 = saveFib1 + fib2;
        }
        while (fib2 < num);

        if (fib2 == num)
            return true;
        else
            return false;
    }

    public boolean isType(int[] spiral) {
        if (isType(spiral[0]) && isType(spiral[1])) {
            int trueCounter = 0;
            for (int i = 0; i < spiral.length - 2; i++) {
                if (spiral[i + 2] == spiral[i] + spiral[i + 1]) {
                    trueCounter++;
                }
            }
            if (trueCounter == spiral.length - 2) {
                return true;
            }
        }
        return false;
    }
}
