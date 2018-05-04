package org.spiral;

public class TaskIsThereAFibonacciSpiral extends Fibonacci {

    LeftClockwise leftClockwise = new LeftClockwise();
    LeftCounterClockwise leftCounterClockwise = new LeftCounterClockwise();

    RightClockwise rightClockwise = new RightClockwise();
    RightCounterClockwise rightCounterClockwise = new RightCounterClockwise();

    public boolean isThereAFibonacciSpiral(int[][] matrix) {
        boolean answer = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (isType(matrix[i][j])) {
                    answer = rightClockwise.checkDirection(matrix, i, j);
                    if (answer) {
                        return answer;
                    }
                    answer = rightCounterClockwise.checkDirection(matrix, i, j);
                    if (answer) {
                        return answer;
                    }
                    answer = leftClockwise.checkDirection(matrix, i, j);
                    if (answer) {
                        return answer;
                    }
                    answer = leftCounterClockwise.checkDirection(matrix, i, j);
                    if (answer) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
