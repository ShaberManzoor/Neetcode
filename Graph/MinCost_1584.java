package Graph;

import java.util.Arrays;

public class MinCost_1584 {

    // Prims Algorithm
    public int minCostConnectPointsPrims(int[][] points) {
        int n = points.length;

        int minDis[] = new int[n];
        boolean vis[] = new boolean[n];

        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[0] = 0;
        int minCost = 0;

        for(int point=0;point<n;point++) {
            int u = -1;

            //1. Minimum unvisited cost
            for(int i=0;i<n;i++) {
                if(!vis[i] && (u==-1 || minDis[i]<minDis[u])) {
                    u = i;
                }
            }

            // 2. Include in MST
            vis[u] = true;
            minCost += minDis[u];

            // 3. Cost to remaining unvisited points
            for(int v=0;v<n;v++) {
                if(!vis[v]) {
                    int dis = Math.abs(points[v][0]-points[u][0]) + Math.abs(points[v][1]-points[u][1]);

                    minDis[v] = Math.min(dis, minDis[v]);
                }
            }
        }

        return minCost;
    }
}
