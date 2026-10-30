package Backtracking;

public class WordSearch_79 {
    int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        if(word.length()>m*n) return false;

        //pruning 1: Checking freq of char
        int freq[] = new int[128];
        for (char[] row : board) {
            for (char ch : row) {
                freq[ch]++;
            }
        }

        for(char c: word.toCharArray()) {
            if(--freq[c]<0) return false;
        }

        //pruning 2: start from the lest freq char
        if(freq[word.charAt(0)] > freq[word.charAt(word.length()-1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(dfs(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int idx) {
        if(idx==word.length()) return true;

        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(idx)) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        for(int d[]: dirs) {
            if(dfs(board, r + d[0], c + d[1], word, idx+1)) {
                board[r][c] = temp;
                return true;
            }
        }

        board[r][c] = temp;
        return false;
    }
}
