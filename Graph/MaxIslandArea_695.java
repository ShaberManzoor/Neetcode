package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class MaxIslandArea_695 {
    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int maxArea = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1 && !vis[i][j]) {
                    // int area = bfs(grid, vis, i, j);
                    int area = dfs(grid, vis, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int bfs(int[][] grid, boolean[][] vis, int r, int c) {
        vis[r][c] = true;

        int area = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        while(!q.isEmpty()){
            area++;

            int cell[] = q.poll();
            r = cell[0];
            c = cell[1];

            for(int d=0;d<4;d++){
                int nr = r + dr[d], nc = c + dc[d];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && !vis[nr][nc]){
                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                } 
            }
        }

        return area;
    }

    public int dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || vis[r][c] || grid[r][c]==0) return 0;

        vis[r][c] = true;
        int area =  1;
        for(int d=0;d<4;d++) {
            area += dfs(grid, vis, r + dr[d], c + dc[d]);
        }

        return area;
    }
}