package PriorityQueue;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> smaller; // All the smaller elements of array in maxHeap
    PriorityQueue<Integer> larger; // All the larger elements of array in minheap

    public MedianFinder() {
        smaller = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        larger = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(smaller.isEmpty() || num<=smaller.peek()) {
            smaller.offer(num);
        } else {
            larger.offer(num);
        }

        if(smaller.size()>larger.size()+1) larger.offer(smaller.poll());
        if(larger.size()>smaller.size()) smaller.offer(larger.poll());
    }
    
    public double findMedian() {
        if(smaller.size()>larger.size()) return smaller.peek();

        return (smaller.peek() + larger.peek()) / 2.0;
    }
}