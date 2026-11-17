package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        //Using Kahns Algo (BFS - Topo Sort)
        int indeg[] = new int[numCourses];
        for(int pre[]: prerequisites) {
            int u = pre[1];
            int v = pre[0];

            adj.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int v=0;v<numCourses;v++) {
            if(indeg[v]==0) q.offer(v);
        }

        if(q.isEmpty()) return false;
        
        int courses = 0;
        while(!q.isEmpty()){
            int v = q.poll();
            courses++;

            for(int neigh: adj.get(v)) {
                if(--indeg[neigh]==0) q.offer(neigh);
            }
        }

        return courses==numCourses;
    }
}
