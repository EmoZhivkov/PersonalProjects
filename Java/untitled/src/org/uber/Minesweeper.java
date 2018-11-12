package org.uber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Minesweeper {
    private int sides;
    private int numOfBombs;
    private int[][] board;

    public Minesweeper(int sides, int numOfBombs) {
        this.sides = sides;
        this.numOfBombs = numOfBombs;
        this.board = new int[sides][sides];
        this.createMatrix();
    }

    public void showBoard() {
        for (int i = 0; i < sides; i++) {
            for (int j = 0; j < sides; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void createMatrix() {
        putBombs();
        putNumbers();
    }

    private void putBombs() {
        int cntBombs = this.numOfBombs;

        for (int i = 0; i < this.sides; i++) {
            for (int j = 0; j < this.sides; j++) {
                board[i][j] = -1;

                cntBombs--;
                if (cntBombs == 0) {
                    break;
                }
            }
            if (cntBombs == 0) {
                break;
            }
        }
    }

    private void putNumbers() {
        for (int i = 0; i < this.sides; i++) {
            for (int j = 0; j < this.sides; j++) {
                if (board[i][j] == -1) {
                    continue;
                } else {
                    int cnt = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k == -1 || l == sides || l == -1 || k == sides) {
                                continue;
                            } else {
                                if (board[k][l] == -1) {
                                    cnt++;
                                }
                            }
                        }
                    }
                    board[i][j] = cnt;
                }
            }
        }
    }

}


