package org.spiral;

public class Main {
    public static void main(String[] args) {
        int[][] matrix =
                {{1,1,1},
                 {1,1,2},
                 {5,4,3}};
        TaskIsThereAFibonacciSpiral taskIsThereAFibonacciSpiral = new TaskIsThereAFibonacciSpiral();
        System.out.println(taskIsThereAFibonacciSpiral.isThereAFibonacciSpiral(matrix));
    }
}
