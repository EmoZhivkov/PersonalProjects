package org.spiral;

public class isFibonacci {
    static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) ||
                isPerfectSquare(5 * n * n - 4);
    }

    public static boolean isFibonacci(int[] spiral) {
        if (isFibonacci((int) spiral[0]) && isFibonacci((int) spiral[1])) {
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
