package PriorityQueue;

import java.util.PriorityQueue;

public class KClosest_973 {
    public int[][] kClosest(int[][] points, int k) {
        // {sqr, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int[] point: points) {
            int x = point[0], y = point[1];
            int sqr = x*x + y*y;
            pq.offer(new int[]{sqr, x, y});

            if(pq.size()>k) pq.poll();
        }

        int[][] res = new int[k][2];
        for(int i=0;i<k;i++) {
            int[] p = pq.poll();
            res[i][0] = p[1];
            res[i][1] = p[2];
        }

        return res;
    }
}
