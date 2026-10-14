package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemp_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> st = new ArrayDeque<>();
        int ans[] = new int[n];

        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}
