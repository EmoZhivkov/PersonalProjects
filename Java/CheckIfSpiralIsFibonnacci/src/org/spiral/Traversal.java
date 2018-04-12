package org.spiral;

public class Traversal {

    public static boolean isFibIndexesSpiral(int[] left, int[] right, int sizeMatrix) {
        int n = left.length;
        //trqbva ni za sluchaq s 3x3 matrica s 2x2 fibonacci
        //vadi razlikata mevdu nai-gorniq red na fibonacci i naj-dolniq i dobavq 1
        //taka vijdame kolko e golqmo i podavame negoviq razmer
        int max=left[0];
        int min=left[0];
        for (int i = 0; i < n ; i++) {
            if(left[i]>max){
                max=left[i];
            }
            if(left[i]<min){
                min=left[i];
            }
        }
        int m = max-min+1;

        boolean isSppiralFibonacci = true;

        if (n == (4 * m - 4)) {
            for (int i = 0; i < n / 3 && isSppiralFibonacci; i++) {
                if (!(left[i] == left[i + 1] && right[i] + 1 == right[i + 1])) {
                    isSppiralFibonacci = false;
                }
            }
            for (int i = n / 3; i < n / 2 && isSppiralFibonacci; i++) {
                if (!(left[i] + 1 == left[i + 1] && right[i] == right[i + 1])) {
                    isSppiralFibonacci = false;
                }
            }
            for (int i = n / 2 ; i < (3 * n) / 4 && isSppiralFibonacci; i++) {
                if (!(left[i] == left[i + 1] && right[i] - 1 == right[i + 1])) {
                    isSppiralFibonacci = false;
                }
            }
            for (int i = (3 * n) / 4 ; i < n -1 && isSppiralFibonacci; i++) {
                if (!(left[i] - 1 == left[i + 1] && right[i] == right[i + 1])) {
                    isSppiralFibonacci = false;
                }
            }
        } else {
            isSppiralFibonacci = false;
        }
        return isSppiralFibonacci;
    }
}
