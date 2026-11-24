package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItenary_322 {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        //1. Build the graph
        for(List<String> ticket: tickets) {
            String from = ticket.get(0), to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        //2. Start dfs from "JFK"
        dfs("JFK");

        //3. Reverse the result
        Collections.reverse(result);

        return result;
    }

    public void dfs(String airport) {
        PriorityQueue<String> neigh = graph.get(airport);

        //4. Explore the neighbours
        while(neigh!=null && !neigh.isEmpty()) {
            String next = neigh.poll();

            dfs(next);
        }

        //5. After visiting all the neigh add the airport
        result.add(airport);
    }
}
