package com.company;

public class Main {

    private void solve(int[][] board) {
        if (solve(board, 0, 0)){
            print(board);
        }
        else {
            System.err.println("Invalid Board");
        }
    }
    private boolean solve(int[][] board, int x, int y) {
        for (x = 0; x < 9; x++) {
            for (y = 0; y < 9; y++) {
                if (board[y][x] == 0) {
                    for (int value = 1; value <= 9; value++) {
                        if (possible(board, x, y, value)) {
                            board[y][x] = value;
                            if (!solve(board, x, y)) {
                                board[y][x] = 0;
                            }
                            else {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean possible(int[][] board, int x, int y, int value){
        int x0 = (x/3) * 3;
        int y0 = (y/3) * 3;
        for(int i = 0; i < 9; i++){
            if(board[i][x] == value || board[y][i] == value){
                return false;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[y0+i][x0+j] == value){
                    return false;
                }
            }
        }
        return true;
    }
    private void print(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                System.out.print(board[i][j] + "  " + "");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        int [][] board = {{0, 0, 3, 0, 8, 6, 0, 0, 0},
                          {0, 0, 0, 0, 0, 1, 0, 8, 2},
                          {1, 0, 0, 0, 0, 0, 7, 0, 0},
                          {0, 7, 5, 0, 9, 0, 0, 0, 4},
                          {0, 0, 0, 1, 0, 0, 3, 0, 0},
                          {3, 0, 0, 8, 0, 0, 0, 0, 0},
                          {0, 8, 1, 0, 0, 0, 0, 7, 9},
                          {0, 0, 0, 0, 5, 4, 0, 0, 3},
                          {9, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println("Unsolved Sudoku: ");
        m.print(board);
        System.out.println("Solved Sudoku: ");
        m.solve(board);
    }
}