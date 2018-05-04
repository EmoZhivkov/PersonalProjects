package org.spiral;

public class LeftCounterClockwise extends Fibonacci implements Direction {
    public boolean checkDirection(int[][] matrix, int i, int j) {
        int iHelper = i;
        int jHelper = j;
        boolean isFibonacci = false;

        for (int k = 2; k <= matrix.length; k++) {
            int arrIndex = 0;
            int[] arr = new int[4*k - 4];

            //down left
            for (int l = 0; l < k; l++) {
                if (j - l == -1) {
                    return isFibonacci;
                }
                arr[arrIndex] = matrix[i][j - l];
                arrIndex++;
            }
            j = j - k + 1;

            //top down
            for (int l = 1; l < k; l++) {
                if (i + l == matrix.length) {
                    return isFibonacci;
                }
                arr[arrIndex] = matrix[i + l][j];
                arrIndex++;
            }
            i = i + k - 1;

            //top right
            for (int l = 1; l < k; l++) {
                arr[arrIndex] = matrix[i][j + l];
                arrIndex++;
            }
            j = j + k - 1;

            //down up
            for (int l = 1; l < k-1; l++) {
                arr[arrIndex] = matrix[i - l][j];
                arrIndex++;
            }
            i = i - k + 1;

            isFibonacci = isType(arr);
            if (isFibonacci == true) {
                return true;
            }
            i = iHelper;
            j = jHelper;
        }
        return false;
    }
}
