package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges_994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int freshOranges = 0, rottenOranges = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) freshOranges++;
                else if(grid[i][j]==2) {
                    rottenOranges++;
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(freshOranges==0) return 0;
        if(rottenOranges==0) return -1;

        int time = 0;
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

        while(!q.isEmpty() && freshOranges>0) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for(int d=0;d<4;d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        freshOranges--;
                    }
                }
            }

            time++;
        }

        return freshOranges==0 ? time : -1;
    }
}
