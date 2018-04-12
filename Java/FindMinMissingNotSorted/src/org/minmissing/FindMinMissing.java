package org.minmissing;

public class FindMinMissing {
    //input a sorted array with a missing element
    public static int getMinMissing(int[] input) {
        int l = 0;
        int r = input.length -1;
        int m = (input.length - 1)/2;
        int missing = 0;

        for (;;) {
            //if the middle index element matches the middle index+1 then the
            //left part of the array doesn't have a missing element, then proceed to the right part
            if (input[m] != m + 1) {
                r = m;
                m = l + (r - l) / 2;
            } else {
                l = m;
                m = l + (r - l) / 2;
            }

            if (r - l == 1) {
                missing = input[l]+1;
                if (l == 0 && input[l] != 1) {
                    missing = 1;
                }
                break;
            }
        }
        return missing;
    }
}
