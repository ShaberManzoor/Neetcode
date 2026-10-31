package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char b[]: board) Arrays.fill(b, '.');

        solve(board, 0);

        return res;
    }

    public void solve(char[][] board, int row) {
        if(row==board.length) {
            //now we will add the solution
            List<String> temp = new ArrayList<>();
            for(char[] r: board) {
                temp.add(new String(r));
            }

            res.add(temp);
            return;
        }

        for(int col=0;col<board.length;col++) {
            if(isValid(board, row, col)) {
                // Choose
                board[row][col] = 'Q';

                // Explore
                solve(board, row+1);

                // Undo
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        //check col
        for(int r=0;r<row;r++) {
            if(board[r][col]=='Q') return false;
        }

        //check upper left diagonal
        int r = row-1, c = col-1;
        while(r>=0 && c>=0) {
            if(board[r][c]=='Q') return false;

            r--;
            c--;
        }

        //check upper right diagonal
        r = row-1;
        c = col+1;
        while(r>=0 && c<board[0].length) {
            if(board[r][c]=='Q') return false;

            r--;
            c++;
        }

        return true;
    }
}
