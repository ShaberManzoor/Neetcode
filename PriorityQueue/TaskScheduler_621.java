package PriorityQueue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int freqs[] = new int[26]; //freq of each tasks
        int maxFreq = 0; //max freq of a task
        
        for(char ch: tasks){
            freqs[ch-'A']++;
            maxFreq = Math.max(maxFreq, freqs[ch-'A']);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); //To store the tasks based on the frequencies

        for(int freq: freqs){
            if(freq>0) maxHeap.offer(freq);
        }

        Queue<int[]> cooldown = new ArrayDeque<>(); //to store the cooldown period of task as {remainingFreq, availableTime};

        int time = 0;
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll(); //getting the most freq task
                count--; //using it & decreasing its count

                if(count>0){
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1]==time){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }


        return time;
    }

    public int leastIntervalOpt(char[] tasks, int n) {
        int freqs[] = new int[26];
        for(char task: tasks) freqs[task-'A']++;

        int maxFreq = 0, maxCount = 0;
        for(int freq: freqs) {
            if(freq>maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            } else if(freq==maxFreq) {
                maxCount++;
            }
        }

        int time = (maxFreq-1) * (n+1) + maxCount;

        return Math.max(time, tasks.length);
    }
}
