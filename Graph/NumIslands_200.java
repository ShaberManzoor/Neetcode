package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumIslands_200 {

    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public int numIslands_bfs(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1' && !vis[i][j]) {
                    q.offer(new int[]{i, j});
                    islands++;
                    vis[i][j] = true;
                }

                while(!q.isEmpty()) {
                    int cell[] = q.poll();
                    int r = cell[0], c = cell[1];

                    for(int d=0;d<4;d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' && !vis[nr][nc]){
                            q.offer(new int[]{nr, nc});
                            vis[nr][nc] = true;
                        }
                    }
                }
            }
        }

        return islands;
    }

    public int numIslands_dfs(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;
        boolean vis[][] = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1' && !vis[i][j]) {
                    dfs(grid, vis, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, boolean[][] vis, int r, int c) {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || vis[r][c] || grid[r][c]=='0') return;

        vis[r][c] = true;
        for(int d=0;d<4;d++) {
            int nr = r + dr[d], nc = c + dc[d];
            dfs(grid, vis, nr, nc);
        }
    }
}
