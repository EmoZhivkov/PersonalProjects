package org.closerright;

public class Main {
    public static void main(String[] args) {
        int[] input = {1, 0, 10, 8, 16};
        int[] output = CloserRight.biggerRight(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

}
