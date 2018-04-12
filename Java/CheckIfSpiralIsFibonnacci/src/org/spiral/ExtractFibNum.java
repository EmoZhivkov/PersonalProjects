package org.spiral;

public class ExtractFibNum {
    public static int[] fibonacciNumbers(int[][] matrix, int matrixSize){
        //before: new int[3*size*size -3]
        //now: new int[(4*matrixSize - 4)*3]

        //ne bachka za sluchaq, kogato vsichkite chisla w matricata sa fib nums
        //changed it back again, because all the numbers in the matrix could be fib numbers
        // => the largest number of fib nums is 3*matrixSize*matrixSize
        int[] fibNumbers = new int[3*matrixSize*matrixSize];
        int counter = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if(isFibonacci.isFibonacci(matrix[i][j])){
                    fibNumbers[counter]=matrix[i][j];
                    counter++;
                    fibNumbers[counter]=i;
                    counter++;
                    fibNumbers[counter]=j;
                    counter++;
                }
            }
        }
        //izolirame nulite, ako imame 3x3 matrica, no 2x2 fibonacci
        int[] finalFibNumbers=new int[counter];
        for (int i = 0; i < counter; i++) {
            finalFibNumbers[i] = fibNumbers[i];
        }
        return finalFibNumbers;
    }
}
