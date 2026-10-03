package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent_271 {

    // Using Min Heap O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a)-freq.get(b));

        for(int num: freq.keySet()) {
            pq.offer(num);
            
            if(pq.size()>k) pq.poll();
        }

        int res[] = new int[k];
        for(int i=k-1;i>=0;i--) {
            res[i] = pq.poll();
        }

        return res;
    }

    // Bucket Sort O(n)
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // to store how many elements has how much frequency
        List<Integer>[] bucket = new List[n+1]; 

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            int num = entry.getKey();
            int numFreq = entry.getValue();

            if(bucket[numFreq]==null) {
                bucket[numFreq] = new ArrayList<>();
            }

            bucket[numFreq].add(num);
        }

        int res[] = new int[k];
        int i=0;

        for(int j=n;j>=0 && i<k;j--) {
            if(bucket[j]==null) continue;

            for(int num: bucket[j]) {
                res[i++] = num;

                if(i==k) break;
            }
        }

        return res;
    }
}