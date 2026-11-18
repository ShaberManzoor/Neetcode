package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic_417 {
    int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        // first row 
        for(int i=0;i<n;i++) {
            if(!pacific[0][i]) dfs(0, i, heights, pacific);
        }

        //first col 
        for(int i=0;i<m;i++) {
            if(!pacific[i][0]) dfs(i, 0, heights, pacific);
        }

        //last col
        for(int i=0;i<m;i++) {
            if(!atlantic[i][n-1]) dfs(i, n-1, heights, atlantic);
        }

        //last row
        for(int i=0;i<n;i++) {
            if(!atlantic[m-1][i]) dfs(m-1, i, heights, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    void dfs(int r, int c, int heights[][], boolean[][] vis) {
        if(vis[r][c]) return;

        vis[r][c] = true;
        for(int di[]: d) {
            int nr = r + di[0], nc = c + di[1];
            if(nr<0 || nr>=heights.length || nc<0 || nc>=heights[0].length) continue;

            if(heights[nr][nc]>=heights[r][c] && !vis[nr][nc]) dfs(nr, nc, heights, vis);
        }
    }
}
