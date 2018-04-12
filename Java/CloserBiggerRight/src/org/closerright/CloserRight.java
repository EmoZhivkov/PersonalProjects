package org.closerright;

import java.util.Stack;

public class CloserRight {
    //Naive solution
    public static int[] biggerRight(int[] input) {
        int[] output = new int[input.length];

        for (int i= 0;i < input.length;i++) {
            int current = input[i];
            int cntCurrent = i;

            if (i == input.length - 1) {
                output[cntCurrent] = -1;
                break;
            }

            for (int j = i+1; j < input.length; j++) {
                if (current < input[j]) {
                    output[cntCurrent] = input[j];
                    break;
                }
                if (j == input.length - 1) {
                    output[cntCurrent] = -1;
                }
            }
        }
        return output;
    }
}
