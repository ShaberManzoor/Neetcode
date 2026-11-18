package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ValidTree_261 {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, -1});
        vis[0] = true;

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int node = curr[0];
            int parent = curr[1];

            for(int neigh : adj.get(node)) {

                if(neigh == parent) {
                    continue;
                }

                if(vis[neigh]) {
                    return false;
                }

                vis[neigh] = true;
                q.offer(new int[]{neigh, node});
            }
        }

        for(boolean visited : vis) {
            if(!visited) {
                return false;
            }
        }

        return true;
    }
}
