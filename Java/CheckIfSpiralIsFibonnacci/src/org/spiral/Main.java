package org.spiral;

public class Main {
    public static void main(String[] args) {
        //int[][] matrix = CreateMatrix.createMatrix(3);
        int sizeMatrix = 3;
        int[][] matrix =
                        {{1, 2, 2},
                        {5, 3, 3},
                        {21, 13, 1}};
        int[] arr = ExtractFibNum.fibonacciNumbers(matrix, sizeMatrix);
        Sort.sort(arr);
        int[] sortedInFibSequences = Sort.devideTheFibNumbersInFibSequences(arr);

        boolean a= AreThereFibSpirals.answer(sortedInFibSequences, 0, 3);

        System.out.println(a);
    }
}
