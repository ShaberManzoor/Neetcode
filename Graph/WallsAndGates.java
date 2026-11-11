package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class WallsAndGates {
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(a[i][j]==0) q.offer(new int[]{i, j, 0});
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if(d>a[r][c]) continue;

            for(int i=0;i<4;i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && a[nr][nc]>d+1) {
                    a[nr][nc] = d+1;
                    q.offer(new int[]{nr, nc, a[nr][nc]});
                } 
            }
        }

        return a;
    }
}
