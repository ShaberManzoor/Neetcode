package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueensOpt {
    List<List<String>> res;

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>(); // upper left
    Set<Integer> diag2 = new HashSet<>(); // upper right

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
            int d1 = row - col;
            int d2 = row + col;

            if(cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) continue;
            
            // Choose
            board[row][col] = 'Q';

            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            // Explore
            solve(board, row+1);

            // Backtrack
            board[row][col] = '.';

            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }
}
