package PriorityQueue;

import java.util.PriorityQueue;

public class LastStone_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> Integer.compare(b, a));

        for(int stone: stones) maxHeap.offer(stone);

        while(maxHeap.size()!=1) {
            int a = maxHeap.poll(), b = maxHeap.poll();

            maxHeap.offer(Math.abs(a-b));
        }

        return maxHeap.poll();
    }
}
