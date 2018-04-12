package org.spiral;

import java.util.Scanner;

public class  CreateMatrix {
    public static int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];
        Scanner num = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = num.nextInt();
            }
        }
        return matrix;
    }
}
